package Uni;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import Test.Tester;
import Test.dummyObj;
import pj.Pyjama;

public class LockFreeUniversal {
	private AtomicReference<Tester> objRef = new AtomicReference<Tester>();  // Have to declare which object should be shared here, expediency
	
	private ArrayList<Node> head;
	private Node tail;
	private int threadNum;
	public LockFreeUniversal(int n, Tester target){
		tail = new Node();
		objRef.set(target);
		head = new ArrayList<Node>(n);
		threadNum = n;
		tail.seq = 0;
		for (int i=0; i<n; i++) {
			head.add(tail);
		}
		//System.out.println("tail is:"+ tail);
	}
	
	public Response apply(Invocation invoc) {
		int i = Pyjama.omp_get_thread_num(); //get current thread's alias id from pyjama
		Node prefer = new Node(invoc);  //create a new node 
		//System.out.println("prefer==========:"+prefer+"from thread"+i);
		while (prefer.seq == 0) {   //main loop, end till current node is added into sequential list
			Node before = Node.max(head,threadNum);  //get current latest head node

			Node after = before.decideNext.decide(prefer);  // consensus return the node who win

			//System.out.println("the one decided:"+after+"for thread"+i);
			before.next = after; //add after node (won node) to sequential list
			//System.out.println(before+"==>"+after);
			after.seq = before.seq + 1; //increase node id
			head.set(i, after); //update head pointer for own id
		}
		//Constructor<T> c = new Constructor<T>();
		//需要显性更改的接口
		dummyObj myObject = new dummyObj(this.objRef.get()); //强制转换
		//SeqObject是接口， dummyObj是实现类型
		//T myObject myObject = c.build(obj);  // create a new Object, need copy the entire data structure
		Node current = tail.next; // back to tail and execute sequential invocation one by one
		while (current != prefer) {
			myObject.apply(current.invoc);
			current = current.next;
		}   // until remain prefer to invoke 
		Response rs =  myObject.apply(current.invoc);
		myObject.apply(new Invocation(33));
		//this.objRef.set(myObject.getObj());
		return rs;
	}
	
	public Object fetchObj() {
		return this.objRef.get();
	}
}

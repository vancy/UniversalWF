package Test;

import java.util.concurrent.atomic.AtomicReference;

import pj.Pyjama;
import Uni.Invocation;
import Uni.Response;

public class dummyObj implements Uni.SeqObject{
	Tester t;
	public dummyObj(Tester t) {
		this.t = new Tester(t);  //copy constructor
		//this.obj.set(t);
	}
	@Deprecated
	public dummyObj(AtomicReference<Tester> t) {
		this.t = new Tester(t.get());  //copy constructor
		//this.obj.set(t);
	}
	
	@Override
	public Response apply(Invocation invoc) {
		Response returnValue = null;
		switch (invoc.num) {
		case 11:
			returnValue = new Response();
			returnValue.value = this.t.inc();
			//System.out.println("the value is:"+this.t.get()+ "after INC in thread "+ Pyjama.omp_get_thread_num());
			break;
		case 22:
			returnValue = new Response();
			returnValue.value = this.t.dec();
			//System.out.println("the value is:"+this.t.get()+ "after DEC in thread "+ Pyjama.omp_get_thread_num());
			break;
		case 33:
			//System.out.println("the value is:"+this.t.get()+ "in thread "+ Pyjama.omp_get_thread_num());
		default:
			break;
		}
		return returnValue;
	}

	public Tester getObj() {
		return this.t;
	}

}

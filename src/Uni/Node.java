package Uni;

import java.util.ArrayList;

public class Node {
	public int seq;
	public Invocation invoc;
	public Consensus<Node> decideNext;
	public Node next;
	public Node(Invocation invoc) {
		this.invoc = invoc;
		this.decideNext = new Consensus<Node>();
		seq = 0;
	}
	public Node() {
		this.invoc = null;
		this.decideNext = new Consensus<Node>();
		seq = 0;
	}
	public static Node max(ArrayList<Node> array, int n) {
		Node max = array.get(0);
		for (int i=0; i<n; i++) {
			if (max.seq < array.get(i).seq) {
				max = array.get(i);
			}
		}
		return max;
	}
}

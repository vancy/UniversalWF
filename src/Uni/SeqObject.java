package Uni;

import java.util.concurrent.atomic.AtomicReference;

import Test.Tester;

public interface SeqObject {
	AtomicReference<Tester> obj = new AtomicReference<Tester>();

	public  Response apply(Invocation invoc);     //also should be reimplemented by sub class
}

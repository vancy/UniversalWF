package Uni;

import java.util.concurrent.atomic.AtomicReference;

public class Consensus<T> {
	AtomicReference<Object> critic = new AtomicReference<Object>(null);

	public T decide(T item) {
		critic.compareAndSet(null, item);
		return (T)critic.get();
	}
}

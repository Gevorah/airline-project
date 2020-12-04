package datastructure;

public interface IQueue<E> {
	public void enqueue(E e);
	public E dequeue();
	public boolean isEmpty();
	public int size();
	public Node<?> first();
}

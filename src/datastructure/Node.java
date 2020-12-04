package datastructure;

public class Node<E> {
	E e;
	Node<E> next;
	public Node(E e) {
		this.e=e;
	}
	public E getE() {
		return e;
	}
}

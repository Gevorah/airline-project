package datastructure;

public class Queue<E> implements IQueue<E> {

	Node<E> first;
	Node<E> end;
	int size;

	public Queue() {
		size = 0;
	}

	public void enqueue(E e) {
		Node<E> add = new Node<E>(e);
		if (first == null) {
			first = add;
			end = add;
		} else {
			end.next = add;
			end = add;
		}
		size++;
	}

	public E dequeue() {
		if(first == null) return null;
		Node<E> n = first;
		first = first.next;
		size--;
		return n.e;
	} 

	public boolean isEmpty() {return (size==0);}

	public int size() {return size;}

	public Node<E> first() {
		if (first == null) return null;
		else return first;
	}

	public String print() {
		String list="";
		Node<E> curr = first;
		while (curr!=null) {
			list+=(curr.getE()+"\n");
			curr=curr.next;
		}
		return list;
	}
	
	public E getFirst(){
		return first.e;
	}
}

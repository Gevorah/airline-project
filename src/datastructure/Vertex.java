package datastructure;

import java.util.*;

public class Vertex<E> {
	private E e;
	private List<Edge<E>> connections;
	public Node(E e) {
        this.e = e;
        connections = new ArrayList<>();
    }
     public void addVertex(Edge<E> edge) {
        connections.add(edge);
    }
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	public List<Edge<E>> getConnections() {
		return connections;
	}
	public void setConnections(List<Edge<E>> connections) {
		this.connections = connections;
	}
}

package datastructure;

import java.util.*;

public class ListGraph<E> {
	private List<Vertex<E>> vertices;
	public ListGraph() {
		vertices = new ArrayList<>();
	}
	public void addNode(Vertex<E> vertex) {
		vertices.add(vertex);
	}
}

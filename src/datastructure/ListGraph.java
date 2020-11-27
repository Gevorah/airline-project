<<<<<<< HEAD
package datastructure;

import java.util.*;

public class ListGraph<E> {
	private List<Vertex<E>> vertices;
	public ListGraph() {
		vertices = new ArrayList<>();
	}
	public void addVertex(E e) {
		Vertex<E> vertex = new Vertex<E>(e);
		vertices.add(vertex);
	}
	public void deleteVertex(Vertex<E> vertex) {
		vertices.remove(vertex);
	}
	public void addEdge(Vertex<E> from, Vertex<E> to, double distance) {
		Edge<E> fromEdge = new Edge<E>(from,to,distance);
		Edge<E> toEdge = new Edge<E>(to,from,distance);
		from.addEdge(fromEdge);
		to.addEdge(toEdge);
	}
	public void deleteEdge(Vertex<E> from, Vertex<E> to) {
		List<Edge<E>> fromList = from.getConnections();
		for(int i=0;i<fromList.size();i++) {
			Edge<E> edge = fromList.get(i);
			if(edge.getFrom().equals(from) && edge.getTo().equals(to)) {
				fromList.remove(i);
				break;
			}
		}
		
	}
	
}
=======
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
>>>>>>> 9faffa724b35b3f4feb669f26ee21c52e8885b4d

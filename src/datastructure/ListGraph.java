package datastructure;

import java.util.*;

public class ListGraph<E extends Comparable<E>> {
	private List<Vertex<E>> vertices;
	private int size;

	public ListGraph() {
		vertices = new ArrayList<>();
		size = 0;
	}
	public void addVertex(E e) {
		Vertex<E> vertex = new Vertex<E>(e);
		vertex.addEdge(vertex, 0);
		vertices.add(vertex);
		size++;
	}
	public Vertex<E> search(E e) {
		for(Vertex<E> v:vertices) {
			if(v.getE().equals(e)) {
				return v;
			}
		}
		return null;
	}
	public void deleteVertex(Vertex<E> vertex) {
		vertices.remove(vertex);
		size--;
	}
	public boolean contains(E e) {
		return search(e)!=null;
	}
	public void addEdge(E from, E to, double distance) {
		if(!contains(from)) addVertex(from);
		if(!contains(to)) addVertex(to); 
		search(from).addEdge(search(to),distance);
	}
	public void deleteEdge(E from, E to) {
		search(from).deleteEdge(search(to));
	}
	public List<Vertex<E>> getVertices() {
		return vertices;
	}
	public static final double INF = 999999;
	public void bfs(Vertex<E> start) {
		for(Vertex<E> u:vertices) {
			u.setColor('W');
			u.setValue(INF);
			u.setPredecesor(null);
		}
		start.setValue(0);
		start.setPredecesor(null);
		Queue<Vertex<E>> q = new Queue<>();
		q.enqueue(start);
		while (q.size() > 0) {
			Vertex<E> u = q.dequeue();
			for(Vertex<E> v:u.getConnections()) {
				if(v.getColor() == 'W') {
					v.setColor('G');
					v.setValue(u.getValue()+1);
					v.setPredecesor(u);
					q.enqueue(v);
				}
			}
			u.setColor('B');
		}
	}

	public void dijkstra(Vertex<E> start) {
		for(Vertex<E> u:vertices) u.setPredecesor(null);
		MinHeap<Vertex<E>> mh = new MinHeap<>(vertices.size());
		start.setValue(0);
		start.setPredecesor(null);
		for(Vertex<E> v:vertices) mh.insert(v);
		while(!mh.isEmpty()) {
			Vertex<E> u = mh.extractMin();
			for(Vertex<E> v:u.getConnections()){
				double nValue = u.getValue() / u.getCost(v);
				if(mh.contains(v) && nValue<v.getValue()) {
					v.setValue(nValue);
					v.setPredecesor(u);
					mh.search(v).setValue(nValue);
				}
			}
		}
	}
	
	public void prim(Vertex<E> start) {
		MinHeap<Vertex<E>> mh = new MinHeap<>(vertices.size());
		for(Vertex<E> u:vertices) {
			u.setValue(INF);
			u.setPredecesor(null);
		}
		start.setValue(0);
		start.setPredecesor(null);
		for(Vertex<E> v:vertices) mh.insert(v);
		while(!mh.isEmpty()){
			Vertex<E> u = mh.extractMin();
			for(Vertex<E> v:u.getConnections()){
				double nValue = u.getCost(v);
				if(mh.contains(v) && nValue<v.getValue()){
					v.setValue(nValue);
					v.setPredecesor(u);
					mh.search(v).setValue(nValue);
				}
			}
		}
	}	
	public String print(Vertex<E> s, Vertex<E> v) {
	    if(s==v) return s.getE()+" ";
	    else if(v.getPredecesor()==null) return "Null Path";
	    else return print(s,v.getPredecesor())+" "+v.getE();
	}
}
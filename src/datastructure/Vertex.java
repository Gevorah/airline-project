package datastructure;

import java.util.*;

public class Vertex<E> implements Comparable<Vertex<E>> {
	private E e;
	private List<Vertex<E>> connections;
	private HashMap<E,Double> edges;
	private char color;
	private Vertex<E> predecesor;
	private double value;
	public Vertex(E e) {
        this.e = e;
        connections = new ArrayList<>();
        edges = new HashMap<>();
        color = 'W';
    }
    public void addEdge(Vertex<E> to, double cost) {
        connections.add(to);
        edges.put(to.getE(), cost);
    }
    public void deleteEdge(Vertex<E> to) {
    	connections.remove(to);
    	edges.remove(to);
    }
    public double getCost(Vertex<E> v) {
    	return edges.get(v.getE());
    }
    public void setCost(Vertex<E> v, double cost) {
    	edges.replace(v.getE(), cost);
    }
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	public List<Vertex<E>> getConnections() {
		return connections;
	}
	public HashMap<E, Double> getEdges() {
		return edges;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public Vertex<E> getPredecesor() {
		return predecesor;
	}
	public void setPredecesor(Vertex<E> predecesor) {
		this.predecesor = predecesor;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public int compareTo(Vertex<E> v) {
		if(this.value>v.value) return 1;
		else if(this.value<v.value) return -1;
		else return 0;
	}
}
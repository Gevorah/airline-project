<<<<<<< HEAD
package datastructure;

public class Edge<E> {
	private Vertex<E> from;
    private Vertex<E> to;
    private double distance;
 
    public Edge(Vertex<E> from, Vertex<E> to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
	public Vertex<E> getFrom() {
		return from;
	}
	public void setFrom(Vertex<E> from) {
		this.from = from;
	}
	public Vertex<E> getTo() {
		return to;
	}
	public void setTo(Vertex<E> to) {
		this.to = to;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
    
}
=======
package datastructure;

public class Edge<E> {
	private Vertex<E> from;
    private Vertex<E> to;
    private double distance;
 
    public Edge(Vertex<E> from, Vertex<E> to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

	public Vertex<E> getFrom() {
		return from;
	}
	public void setFrom(Vertex<E> from) {
		this.from = from;
	}
	public Vertex<E> getTo() {
		return to;
	}
	public void setTo(Vertex<E> to) {
		this.to = to;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
    
}
>>>>>>> 9faffa724b35b3f4feb669f26ee21c52e8885b4d

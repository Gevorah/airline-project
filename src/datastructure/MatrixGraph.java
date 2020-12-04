package datastructure;

import java.util.*;

public class MatrixGraph {
	private int n;
	private double[][] matrix;
	private ArrayList<String> destinations = new ArrayList<String>();

	public MatrixGraph(int n) {
		this.n = n;
		matrix = new double[this.n][this.n];
	}

	static int i;
	static int j;

	public void search(String from, String to) {
		i = -1;
		j = -1;

		for (int k = 0; k < destinations.size(); k++) {

			if (destinations.get(k).equals(from)) {
				i = k;

				break;
			}

		}
		if (i == -1) {
			destinations.add(from);
			i = destinations.size() - 1;

		}

		for (int l = 0; l < destinations.size(); l++) {

			if (destinations.get(l).equals(to)) {
				j = l;

				break;
			}

		}
		if (j == -1) {
			destinations.add(to);
			j = destinations.size() - 1;
		}
	}

	public void initializeMatrix() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = -1;
			}
		}
	}

	public void addEdge(String from, String to, double value) {
		search(from, to);
		matrix[i][j] = value;

	}

	public String addVertex(String place) {
		destinations.add(place);
		return place;
	}

	public String removeVertex(String place) {
		String value = "";
		for (int k = 0; k < destinations.size(); k++) {
			if (destinations.get(k).equals(place)) {
				value = destinations.get(k);
				destinations.remove(k);

			}
		}

		return value;
	}

	public double removeEdge(String from, String to) {
		double value = 0;
		search(from, to);
		if (matrix[i][j] > 0)
			value = matrix[i][j];
		matrix[i][j] = 0;

		return value;
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public static String path = "";
	public double path() {
		int sum = 0;
		String[] p = path.split(" ");
		for(int k=0;k<p.length-1;k++) {
			if(Integer.parseInt(p[k+1])==j) break;
			sum += matrix[Integer.parseInt(p[k])][Integer.parseInt(p[k+1])];
		}
		return sum;
	}
	public String spath() {
		String str = "";
		String[] p = path.split(" ");
		for(int k=0;k<p.length;k++) {
			str += destinations.get(Integer.parseInt(p[k]))+" ";
			if(Integer.parseInt(p[k])==j) break;
		}
		return str;
	}
	public void DFS() {
		boolean visited[] = new boolean[n];
		DFSUtil(i, visited);
	}

	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		path += v + " ";

		// Recur for all the vertices adjacent to this
		// vertex
		for (int j = 0; j < n; j++) {
			// If j is adjacent
			if (matrix[v][j] != -1) {
				if (!visited[j])
					DFSUtil(j, visited);
			}
		} //
	}

	public void floydWarshall() {
		double[][] dist = new double[n][n];
		int m, l, k;

		for (m = 0; m < n; m++)
			for (l = 0; l < n; l++)
				dist[m][l] = matrix[m][l];

		for (k = 0; k < n; k++) {

			for (m = 0; m < n; m++) {

				for (l = 0; l < n; l++) {

					if (dist[m][k] + dist[k][l] < dist[m][l])
						dist[m][l] = dist[m][k] + dist[k][l];
				}
			}
		}

		printSolution(dist);
	}

	public void printSolution(double dist[][]) {
		System.out.println("floyd");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (dist[i][j] == 0)
					System.out.print("0");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public double[][] kruskal() {
		double[][] adyacencia = matrix;
		double[][] arbol = new double[n + 1][n + 1];
		int[] pertenece = new int[n]; 

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arbol[i][j] + "  ");
			}
			System.out.println();

		}

		int nodoA = -1;
		int nodoB = -1;
		int arcos = 1;
		while (arcos < n) {
			double min = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (min > adyacencia[i][j] && pertenece[i] != pertenece[j]) {
						min = adyacencia[i][j];
						nodoA = i;
						nodoB = j;
					}

			if (pertenece[nodoA] != pertenece[nodoB]) {
				arbol[nodoA][nodoB] = min;
				arbol[nodoB][nodoA] = min;

				
				int temp = pertenece[nodoB];
				pertenece[nodoB] = pertenece[nodoA];
				for (int k = 0; k < n; k++)
					if (pertenece[k] == temp)
						pertenece[k] = pertenece[nodoA];

				arcos++;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arbol[i][j] + "  ");
			}
			System.out.println();
		}

		return arbol;
	}

}

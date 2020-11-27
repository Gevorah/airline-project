package datastructure;

import java.util.ArrayList;

public class MatrixGraph {

	private int n;
	private double[][] matriz;
	private ArrayList<String> destinations = new ArrayList<String>();

	public MatrixGraph(int n) {
		this.n = n;
		matriz = new double[this.n][this.n];
	}
	static int i;
	static int j;
	public void search(String from, String to, double value) {
		i=-1;
		j=-1;
		
		for(int k=0; k<destinations.size();k++) {
			if(destinations.get(k).equals(from)) {
				i=k;
			}
		}
		if (i==-1) {
			destinations.add(from);
			i=destinations.size()-1;
		}
		
		for(int l=0; j<destinations.size(); l++) {
			if(destinations.get(l).equals(to)) {
				j=l;
		}
			
		}
		if (j==-1) {
			destinations.add(from);
			j=destinations.size()-1;
		}
	}

	public void initializeMatrix() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = 0;
			}
		}
	}

	public void add(int i, int j, double value) {
		matriz[i][j] = value;
	}

	public void remove(int i, int j) {
		if (matriz[i][j] > 0)
			matriz[i][j] = 0;
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/*
	 * private int[][] matrix; static int aq[]; static int pind=0; static int
	 * rind=0; static int n,m,q; static int[] x={0,0,-1,1}; static int[]
	 * y={1,-1,0,0}; void bfs(int si, int sj){ aq[pind++]=si; aq[pind++]=sj;
	 * matrix[si][sj]=0; while(rind<pind){ int ux=aq[rind++]; int uy=aq[rind++];
	 * for(int i=0;i<4;i++){ int vx=ux+x[i]; int vy=uy+y[i]; if(vx>0 && vx<=n &&
	 * vy>0 && vy<=m && matrix[vx][vy]==-1){ matrix[vx][vy]=matrix[ux][uy]+1;
	 * aq[pind++]=vx; aq[pind++]=vy; } } } } }
	 */
}

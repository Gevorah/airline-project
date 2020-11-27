package model;

import java.util.Stack;

public class AirLine {

	public String calculateRoute(String departure, String arrival, String criteria, String typeGraph) {

		String result = "";

		if (typeGraph.equals("Grafo 1")) {

			if (criteria.equals("Speed")) {

				result = searchbyCostMatrix(departure, arrival);
			}

			else if (criteria.equals("Cost")) {

				result = searchbySpeedMatrix(departure, arrival);
			}

		}

		else if (typeGraph.equals("Grafo 2")) {

			if (criteria.equals("Speed")) {

				result = searchbyCostList(departure, arrival);
			}

			else if (criteria.equals("Cost")) {

				result = searchbySpeedList(departure, arrival);
			}
		}

		return result;
	}

	
	public String searchbySpeedMatrix(String departure, String arrival) {
		/*
		Stack s=new Stack(); 
		s.push(this.rootNode); 
		rootNode.; 
		printNode(rootNode);
		while(!s.isEmpty()) { 
			Node n=(Node)s.peek(); 
			Node child=getUnvisitedChildNode(n); 
			if(child!=null) { child.visited=true; printNode(child); s.push(child); }
			else { s.pop(); } } clearNodes(); */

	return"Hola";

	}

	public String searchbyCostMatrix(String departure, String arrival) {

		return "como vas";
	}

	public String searchbySpeedList(String departure, String arrival) {
		

	return"Hola";

	}

	public String searchbyCostList(String departure, String arrival) {

		return "como vas";
	}

	static int[][] grid;
	static int[] q = new int[2000002];
	static int pind = 0;
	static int rind = 0;
	static int[] x = { 0, 0, -1, 1 };
	static int[] y = { 1, -1, 0, 0 };

	static void bfs(int si, int sj){
		q[pind++]=si;
		q[pind++]=sj;
		grid[si][sj]=0;
		while(rind<pind){
			int ux=q[rind++];
			int uy=q[rind++];
			for(int i=0;i<4;i++){
				int vx=ux+x[i];
				int vy=uy+y[i];
				if(vx>0 && vx<=n && vy>0 && vy<=m && grid[vx][vy]==-1){
					grid[vx][vy]=grid[ux][uy]+1;
					q[pind++]=vx;
					q[pind++]=vy;
				}
			}
		}
	}
}

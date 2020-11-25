package datastructure;

public class MatrixGraph {
	private int[][] matrix;
	static int aq[];
	static int pind=0;
	static int rind=0;
	static int n,m,q;
	static int[] x={0,0,-1,1};
	static int[] y={1,-1,0,0};
	void bfs(int si, int sj){
		aq[pind++]=si;
		aq[pind++]=sj;
		matrix[si][sj]=0;
		while(rind<pind){
			int ux=aq[rind++];
			int uy=aq[rind++];
			for(int i=0;i<4;i++){
				int vx=ux+x[i];
				int vy=uy+y[i];
				if(vx>0 && vx<=n && vy>0 && vy<=m && matrix[vx][vy]==-1){
					matrix[vx][vy]=matrix[ux][uy]+1;
					aq[pind++]=vx;
					aq[pind++]=vy;
				}
			}
		}
	}
}

package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixGraphTest {

	MatrixGraph mg;
	MatrixGraph mg2;
	MatrixGraph mg3;
	MatrixGraph mg4;
	
	public void setUp1() {
		mg= new MatrixGraph(4);
		mg.initializeMatrix();
		mg.addEdge(mg.addVertex("cali"), mg.addVertex("bogota"), 4);
		mg.addEdge(mg.addVertex("medellin"), "bogota", 5);
		mg.addEdge("cali", "medellin", 6);
		mg.addEdge(mg.addVertex("españa"), "cali", 3);
		mg.addEdge("medellin", "españa", 2);
	}
	
	public void setUp2() {
		mg2= new MatrixGraph(7);
		mg2.initializeMatrix();
		
		mg2.addEdge(mg2.addVertex("africa"), mg2.addVertex("australia"), 4);
		mg2.addEdge(mg2.addVertex("usa"),"africa", 3);
		mg2.addEdge("australia", "usa", 2);
		
	}
	
	public void setUp3() {
		mg3= new MatrixGraph(24);
		mg3.initializeMatrix();
		
		mg3.addEdge(mg3.addVertex("canada"), mg3.addVertex("texas"), 4);
		mg3.addEdge(mg3.addVertex("miami"), mg3.addVertex("new york"), 7);
		mg3.addEdge("new york", "canada", 5);
		mg3.addEdge(mg3.addVertex("londres"), "miami", 3);
		mg3.addEdge("australia", "texas", 5);
		mg3.addEdge("texas", "canada",7 );
		mg3.addEdge("londres", "texas", 8);
		mg3.addEdge("londres", "new york", 2);
		mg3.addEdge(mg3.addVertex("dember"), "londres", 6);
		mg3.addEdge("new york", "dember", 4);
		
	}
	
	
	
	@Test
	void removeVertexTest() {
		
		setUp1();
		setUp2();
		setUp3();
		
		
		assertEquals("cali",mg.removeVertex("cali"));
		assertEquals("bogota",mg.removeVertex("bogota"));
		
		assertEquals("usa",mg2.removeVertex("usa"));
		
		assertEquals("canada",mg3.removeVertex("canada"));
		assertEquals("texas",mg3.removeVertex("texas"));
		assertEquals("londres",mg3.removeVertex("londres"));
		assertEquals("miami",mg3.removeVertex("miami"));
		
	}
	
	@Test
	void removeEdgeTest() {
	
		setUp1();
		setUp2();
		setUp3();
		
		assertEquals(4,mg.removeEdge("cali", "bogota"),"");
		assertEquals(6,mg.removeEdge("cali", "medellin"),"");
		assertEquals(2,mg.removeEdge("medellin", "españa"),"");
		
		assertEquals(3,mg2.removeEdge("usa", "africa"),"");
		
		assertEquals(4,mg3.removeEdge("canada", "texas"),"");
		assertEquals(2,mg3.removeEdge("londres", "new york"),"");
		assertEquals(7,mg3.removeEdge("texas", "canada"),"");
		assertEquals(6,mg3.removeEdge("dember", "londres"),"");
		assertEquals(7,mg3.removeEdge("miami", "new york"),"");
		
		
	}

}

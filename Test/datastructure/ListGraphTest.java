package datastructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListGraphTest {

	ListGraph <Integer>lg1;
	ListGraph <String>lg2;
	ListGraph <Character>lg3;
	
	public void setUp1() {
		lg1= new ListGraph<Integer>();
		
		lg1.addEdge(1, 3, 2);
		lg1.addEdge(3, 7, 4);
		lg1.addEdge(2, 8, 6);
	}
	public void setUp2() {
		lg2= new ListGraph <String>();
		
		lg2.addEdge("cristian", "maria", 4);
		lg2.addEdge("carlos", "juan", 7);
		lg2.addEdge("maria", "juan",5 );
		lg2.addEdge("carlos", "cristian", 8);
		lg2.addEdge("maria", "carlos", 2);
		
	}
	public void setUp3() {
		lg3= new ListGraph <Character> ();
		
		lg3.addEdge('Y', 'Z', 2);
		lg3.addEdge('A', 'D', 4);
		
	}
	
	@Test
	void deleteVertexTest() {
		setUp1();
		setUp2();
		setUp3();
		
		lg1.addVertex(12);
		lg1.addVertex(3);
		lg1.addVertex(69);
		lg1.deleteVertex(lg1.search(12));
		assertEquals(false, lg1.contains(12));
		assertEquals(true, lg1.contains(69));
		
		lg3.addVertex('h');
		lg3.addVertex('x');
		lg3.addVertex('g');
		
		lg3.deleteVertex(lg3.search('h'));
		assertEquals(false, lg3.contains('h'));
		lg3.deleteVertex(lg3.search('x'));
		assertEquals(false, lg3.contains('x'));
		lg3.deleteVertex(lg3.search('g'));
		assertEquals(false, lg3.contains('g'));
	}
	
	
	@Test
	void bfsTest() {
		setUp1();
		lg1.bfs(lg1.search(1));
		assertEquals("1  3 7", lg1.print(lg1.search(1),lg1.search(7)));
	}

	
	
}

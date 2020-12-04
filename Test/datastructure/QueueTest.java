package datastructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class QueueTest {

	Queue<Integer> qI;
	Queue<Character > qC;
	Queue<String> qS;
	Queue<String> qK;


	void setUp1() {
		qI = new Queue<Integer>();
		qI.enqueue(7);
		qI.enqueue(15);
		qI.enqueue(53);
	}

	void setUp2() {
		qC= new Queue<Character>();
		qC.enqueue('A');
		qC.enqueue('Ñ');
		qC.enqueue('Z');
		qC.enqueue('D');
	}

	void setUp3() {
		qS= new Queue<String>();
		qS.enqueue("perro");
		qS.enqueue("gato");
		qS.enqueue("vaca");
		qS.enqueue("pato");
		qS.enqueue("pajaro");
		qS.enqueue("mono");
		
	}
	
	void setUp4() {
		qK = new Queue<String>();
	}


	@Test
	void dequeueTest() {

		setUp1();
		assertEquals(qI.getFirst(), qI.dequeue());
		
		
		setUp2();
		assertEquals(qC.getFirst(), qC.dequeue());
		assertEquals(qC.getFirst(), qC.dequeue());
		assertEquals(qC.getFirst(), qC.dequeue());
		
		setUp3();
		assertEquals(qS.getFirst(), qS.dequeue());
		assertEquals(qS.getFirst(), qS.dequeue());
		assertEquals(qS.getFirst(), qS.dequeue());
		assertEquals(qS.getFirst(), qS.dequeue());
		assertEquals(qS.getFirst(), qS.dequeue());
		assertEquals(qS.getFirst(), qS.dequeue());
		try {
		assertEquals(null, qS.dequeue());
		}
		catch(NullPointerException e) {
			System.out.println("La lista esta vacia");
		}
		
	}

	@Test
	void isEmptyTest() {
		setUp1();
		assertEquals(false, qI.isEmpty());
		
		setUp2();
		assertEquals(false, qC.isEmpty());
		
		setUp4();
		assertEquals(true, qK.isEmpty());
	
	}
}

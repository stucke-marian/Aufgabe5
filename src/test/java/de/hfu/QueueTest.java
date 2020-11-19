package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void testQueue() {
		Queue queue = new Queue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(5, queue.dequeue());
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		assertEquals(1, queue.dequeue());
		
		queue.enqueue(4);
		
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());		
	}
	
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testConstructor() {
		new Queue(0);
	}
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testDequeue() {
		Queue queue = new Queue(3);
		queue.enqueue(1);
		queue.dequeue();
		queue.dequeue();
	}

}

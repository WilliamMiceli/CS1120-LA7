package edu.wmich.cs1120.williambowen;

import java.util.*;

public class PriorityQueue<T> {
	private Queue<Request> queue1;
	private Queue<Request> queue2;
	
	public PriorityQueue() {
		
	}
	/**
	 * Determines if the priority queue is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return (this.queue1.size() == 0);
	}
	/**
	 * Adds the object received to the priority queue taking into
	 * consideration the rules governing priority.
	 * @param data
	 */
	public void enqueue(Request data) {
		while(true) {
			if(queue1.isEmpty()) {
				queue2.add(data);
				break;
			}else {
				if(data.compareTo(queue1.peek()) > 0) {
					queue2.add(data);
					break;
				}else {
					queue2.add(queue1.poll());
				}
			}
		}
		while(queue1.size() > 0) {
			queue2.add(queue1.poll());
		}
		while(queue2.size() > 0) {
			queue1.add(queue2.poll());
		}
	}
	/**
	 * Removes the object with the highest priority (at the front
	 * of the queue) from the priority queue.
	 * @return
	 */
	public Request dequeue() {
		return queue1.poll();
	}
}

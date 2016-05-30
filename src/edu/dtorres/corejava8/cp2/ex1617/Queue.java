package edu.dtorres.corejava8.cp2.ex1617;

import java.util.Arrays;

/**
 * 16 - Implement a class Queue, an unbounded queue of strings. Provide methods
 * add, adding at the tail, and remove, removing at the head of the queue. Store
 * element as a linked list of nodes. Make Node a nested class. Should it be
 * static or not?
 * 
 * Should not be static, because each node needs to know to which queue it
 * belongs.
 * 
 * 17 - Provide an iterator - an object that yields the elements of the queue in
 * turn - for the queue of the preceding class. Make Iterator a nested class
 * with methods next and hasNext. Provide a method iterator() of the Queue class
 * that yields a Queue.Iterator Should Iterator be static or not?
 * 
 * Should be static, because does not have to rememver to which queue it
 * belongs.
 * 
 * @author diego
 *
 */
public class Queue {

	private Node[] nodes;

	public static void main(String... args) {
		Queue queue = new Queue();
		queue.add("One");
		queue.add("Two");
		queue.add("Three");
		queue.add("Four");
		queue.add("Five");
		queue.add("Six");

		Iterator it = queue.getIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Node n = null;
		while ((n = queue.remove()) != null) {
			System.out.println(n.getContent());
		}
	}

	/**
	 * Removes a Node from the head.
	 * 
	 * @return the removed object reference.
	 */
	public Node remove() {
		if (nodes != null && nodes.length > 1) {
			Node temp = nodes[nodes.length - 1];
			Node[] shrinked = Arrays.copyOfRange(nodes, 0, nodes.length - 1);
			shrinked[shrinked.length - 1].setNext(null);
			nodes = Arrays.copyOf(shrinked, shrinked.length);
			return temp;
		} else if (nodes != null && nodes.length == 1) {
			Node temp = nodes[0];
			nodes = null;
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * Adds at the tail and provides references for previous and next nodes.
	 * 
	 * @param content
	 */
	public void add(String content) {
		Node newNode = new Node(content);
		if (nodes != null) {
			Node[] result = Arrays.copyOf(nodes, nodes.length + 1);
			if (result.length > 1) {
				newNode.setPrevious(result[result.length - 2]);
				result[result.length - 2].setNext(newNode);
			}
			result[result.length - 1] = newNode;
			nodes = Arrays.copyOf(result, result.length);
		} else {
			Node[] result = new Node[1];
			result[0] = newNode;
			nodes = result;
		}
	}

	public Iterator getIterator() {
		if (nodes == null)
			return null;
		return new Iterator(nodes[0]);
	}

	public static class Iterator {
		private Node currentNode;

		private Iterator(Node currentNode) {
			this.currentNode = currentNode;
		}

		public boolean hasNext() {
			return currentNode != null;
		}

		public Node next() {
			Node temp = currentNode;
			currentNode = currentNode.getNext();
			return temp;
		}
	}

	public class Node {
		private Node previous;
		private Node next;
		private String content;

		public Node(String content) {
			this.content = content;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		@Override
		public String toString() {
			return "Node [content=" + content + "]";
		}

	}
}

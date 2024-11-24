package com.dsa.linkedList.Nov2424;

public class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void insertAtBegining(int data) {
		Node newNode = new Node(data);
		head = newNode;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void append(int data) {
	    Node newNode = new Node(data);
	    if (head == null) {
	        head = newNode;
	        return;
	    }
	    Node current = head;
	    while (current.next != null) {
	        current = current.next;
	    }
	    current.next = newNode;
	}


	public void insertAtEnd(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current = new Node(data);
		}
	}

	public void insertAtPosition(int position, int data) {
		Node newNode = new Node(data);
		if (position == 0) {
			head = newNode;
			return;
		}
		Node current = head;
		for (int i = 0; i < position - 1 && current != null; i++) {
			current = current.next;
			
			// Explanation
			
			//[Node A] -> [Node B] -> [Node C] -> null
			//current points to Node A.
			//current.next points to Node B.
			//newNode.next = current.next;
			//newNode -> [Node B] -> [Node C] -> null
			//current.next = newNode;
			//[Node A] -> [newNode] -> [Node B] -> [Node C] -> null
		}
		if (current == null) {
			throw new IllegalArgumentException("Position out of bounds");
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
//		list.insertAtBegining(0);
//		list.display();
//		list.append(1);
		//list.display();
		list.append(4);
		//list.display();
		list.append(3);
		//list.display();
		list.append(45);
		list.display();
		System.out.println("------------");
		list.insertAtPosition(1,76);
		list.display();
//		//list.insertAtEnd(56);
//		list.display();
	}

}

package com.dsa.linkedList;

public class LinkedList {

	Node head;

	// Insert at the beginning
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data); // This common, you have to create this.
		newNode.next = head;
		head = newNode;
	}

	// Insert at the end
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Display the list
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
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

			// [Node A] -> [Node B] -> [Node C] -> null
			// current points to Node A.
			// current.next points to Node B.
			// newNode.next = current.next;
			// newNode -> [Node B] -> [Node C] -> null
			// current.next = newNode;
			// [Node A] -> [newNode] -> [Node B] -> [Node C] -> null
		}
		if (current == null) {
			throw new IllegalArgumentException("Position out of bounds");
		}
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

//		list.insertAtBeginning(0);
//
//		list.display();
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

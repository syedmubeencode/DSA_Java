package com.dsa.linkedList;

public class LinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertAtBeginning(0);
		
		list.display();
	}
	
	Node head;

	// Insert at the beginning
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);  // This common, you have to create this. 
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
}

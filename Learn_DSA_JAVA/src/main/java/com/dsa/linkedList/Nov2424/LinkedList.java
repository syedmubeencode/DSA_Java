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
		Node current = head;
		if(current.next == null) {
			head = new Node(data);
			return;
		}
		while(current.next != null) {
			current = current.next;
		}
		current = new Node(data);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBegining(0);
		list.display();
		list.append(1);
		list.display();
	}

}

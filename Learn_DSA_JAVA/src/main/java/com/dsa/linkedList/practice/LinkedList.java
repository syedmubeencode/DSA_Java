package com.dsa.linkedList.practice;

public class LinkedList {
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int data){
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
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void append(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void insertAtSpecificPosition(int position, int data) {
		Node newNode = new Node(data);
		if(position == 0) {
			head = newNode;
			return;
		}
		Node current = head;
		for (int i = 0; i < position - 1 && current != null; i++) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		//list.insertAtBegining(0);
		list.append(0);
		list.display();
		list.append(1);
		list.display();
	}

}

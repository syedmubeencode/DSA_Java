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
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBegining(0);
		list.display();
	}
}

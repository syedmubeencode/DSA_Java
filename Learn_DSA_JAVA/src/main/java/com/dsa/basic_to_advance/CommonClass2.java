package com.dsa.basic_to_advance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonClass2 {
	// Node class representing each element in the list
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head; // Head of the linked list

	// Insert a new node at the end
	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	// Delete a node with a given key
	public void delete(int key) {
		if (head == null)
			return;

		// If head node itself holds the key
		if (head.data == key) {
			head = head.next;
			return;
		}

		Node temp = head;
		Node prev = null;

		// Search for the key
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// Key not found
		if (temp == null)
			return;

		// Unlink the node
		prev.next = temp.next;
	}

	// Display the linked list
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
}

class LinkedListStreams2 {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	public void delete(int key) {
		if (head == null)
			return;

		if (head.data == key) {
			head = head.next;
			return;
		}

		Node temp = head;
		Node prev = null;

		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	public void display() {
		List<Integer> elements = new ArrayList<>();
		Node temp = head;
		while (temp != null) {
			elements.add(temp.data);
			temp = temp.next;
		}
		String result = elements.stream().map(String::valueOf).collect(Collectors.joining(" -> ", "", " -> null"));
		System.out.println(result);
	}
}
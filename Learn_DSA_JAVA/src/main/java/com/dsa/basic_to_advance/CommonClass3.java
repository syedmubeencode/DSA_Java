package com.dsa.basic_to_advance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class LinkedListStreams {
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
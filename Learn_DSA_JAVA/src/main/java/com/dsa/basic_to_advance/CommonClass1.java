package com.dsa.basic_to_advance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class AuthQueueCore {
	private Stack<Integer> pushStack = new Stack<>();
	private Stack<Integer> popStack = new Stack<>();

	// Enqueue operation
	public void enqueue(int item) {
		pushStack.push(item);
	}

	// Dequeue operation
	public int dequeue() {
		if (popStack.isEmpty()) {
			if (pushStack.isEmpty()) {
				throw new RuntimeException("Queue is empty");
			}
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.pop();
	}

	// Check if queue is empty
	public boolean isEmpty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}

	// Peek at front element
	public int peek() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.peek();
	}
}

class AuthQueueStream {
	private Deque<Integer> pushStack = new ArrayDeque<>();
	private Deque<Integer> popStack = new ArrayDeque<>();

	// Enqueue using Streams
	public void enqueue(int item) {
		pushStack.push(item);
	}

	// Dequeue using Streams
	public int dequeue() {
		if (popStack.isEmpty()) {
			if (pushStack.isEmpty()) {
				throw new RuntimeException("Queue is empty");
			}
			popStack.addAll(pushStack.stream().collect(Collectors.toCollection(ArrayDeque::new)));
			pushStack.clear();
		}
		return popStack.poll();
	}

	// Peek using Streams
	public int peek() {
		if (popStack.isEmpty()) {
			popStack.addAll(pushStack.stream().collect(Collectors.toCollection(ArrayDeque::new)));
			pushStack.clear();
		}
		return popStack.peek();
	}
}

class AuthStackCore {
	private int[] stack;
	private int top;
	private int capacity;

	// Constructor
	public AuthStackCore(int size) {
		capacity = size;
		stack = new int[capacity];
		top = -1; // Stack is empty initially
	}

	// Push operation
	public void push(int item) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		stack[++top] = item;
	}

	// Pop operation
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stack[top--];
	}

	// Peek operation
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stack[top];
	}

	// Check if stack is empty
	public boolean isEmpty() {
		return top == -1;
	}

	// Check if stack is full
	public boolean isFull() {
		return top == capacity - 1;
	}
}

class AuthStackStream {
	private ArrayList<Integer> stack = new ArrayList<>();
	private int capacity;

	// Constructor
	public AuthStackStream(int size) {
		this.capacity = size;
	}

	// Push operation using Streams
	public void push(int item) {
		if (stack.size() >= capacity) {
			throw new RuntimeException("Stack is full");
		}
		stack.add(item);
	}

	// Pop operation using Streams
	public int pop() {
		if (stack.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stack.remove(stack.size() - 1);
	}

	// Peek operation using Streams
	public int peek() {
		return stack.stream().skip(stack.size() - 1).findFirst()
				.orElseThrow(() -> new RuntimeException("Stack is empty"));
	}

	// Check if empty
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}

class MultiThreadCore {
	private int num = 1;
	private final int limit;

	public MultiThreadCore(int limit) {
		this.limit = limit;
	}

	public synchronized void printOdd() {
		while (num <= limit) {
			if (num % 2 == 0) {
				try {
					wait(); // Wait until it's odd number's turn
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			if (num <= limit) {
				System.out.println(Thread.currentThread().getName() + " -> " + num);
				num++;
				notify(); // Notify the other thread
			}
		}
	}

	public synchronized void printEven() {
		while (num <= limit) {
			if (num % 2 != 0) {
				try {
					wait(); // Wait until it's even number's turn
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			if (num <= limit) {
				System.out.println(Thread.currentThread().getName() + " -> " + num);
				num++;
				notify(); // Notify the other thread
			}
		}
	}
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75f, true); // Enable access order
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity; // Remove oldest entry if cache is full
	}
}

class LRUCacheStream<K, V> {
	private final int capacity;
	private final Map<K, V> cache;
	private final LinkedList<K> keys;

	public LRUCacheStream(int capacity) {
		this.capacity = capacity;
		this.cache = new ConcurrentHashMap<>();
		this.keys = new LinkedList<>();
	}

	public V get(K key) {
		if (cache.containsKey(key)) {
			keys.remove(key);
			keys.addLast(key);
			return cache.get(key);
		}
		return null;
	}

	public void put(K key, V value) {
		if (cache.containsKey(key)) {
			keys.remove(key);
		} else if (cache.size() >= capacity) {
			K oldestKey = keys.pollFirst();
			cache.remove(oldestKey);
		}
		cache.put(key, value);
		keys.addLast(key);
	}

	public void display() {
		String result = keys.stream().map(k -> k + "=" + cache.get(k)).collect(Collectors.joining(", ", "{", "}"));
		System.out.println(result);
	}
}

class StackArray {
	private int[] stack;
	private int top;
	private int capacity;

	public StackArray(int size) {
		this.capacity = size;
		this.stack = new int[size];
		this.top = -1;
	}

	public void push(int value) {
		if (top == capacity - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		stack[++top] = value;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stack[top--];
	}

	public int peek() {
		return (top == -1) ? -1 : stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void display() {
		for (int i = top; i >= 0; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}

}

class StackStream {
	private int[] stack;
	private int top;

	public StackStream(int size) {
		stack = new int[size];
		top = -1;
	}

	public void push(int value) {
		if (top == stack.length - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		stack[++top] = value;
	}

	public int pop() {
		return (top == -1) ? -1 : stack[top--];
	}

	public int peek() {
		return (top == -1) ? -1 : stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void display() {
		IntStream.rangeClosed(0, top).map(i -> stack[top - i]) // Reverse order
				.forEach(value -> System.out.print(value + " "));
		System.out.println();
	}
}
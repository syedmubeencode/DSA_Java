package com.dsa.basic_to_advance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneralMainClass2 {

	public static void main(String[] args) {
		// 1. Write a Java program to print "Hello, World!" to the console.
		helloWorld(false, "core", "Hi Syed!");

		// 2. Write a Java program to swap two numbers without using a third variable.
		swapNumber(false, "core", 10, 20);

		// 30. Implement a multi-threaded Java program that prints odd and even numbers
		// alternately using two threads.
		muitiThread(false, "core");

		// 29. Implement a basic LRU (Least Recently Used) cache.
		basicLRU(false, "streams");

		// 28. Check if two strings are anagrams of each other.
		anagarmStrings(false, "streams", "sl", "ls");

		// 27. Find all permutations of a string.
		findAllPermutaionsOfString(false, "streams", "slt");

		// 26. Implement a queue using two stacks.
		implimentQueueUsingStacks(false, "streams");

		// 25. Implement a stack using an array.
		implimentStackUsingQueue(false, "streams");

		// 25. Implement a stack using an array.
		implimentStackUsingArray(false, "streams");

		// 24. Find the Kth largest element in an array.
		findKthLargestEleInArray(false, "core");
		
		// 23. Find the longest substring without repeating characters in a string.
		findLongestSubStringWtReptingChars(false, "streams");
		
		// 22. Implement a linked list and perform insert, delete, and display operations.
		linkedLisOprations(true, "streams");
	}

	private static boolean linkedLisOprations(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			CommonClass2 list = new CommonClass2();
	        list.insert(10);
	        list.insert(20);
	        list.insert(30);
	        list.display(); // Output: 10 -> 20 -> 30 -> null
	 
	        list.delete(20);
	        list.display(); // Output: 10 -> 30 -> null
		}else if(method.equalsIgnoreCase("streams")) {
			LinkedListStreams2 list = new LinkedListStreams2();
			list.insert(10);
			list.insert(20);
			list.insert(30);
			list.display(); // Output: 10 -> 20 -> 30 -> null

			list.delete(20);
			list.display(); // Output: 10 -> 30 -> null
		}
		return false;
	}

	private static boolean findLongestSubStringWtReptingChars(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			String input = "abcabcbb";
			int n = input.length();
			int startt = 0, maxStart = 0, maxLen = 0;
			Set<Character> set = new HashSet<>();

			for (int end = 0; end < n; end++) {
				char c = input.charAt(end);
				// If character is already in the set, shrink the window from the left until
				// it's removed
				while (set.contains(c)) {
					set.remove(input.charAt(startt));
					startt++;
				}
				// Add current character and update max window if needed
				set.add(c);
				if (end - startt + 1 > maxLen) {
					maxLen = end - startt + 1;
					maxStart = startt;
				}

			}
			System.out.println(input.substring(maxStart, maxStart + maxLen));
		} else if (method.equalsIgnoreCase("streams")) {
			String s = "abcabcbb";
			System.out.println(IntStream.range(0, s.length()).boxed()
					.flatMap(i -> IntStream.rangeClosed(i + 1, s.length()).mapToObj(j -> s.substring(i, j)))
					.filter(GeneralMainClass2::isUnique).max(Comparator.comparingInt(String::length)).orElse(""));
		}
		return false;
	}

	// Helper method to check if a string has all unique characters
	public static boolean isUnique(String str) {
		Set<Character> set = new HashSet<>();
		for (char c : str.toCharArray()) {
			if (!set.add(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean findKthLargestEleInArray(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			int[] numbers = { 10, 45, 78, 23, 89, 56 };
			int max = numbers[0]; // Assume first element is the largest
			for (int num : numbers) {
				if (num > max) {
					max = num;
				}
			}
			System.out.println("Largest element: " + max);
		} else if (method.equalsIgnoreCase("streams")) {
			int[] numbers = { 10, 45, 78, 23, 89, 56 };
			int max = Arrays.stream(numbers).max().orElseThrow();
			System.out.println("Largest element: " + max);
		}
		return false;
	}

	private static boolean implimentStackUsingArray(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			StackArray stack = new StackArray(5);
			stack.push(10);
			stack.push(20);
			stack.push(30);
			stack.display(); // Output: 30 20 10
			stack.pop();
			stack.display(); // Output: 20 10
		} else if (method.equalsIgnoreCase("streams")) {
			StackStream stack = new StackStream(5);
			stack.push(10);
			stack.push(20);
			stack.push(30);
			stack.display(); // Output: 30 20 10
			stack.pop();
			stack.display(); // Output: 20 10
		}
		return false;
	}

	private static boolean basicLRU(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			LRUCache<Integer, String> cache = new LRUCache<>(3);

			cache.put(1, "A");
			cache.put(2, "B");
			cache.put(3, "C");
			System.out.println(cache); // {1=A, 2=B, 3=C}

			cache.get(1); // Access 1, making it most recently used
			cache.put(4, "D"); // Removes least recently used (2)

			System.out.println(cache); // {3=C, 1=A, 4=D}
		} else if (method.equalsIgnoreCase("streams")) {
			LRUCacheStream<Integer, String> lru = new LRUCacheStream<>(3);
			lru.put(1, "A");
			lru.put(2, "B");
			lru.put(3, "C");
			lru.get(1);
			lru.put(4, "D"); // Removes 2 (Least recently used)
			lru.display(); // Output: {3=C, 1=A, 4=D}
		}
		return false;
	}

	private static boolean muitiThread(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			int limit = 10; // Set the range for printing numbers
			MultiThreadCore printer = new MultiThreadCore(limit);

			Thread oddThread = new Thread(printer::printOdd, "OddThread");
			Thread evenThread = new Thread(printer::printEven, "EvenThread");

			oddThread.start();
			evenThread.start();
		} else if (method.equalsIgnoreCase("streams")) {
			int limit = 10;
			IntStream.rangeClosed(1, limit).parallel()
					.forEach(n -> System.out.println(Thread.currentThread().getName() + " -> " + n));
		}
		return false;
	}

	private static boolean implimentStackUsingQueue(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			AuthStackCore authStack = new AuthStackCore(5);
			authStack.push(10);
			authStack.push(20);
			authStack.push(30);

			System.out.println(authStack.pop()); // 30
			System.out.println(authStack.peek()); // 20
			System.out.println(authStack.pop()); // 20
			System.out.println(authStack.pop()); // 10
		} else if (method.equalsIgnoreCase("streams")) {
			AuthStackStream authStack = new AuthStackStream(5);
			authStack.push(10);
			authStack.push(20);
			authStack.push(30);

			System.out.println(authStack.pop()); // 30
			System.out.println(authStack.peek()); // 20
			System.out.println(authStack.pop()); // 20
			System.out.println(authStack.pop()); // 10
		}
		return false;
	}

	private static boolean implimentQueueUsingStacks(boolean start, String method) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			AuthQueueCore authQueue = new AuthQueueCore();
			authQueue.enqueue(1);
			authQueue.enqueue(2);
			authQueue.enqueue(3);

			System.out.println(authQueue.dequeue()); // 1
			System.out.println(authQueue.peek()); // 2
			System.out.println(authQueue.dequeue()); // 2
			System.out.println(authQueue.dequeue()); // 3
		} else if (method.equalsIgnoreCase("Streams")) {
			AuthQueueStream authQueue = new AuthQueueStream();
			authQueue.enqueue(1);
			authQueue.enqueue(2);
			authQueue.enqueue(3);

			System.out.println(authQueue.dequeue()); // 1
			System.out.println(authQueue.peek()); // 2
			System.out.println(authQueue.dequeue()); // 2
			System.out.println(authQueue.dequeue()); // 3
		}
		return false;
	}

	private static boolean findAllPermutaionsOfString(boolean start, String method, String input) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("recursion")) {
			permute(input, "");
		} else if (method.equalsIgnoreCase("Streams")) {
			String result = "";
			if (input.isEmpty()) {
				System.out.println(result);
				return false;
			}

			IntStream.range(0, input.length())
					.forEach(i -> permute(input.substring(0, i) + input.substring(i + 1), result + input.charAt(i)));
		}
		return false;
	}

	public static void permute(String str, String result) {
		if (str.isEmpty()) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			permute(str.substring(0, i) + str.substring(i + 1), result + str.charAt(i));
		}
	}

	private static boolean anagarmStrings(boolean start, String method, String str1, String str2) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			if (str1.length() != str2.length()) {
				System.out.println("Lenght of 2 strings is not same!");
				return false;
			}
			char[] strChar1 = str1.toCharArray();
			char[] strChar2 = str2.toCharArray();
			Arrays.sort(strChar1);
			Arrays.sort(strChar2);
			if (Arrays.equals(strChar1, strChar2)) {
				System.out.println("true");
				return true;
			}
		} else if (method.equalsIgnoreCase("Streams")) {
			if (str1.length() != str2.length()) {
				System.out.println("Lenght of 2 strings is not same!");
				return false;
			}
			if (str1.chars().boxed().collect(Collectors.groupingBy(Function.identity()))
					.equals(str2.chars().boxed().collect(Collectors.groupingBy(Function.identity())))) {
				System.out.println("true");
				return true;
			}
		}
		return false;
	}

	private static boolean swapNumber(boolean start, String method, int a, int b) {

		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			System.out.println("Before swap = " + "a ->" + a + " b -> " + b);
			a = a + b;
			b = a - b;
			a = a - b;
			System.out.println(" After swap = " + "a ->" + a + " b -> " + b);
		} else if (method.equalsIgnoreCase("streams")) {

		}
		return false;

	}

	private static boolean helloWorld(boolean start, String method, String input) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			System.out.println(input);
		} else if (method.equalsIgnoreCase("streams")) {

		}
		return false;
	}

}
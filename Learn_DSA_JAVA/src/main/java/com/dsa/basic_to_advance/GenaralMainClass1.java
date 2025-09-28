package com.dsa.basic_to_advance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GenaralMainClass1 {

	public static void main(String[] args) {

		// ** NOTE ** //
		// Streams method = Streams
		// Old method = core
		// Recursion method = recursion

		// ** reverse a string
		reversString(false, "recursion", "Hellow");

		// ** Check if a number is a prime
		isPrime(false, "core", 11);

		// ** Find the factorial of a number
		factorial(false, "Recursion", 6);
		
		// ** Find the fibonacci of a number
		fibonacci(true, "Recursion", 2);

		// ** Find the largest element in an array
		largetsElement(false, "core");

		// ** Check if a string is palindrom
		palindrom(false, "streams", 121);
	}

	private static boolean fibonacci(boolean start, String method, int n) {
		if(!start) {
			return false;
		}
		if(method.equalsIgnoreCase("recursion")) {
			System.out.println(fiboRec(n));
		}
		return false;
	}

	private static int fiboRec(int n) {
		if(n<=1) {
			return n;
		}
		return fiboRec(n - 1) + fiboRec(n - 2);
	}

	private static String reversString(boolean start, String method, String string) {
		if (!start) {
			return null;
		}
		if (method.equalsIgnoreCase("method")) {
			StringBuilder strBldr = new StringBuilder(string);
			strBldr.reverse();
			return strBldr.toString();
		} else if (method.equalsIgnoreCase("core")) {
			String reverse = "";
			for (int i = string.length() - 1; i >= 0; i--) {
				reverse += string.charAt(i);
			}
			System.out.println(reverse);
			return reverse;
		} else if (method.equalsIgnoreCase("recursion")) {
			System.out.println(reversStringRecursion(string));
			return null;
		}
		return "input ->" + string;

	}

	public static String reversStringRecursion(String str) {
		if (str.isEmpty())
			return str;
		return reversStringRecursion(str.substring(1)) + str.charAt(0);
	}

	public static boolean isPrime(boolean start, String method, int num) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			if (num <= 1) {
				System.out.println(false);
				return false; // 0 and 1 are not prime numbers
			}
			if (num == 2) {
				System.out.println(false);
				return true; // 2 is the only even prime number
			}

			for (int i = 2; i <= Math.sqrt(num); i++) { // Check up to √num
				if (num % i == 0) {
					System.out.println(false);
					return false; // If divisible, not a prime
				}

			}
			System.out.println(true);
			return true;
		} else if (method.equalsIgnoreCase("Streams")) {
			if (num <= 1) {
				System.out.println(false);
				return false; // 0 and 1 are not prime numbers
			}
			return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
		}
		System.out.println(false);
		return false;
	}

	private static boolean palindrom(boolean start, String method, int num) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			int original = num;
			int reverse = 0;
			while (num > 0) {
				int digi = num % 10;
				reverse = reverse * 10 + digi;
				num /= 10;
			}
			if (original == reverse) {
				System.out.println("It's a palindrom number -> " + original);
			} else {
				System.out.println("It's not a palindrom number -> " + original);
			}
		} else if (method.equalsIgnoreCase("Streams")) {
			String str = String.valueOf(num);
			System.out.println(IntStream.range(0, str.length() / 2)
					.allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1)));
		}
		return false;
	}

	private static boolean largetsElement(boolean start, String method) {
		if (!start) {
			return false;
		}
		// List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5);
		int[] ls = { 1, 2, 3, 4, 5 };
		if (method.equalsIgnoreCase("core")) {
			int max = 0;
			for (int num : ls) {
				if (num > max) {
					max = num;
				}
			}
			System.out.println("Max number -> " + max);
		} else if (method.equalsIgnoreCase("Streams")) {
			int max = Arrays.stream(ls).max().orElseThrow();
			System.out.println("Max number -> " + max);
		}

		return false;
	}

	private static boolean factorial(boolean start, String method, int num) {
		if (!start) {
			return false;
		}
		if (method.equalsIgnoreCase("core")) {
			long fact = 1;
			for (int i = 2; i <= num; i++) {
				fact *= i;
			}
			System.out.println("factorial of " + num + " is -> " + fact);
			return true;
		} else if (method.equalsIgnoreCase("Recursion")) {
			System.out.println("factorial of " + num + " is -> " + factorialRecursion(num));
		}
		return false;
	}

	private static long factorialRecursion(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		return num * factorialRecursion(num - 1);
	}

}
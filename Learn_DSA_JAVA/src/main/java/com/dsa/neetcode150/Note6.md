# Problem #6: Encode and Decode Strings

## Problem Description

Design an algorithm to encode a list of strings into a single string, and a corresponding algorithm to decode the single string back to the original list of strings.  

The solution must be **lossless**, meaning that after encoding and decoding, the original list of strings should be exactly preserved.

## Example

```text
Input: ["neet", "code", "love", "you"]
Output: ["neet", "code", "love", "you"]
```

```text
public class EncodeDecodeStrings { // Encodes a list of strings to a single string
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString();
    } // Decodes a single string back to a list of strings

    public static List<String> decode(String encodedStr) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < encodedStr.length()) {
            int j = i; // find the '#' delimiter to extract length
            while (encodedStr.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(encodedStr.substring(i, j));
            j++; // move past '#'
            String word = encodedStr.substring(j, j + length);
            result.add(word);
            i = j + length; // move to next encoded segment
        }
        return result;
    } // Driver code

    public static void main(String[] args) {
        List<String> input = Arrays.asList("neet", "code", "love", "you");
        String encoded = encode(input);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
```

# My Findings

- Always `for` loop is not good — sometimes we need to use a `while` loop as well.  
- `encodedStr.charAt(j) != '#'` is used to find a specific character in a string.  
- Please learn how `substring` works: `encodedStr.substring(i, j)`.


## Understanding `substringsubstring` in Java
```
String substring(int beginIndex)  
String substring(int beginIndex, int endIndex)
```
- beginIndex → inclusive (starts at this index)
- endIndex → exclusive (stops before this index)

```
public class SubstringDemo {
    public static void main(String[] args) {
        String str = "HelloWorld";

        // Example 1: substring(beginIndex)
        System.out.println(str.substring(0));  // HelloWorld (whole string)
        System.out.println(str.substring(5));  // World (starts at index 5)

        // Example 2: substring(beginIndex, endIndex)
        System.out.println(str.substring(0, 5));  // Hello  (0 to 4)
        System.out.println(str.substring(3, 7));  // loWo   (3 to 6)
        System.out.println(str.substring(7, 10)); // rld    (7 to 9)

        // Example 3: extracting single characters (like charAt but slower)
        System.out.println(str.substring(1, 2));  // e (only index 1)

        // Example 4: empty string
        System.out.println("Empty: '" + str.substring(5, 5) + "'"); // ""

        // Example 5: error case
        try {
            System.out.println(str.substring(5, 15)); // StringIndexOutOfBoundsException
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

```



# Problem Statement
Design a class that perform following operations on Strings, without using Java APIs. <br>
Assume strings to be not null and case sensitive. 

- Compare two strings and return 1 if equals else 0. Take two string inputs, compare them and return values accordingly.
- Return the reverse of any string.
- Receive a string as parameter and replace lowercase characters with uppercase and vice-versa. 
- Return the largest word of a string. If two words are of same length then return last word.


Also write proper specification for each method created above.

# StringManipulation
```java
class StringManipulation{
	static final int CHAR_CASE_SHIFT = 32;
	static final int ASCII_FOR_SPACE = 32;


	// Returns 1 if strings match else 0
	public static int compare(String s1, String s2){
		int lengthOfS1 = s1.length();
		int lengthOfS2 = s2.length();

		if(lengthOfS1 != lengthOfS2) return 0;

		for(int i = 0; i<lengthOfS1; i++){
			if(s1.charAt(i) != s2.charAt(i)) return 0;
		}
		
		return 1;
	}

	public static String reverseString(String s){
		String result = "";

		int stringLength = s.length();
		for(int i = 0; i<stringLength; i++){
			result = s.charAt(i) + result;
		}

		return result;
	}

	public static String reverseCase(String s){
		String result = "";

		int stringLength = s.length();
		for(int i = 0; i<stringLength; i++){
			int charAsciiValue = (int)s.charAt(i);

			if(charAsciiValue >=65 && charAsciiValue <=90){
				result = result + (char)(charAsciiValue + CHAR_CASE_SHIFT);
			}else if(charAsciiValue >=97 && charAsciiValue <=122){
				result = result + (char)(charAsciiValue - CHAR_CASE_SHIFT);
			}else{
				result = result + (char)charAsciiValue;
			}
		}

		return result;
	}

	static public String longestWordInString(String s){
		String longestString = "";
		String currentString = "";

		int stringLength = s.length();
		for(int i = 0; i<stringLength; i++){
			boolean isLastChar = i == stringLength - 1;
			boolean isNotSpaceChar = (int)s.charAt(i) != ASCII_FOR_SPACE;
			//boolean wordEnd = isSpaceChar || isLastChar;

			if(isNotSpaceChar && !isLastChar){
				currentString += s.charAt(i);
			}else if(isLastChar){
				currentString += s.charAt(i);
				if(longestString.length() <= currentString.length()) longestString = currentString;
			}else{
				if(longestString.length() <= currentString.length()){
					longestString = currentString;
				}
				currentString = "";
			}
		}
		
		return longestString;
	} 
}

class Assignment {
	public static void main(String[] args) {
		// String compare usage
		int out = StringManipulation.compare("String", "String");
		System.out.println(out);

		// String reverse usage
		System.out.println(StringManipulation.reverseString("String"));

		// String reverseCase usage
		System.out.println(StringManipulation.reverseCase("String"));

		// Longest word in string usage
		System.out.println(StringManipulation.longestWordInString(" How are doing my buddy"));
	}
}
```
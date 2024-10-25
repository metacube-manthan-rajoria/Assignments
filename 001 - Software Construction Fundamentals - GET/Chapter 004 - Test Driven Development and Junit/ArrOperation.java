import java.util.Scanner;
import java.util.ArrayList;

public class ArrOperation {
	private int intArray[];
	private int intArraySize = 0;

	public ArrOperation(ArrayList<Integer> arr) {
		intArraySize = arr.size();
		intArray = new int[intArraySize];
		for (int i = 0; i < intArraySize; i++) {
			intArray[i] = arr.get(i);
		}
	}

	public int maxMirror() {
		ArrayList<Integer> mirrors = new ArrayList<Integer>();

		// 2 Pointers used in both for Loops
		int left = 0;
		int right = 0;

		// Handles odd mirrors(For ex: 121)
		for (int i = 0; i < intArraySize; i++) {
			left = i;
			right = i;
			int window = 0;
			boolean cont = true;
			int immediateInt = 0;
			int addWindow = 1;

			while (left > 0 && right < intArraySize - 1) {
				left--;
				right++;
				immediateInt++;
				if (intArray[left] == intArray[right]) {
					if (immediateInt == 1) {
						window++;
						addWindow = 2;
						cont = true;
					}
					if (cont) {
						window += addWindow;
					} else {
						addWindow = 1;
						window += addWindow;
					}
					if (window > 1) {
						mirrors.add(window);
					}
				} else {
					window = 0;
					addWindow = 1;
					cont = false;
				}
			}
		}

		// Handles even mirrors(For ex: 1221)
		for (int i = 0; i < intArraySize; i++) {
			left = i;
			right = i + 1;
			int window = 0;

			while (left > 0 && right < intArraySize - 1) {
				left--;
				right++;
				if (intArray[left] == intArray[right]) {
					window += 1;
				}
			}

			if (window > 1) {
				mirrors.add(window);
			}
		}

		// Find max window in mirrors list
		int maxMirror = 0;
		for (int i = 0; i < mirrors.size(); i++) {
			if (mirrors.get(i) > maxMirror) {
				maxMirror = mirrors.get(i);
			}
		}
		return maxMirror;
	}

	public int clumpArray() {
		int lastElement = -1;
		boolean newElement = true;
		int clusters = 0;

		for (int i = 0; i < intArraySize; i++) {
			// First time loop
			if (lastElement == -1) {
				lastElement = intArray[i];
				continue;
			}

			if (intArray[i] == lastElement) {
				if (newElement) {
					clusters += 1;
				}
				newElement = false;
			} else {
				newElement = true;
			}
			lastElement = intArray[i];
		}

		return clusters;
	}

	public int[] fixXY(int x, int y) {
		// Making a copy of intArray
		int resultArray[] = new int[intArraySize];
		for (int i = 0; i < intArraySize; i++) {
			resultArray[i] = intArray[i];
		}

		ArrayList<Integer> indexOfAllX = new ArrayList<Integer>();
		ArrayList<Integer> freeIntegers = new ArrayList<Integer>();

		try {
			/*
			 * If number of X != number of Y then throw error
			 * Also count number and index of all X
			 */
			int totalXNumbers = 0;
			int totalYNumbers = 0;
			for (int i = 0; i < intArraySize; i++) {
				if (resultArray[i] == x) {
					totalXNumbers++;
					indexOfAllX.add(i);
				} else if (resultArray[i] == y) {
					totalYNumbers++;
					resultArray[i] = -1;
				} else {
					freeIntegers.add(resultArray[i]);
					resultArray[i] = -1;
				}
			}
			// Error if count of x != count of y OR last element is x
			if (totalXNumbers != totalYNumbers || resultArray[intArraySize - 1] == x) {
				throw new Exception("Invalid Array");
			}

			// Set all values after x to y
			for (Integer i : indexOfAllX) {
				resultArray[i + 1] = y;
			}

			// Put all non x,y numbers in rest of the spaces
			for (int i = 0; i < intArraySize; i++) {
				if (resultArray[i] == -1) {
					resultArray[i] = freeIntegers.get(0);
					freeIntegers.remove(0);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return resultArray;
	}

	public int splitArray() {
		int total = 0; // Total sum of array
		for (int i = 0; i < intArraySize; i++) {
			total += intArray[i];
		}

		int leftWindow = 0;
		for (int i = 0; i < intArraySize; i++) {
			leftWindow += intArray[i];
			if (total - leftWindow == leftWindow) {
				return i + 1;
			}
		}
		return -1;
	}
}

class Assignment {
	public static void main(String[] args) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		try {
			// Taking user input
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter number of inputs : ");
			int noOfInputs = scanner.nextInt();
			System.out.println();
			for (int i = 0; i < noOfInputs; i++) {
				System.out.print("Enter int for index " + i + " : ");
				int input = scanner.nextInt();
				intArray.add(input);
				System.out.println();
			}
			scanner.close();

			// Example uses
			ArrOperation op = new ArrOperation(intArray);

			System.out.println("Max Mirror Size : " + op.maxMirror());

			System.out.println("Clumps in Array : " + op.clumpArray());

			int fixedArray[] = op.fixXY(4, 5);
			System.out.print("Fixed Array : ");
			for (int i = 0; i < noOfInputs; i++) {
				System.out.print(fixedArray[i] + " ");
			}
			System.out.println();

			System.out.println("Split Array Position : " + op.splitArray());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

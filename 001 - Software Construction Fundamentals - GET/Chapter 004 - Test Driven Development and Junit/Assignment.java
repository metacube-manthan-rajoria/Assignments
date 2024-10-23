import java.util.Scanner;
import java.util.ArrayList;

class ArrOperation {
	private int intArray[];
	private int intArraySize = 0;

	public ArrOperation(ArrayList<Integer> arr) {
		intArraySize = arr.size();
		intArray = new int[intArraySize];
		for (int i = 0; i < intArraySize; i++) {
			intArray[i] = arr.get(i);
		}
	}

	public int maxMirror(){
		ArrayList<Integer> mirrors = new ArrayList<Integer>();
		System.out.println();

		int left = 0;
		int right = 0;
		for(int i = 0; i<intArraySize; i++){
			left = i;
			right = i;
			int window = 0;

			int immediateInt = 0;
			while(left > 0 && right < intArraySize-1){
				left  -= 1;
				right += 1;
				immediateInt++;
				if(intArray[left] == intArray[right]){
					if(immediateInt == 1){
						window++;
					}
					System.out.println("Loop 1 - Index : " + i + " = " + intArray[left] + " : " + intArray[right]);
					window += 2;
				}
			}

			if(window > 1){
				mirrors.add(window);
			}
		}
		for(int i = 0; i<intArraySize; i++){
			left = i;
			right = i+1;
			int window = 0;

			while(left > 0 && right < intArraySize - 1){
				left  -= 1;
				right += 1;
				if(intArray[left] == intArray[right]){
					System.out.println("Loop 2 - Index : " + i + " = " + intArray[left] + " : " + intArray[right]);
					window += 1;
				}
			}

			if(window > 1){
				mirrors.add(window);
			}

		}
		


		int maxMirror = 0;
		for(int i = 0; i<mirrors.size(); i++){
			if(mirrors.get(i) > maxMirror) maxMirror = mirrors.get(0);
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
				if (newElement)
					clusters += 1;
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
			// if number of X != number of Y
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
			if (totalXNumbers != totalYNumbers || resultArray[intArraySize - 1] == x)
				throw new Exception("Invalid Array");



			//
			for (Integer i : indexOfAllX) {
				resultArray[i + 1] = y;
			}
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
		int total = 0;
		for (int i = 0; i < intArraySize; i++) {
			total += intArray[i];
		}

		int leftWindow = 0;
		for (int i = 0; i < intArraySize; i++) {
			leftWindow += intArray[i];
			if (total - leftWindow == leftWindow)
				return i + 1;
		}
		return total;
	}

}

class Assignment {
	public static void main(String[] args) {
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		try {

			// Taking user input
			// Scanner scanner = new Scanner(System.in);
			// System.out.print("Enter number of inputs : ");
			// int noOfInputs = scanner.nextInt();
			// System.out.println();
			// for (int i = 0; i < noOfInputs; i++) {
			// 	System.out.println("Enter int for index " + i + " : ");
			// 	int input = scanner.nextInt();
			// 	intArray.add(input);
			// 	System.out.println();

			// }
			// scanner.close();
			intArray.add(1);
			intArray.add(2);
			intArray.add(1);
			intArray.add(3);

			// Example uses
			ArrOperation op = new ArrOperation(intArray);
			// System.out.println(op.clumpArray());
			// System.out.println(op.splitArray());

			// int fixedArray[] = op.fixXY(4, 5);
			// for(int i = 0; i<noOfInputs; i++){
			// 	System.out.print(fixedArray[i] + " ");
			// }
			



			/// Change to noOfInputs
			for(int i = 0; i<intArray.size(); i++){
				System.out.print(intArray.get(i) + " ");
			}

			int ans = op.maxMirror();
			System.out.println("Max : " + ans);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

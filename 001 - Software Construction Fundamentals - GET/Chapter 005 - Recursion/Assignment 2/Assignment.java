// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.HashMap;

class MathOperations {
	int index = 0;

	public int findNumber(int numArray[], int num){
		if((index == numArray.length - 1) && numArray[index] != num) return -1;

		if(numArray[index] == num){
			return index;
		}

		index++;

		findNumber(numArray, num);
		return index;
	}
	static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

	
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

}

public class Assignment {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		MathOperations mo = new MathOperations();
		int res = mo.findNumber(arr, 7);
		System.out.println(res);
	}
}

import java.util.Scanner;

public class MathOperations {
    /**
     * Gives the Highest Common Factor of two numbers
     * 
     * @param number1 first number
     * @param number2 second number
     * @return integer hcf
     */
    public int getHCF(int number1, int number2) {
        int remainder = number1 % number2;

        if (remainder == 0)
            return number2;
        return getHCF(number2, remainder);
    }

    /**
     * Gives the Lowest Common Multiple of two numbers
     * 
     * @param number1 first number
     * @param number2 second number
     * @return integer lcm
     */
    public int getLCM(int number1, int number2) {
        int hcfOfNumbers = getHCF(number1, number2);
        int product = number1 * number2;
        return (int) product / hcfOfNumbers;
    }
}

class Assignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 25;
        int num2 = 10;
        // int num1 = scanner.nextInt();
        // int num2 = scanner.nextInt();

        MathOperations mathOp = new MathOperations();
        System.out.println("LCM : " + mathOp.getLCM(num1, num2));
        System.out.println("HCF : " + mathOp.getHCF(num1, num2));
        scanner.close();
    }
}

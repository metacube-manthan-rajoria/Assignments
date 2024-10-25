import java.util.Scanner;

class MathOperations {
	private int number1 = 0;
	private int number2 = 0;

	public MathOperations(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public int getHCF(int a, int b) {
        if (a == 0) return b;
        return getHCF(b % a, a);
    }

	public int getLCM(int a, int b) {
        return (a / getLCM(a, b)) * b;
    }

	/**
     * @return int return the number1
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    /**
     * @return int return the number2
     */
    public int getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(int number2) {
        this.number2 = number2;
    }
}

class Assignment {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();

		MathOperations mathOp = new MathOperations(num1, num2);
		System.out.println(mathOp.getLCM(num1, num2));
		System.out.println(mathOp.getHCF(num1, num2));
	}
}

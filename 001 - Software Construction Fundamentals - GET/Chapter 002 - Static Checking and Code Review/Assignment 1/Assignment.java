import java.util.HashMap;

class BaseConverter {
	private final HashMap<String, String> map = new HashMap<String, String>();
	private final int CHAR_ASCII_SHIFT = 87;

	public BaseConverter(){
		map.put("0", "0");
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		map.put("8", "8");
		map.put("9", "9");
		map.put("a", "10");
		map.put("b", "11");
		map.put("c", "12");
		map.put("d", "13");
		map.put("e", "14");
		map.put("f", "15");
		map.put("g", "16");
		map.put("h", "17");
		map.put("i", "18");
		map.put("j", "19");
		map.put("k", "20");
		map.put("l", "21");
		map.put("m", "22");
		map.put("n", "23");
		map.put("o", "24");
		map.put("p", "25");
		map.put("q", "26");
		map.put("r", "27");
		map.put("s", "28");
		map.put("t", "29");
		map.put("u", "30");
		map.put("v", "31");
		map.put("w", "32");
		map.put("x", "33");
		map.put("y", "34");
		map.put("z", "35");
	}

	public int toDecimal(String number, int base){

		// Exception Handling
		if(number.isEmpty()) return -1;
		if(base < 2) return -1;

		String normalisedNumber = number.toLowerCase();

		int numberLengthInText = normalisedNumber.length();
		for(int i = 0; i<numberLengthInText; i++){
			char c = normalisedNumber.charAt(i);
			if(c == ' ') return -1;

			int numericValueOfChar = Integer.parseInt(map.get(c+""));
			if(numericValueOfChar >= base) return -1;
		}
		
		// Main Logic
		int result = 0;
		for(int i = numberLengthInText-1; i>=0; i--){
			int lastDigit = Integer.parseInt(map.get(normalisedNumber.charAt(i)+""));
			Double place_value = Math.pow(base, numberLengthInText - 1 - i);
			int final_value = lastDigit * place_value.intValue();
			result += final_value;
		}

		return result;
	}

	public String toBase(int number, int outputBase){
		if(outputBase > 35) return "Invalid Base";
		String result = "";
		int numberCopy = number;
		while(numberCopy > 0){
			int remainder = numberCopy % outputBase;
			numberCopy = numberCopy / outputBase;

			if(remainder <= 9){
				result = remainder + result;
			}else{
				result = result + Character.toString((char) remainder + CHAR_ASCII_SHIFT);
			}
		}

		return result;
	}
}

class HexCalc {
	static BaseConverter bc = new BaseConverter();
	public static String addNumber(String num1, String num2, int base1, int base2){
		int num1_decimal = bc.toDecimal(num1, base1);
		int num2_decimal = bc.toDecimal(num2, base1);
		return bc.toBase(num1_decimal + num2_decimal, base2) + "";
	}
	public static String subtractNumber(String num1, String num2, int base1, int base2){
		int num1_decimal = bc.toDecimal(num1, base1);
		int num2_decimal = bc.toDecimal(num2, base1);
		return bc.toBase(num1_decimal - num2_decimal, base2) + "";
	}
	public static String multiplyNumber(String num1, String num2, int base1, int base2){
		int num1_decimal = bc.toDecimal(num1, base1);
		int num2_decimal = bc.toDecimal(num2, base1);
		return bc.toBase(num1_decimal * num2_decimal, base2) + "";
	}
	public static String divideNumber(String num1, String num2, int base1, int base2){
		int num1_decimal = bc.toDecimal(num1, base1);
		int num2_decimal = bc.toDecimal(num2, base1);
		return bc.toBase(num1_decimal * num2_decimal, base2) + "";
	}

	// Prints 
	// 1  if num1 > num2
	// 0  if num1 = num2
	// -1 if num2 < num2
	public static int compare(String num1, String num2, int base){
		int num1_decimal = bc.toDecimal(num1, base);
		int num2_decimal = bc.toDecimal(num2, base);
		if(num1_decimal < 0 || num2_decimal < 0) return -2;

		if(num1.length() > num2.length()) return 1;
		if(num1.length() < num2.length()) return -1;
		if(num1.equals(num2)) return 0;

		int len = num1.length();
		for(int i = 0; i<len; i++){
			if(num1.charAt(i) > num2.charAt(i)) return 1;
			if(num1.charAt(i) < num2.charAt(i)) return -1;
		}

		return -2;
	}
}

class Assignment {
	public static void main(String[] args) {
		BaseConverter bc = new BaseConverter();

		System.out.println(bc.toDecimal("4CC", 16));
		System.out.println(bc.toBase(1228, 16));
		
		System.out.println(HexCalc.addNumber("1000", "228", 10, 16));
		System.out.println(HexCalc.compare("4F", "4C", 16));
		
	}
}
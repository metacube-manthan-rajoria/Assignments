import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class BaseConverter {
	private final HashMap<String, String> map = new HashMap<String, String>();
	private final int CHAR_NORMALIZE = 87;

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
		if(number.isEmpty()) return 0;
		if(base < 2) return 0;

		String normalisedNumber = number.toLowerCase();

		int numberLengthInText = normalisedNumber.length();
		for(int i = 0; i<numberLengthInText; i++){
			char c = normalisedNumber.charAt(i);
			if(c == ' ') return 0;

			int numericValueOfChar = Integer.parseInt(map.get(c+""));
			if(numericValueOfChar >= base) return 0;
		}
		
		// Main Logic
		int result = 0;

		for(int i = numberLengthInText-1; i>=0; i--){
			System.out.println("hahdasd");
			int lastDigit = Integer.parseInt(map.get(normalisedNumber.charAt(i)+""));
			Double place_value = Math.pow(base, numberLengthInText - 1 - i);
			int final_value = lastDigit * place_value.intValue();
			result += final_value;
		}

		return result;
	}
}

class Assignment {
	public static void main(String[] args) {

		BaseConverter bc = new BaseConverter();
		System.out.println(bc.toDecimal("101", 2));
		
	}
}
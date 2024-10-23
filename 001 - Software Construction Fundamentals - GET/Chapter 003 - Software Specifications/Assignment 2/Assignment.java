import java.util.ArrayList;

class ClassMarksheet {
	ArrayList<Integer> marksheet = new ArrayList<Integer>();
	private final int PASSING_MARKS = 40;

	/**
	 * add marks to list
	 * 
	 * @param marks marks obtained by student
	 * @throws ArithematicException when marks<0
	 */
	public void addMarks(int marks) {
		try {
			if (marks < 0 || marks > 100)
				throw new ArithmeticException("Invalid Marks");
			marksheet.add(marks);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * get average of all marks
	 * 
	 * @return double average rounded to 2 decimal places
	 * @throws ArithematicException if Marksheet is empty
	 */
	public double averageMarks() {
		try {
			if (marksheet.isEmpty())
				throw new ArithmeticException("Marksheet Empty");
			double sum = 0;
			for (Integer i : marksheet) {
				sum += i;
			}
			double result = sum / (double) marksheet.size();
			return Double.parseDouble(String.format("%.2f", result));
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	/**
	 * maximum marks obtained
	 * 
	 * @return int maximum marks in list
	 * @throws ArithematicException if Marksheet is empty
	 */
	public int maximumMarks() {
		try {
			if (marksheet.isEmpty())
				throw new ArithmeticException("Marksheet Empty");
			int max = 0;
			for (Integer i : marksheet) {
				if (i > max)
					max = i;
			}
			return max;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}

	/**
	 * minimum marks obtained
	 * 
	 * @return int minimum marks in list
	 * @throws ArithematicException if Marksheet is empty
	 */
	public int minimumMarks() {
		try {
			if (marksheet.isEmpty())
				throw new ArithmeticException("Marksheet Empty");
			int min = 100;
			for (Integer i : marksheet) {
				if (i < min)
					min = i;
			}
			return min;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	/**
	 * Percent of students who passed( marks > 40 )
	 * 
	 * @return double percentage rounded to 2 decimal places
	 * @throws ArithematicException if Marksheet is empty
	 */
	public double percentOfPassedStudents() {
		try {
			if (marksheet.isEmpty())
				throw new ArithmeticException("Marksheet Empty");

			double passedCount = 0;
			for (Integer i : marksheet) {
				if (i >= PASSING_MARKS) {
					passedCount += 1;
				}
			}

			double ratio = passedCount / (double) marksheet.size();
			return Double.parseDouble(String.format("%.2f", ratio * 100));
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
}

class Assignment {
	public static void main(String[] args) {
		ClassMarksheet marksheet = new ClassMarksheet();
		marksheet.addMarks(10);
		marksheet.addMarks(20);
		marksheet.addMarks(30);
		marksheet.addMarks(40);
		marksheet.addMarks(50);
		marksheet.addMarks(60);
		marksheet.addMarks(70);
		marksheet.addMarks(80);
		marksheet.addMarks(90);
		marksheet.addMarks(100);

		System.out.println(marksheet.averageMarks());
		System.out.println(marksheet.maximumMarks());
		System.out.println(marksheet.minimumMarks());
		System.out.println(marksheet.percentOfPassedStudents());
	}
}

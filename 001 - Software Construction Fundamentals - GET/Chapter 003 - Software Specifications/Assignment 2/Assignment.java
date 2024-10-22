import java.util.ArrayList;

class ClassMarksheet {
	ArrayList<Integer> marksheet = new ArrayList<Integer>();
	private final int PASSING_MARKS = 40; 

	/**
	 * add marks to list
	 * @param marks marks obtained by student
	 */
	public void addMarks(int marks){
		if(marks<0 || marks>100) return;
		marksheet.add(marks);
	}

	/**
	 * get average of all marks
	 * @return double average rounded to 2 decimal places 
	 */
	public double averageMarks(){
		if(marksheet.isEmpty()) return 0;
		double sum = 0;
		for(Integer i : marksheet){
			sum += i;
		}
		double result = sum/(double)marksheet.size();
		return Double.parseDouble(String.format("%.2f", result));
	}

	/**
	 * maximum marks obtained
	 * @return int maximum marks in list
	 */
	public int maximumMarks(){
		if(marksheet.isEmpty()) return 0;
		int max = 0;
		for(Integer i : marksheet){
			if(i > max) max = i;
		}
		return max;
	}

	/**
	 * minimum marks obtained
	 * @return int minimum marks in list
	 */
	public int minimumMarks(){
		if(marksheet.isEmpty()) return 0;
		int min = 100;
		for(Integer i : marksheet){
			if(i < min) min = i;
		}
		return min;
	}

	/**
	 * Percent of students who passed( marks > 40 )
	 * @return double percentage rounded to 2 decimal places
	 */
	public double percentOfPassedStudents(){
		if(marksheet.isEmpty()) return 0;

		double passedCount = 0;
		for(Integer i : marksheet){
			if(i >= PASSING_MARKS){
				passedCount += 1;
			}
		}

		double ratio = passedCount/(double)marksheet.size();
		return Double.parseDouble(String.format("%.2f", ratio*100));
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

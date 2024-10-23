



class Assignment {
	public static void main(String[] args) {
		int[] arr = {1,14,1,2,1,10,1};
		int length = 7;

		System.out.println(""+splitArray(arr, length));

	}

	public static int clumpArray(int[] arr, int length){
		int lastElement = -1;
		boolean newElement = true;
		int clusters = 0;

		for(int i = 0; i<length; i++){
			if(lastElement == -1){
				lastElement = arr[i];
				continue;
			}
			if(arr[i] == lastElement)

		}


		return 0;
	}

	public static int splitArray(int[] arr, int length){
		int total = 0;
		for(int i = 0; i<length; i++){
			total += arr[i];
		}

		int leftWindow = 0;
		for(int i = 0; i<length; i++){
			leftWindow += arr[i];
			if(total - leftWindow == leftWindow) return i + 1;
		}
		return total;
	}
}

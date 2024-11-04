import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

final class IntSet {
    private final int currentSet[];
    private final HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

    public IntSet(int arr[]){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 0 && arr[i] <=1000){
                map.put(arr[i], 1);
            }
        }
        currentSet = arr;
    }

    /**
     * Checks whether x is the part of current set
     * @param x integer to be checked
     * @return boolean. true if set contains x, false otherwise.
     */
    public boolean isMember(int x){
        if(map.getOrDefault(x, 0) >= 1){
            return true;
        }
        return false;
    }

    /**
     * Gives count of unique elements in the set 
     * @return integer size of set
     */
    public int size(){
        return map.size();
    }

    /**
     * Checks if every element of s is present in current set
     * @param s set that is to be checked
     * @return boolean. true if s is subset of current set
     */
    public boolean isSubSet(IntSet s){
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.putAll(s.getSet());
        boolean isSubSet = true;

        for(Integer i : m.keySet()){
            if(map.getOrDefault(i, 0) != 1){
                isSubSet = false;
            }
        }

        return isSubSet;
    }

    /**
     * Returns universal set - current set
     * @return int array of complement of current set
     */
    public int[] getComplement(){
        int result[] = new int[1000 - map.size()];
        int index = 0;
        for(int i = 1; i<=1000; i++){
            if(map.getOrDefault(i, 0) == 0){
                result[index] = i;
                index++;
            }
        }
        return result;
    }
    
    /**
     * Returns union of current set and input set
     * @param s input set
     * @return integer array containing union of both sets
     */
    public int[] union(IntSet s){
        HashMap<Integer, Integer> union = new HashMap<Integer, Integer>();
        union.putAll(s.getSet());
        
        for(Integer i : map.keySet()){
            union.put(i, 1);
        }
        
        int result[] = new int[union.size()];
        int index = 0;
        for(Integer i : union.keySet()){
            result[index] = i;
            index++;
        }

        return result;
    }

    /**
     * Gives all elements that are present in both sets
     * @param s input array
     * @return integer array containing intersection of both sets
     */
    public int[] intersection(IntSet s){
        ArrayList<Integer> resultArray = new ArrayList<Integer>();

        for(Integer i : s.getSet().keySet()){
            if(map.getOrDefault(i, 0) >= 1){
                resultArray.add(i);
            }
        }

        int result[] = new int[resultArray.size()];
        int index = 0;
        for(Integer i : resultArray){
            result[index] = i;
            index++;
        }

        return result;
    }

    /**
     * Gives all elements that are only present in cureent set
     * @param s input set
     * @return integer array containing difference
     */
    public int[] difference(IntSet s){
        HashMap<Integer, Integer> difference = new HashMap<Integer, Integer>();
        difference.putAll(map);
        for(Integer i : s.getSet().keySet()){
            difference.remove(i);
        }

        int result[] = new int[difference.size()];
        int index = 0;
        for(Integer i : difference.keySet()){
            result[index] = i;
            index++;
        }

        return result;
    }

    /**
     * Prints the set
     */
    public void show(){
        for(int i = 0; i<currentSet.length; i++){
            System.out.println(currentSet[i]);
        }
    }

    public HashMap<Integer, Integer> getSet(){
        return map;
    }
}

public class Assignment{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of first set : ");
        int set1Size = scanner.nextInt();
        int arr1[] = new int[set1Size];

        System.out.println();
        for(int i = 0; i<set1Size; i++){
            System.out.print("Enter number " + (i + 1) + " : ");
            int input = scanner.nextInt();
            arr1[i] = input; 
        }

        System.out.print("\nEnter size of second set : ");
        int set2Size = scanner.nextInt();
        int arr2[] = new int[set2Size];

        System.out.println();
        for(int i = 0; i<set2Size; i++){
            System.out.print("Enter number " + (i + 1) + " : ");
            int input = scanner.nextInt();
            arr2[i] = input; 
        }

        System.out.print("\nEnter a random number : ");
        int randomNumber = scanner.nextInt();
        scanner.close();
         
        IntSet intSet1 = new IntSet(arr1);
        IntSet intSet2 = new IntSet(arr2);

        int res1[] = intSet1.union(intSet2);
        int res2[] = intSet1.intersection(intSet2);
        int res3[] = intSet1.difference(intSet2);
        
        System.out.println("\nIs " + randomNumber + " member of set1 : " + intSet1.isMember(randomNumber));
        System.out.println("Set 1 size : " + intSet1.getSet().size());
        System.out.println("Is set2 subset of set1 : " + intSet1.isSubSet(intSet2));
       
        System.out.println("\nUnion");
        for(int i = 0; i<res1.length; i++){
            System.out.print(res1[i] + " ");
        }
        //System.out.println();
        System.out.println("\n\nIntersection");
        for(int i = 0; i<res2.length; i++){
            System.out.print(res2[i] + " ");
        }
        //System.out.println();
        System.out.println("\n\nDifference");
        for(int i = 0; i<res3.length; i++){
            System.out.print(res3[i] + " ");
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;

final class IntSet {
    private final int array[];
    private final HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

    public IntSet(int arr[]){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 0 && arr[i] <=1000){
                map.put(arr[i], 1);
            }
        }
        array = arr;
    }

    public boolean isMember(int x){
        if(map.getOrDefault(x, 0) >= 1){
            return true;
        }
        return false;
    }

    public int size(){
        return map.size();
    }

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

    public void show(){
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public HashMap<Integer, Integer> getSet(){
        return map;
    }
}

public class Assignment{
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {3,4,7};
         
        IntSet intSet1 = new IntSet(arr1);
        IntSet intSet2 = new IntSet(arr2);

        int res1[] = intSet1.union(intSet2);
        int res2[] = intSet1.intersection(intSet2);
        int res3[] = intSet1.difference(intSet2);
        

        System.out.println(intSet1.isMember(7));
        System.out.println(intSet1.getSet().size());
        System.out.println(intSet1.isSubSet(intSet2));
       
        for(int i = 0; i<res1.length; i++){
            System.out.println(res1[i]);
        }
        System.out.println();
        for(int i = 0; i<res2.length; i++){
            System.out.println(res2[i]);
        }
        System.out.println();
        for(int i = 0; i<res3.length; i++){
            System.out.println(res3[i]);
        }
    }
}
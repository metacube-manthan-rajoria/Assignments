import java.util.HashMap;
final  class IntSet {
    private final int array[];
    private HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

    public IntSet(int arr[]){
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], 1);
        }
        array = arr;
    }

    public boolean isMember(int x){
        if(map.getOrDefault(x, 0) == 1){
            return true;
        }
        return false;
    }

    public int size(){
        return map.size();
    }

    public boolean isSubSet(IntSet s){
        HashMap<Integer, Integer> m = s.getSet();
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
        HashMap<Integer, Integer> m = s.getSet();
        
        for(Integer i : map.keySet()){
            m.put(i, 1);
        }
        
        int result[] = new int[m.size()];
        int index = 0;
        for(Integer i : m.keySet()){
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
        IntSet is1 = new IntSet(arr1);
        IntSet is2 = new IntSet(arr2);

        // System.out.println(is1.isMember(7));
        // System.out.println(is1.size());
        // System.out.println(is1.isSubSet(is2));

        int a[] = is1.getComplement();
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
        
    }

}
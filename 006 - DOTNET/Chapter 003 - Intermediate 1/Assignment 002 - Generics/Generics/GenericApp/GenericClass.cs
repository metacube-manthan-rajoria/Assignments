namespace GenericApp;

public class GenericClass<T>
{
    public static void Compare(T val1, T val2){
        bool isEqual = val1.Equals(val2);
        Console.WriteLine(isEqual);
    }
}

public class CheckList {
    public static void IsListEmpty<T>(List<T> list){
        if(list.Count > 0){
            Console.WriteLine("Not Empty");
        }else{
            Console.WriteLine("Empty");
        }
    }
}

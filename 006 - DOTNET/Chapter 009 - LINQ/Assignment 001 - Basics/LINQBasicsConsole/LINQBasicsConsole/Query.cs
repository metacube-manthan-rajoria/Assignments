namespace LINQBasicsConsole;

public class Query {
    public static void Test(){
        int[] numbers = [ 0, 1, 2, 3, 4, 5, 6 ];

        var numQuery = 
                    from num in numbers
                    where (num % 2) == 0
                    select num;

        foreach (int num in numQuery)
        {
            Console.Write("{0,1} ", num);
        }
    }
}
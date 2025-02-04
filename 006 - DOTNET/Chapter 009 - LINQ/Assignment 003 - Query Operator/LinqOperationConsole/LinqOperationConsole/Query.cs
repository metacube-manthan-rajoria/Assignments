using System.Linq;

namespace LinqOperationConsole;

public class Query {
    public static void SelectOddNumbers(){
        List<int> numbers = new List<int>(){ 0, 1, 2, 3, 4, 5, 6 };

        var numQuery = 
                    from num in numbers
                    where (num % 2) == 1
                    select num;

        foreach (int num in numQuery)
        {
            Console.Write($"{num} ");
        }
    }

    public static void SelectUpperCaseWords(){
        string str = "Extract UPPER case words FROM THIS string";
        var words = str.Split(" ").Where(word => word.All(char.IsUpper));

        Console.WriteLine("\n");
        foreach(string word in words){
            Console.Write($"{word} " );
        }
    }
}
namespace LinqObjectsConsole;

public class Query{
    public static void GetRange(){
        List<string> words = new List<string>{
            "John", 
            "Mike", 
            "Chris", 
            "Jack", 
            "Andy", 
            "Gretchen", 
            "Helen"
        };

        var range = words.Skip(1).Take(4);
        
        foreach(var word in range){
            Console.WriteLine(word);
        }
    }
}
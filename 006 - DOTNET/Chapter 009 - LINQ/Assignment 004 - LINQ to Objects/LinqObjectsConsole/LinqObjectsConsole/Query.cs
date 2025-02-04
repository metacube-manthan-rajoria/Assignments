namespace LinqObjectsConsole;

public class Query{
    public static void GetRange(){
        List<Person> words = new List<Person>{
            new Person("John"),
            new Person("Mike"),
            new Person("Chris"),
            new Person("Jack"),
            new Person("Andy"),
            new Person("Gretchen"),
            new Person("Helen"),
        };

        IEnumerable<Person> range = words.Skip(1).Take(4);
        IEnumerable<Person> range2 = words.GetRange(1,4);
        
        foreach(var word in range2){
            Console.WriteLine(word.Name);
        }
    }
}
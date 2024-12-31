namespace AnonymousLibrary;

public delegate void Annoy(string name);
public class AnonymousClass
{
    public static void DoSomething(string name){
        Annoy annoy = delegate (string name) {
            Console.WriteLine("Annoy " + name);
        };

        annoy(name);

        Annoy annoySomeMore = name => Console.WriteLine("Annoy " + name + " again");
        annoySomeMore(name);
    }
}

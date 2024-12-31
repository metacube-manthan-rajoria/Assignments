namespace DelegateLibrary;

public delegate int Operation(int x, int y);
public class DelegateClass
{
    private static int Addition(int a, int b) {
        return a + b;
    }

    public static void DoOperation(int x, int y){
        Operation op = new Operation(Addition);

        Console.WriteLine(op(x, y));
    }

}

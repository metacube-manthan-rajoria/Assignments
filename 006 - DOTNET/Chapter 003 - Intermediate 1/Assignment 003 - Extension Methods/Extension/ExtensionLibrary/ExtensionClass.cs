namespace ExtensionLibrary;

public static class ExtensionClass
{
    public static void IsEven(this int value) {
        Console.WriteLine(value % 2 == 0);
    }
}

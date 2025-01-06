namespace ExtensionLibrary;

using System.Text.RegularExpressions;

public static class ExtensionClass
{
    public static void RemoveWhiteSpaces(this string value) {
        Regex whiteSpace = new Regex(@"\s+");
        Console.WriteLine(whiteSpace.Replace(value, ""));
    }
}

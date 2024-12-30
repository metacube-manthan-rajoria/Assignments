# Assignment

> Question 1 : Explain partial classes in C# language with an example.

It's possible to split the definition of a class, a struct, an interface, or a method over two or more source files. Each source file contains a section of the type or method definition, and all parts are combined when the application is compiled.

To split a class definition, use the partial keyword modifier. In practice, each partial class is typically defined in a separate file, making it easier to manage and expand the class over time.

```cs
// This is in Employee_Part1.cs
public partial class Employee
{
    public void DoWork()
    {
        Console.WriteLine("Employee is working.");
    }
}

// This is in Employee_Part2.cs
public partial class Employee
{
    public void GoToLunch()
    {
        Console.WriteLine("Employee is at lunch.");
    }
}

//Main program demonstrating the Employee class usage
public class Program
{
    public static void Main()
    {
        Employee emp = new Employee();
        emp.DoWork();
        emp.GoToLunch();
    }
}

// Expected Output:
// Employee is working.
// Employee is at lunch.
```


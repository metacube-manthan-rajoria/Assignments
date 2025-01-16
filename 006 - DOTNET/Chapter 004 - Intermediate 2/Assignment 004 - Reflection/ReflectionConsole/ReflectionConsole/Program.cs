using System.Reflection;
using ReflectionConsole;

public class Program
{
    public static void Main()
    {
        Car car = new Car(100, "Audi", true);
        Type type = car.GetType();
        Console.WriteLine(type.FullName);

        Assembly assembly = Assembly.GetExecutingAssembly();

        Type[] types = assembly.GetTypes();
        foreach (var item in types)
        {
            Console.WriteLine("Class : " + item.Name);

            MethodInfo[] methods = item.GetMethods();
            foreach (var method in methods)
            {
                Console.WriteLine("\tMethod : {0}({1})", method.Name, method.Attributes);

                ParameterInfo[] parameters = method.GetParameters();
                foreach (var arg in parameters)
                {
                    Console.WriteLine("\t\tParameter : {0} Type : {1}", arg.Name, arg.ParameterType);
                }
            }
        }
    }
}
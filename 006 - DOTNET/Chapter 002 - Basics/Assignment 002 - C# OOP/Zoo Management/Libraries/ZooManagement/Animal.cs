using System.Diagnostics;

namespace Metacube.Net.ZooManagement;

public abstract class Animal
{
    private readonly string name = "";
    private readonly int age = 0;
    private readonly double weight = 0.0d;

    public Animal(int age, double weight){
        name = DateTime.Now.Ticks.ToString();
        this.age = age;
        this.weight = weight;
    }

    public abstract string GetSound();

    public string GetName(){
        return name;
    }
    public int GetAge(){
        return age;
    }
    public double GetWeight(){
        return weight;
    }
}

public abstract class Mammal : Animal
{
    public Mammal(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Mammal Sound";
    }
}

public class Reptile : Animal
{
    public Reptile(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Reptile Sound";
    }
}

public class Bird : Animal
{
    public Bird(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Bird Sound";
    }
}

public class Fish : Animal
{
    public Fish(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Fish Sound";
    }
}

// Animal Subtypes

public class Lion : Mammal
{
    public Lion(int age, double weight) : base(age, weight) {}
    public override string GetSound()
    {
        return "Lion Sound";
    }
}
public class Tiger : Mammal
{
    public Tiger(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Tiger Sound";
    }
}

public class Snake : Reptile
{
    public Snake(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Snake Sound";
    }
}

public class Turtle : Reptile
{
    public Turtle(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Turtle Sound";
    }
}

public class Penguin : Bird
{
    public Penguin(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Penguin Sound";
    }
}

public class Owl : Bird
{
    public Owl(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Owl Sound";
    }
}

public class Dolphin : Fish
{
    public Dolphin(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Dolphin Sound";
    }
}
public class Salmon : Fish
{
    public Salmon(int age, double weight) : base(age, weight){}
    public override string GetSound()
    {
        return "Salmon Sound";
    }
}
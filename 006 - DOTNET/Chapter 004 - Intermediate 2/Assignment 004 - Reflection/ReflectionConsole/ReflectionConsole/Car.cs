using System;

namespace ReflectionConsole;

public class Car
{
    private int speed {get; set;}
    private string company {get; set;}
    private bool isPetrol {get; set;}

    public Car(int speed, string company, bool isPetrol){
        this.speed = speed;
        this.company = company;
        this.isPetrol = isPetrol;
    }

    private bool IncreaseSpeed(){
        speed+=20;
        return true;
    }

    public void PrintDetails(){
        Console.WriteLine(
            "Max Speed: " + speed +
            "Company: " + company +
            "Uses Petrol:" + isPetrol
        );
    }
}

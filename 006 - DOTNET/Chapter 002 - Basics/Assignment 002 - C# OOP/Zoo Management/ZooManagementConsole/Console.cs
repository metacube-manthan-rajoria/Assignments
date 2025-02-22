﻿namespace Metacube.Net.ZooManagement.Console;

class Console
{
    static void Main(string[] args)
    {
        Zoo zoo = new Zoo();
        zoo.AddZone(AnimalType.MAMMAL, 2, true, true);
        zoo.AddZone(AnimalType.BIRD, 3, true, false);

        // Creating Animals
        Lion lion1 = new Lion(10, 50.0);
        Lion lion2 = new Lion(11, 55.0);
        Lion lion3 = new Lion(12, 58.0);
        Lion lion4 = new Lion(13, 58.0);
        Lion lion5 = new Lion(14, 58.0);
        Lion lion6 = new Lion(15, 58.0);

        Tiger tiger1 = new Tiger(13, 51.0);
        Tiger tiger2 = new Tiger(15, 52.0);
        Tiger tiger3 = new Tiger(15, 52.0);

        Owl owl1 = new Owl(3, 1.0);
        Owl owl2 = new Owl(4, 1.5);
        Owl owl3 = new Owl(5, 1.6);

        // Adding Animals
        zoo.AddAnimal(lion1);
        zoo.AddAnimal(lion2);
        zoo.AddAnimal(lion3);
        zoo.AddAnimal(lion4);
        zoo.AddAnimal(lion5);
        zoo.AddAnimal(lion6);
        zoo.AddAnimal(tiger1);
        zoo.AddAnimal(tiger2);
        zoo.AddAnimal(tiger3);
        zoo.AddAnimal(owl1);
        zoo.AddAnimal(owl2);
        zoo.AddAnimal(owl3);
        zoo.AddAnimal(owl3);

        zoo.PrintZooStatistics();

        zoo.AnimalDied(zoo.GetAllAnimals()[100].GetName());

        zoo.PrintZooStatistics();

        return;
    }
}
namespace Metacube.Net.ZooManagement;

public class Cage
{
    private readonly string animalSubType = "";
    private readonly int maxAnimalCount = 0;

    private List<Animal> animals;
    public Cage(string subtype, int maxAnimalCount){
        animalSubType = subtype;
        this.maxAnimalCount = maxAnimalCount;

        animals = new List<Animal>(maxAnimalCount);
    }

    public bool AddAnimal(Animal animal){
        if(animals.Count >= maxAnimalCount) return false;

        if(animal.GetType().ToString() == animalSubType){
            animals.Add(animal);
            return true;
        }
        Console.WriteLine("Incompatible animal type");
        return false;
    }

    public bool RemoveAnimal(string name){
        foreach(var animal in animals){
            if(animal.GetName().Equals(name)){
                animals.Remove(animal);
                return true;
            }
        }
        return false;
    }

    public string GetAnimalSubType(){
        return animalSubType;
    }
    public List<Animal> GetAnimals(){
        return animals;
    }
}
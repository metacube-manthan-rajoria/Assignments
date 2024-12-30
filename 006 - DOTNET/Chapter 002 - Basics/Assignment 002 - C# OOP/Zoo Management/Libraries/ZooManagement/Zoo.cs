namespace Metacube.Net.ZooManagement;

public class Zoo
{
    const string NAMESPACE_NAME = "Metacube.Net.ZooManagement.";
    private List<Zone> zones;

    public Zoo(){
        zones = new List<Zone>();
    }

    public void AddZone(AnimalType type, int maxCageCount = 5, bool hasPark = true, bool hasCanteen = true) {
        Zone zone = new Zone(type, maxCageCount, hasPark, hasCanteen);
        zones.Add(zone);
    }

    public bool AddAnimal(Animal animal) {
        try{
            Type species = animal.GetType().BaseType;
            Type subspecies = animal.GetType();

            // Looping over existing cages to find space for animal
            foreach(var zone in zones){
                string zoneAnimalType = (NAMESPACE_NAME + zone.GetAnimalType().ToString()).ToLower();
                if(zoneAnimalType.Equals(species.ToString().ToLower())){
                    foreach(var cage in zone.GetCages()){
                        string zoneAnimalSubType = (NAMESPACE_NAME + zone.GetAnimalType().ToString()).ToLower();
                        if(cage.GetAnimalSubType().Equals(subspecies.ToString().ToLower()) && cage.HasSpace()){
                            cage.AddAnimal(animal);
                            return true;
                        }
                    }

                    // Creating new cage if current zone has space
                    if(zone.HasSpace()){
                        zone.AddCage(subspecies.ToString().ToLower(), 5);
                        zone.GetCages()[zone.GetCages().Count - 1].AddAnimal(animal);
                        return true;
                    }
                }
            }

            // Adding new Zone to add animal
            AnimalType animalEnumType;
            switch(species.ToString().ToLower()){
                case "metacube.net.zoomanagement.reptile": 
                    animalEnumType = AnimalType.REPTILE;
                    break;
                case "metacube.net.zoomanagement.bird": 
                    animalEnumType = AnimalType.BIRD;
                    break;
                case "metacube.net.zoomanagement.fish": 
                    animalEnumType = AnimalType.FISH;
                    break;
                default:
                    animalEnumType = AnimalType.MAMMAL;
                    break;
            }
            AddZone(animalEnumType, 5, true, true);
            zones[zones.Count - 1].AddCage(subspecies.ToString().ToLower(), 5);
            zones[zones.Count - 1].GetCages()[0].AddAnimal(animal);
            return true;
        }catch(NullReferenceException){
            Console.WriteLine("Null Exception for animal class.");
        }
        return false;
    }

    public bool AnimalDied(string name) {
        foreach(var zone in zones){
            foreach(var cage in zone.GetCages()){
                foreach(var animal in cage.GetAnimals()){
                    if(animal.GetName().Equals(name)){
                        cage.GetAnimals().Remove(animal);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Animal> GetAllAnimals(){
        List<Animal> allAnimals = new List<Animal>();
        foreach(var zone in zones){
            foreach(var cage in zone.GetCages()){
                foreach(var animal in cage.GetAnimals()){
                    allAnimals.Add(animal);
                }
            }
        }
        return allAnimals;
    }

    public void PrintZooStatistics(){
        Console.WriteLine("Zoo Statistics");

        int zoneCount = 0;
        foreach(var zone in zones){
            zoneCount++;
            Console.WriteLine($"Zone {zoneCount} : " + zone.GetAnimalType().ToString());

            int cageCount = 0;
            foreach(var cage in zone.GetCages()){
                cageCount++;
                Console.WriteLine($"\tCage {cageCount} : " + cage.GetAnimalSubType());

                foreach(var Animal in cage.GetAnimals()){
                    Console.WriteLine($"\t\t{Animal.GetType()}, Name : {Animal.GetName()}, Age : {Animal.GetAge()}, Weight : {Animal.GetWeight()}");
                }
            }
        }
    }
}

public enum AnimalType {
    MAMMAL,
    REPTILE,
    BIRD,
    FISH
}
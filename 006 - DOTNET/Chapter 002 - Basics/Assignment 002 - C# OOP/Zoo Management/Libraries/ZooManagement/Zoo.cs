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

            bool suitableZonePresent = false;
            bool suitableZoneHasSpace = false;
            bool suitableCagePresent = false;
            bool suitableCageHasSpace = false;

            foreach(var zone in zones){
                string zoneAnimalType = (NAMESPACE_NAME + zone.GetAnimalType().ToString()).ToLower();
                if(zoneAnimalType.Equals(species.ToString().ToLower())){
                    foreach(var cage in zone.GetCages()){
                        string zoneAnimalSubType = (NAMESPACE_NAME + zone.GetAnimalType().ToString()).ToLower();
                        if(cage.GetAnimalSubType().Equals(subspecies.ToString().ToLower())){

                        }
                    }
                }
            }

        }catch(NullReferenceException){
            Console.WriteLine("Null Exception for animal class.");
        }

        // foreach(var zone in zones){
        //     if(zone.GetAnimalType().ToString().Equals(animal.GetType()))
        //     foreach(var cage in zone.GetCages()){
        //         bool isAnimalAdded = cage.AddAnimal(animal);
        //         if(isAnimalAdded){
        //             Console.WriteLine("Animal added to cage");
        //         }else{
                    
        //         }
        //     }
        // }
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

    public void PrintZooStatistics(){
        Console.WriteLine("Zoo Statistics");

        int zoneCount = 0;
        foreach(var zone in zones){
            zoneCount++;
            Console.WriteLine($"Zone {zoneCount} : " + zone.GetAnimalType().ToString());

            int cageCount = 0;
            foreach(var cage in zone.GetCages()){
                cageCount++;
                Console.WriteLine($"\tCage {cageCount} : " + cage.GetType());

                foreach(var Animal in cage.GetAnimals()){
                    Console.WriteLine($"{Animal.GetType()}, Name : {Animal.GetName()}, Age : {Animal.GetAge()}, Weight : {Animal.GetWeight()}");
                }
            }
        }
    }

    public List<Zone> GetZones(){
        return zones;
    }
}

public enum AnimalType {
    MAMMAL,
    REPTILE,
    BIRD,
    FISH
}

// public enum Mammal {
//     ELEPHANT,
//     LION,
//     TIGER
// }

// public enum Reptile {
//     ALIGATOR,
//     TURTLE,
//     IGUANA,
//     SNAKE
// }

// public enum Bird {
//     OWL,
//     WOODPECKER,
//     EAGLE,
//     PARROT,
//     PENGUIN
// }

// public enum Fish {
//     DOLPHIN,
//     SALMON,
//     CARP
// }
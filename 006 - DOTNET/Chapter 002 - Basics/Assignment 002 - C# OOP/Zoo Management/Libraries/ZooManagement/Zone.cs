namespace Metacube.Net.ZooManagement;

public class Zone
{
    private readonly int maxCageCount = 0;
    private List<Cage> cages;
    private AnimalType animalType;
    private readonly bool hasPark = false;
    private readonly bool hasCanteen = false;

    public Zone(AnimalType type, int maxCageCount, bool hasPark, bool hasCanteen) {
        this.animalType = type;
        this.maxCageCount = maxCageCount;
        cages = new List<Cage>(maxCageCount);
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }

    public bool AddCage(string subtype, int maxAnimalCount){
        try{
            if(cages.Count >= maxCageCount) return false;
            
            Cage cage = new Cage(subtype, maxAnimalCount);
            cages.Add(cage);
            return true;
        }catch{
            Console.WriteLine("Cannot add more cages to this zone.");
            return false;
        }
    }

    public bool HasSpace(){
        if(cages.Count < maxCageCount) return true;
        return false;
    }
    public List<Cage> GetCages(){
        return cages;
    }
    public AnimalType GetAnimalType(){
        return animalType;
    }
    public bool HasPark(){
        return hasPark;
    }
    public bool HasCanteen(){
        return hasCanteen;
    }
}
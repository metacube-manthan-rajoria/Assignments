using system;
namespace Metacube.Net.ZooManagement.Cage {
    private abstract class Cage {
        int maxAnimalCount = 0;
        public abstract bool addAnimal(string name); 
        public abstract bool removeAnimal(string name); 
    }

    public class MammalCage: Cage {
        public MammalCage(int maxAnimalCount) {
            super(maxAnimalCount);
        }
        public enum Animals {
            ELEPHANT,
            LION,
            TIGER
        } 
    }
    public class ReptileCage: Cage {
        public enum Animals {
            ALIGATOR,
            TURTLE,
            LIZARD,
            SNAKE
        }
    }
    public class BirdCage: Cage {
        public enum Animals {
            OWL,
            WOODPECKER,
            EAGLE,
            PARROT,
            PENGUIN
        }
    }
    public class FishCage: Cage {
        public enum Animals {
            DOLPHIN,
            SALMON,
            CARP
        }
    }
}

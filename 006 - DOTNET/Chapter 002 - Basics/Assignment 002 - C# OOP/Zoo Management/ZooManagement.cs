using System;
using Metacube.Net.ZooManagement.Cage;

namespace Metacube.Net.ZooManagement {
    class ZooManagement {
        private maxZoneCount = 0;
        private List<Zone> zones;

        public ZooManagement (int maxZoneCount) {
            this.maxZoneCount = maxZoneCount;
            zones = new List<Zone>(maxZoneCount);
        }

        public bool addZone(Zone.AnimalType type, int maxCageCount) {
            Zone zone = new Zone(type, maxCageCount);
            zones.add(zone);
        }

        public bool addAnimal(Animal animal) {
            //...
        }
        public bool animalDied(string name) {
            //...
        }
    }

    class Zone {
        private maxCageCount = 0;
        private AnimalType type;
        private bool hasPark = false;
        private bool hasCanteen = false;
        private List<Cage> cages;
        public Zone(AnimalType type, int maxCageCount, bool hasPark, bool hasCanteen) {
            this.type = type;
            this.maxCageCount = maxCageCount;
            cages = new List<Cage>(maxCageCount);
            this.hasPark = hasPark;
            this.hasCanteen = hasCanteen;
        }

        private createCage(Cage.Animals subtype, int maxAnimalCount){
            Cage cage = new Cage(subtype, maxAnimalCount);
            cages.add(cage);
        }

        public enum AnimalType {
            MAMMAL,
            REPTILE,
            BIRD,
            FISH
        }
    }
}
public class SolarSystem {
    public enum Planets {
        MERCURY(0, 22000, null),
        VENUS(78563, 89777, MERCURY),
        EARTH(33226, 83767, VENUS),
        MARS(33341, 34000, EARTH),
        JUPITER(242454, 34000, MARS),
        SATURN(3357, 87555, JUPITER),
        URANUS(35662, 54000, SATURN),
        NEPTUNE(24546565, 89000, URANUS),
        PLUTO(8767658, 98766, NEPTUNE);

        private final int prevDistance;
        private final int radius;
        private final Planets previous;

        Planets(int prevDistance, int radius, Planets previous) {
            this.prevDistance = prevDistance;
            this.radius = radius;
            this.previous = previous;
        }

        public int getPrevDistance() {
            return prevDistance;
        }

        public int getRadius() {
            return radius;
        }

        public Planets getPrevious() {
            return previous;
        }
        public Planets getNext(){
            return getNextPlanet();
        }

        public int getNumberFromSun() {
            return this.ordinal() + 1;
        }

        private int getDistanceFromTheSun() {
            int distanceFromSun = 0;

            for (Planets planet : Planets.values()) {
                if (planet.ordinal() <= this.ordinal()) {
                    distanceFromSun = distanceFromSun + planet.prevDistance;
                } else {
                    break;
                }
            }
            return distanceFromSun;
        }

        private Planets getNextPlanet(){
            int nextPlanetNumber = this.ordinal()+1;
            if (nextPlanetNumber < Planets.values().length)
            {
                return Planets.values()[nextPlanetNumber];
            }
            else {
                return null;
            }
        }

    }

    public static void showPlanets() {
        for (Planets planet : Planets.values()) {
            System.out.println(planet.name() + ": Distance from previous = " + planet.getPrevDistance() + ", Radius = " + planet.getRadius() + ", Previous planet = " + (planet.getPrevious() != null ? planet.getPrevious().name() : "None") + ", Next  planet = " + (planet.getNext() != null ? planet.getNext().name() : "None"));
        }
    }

    public static void printAllSequenceNumberFromSun() {
        for (Planets planet : Planets.values()) {
            System.out.println(planet.name() + ": The sequence Number  = " + planet.getNumberFromSun());
        }
    }

    public static void printAllPlanetsDistanceFromSun() {
        for (Planets planet : Planets.values()) {
            System.out.println(planet.name() + ": Distance from the sun = " + planet.getDistanceFromTheSun());
        }

    }


}
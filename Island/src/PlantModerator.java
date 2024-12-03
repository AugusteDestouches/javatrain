import java.util.ArrayList;
import java.util.List;

class PlantModerator {
    private List<Creature> creatures = new ArrayList<>();
    private int plantCount = 0;

    void addCreature(Creature creature) {
        creatures.add(creature);
    }

    void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    boolean hasPlant() {
        return plantCount > 0;
    }

    void consumePlant() {
        if (plantCount > 0) {
            plantCount--;
        }
    }

    void growPlant() {
        if (plantCount < 5) {
            plantCount++;
        }
    }
    void updateCreatures(List<Creature> newCreatures, Island island) {
        for (Creature creature : new ArrayList<>(creatures)) {
            creature.consumeEnergy();

            if (!creature.isAlive()) {
                removeCreature(creature);
                continue;
            }
            creature.eat(this);
            creature.move(island);
            creature.reproduce(newCreatures);
        }
    }
    String getRepresentation() {
        if (!creatures.isEmpty()) {
            return creatures.get(0).getSymbol();
        }
        else if (hasPlant()) {
            return "🌱";
        }
        else {
            return ".";
        }
    }


    List<Creature> getCreatures() {
        return creatures;
    }

    List<Creature> getPlantEaters() {
        List<Creature> plantEaters = new ArrayList<>();
        for (Creature creature : creatures) {
            if (creature instanceof Herbivorous) {
                plantEaters.add(creature);
            }
        }
        return plantEaters;
    }
}


import java.util.Optional;

abstract class Predator extends Creature {
    public Predator(String name, int x, int y, int initialEnergy) {
        super(name, x, y, initialEnergy);
    }

    @Override
    void eat(PlantModerator plantModerator) {
        Optional<Creature> prey = plantModerator.getPlantEaters().stream().findFirst();
        prey.ifPresent(creature -> {
            plantModerator.removeCreature(creature);
            energy +=
                    energy += 5;
            System.out.println(name + " съел " + creature.name);
        });
    }
}

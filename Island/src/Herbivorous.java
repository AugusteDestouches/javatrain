abstract class Herbivorous extends Creature {
    public Herbivorous(String name, int x, int y, int initialEnergy) {
        super(name, x, y, initialEnergy);
    }

    @Override
    void eat(PlantModerator cell) {
        if (cell.hasPlant()) {
            cell.consumePlant();
            energy += 2;
            System.out.println(name + " съел растение");
        }
    }
}

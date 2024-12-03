import java.util.List;

abstract class Creature {
    protected String name;
    protected int x, y;
    protected int energy;

    public Creature(String name, int x, int y, int initialEnergy) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.energy = initialEnergy;
    }

    abstract void eat(PlantModerator cell);
    abstract void move(Island island);
    abstract void reproduce(List<Creature> newCreatures);

    public boolean isAlive() {
        return energy > 0;
    }

    public void consumeEnergy() {
        energy--;
    }

    public abstract String getSymbol();
}

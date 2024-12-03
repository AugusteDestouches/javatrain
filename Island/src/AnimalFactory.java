
import java.util.Random;

class AnimalFactory {
    private static final Random random = new Random();


    public static Creature createRandomCreature(int x, int y) {
        CONFIG config = new CONFIG();
        int maxChoice = config.animalAmountMode == 1 ? 2 : 10;
        int choice = random.nextInt(maxChoice);

        switch (choice) {
            case 0:
                return new Wolf(x, y);
            case 1:
                return new Rabbit(x, y);
            case 2:
                return new Deer(x, y);
            case 3:
                return new Bear(x, y);
            case 4:
                return new Fox(x, y);
            case 5:
                return new Sheep(x, y);
            case 6:
                return new Eagle(x, y);
            case 7:
                return new Snake(x, y);
            case 8:
                return new Horse(x, y);
            default:
                return new Goat(x, y);
        }
    }
}
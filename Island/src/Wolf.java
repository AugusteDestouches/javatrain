import java.util.List;
import java.util.Random;

class Wolf extends Predator {
    public Wolf(int x, int y) {
        super("Wolf", x, y, 10);
    }

    @Override
    void move(Island island) {
        Random random = new Random();
        x = Math.max(0, Math.min(island.getWidth() - 1, x + random.nextInt(3) - 1));
        y = Math.max(0, Math.min(island.getHeight() - 1, y + random.nextInt(3) - 1));
    }

    @Override
    void reproduce(List<Creature> newAnimals) {
        if (new Random().nextInt(100) < 10) {
            newAnimals.add(new Wolf(x, y));
        }
    }

    @Override
    public String getSymbol() {
        return "🐺";
    }
}

import java.util.*;
import java.util.concurrent.*;

public class EcoSystemSimulation {
    public static void main(String[] args) {
        CONFIG config = new CONFIG();
        Island island = new Island(config.islandWidth, config.islandHeight);

        initializeCreatures(island, config);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(999);
        scheduler.scheduleAtFixedRate(() -> updateIsland(island, config), 0, config.tickDuration, TimeUnit.MILLISECONDS);
    }

    private static void initializeCreatures(Island island, CONFIG config) {
        Random random = new Random();
        for (int i = 0; i < config.initialCreatureCount; i++) {
            Creature creature = AnimalFactory.createRandomCreature(
                    random.nextInt(island.getWidth()),
                    random.nextInt(island.getHeight())
            );
            island.addCreature(creature);
        }
    }

    private static void updateIsland(Island island, CONFIG config) {
        List<Creature> newCreatures = new ArrayList<>();
        boolean hasPlantEaters = false;

        for (PlantModerator plantModerator : island.getAllHabitats()) {
            for (Creature creature : plantModerator.getCreatures()) {
                if (creature instanceof Herbivorous) {
                    hasPlantEaters = true;
                }

            }

            plantModerator.updateCreatures(newCreatures, island);
            plantModerator.growPlant();
        }

        for (Creature creature : newCreatures) {
            island.addCreature(creature);
        }

        printIsland(island);

        if (!hasPlantEaters) {

            System.out.println("Симуляция завершена. (в экосистеме не осталось травоядных)");
            System.exit(0);
        }
    }

    private static void printIsland(Island island) {

        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                PlantModerator plantModerator = island.getHabitat(x, y);
                System.out.print(plantModerator.getRepresentation());
            }
            System.out.println();
        }
        System.out.println("=".repeat(island.getWidth()));
    }
}

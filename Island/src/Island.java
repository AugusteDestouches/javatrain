import java.util.ArrayList;
import java.util.List;

class Island {
    private int width, height;
    private PlantModerator[][] grid;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new PlantModerator[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new PlantModerator();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlantModerator getHabitat(int x, int y) {
        return grid[x][y];
    }

    public void addCreature(Creature creature) {
        grid[creature.x][creature.y].addCreature(creature);
    }

    public List<PlantModerator> getAllHabitats() {
        List<PlantModerator> plantModerators = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                plantModerators.add(grid[x][y]);
            }
        }
        return plantModerators;
    }
}

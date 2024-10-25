import javafx.scene.layout.GridPane;
import java.util.Random;

/**
 * Represents the game map, which consists of a grid of tiles.
 */
public class GameMap extends GridPane {
    private final int width;
    private final int height;
    private Tile[][] tiles;
    private Random rand = new Random();
    private Drill drill;

    /**
     * Constructs a GameMap object with the specified width and height.
     *
     * @param width  the width of the game map in terms of number of tiles
     * @param height the height of the game map in terms of number of tiles
     */
    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
        initializeMap();
    }

    /**
     * Initializes the game map by creating and placing tiles.
     */
    private void initializeMap() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j < 3) {
                    tiles[i][j] = new Sky();
                } else if (j == 3) {
                    tiles[i][j] = new Grass();
                } else if (j > 2 && (i == 0 || i == width - 1 || j == height - 1)) {
                    tiles[i][j] = new Boulder();
                } else {
                    double chance = rand.nextDouble();
                    if (chance < 0.01) {
                        tiles[i][j] = new Diamond();
                    } else if (chance < 0.04) {
                        tiles[i][j] = new Goldium();
                    } else if (chance < 0.10) {
                        tiles[i][j] = new Silverium();
                    } else if (chance < 0.20) {
                        tiles[i][j] = new Ironium();
                    } else if (chance < 0.21) {
                        tiles[i][j] = new Boulder();
                    } else if (chance < 0.24) {
                        tiles[i][j] = new Lava();
                    } else {
                        tiles[i][j] = new Soil();
                    }
                }
                this.add(tiles[i][j].getView(), i, j);
            }
        }
    }

    /**
     * Gets the tile at the specified coordinates.
     *
     * @param x the x-coordinate of the tile
     * @param y the y-coordinate of the tile
     * @return the tile at the specified coordinates, or null if out of bounds
     */
    public Tile getTile(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return tiles[x][y];
        } else {
            return null;
        }
    }

    /**
     * Digs the tile at the specified coordinates.
     *
     * @param x the x-coordinate of the tile to dig
     * @param y the y-coordinate of the tile to dig
     */
    public void digTile(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            Tile currentTile = tiles[x][y];
            if (currentTile.isDiggable()) {
                if (currentTile instanceof Valuable) {
                    Valuable valuable = (Valuable) currentTile;
                    drill.collectValuable(valuable.getValue(), valuable.getWeight());
                } else if (currentTile instanceof Lava) {
                    drill.digLava();
                    return;
                }
                tiles[x][y] = new DugTile();
                this.add(tiles[x][y].getView(), x, y);
                this.getChildren().remove(drill.getView());
                this.add(drill.getView(), x, y);
            }
        }
    }

    /**
     * Adds the drill to the game map at the starting position.
     *
     * @param drill the drill to add to the game map
     */
    public void addDrill(Drill drill) {
        this.drill = drill;
        this.add(drill.getView(), (int) drill.getX(), 2);
    }
}

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Represents the drill in the game, responsible for moving and interacting with tiles.
 */
public class Drill {
    private ImageView view;
    private int fuel;
    private double x, y;
    private DrillDirection currentDirection = DrillDirection.RIGHT;
    private GameMap gameMap;
    private boolean movingUp;
    private int totalValue;
    private double totalWeight;
    private Runnable onGameOver;
    private Runnable onLavaGameOver;

    /**
     * Constructs a Drill object.
     *
     * @param gameMap the game map
     * @param onGameOver the game over callback
     * @param onLavaGameOver the lava game over callback
     */
    public Drill(GameMap gameMap, Runnable onGameOver, Runnable onLavaGameOver) {
        this.gameMap = gameMap;
        this.onGameOver = onGameOver;
        this.onLavaGameOver = onLavaGameOver;
        view = new ImageView(new Image(currentDirection.getPath()));
        view.setFitWidth(50);
        view.setFitHeight(50);
        view.setPreserveRatio(true);
        fuel = 10000;
        x = 0;
        y = 100;
        totalValue = 0;
        totalWeight = 0.0;
        updateViewPosition();
    }

    /**
     * Moves the drill by the specified amount.
     *
     * @param dx the change in x position
     * @param dy the change in y position
     */
    public void move(double dx, double dy) {
        double newX = x + dx;
        double newY = y + dy;
        int tileX = (int) (newX / 50);
        int tileY = (int) (newY / 50);

        if (dy < 0 && !canMoveUp(tileX, tileY)) {
            return;
        }

        if (canMoveTo(tileX, tileY)) {
            updateDirection(dx, dy);
            gameMap.digTile(tileX, tileY);
            x = newX;
            y = newY;
            updateViewPosition();
            movingUp = dy < 0;
            if (dy < 0) {
                consumeFuel(Math.abs(dx) + Math.abs(dy) * 3);
            } else {
                consumeFuel(Math.abs(dx) + Math.abs(dy));
            }
        } else {
            movingUp = false;
        }

        if (!movingUp) {
            applyGravity();
        }
    }

    /**
     * Checks if the drill can move up.
     *
     * @param tileX the x position of the tile
     * @param tileY the y position of the tile
     * @return true if the drill can move up, false otherwise
     */
    private boolean canMoveUp(int tileX, int tileY) {
        Tile tileAbove = gameMap.getTile(tileX, tileY);
        return tileAbove instanceof DugTile || tileAbove instanceof Sky;
    }

    /**
     * Applies gravity to the drill, making it fall if necessary.
     */
    public void applyGravity() {
        int tileX = (int) (x / 50);
        int tileY = (int) ((y + 50) / 50);

        if (gameMap.getTile(tileX, tileY) instanceof DugTile || gameMap.getTile(tileX, tileY) instanceof Sky) {
            y += 50;
            updateViewPosition();
        }
    }

    /**
     * Consumes fuel over time.
     */
    public void consumeFuelOverTime() {
        consumeFuel(1);
    }

    /**
     * Collects a valuable item.
     *
     * @param value the value of the item
     * @param weight the weight of the item
     */
    public void collectValuable(int value, double weight) {
        totalValue += value;
        totalWeight += weight;
    }

    /**
     * Handles digging into lava.
     */
    public void digLava() {
        if (onLavaGameOver != null) {
            onLavaGameOver.run();
        }
    }

    /**
     * Checks if the drill can move to the specified tile.
     *
     * @param tileX the x position of the tile
     * @param tileY the y position of the tile
     * @return true if the drill can move to the tile, false otherwise
     */
    private boolean canMoveTo(int tileX, int tileY) {
        Tile tile = gameMap.getTile(tileX, tileY);
        return tile != null && tile.isPenetrable();
    }

    /**
     * Updates the drill's direction based on movement.
     *
     * @param dx the change in x position
     * @param dy the change in y position
     */
    private void updateDirection(double dx, double dy) {
        if (dx > 0) {
            setCurrentDirection(DrillDirection.RIGHT);
        } else if (dx < 0) {
            setCurrentDirection(DrillDirection.LEFT);
        } else if (dy > 0) {
            setCurrentDirection(DrillDirection.DOWN);
        } else if (dy < 0) {
            setCurrentDirection(DrillDirection.UP);
        }
    }

    /**
     * Sets the current direction of the drill.
     *
     * @param newDirection the new direction
     */
    private void setCurrentDirection(DrillDirection newDirection) {
        if (currentDirection != newDirection) {
            currentDirection = newDirection;
            view.setImage(new Image(newDirection.getPath()));
        }
    }

    /**
     * Consumes fuel.
     *
     * @param amount the amount of fuel to consume
     */
    private void consumeFuel(double amount) {
        fuel -= amount;
        if (fuel <= 0) {
            handleOutOfFuel();
        }
    }

    /**
     * Handles the out of fuel scenario.
     */
    private void handleOutOfFuel() {
        if (onGameOver != null) {
            onGameOver.run();
        }
    }

    /**
     * Updates the position of the drill's image.
     */
    private void updateViewPosition() {
        GridPane.setColumnIndex(view, (int) x / 50);
        GridPane.setRowIndex(view, (int) y / 50);
    }

    /**
     * Gets the image view of the drill.
     *
     * @return the image view
     */
    public ImageView getView() {
        return view;
    }

    /**
     * Gets the x position of the drill.
     *
     * @return the x position
     */
    public int getX() {
        return (int) x / 50;
    }

    /**
     * Gets the y position of the drill.
     *
     * @return the y position
     */
    public int getY() {
        return (int) y / 50;
    }

    /**
     * Gets the total value of collected valuables.
     *
     * @return the total value
     */
    public int getTotalValue() {
        return totalValue;
    }

    /**
     * Gets the total weight of collected valuables.
     *
     * @return the total weight
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * Gets the remaining fuel.
     *
     * @return the remaining fuel
     */
    public int getFuel() {
        return fuel;
    }
}

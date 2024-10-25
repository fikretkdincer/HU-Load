import javafx.scene.image.ImageView;

/**
 * Abstract class to represent a generic tile in the game.
 * All specific tile types should extend this class.
 */
public abstract class Tile {
    protected ImageView view;

    /**
     * Gets the ImageView associated with this tile.
     *
     * @return the ImageView of this tile
     */
    public ImageView getView() {
        return view;
    }

    /**
     * Determines if this tile is penetrable.
     *
     * @return {@code true} if the tile is penetrable, {@code false} otherwise
     */
    public abstract boolean isPenetrable();

    /**
     * Determines if this tile is diggable.
     *
     * @return {@code true} if the tile is diggable, {@code false} otherwise
     */
    public abstract boolean isDiggable();
}

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a grass tile, typically placed on top of soil.
 */
public class Grass extends Tile {

    /**
     * Constructs a new {@code Grass} instance.
     * Sets up the image representing grass.
     */
    public Grass() {
        Image grassImage = new Image("assets/underground/top_01.png");
        view = new ImageView(grassImage);
    }

    /**
     * Determines if this grass tile is penetrable.
     *
     * @return {@code true} - Grass tiles are penetrable
     */
    @Override
    public boolean isPenetrable() {
        return true;
    }

    /**
     * Determines if this grass tile is diggable.
     *
     * @return {@code true} - Grass can be dug
     */
    @Override
    public boolean isDiggable() {
        return true;
    }
}

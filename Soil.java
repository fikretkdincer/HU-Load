import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a soil tile in the game.
 */
public class Soil extends Tile {

    /**
     * Constructs a new {@code Soil} instance.
     * Sets up the image representing soil.
     */
    public Soil() {
        Image soilImage = new Image("assets/underground/soil_01.png");
        view = new ImageView(soilImage);
    }

    /**
     * Determines if this soil tile is penetrable.
     *
     * @return {@code true} - Soil can be moved through
     */
    @Override
    public boolean isPenetrable() {
        return true;
    }

    /**
     * Determines if this soil tile is diggable.
     *
     * @return {@code true} - Soil can be dug
     */
    @Override
    public boolean isDiggable() {
        return true;
    }
}

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a lava tile in the game, which is penetrable and diggable.
 */
public class Lava extends Tile {

    /**
     * Constructs a new {@code Lava} instance.
     * Sets up the image representing lava.
     */
    public Lava() {
        Image lavaImage = new Image("assets/underground/lava_01.png");
        view = new ImageView(lavaImage);
    }

    /**
     * Determines if this lava tile is penetrable.
     *
     * @return {@code true} - Lava tiles are penetrable
     */
    @Override
    public boolean isPenetrable() {
        return true;
    }

    /**
     * Determines if this lava tile is diggable.
     *
     * @return {@code true} - Lava tiles can be dug
     */
    @Override
    public boolean isDiggable() {
        return true;
    }
}

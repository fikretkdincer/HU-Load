import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a boulder tile in the game, which cannot be drilled through.
 */
public class Boulder extends Tile {

    /**
     * Constructs a new {@code Boulder} instance.
     * Sets up the image representing a boulder.
     */
    public Boulder() {
        Image boulderImage = new Image("assets/underground/obstacle_01.png");
        view = new ImageView(boulderImage);
    }

    /**
     * Determines if this boulder tile is penetrable.
     *
     * @return {@code false} - Boulders cannot be moved through
     */
    @Override
    public boolean isPenetrable() {
        return false;
    }

    /**
     * Determines if this boulder tile is diggable.
     *
     * @return {@code false} - Boulders are not diggable
     */
    @Override
    public boolean isDiggable() {
        return false;
    }
}

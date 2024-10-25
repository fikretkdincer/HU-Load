import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.SnapshotParameters;

/**
 * Represents a dug tile in the game, which can be traversed but not dug further.
 */
public class DugTile extends Tile {

    /**
     * Constructs a new {@code DugTile} instance.
     * Sets up the image representing a dug tile.
     */
    public DugTile() {
        // Create a rectangle to represent the dug tile
        Rectangle rect = new Rectangle(50, 50);
        rect.setFill(Color.web("#5c4934")); // Fill color with hex code

        // Use a snapshot of the rectangle as the image for the ImageView
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = new WritableImage(50, 50);
        rect.snapshot(params, image);

        view = new ImageView(image);
    }

    /**
     * Determines if this dug tile is penetrable.
     *
     * @return {@code true} - Dug tiles are penetrable
     */
    @Override
    public boolean isPenetrable() {
        return true;
    }

    /**
     * Determines if this dug tile is diggable.
     *
     * @return {@code false} - Dug tiles cannot be dug further
     */
    @Override
    public boolean isDiggable() {
        return false;
    }
}

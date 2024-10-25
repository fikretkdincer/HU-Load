import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.SnapshotParameters;

/**
 * Represents a clear sky tile in the game.
 */
public class Sky extends Tile {

    /**
     * Constructs a new {@code Sky} instance.
     * Sets up a simple blue rectangle and converts it to an ImageView.
     */
    public Sky() {
        Rectangle skyRectangle = new Rectangle(50, 50); // Assuming each tile is 50x50 pixels
        skyRectangle.setFill(Color.LIGHTBLUE); // Set the color to light blue for the sky

        // Create a snapshot of the rectangle to convert it to an image
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT); // Ensuring the background remains transparent
        WritableImage image = new WritableImage(50, 50); // Create a writable image
        skyRectangle.snapshot(params, image);

        // Create an ImageView from the image
        view = new ImageView(image);
    }

    /**
     * Determines if this sky tile is penetrable.
     *
     * @return {@code true} - Sky tiles can be moved through
     */
    @Override
    public boolean isPenetrable() {
        return true;
    }

    /**
     * Determines if this sky tile is diggable.
     *
     * @return {@code false} - Sky tiles are not diggable
     */
    @Override
    public boolean isDiggable() {
        return false;
    }
}

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents an ironium in the game, a valuable item with low worth.
 */
public class Ironium extends Valuable {

    /**
     * Constructs a new {@code Ironium} instance with predefined characteristics.
     */
    public Ironium() {
        this.value = 50;    // Example value
        this.weight = 2.0;  // Example weight
        this.rarity = 0.5;  // Example rarity
        this.view = new ImageView(new Image("assets/underground/valuable_ironium.png"));
    }
}

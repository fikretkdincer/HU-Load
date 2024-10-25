import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a goldium in the game, a valuable item with moderate worth.
 */
public class Goldium extends Valuable {

    /**
     * Constructs a new {@code Goldium} instance with predefined characteristics.
     */
    public Goldium() {
        this.value = 200;
        this.weight = 1.0;
        this.rarity = 0.2;
        this.view = new ImageView(new Image("assets/underground/valuable_goldium.png"));
    }
}

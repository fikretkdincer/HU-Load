import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a silverium in the game, a valuable item with moderate worth.
 */
public class Silverium extends Valuable {

    /**
     * Constructs a new {@code Silverium} instance with predefined characteristics.
     */
    public Silverium() {
        this.value = 100;
        this.weight = 1.5;
        this.rarity = 0.3;
        this.view = new ImageView(new Image("assets/underground/valuable_silverium.png"));
    }
}

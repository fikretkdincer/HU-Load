import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents a diamond in the game, a valuable item with high worth.
 */
public class Diamond extends Valuable {

    /**
     * Constructs a new {@code Diamond} instance with predefined characteristics.
     */
    public Diamond() {
        this.value = 500;
        this.weight = 0.5;
        this.rarity = 0.1;
        this.view = new ImageView(new Image("assets/underground/valuable_diamond.png"));
    }
}

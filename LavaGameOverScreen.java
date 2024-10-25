import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Represents the game over screen displayed when the player encounters lava.
 */
public class LavaGameOverScreen extends StackPane {

    /**
     * Constructs a new {@code LavaGameOverScreen} instance.
     * Sets up the appearance and content of the game over screen.
     */
    public LavaGameOverScreen() {
        this.setStyle("-fx-background-color: red;");

        Text gameOverText = new Text("GAME OVER");
        gameOverText.setFont(new Font(50));
        gameOverText.setFill(Color.WHITE);

        this.getChildren().add(gameOverText);
        StackPane.setAlignment(gameOverText, javafx.geometry.Pos.CENTER);
    }
}

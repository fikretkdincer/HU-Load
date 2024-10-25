import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;

/**
 * Represents the game over screen displayed when the game ends.
 */
public class GameOverScreen extends StackPane {

    /**
     * Constructs a new {@code GameOverScreen} instance with the specified weight and value.
     *
     * @param weight the weight of the haul
     * @param value the value of the haul
     */
    public GameOverScreen(double weight, int value) {
        this.setStyle("-fx-background-color: green;");

        Text gameOverText = new Text("GAME OVER");
        gameOverText.setFont(new Font(50));
        gameOverText.setFill(Color.WHITE);

        Text haulText = new Text("Haul: " + weight);
        haulText.setFont(new Font(30));
        haulText.setFill(Color.WHITE);

        Text moneyText = new Text("Money: " + value);
        moneyText.setFont(new Font(30));
        moneyText.setFill(Color.WHITE);

        VBox vbox = new VBox(20, gameOverText, haulText, moneyText);
        vbox.setStyle("-fx-alignment: center;");
        this.getChildren().add(vbox);
    }
}

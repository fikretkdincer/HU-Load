import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * HUD (Heads-Up Display) class to display game information such as remaining fuel, current weight, and current value.
 */
public class HUD extends VBox {
    private Text fuelText;
    private Text weightText;
    private Text valueText;

    /**
     * Constructs a new {@code HUD} instance.
     * Initializes the text elements for displaying game information.
     */
    public HUD() {
        fuelText = new Text("Fuel: 10000");
        weightText = new Text("Weight: 0.0");
        valueText = new Text("Value: 0");

        fuelText.setFont(new Font(20)); // Set font size to 20
        weightText.setFont(new Font(20)); // Set font size to 20
        valueText.setFont(new Font(20)); // Set font size to 20

        this.getChildren().addAll(fuelText, weightText, valueText);
        this.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1); -fx-padding: 10;");
    }

    /**
     * Updates the displayed fuel value.
     *
     * @param fuel the new fuel value to be displayed
     */
    public void updateFuel(int fuel) {
        fuelText.setText("Fuel: " + fuel);
    }

    /**
     * Updates the displayed weight value.
     *
     * @param weight the new weight value to be displayed
     */
    public void updateWeight(double weight) {
        weightText.setText("Weight: " + weight);
    }

    /**
     * Updates the displayed value.
     *
     * @param value the new value to be displayed
     */
    public void updateValue(int value) {
        valueText.setText("Value: " + value);
    }
}

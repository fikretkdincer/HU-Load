import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;

/**
 * Main application class for the HU-Load game. Sets up the game environment, including
 * the scene, grid, and game mechanics.
 */
public class Main extends Application {
    private Scene scene;
    private StackPane root;
    private Drill drill;
    private GameMap gameMap;
    private HUD hud;

    /**
     * The entry point for the JavaFX application.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            gameMap = new GameMap(15, 18);
            drill = new Drill(gameMap, this::gameOver, this::lavaGameOver);
            gameMap.addDrill(drill);

            hud = new HUD();

            root = new StackPane();
            Pane gamePane = new Pane(gameMap);
            root.getChildren().addAll(gamePane, hud);

            StackPane.setAlignment(hud, javafx.geometry.Pos.TOP_LEFT);
            scene = new Scene(root, 750, 900);

            setupKeyEvents();
            setupGravity();
            setupFuelConsumption();
            setupHUDUpdate();

            primaryStage.setTitle("HU-Load");
            primaryStage.setScene(scene);
            primaryStage.show();

            scene.getRoot().requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets up key event handling for the game.
     */
    private void setupKeyEvents() {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    drill.move(0, -50);
                    break;
                case DOWN:
                    drill.move(0, 50);
                    break;
                case LEFT:
                    drill.move(-50, 0);
                    break;
                case RIGHT:
                    drill.move(50, 0);
                    break;
                default:
                    break;
            }
            scene.getRoot().requestFocus();
        });
    }

    /**
     * Sets up the gravity effect in the game.
     */
    private void setupGravity() {
        Timeline gravityTimeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> drill.applyGravity()));
        gravityTimeline.setCycleCount(Timeline.INDEFINITE);
        gravityTimeline.play();
    }

    /**
     * Sets up the fuel consumption over time.
     */
    private void setupFuelConsumption() {
        Timeline fuelConsumptionTimeline = new Timeline(new KeyFrame(Duration.millis(500), e -> drill.consumeFuelOverTime()));
        fuelConsumptionTimeline.setCycleCount(Timeline.INDEFINITE);
        fuelConsumptionTimeline.play();
    }

    /**
     * Sets up the HUD update mechanism.
     */
    private void setupHUDUpdate() {
        Timeline hudUpdateTimeline = new Timeline(new KeyFrame(Duration.millis(100), e -> updateHUD()));
        hudUpdateTimeline.setCycleCount(Timeline.INDEFINITE);
        hudUpdateTimeline.play();
    }

    /**
     * Updates the HUD with the current drill status.
     */
    private void updateHUD() {
        hud.updateFuel(drill.getFuel());
        hud.updateWeight(drill.getTotalWeight());
        hud.updateValue(drill.getTotalValue());
    }

    /**
     * Displays the game over screen.
     */
    public void gameOver() {
        GameOverScreen gameOverScreen = new GameOverScreen(drill.getTotalWeight(), drill.getTotalValue());
        root.getChildren().setAll(gameOverScreen);
    }

    /**
     * Displays the lava game over screen.
     */
    public void lavaGameOver() {
        LavaGameOverScreen lavaGameOverScreen = new LavaGameOverScreen();
        root.getChildren().setAll(lavaGameOverScreen);
    }

    /**
     * The main method to launch the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

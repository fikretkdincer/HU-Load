/**
 * Represents the directions in which a drill can move.
 */
public enum DrillDirection {

    /**
     * Indicates upward movement.
     */
    UP("assets/drill/drill_23.png"),

    /**
     * Indicates downward movement.
     */
    DOWN("assets/drill/drill_40.png"),

    /**
     * Indicates leftward movement.
     */
    LEFT("assets/drill/drill_01.png"),

    /**
     * Indicates rightward movement.
     */
    RIGHT("assets/drill/drill_55.png");

    private String imagePath;

    /**
     * Constructs a new {@code DrillDirection} with the specified image path.
     *
     * @param path the path of the image representing the drill direction
     */
    DrillDirection(String path) {
        this.imagePath = path;
    }

    /**
     * Gets the path of the image representing this drill direction.
     *
     * @return the path of the image
     */
    public String getPath() {
        return imagePath;
    }
}

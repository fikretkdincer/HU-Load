/**
 * Represents a valuable item in the game.
 * Valuables can be collected by the drill and have monetary value, weight, and rarity.
 */
public abstract class Valuable extends Tile {
    protected int value;   // The monetary value of the valuable
    protected double weight; // The weight of the valuable
    protected double rarity; // Rarity defines how often the valuable appears

    /**
     * Constructs a new {@code Valuable} instance.
     */
    public Valuable() {
        super();
    }

    /**
     * Gets the monetary value of the valuable.
     *
     * @return the monetary value
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the weight of the valuable.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets the rarity of the valuable.
     *
     * @return the rarity
     */
    public double getRarity() {
        return rarity;
    }

    /**
     * Determines if this valuable is penetrable.
     *
     * @return {@code true} - All valuables can be penetrated (collected by the drill)
     */
    @Override
    public boolean isPenetrable() {
        return true;
    }

    /**
     * Determines if this valuable is diggable.
     *
     * @return {@code true} - All valuables can be dug
     */
    @Override
    public boolean isDiggable() {
        return true;
    }
}

package org.existence.adventurelib.currency;

/**
 * Framework class for defining types of coins within the game
 */
public class Coin {

    /**
     * Value of the coin compared to 1 gold coin
     */
    public final double magnitude;
    /**
     * Name of the coin type
     */
    public final String name;
    /**
     * Hex code String which corresponds to the color the coin is displayed as in
     * text
     */
    public final String hexColor;

    /**
     * Constructs a new Coin object
     * 
     * @param magnitude Value of the coin type compared to 1 gold coin
     * @param name      Name of the coin type
     * @param hexColor  Hex code String which corresponds to the color the coin is
     *                  displayed as in text
     */
    public Coin(double magnitude, String name, String hexColor) {
        this.magnitude = magnitude;
        this.name = name;
        this.hexColor = hexColor;
    }

    /**
     * @return Value of the coin type compared to 1 gold coin
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * @return Name of the coin type
     */
    public String getName() {
        return name;
    }

    /**
     * @return Hex code String which corresponds to the color the coin is displayed
     *         as in text
     */
    public String getHexColor() {
        return hexColor;
    }

}

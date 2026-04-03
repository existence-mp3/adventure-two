package org.existence.adventurelib.scenes;

/**
 * Framework class for defining dialogue that can be executed in a scene
 */
public class Dialogue {

    /**
     * The text the makes up the dialogue
     */
    public String value;
    /**
     * The hex code for the color that the dialogue is to be displayed with
     */
    public String colorHex;

    /**
     * Defines a new dialogue object with a specified value and display color
     * 
     * @param value    The text that makes up the dialogue
     * @param colorHex The hex code for the color that the dialogue is to be
     *                 displayed with
     */
    public Dialogue(String value, String colorHex) {
        this.value = value;
        this.colorHex = colorHex;
    }

    /**
     * Defines a new dialogue object with a specified value
     * 
     * @param value The text that makes up the dialogue
     */
    public Dialogue(String value) {
        this(value, "#ffffff");
    }

    /**
     * Print the text of the dialogue
     */
    public void print() {
        System.out.println(value);
    }

    /**
     * Set the value of the text of the dialogue
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return Text of the dialogue
     */
    public String getValue() {
        return value;
    }

}

package org.existence.adventure.utils.economy.currency;

/**
 * Framework class for defining groups of coins
 */
public class Coins {

    /**
     * Number of coins included
     */
    public int amount;
    /**
     * The type of Coin that the object represents
     */
    public Coin type;

    /**
     * Constructs a new Coins object with a specified starting amount
     * 
     * @param amount Number of coins included in the object
     * @param type   The type of coin that the object represents
     */
    public Coins(int amount, Coin type) {
        this.amount = amount;
        this.type = type;
    }

    /**
     * Constructs a new coin object. Starts with 0 of the given coin type by defualt
     * 
     * @param type The type of coin that the object represents
     */
    public Coins(Coin type) {
        this(0, type);
    }

    /**
     * Set the amount of coins included within the object to a new value
     * 
     * @param amount Value to set the new amount to
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Change the current amount of coins included in the object by a certain amount
     * 
     * @param delta Amount of coins to add to the new total
     */
    public void changeAmount(int delta) {
        setAmount(amount + delta);
    }

    /**
     * Add a certain number of coins to the total amount included in the object
     * 
     * @param amount Amount of coins to add
     */
    public void add(int amount) {
        changeAmount(amount);
    }

    /**
     * Remove a certain number of coins from the total amount included in the object
     * 
     * @param amount Amount of coins to remove
     */
    public void remove(int amount) {
        changeAmount(-amount);
    }

    /**
     * @return Amount of coins represented within the object
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @return Type of coin that the object represents
     */
    public Coin getType() {
        return type;
    }

}

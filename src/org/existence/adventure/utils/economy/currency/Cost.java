package org.existence.adventure.utils.economy.currency;

/**
 * Framwork class for groups of coins that can be spend
 */
public class Cost {

    /**
     * Set of coins that are included in the Cost
     */
    public Coins[] coins;

    /**
     * Constructs a new Cost object
     * 
     * @param coins The different types of coins included in the object
     */
    public Cost(Coins... coins) {
        this.coins = coins;
    }

}

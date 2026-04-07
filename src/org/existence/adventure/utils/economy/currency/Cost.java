package org.existence.adventure.utils.economy.currency;

/**
 * Framwork class for groups of coins that can be spent
 * <p>
 * Constructed with a list of <code>Coins</code> objects
 * 
 * <pre>
 * <blockquote>Cost cost = new Cost(new Coins(new Gold(), 4), new Coins(new Silver(), 5));</blockquote>
 * </pre>
 * 
 * Leave the constructor blank to make the <code>Cost</code> be nothing
 */
public class Cost {

    /**
     * Set of coins that are included in the Cost
     */
    public Coins[] coins;

    /**
     * Constructs a new Cost object
     * 
     * @param coins The different types of coins included in the object in addition
     *              to the quantity of each one
     */
    public Cost(Coins... coins) {
        this.coins = coins;
    }

    /**
     * <strong>Example:</strong>
     * <p>
     * <em>4 Gold, 1 Copper</em>
     * 
     * @return The different types of coins included in the object and how much of
     *         each type
     */
    public Coins[] getValues() {
        return coins;
    }

}

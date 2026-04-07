package org.existence.adventure.utils.economy.currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Framework class for tracking the amount of money possessed by creatures
 * <p>
 * Can be constructed blank (with no <code>Coins</code> in it) by default
 * <blockquote>
 * 
 * <pre>
 * Wallet wallet = new Wallet();
 * </pre>
 * 
 * </blockquote>
 * Or can be contructed with a preset amount of coins of various types
 * <blockquote>
 * 
 * <pre>
 * Wallet wallet = new Wallet(new Coins(new Gold(), 5), new Coins(new Silver(), 3);
 * </pre>
 * 
 * </blockquote>
 */
public class Wallet {

    /**
     * The different types of coins that the object represents and the quantity of
     * each type
     */
    public List<Coins> coinsList;
    private Coins[] coinsArray;
    /**
     * The total value of all coins in the wallet, expressed in terms of gold coins
     */
    public double totalMagnitude;

    /**
     * Constructs a new Wallet object
     * 
     * @param coins The different types of coins that the object represents and the
     *              quantity of each type (eg. <em>5 Gold, 6 Silver</em> or <em>2
     *              Copper, 10 Silver</em>). If there are multiple groups of coins
     *              of the same type they will be automatically grouped together
     */
    public Wallet(Coins... coins) {
        combineDuplicates(coins);
        calculateValue(coins);
        coinsArray = coins;
        coinsList = Arrays.asList(coins);
        totalMagnitude = 0;
    }

    /**
     * Constructs a new Wallet object with nothing in it by default
     */
    public Wallet() {
        coinsList = new ArrayList<>();
        coinsArray = new Coins[0];
        totalMagnitude = 0;
    }

    /**
     * Combines Coins objects if they are of the same type (eg. <em>2 Silver, 3
     * Gold, 4
     * Gold</em> becomes <em>2 Silver, 7 Gold</em>)
     * 
     * @param coins Array of <strong>Coins</strong> objects for the method to check
     *              for duplicate types of coins within
     */
    private void combineDuplicates(Coins[] coins) {
        List<Coins> coinsList = Arrays.asList(coins);
        List<String> types = new ArrayList<>();
        List<Integer> rejects = new ArrayList<>();

        for (int i = 0; i < coinsList.size(); i++) {
            String currentName = coinsList.get(i).getType().getName();
            types.set(i, currentName);
            if (types.contains(currentName)) {
                rejects.add(i);
                types.get(i).concat("+");
                coinsList.get(types.indexOf(currentName)).add(coinsList.get(i).getAmount());
            }
        }

        for (int i = 0; i < rejects.size(); i++) {
            coinsList.remove(rejects.get(i));
        }

        coinsArray = (Coins[]) coinsList.toArray();
        coins = (Coins[]) coinsList.toArray();
        this.coinsList = coinsList;
    }

    /**
     * Computes the total magnitude of all of the coins in the Wallet (eg. <em>2
     * Gold, 4 Silver</em> gets a magnitude of 2.4)
     * 
     * @param coins The coins to calculate the magnitude of
     * @return The total magnitude
     */
    private double calculateValue(Coins[] coins) {
        double total = 0;
        for (int i = 0; i < coins.length; i++) {
            total += coins[i].getAmount() * coins[i].getType().getMagnitude();
        }
        totalMagnitude = total;
        return total;
    }

    /**
     * Removes an amount of coins of certain types from the <code>Wallet</code>
     * <p>
     * <strong>Example:</Strong>
     * <p>
     * <code>Wallet</code> has <em>2 Gold, 5 Silver, 1 Copper</em>. Price is <em>1
     * Gold, 2 Silver</em>. The <code>Wallet</code> will now have<em> 1 Gold, 3
     * Silver, 1 Copper</em>.
     * 
     * @param price The amount of coins to remove. Which type they are and how many
     *              of each type
     */
    public void pay(Cost price) {
        Coins[] coinPrice = price.getValues();
        for (int i = 0; i < coinPrice.length; i++) {
            removeCoins(coinPrice[i].getType(), coinPrice[i].getAmount());
        }
    }

    /**
     * Sets the value of the Coins contained within the object to the given values
     * <p>
     * <strong>Example:</strong>
     * <p>
     * <em>5 Gold, 6 Silver</em> becomes <em>2 Copper, 10 Silver</em>
     * 
     * @param coins The different types of coins that the object represents and the
     *              quantity of each type. If there are multiple groups of coins
     *              of the same type they will be automatically grouped together
     */
    public void setCoinsList(List<Coins> coins) {
        coinsList = coins;
        coinsArray = (Coins[]) coins.toArray();
        combineDuplicates(coinsArray);
        calculateValue(coinsArray);
    }

    /**
     * Removes a certain amount of a certain type of coin from the Wallet
     * <p>
     * <strong>Example:</strong>
     * <p>
     * You have <em>6 Gold, 8 Silver</em> and remove <em>2 Gold.</em> You
     * now have <em>4 Gold, 8 Silver.</em>
     * 
     * @param type   The type of {@link Coin} to remove an amount of
     * @param amount The amount of coins of said coin type to remove
     */
    public void removeCoins(Coin type, int amount) {
        int id = -1;
        for (int i = 0; i < coinsList.size(); i++) {
            if (coinsList.get(i).getType() == type) {
                id = i;
                break;
            }
        }
        coinsList.get(id).remove(amount);
        setCoinsList(coinsList);
    }

    /**
     * Adds a certain amount of a certain type of coin from the Wallet
     * <p>
     * <strong>Example:</strong>
     * <p>
     * You have <em>6 Gold, 8 Silver</em> and add <em>2 Gold.</em> You
     * now have <em>8 Gold, 8 Silver.</em>
     * 
     * @param type   The type of {@link Coin} to add an amount of
     * @param amount The amount of coins of said coin type to add
     */
    public void addCoins(Coin type, int amount) {
        int id = -1;
        for (int i = 0; i < coinsList.size(); i++) {
            if (coinsList.get(i).getType() == type) {
                id = i;
                break;
            }
        }
        coinsList.get(id).add(amount);
        setCoinsList(coinsList);
    }

    /**
     * Removes certain amounts of certain types of coins from the Wallet
     * <p>
     * <strong>Example:</strong>
     * <p>
     * You have <em>6 Gold, 8 Silver</em> and remove <em>2 Gold, 3 Silver.</em> You
     * now have <em>4 Gold, 5 Silver.</em>
     * 
     * @param types   The types of {@link Coin coins} to remove amounts of
     * @param amounts The amounts of coins of said types to remove
     * @throws ArrayIndexOutOfBoundsException if the length of the arrays are not
     *                                        equivalent
     */
    public void removeCoins(Coin[] types, int[] amounts) {
        if (types.length != amounts.length) {
            throw new ArrayIndexOutOfBoundsException("Length " + types.length +
                    " for coin types is not equal to length "
                    + amounts.length + " for amounts.");
        }

        for (int i = 0; i < types.length; i++) {
            removeCoins(types[i], amounts[i]);
        }
    }

    /**
     * Adds certain amounts of certain types of coins from the Wallet
     * <p>
     * <strong>Example:</strong>
     * <p>
     * You have <em>6 Gold, 8 Silver</em> and add <em>2 Gold, 3 Silver.</em> You
     * now have <em>8 Gold, 11 Silver.</em>
     * 
     * @param types   The types of {@link Coin coins} to add amounts of
     * @param amounts The amounts of coins of said types to add
     * @throws ArrayIndexOutOfBoundsException if the length of the arrays are not
     *                                        equivalent
     */
    public void addCoins(Coin[] types, int[] amounts) {
        if (types.length != amounts.length) {
            throw new ArrayIndexOutOfBoundsException("Length " + types.length +
                    " for coin types is not equal to length "
                    + amounts.length + " for amounts.");
        }

        for (int i = 0; i < types.length; i++) {
            addCoins(types[i], amounts[i]);
        }
    }

}

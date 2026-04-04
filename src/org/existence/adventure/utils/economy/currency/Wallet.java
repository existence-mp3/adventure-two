package org.existence.adventure.utils.economy.currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Framework class for tracking the amount of money possessed by creatures
 */
public class Wallet {

    /**
     * The different types of coins that the object represents and the quantity of
     * each type
     */
    public List<Coins> coins;
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
        this.coins = Arrays.asList(coins);
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

        coins = (Coins[]) coinsList.toArray();
    }

}

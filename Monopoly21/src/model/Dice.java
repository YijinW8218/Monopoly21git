package model;

import java.util.Random;

public class Dice {
    private int value;
    private static Random random = new Random();

    /**
     * Simulates rolling a dice. Will generate a random
     * number between 1-6 and return that
     * @return  number 1-6 inclusive
     */
    public static int rollDice(){
        return random.nextInt(6) + 1;
    }
}


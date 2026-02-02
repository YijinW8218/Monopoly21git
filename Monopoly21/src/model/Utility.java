package model;

public class Utility extends LocationToBuy{
    private static final int OWN_ONE = 6;
    private static final int OWN_TWO = 10;

    public Utility(String name, int location, int cost) {
        super(name, location, 150);
    }

    public int getRent(int count) {
        int diceRoll = Dice.rollDice() + Dice.rollDice();

        return count == 2 ? diceRoll * OWN_TWO : diceRoll * OWN_ONE;
    }
}


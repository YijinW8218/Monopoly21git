package Monopoly21.src.model;

public class Railroad extends LocationToBuy{
    private static final int ONE_RR = 25;
    private static final int TWO_RR = 50;
    private static final int THREE_RR = 100;
    private static final int FOUR_RR = 200;

    public Railroad(String name, int location, int cost) {
        super(name, location, 200);
    }

    public int getRent(int count) {
        if (count==1) {
            return ONE_RR;
        }else if (count == 2) {
            return TWO_RR;
        } else if (count == 3) {
            return THREE_RR;
        } else {
            return FOUR_RR;
        }
    }

}

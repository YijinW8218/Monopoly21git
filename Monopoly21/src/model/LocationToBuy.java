package model;

public class LocationToBuy {
    protected int cost;

    public LocationToBuy(String name, int location, int cost) {
        super(name, location);

        this.cost = cost;
    }

    // Getter and Setter
    public int getCost() {return cost; }

    public void setCost(int cost) {this.cost=cost;}

    @Override

}


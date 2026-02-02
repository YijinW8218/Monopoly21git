package model;

import java.awt.*;
import java.util.Map;

public class Property extends LocationToBuy {
    private  int rent;
    private Color colorGroup;
    private static final Map<Color, Integer> colorCount = Map.of(
            Color.DARK_GRAY, 2, //Normally is Brown
            Color.CYAN, 3,
            Color.PINK, 3,
            Color.ORANGE,3,
            Color.RED,3,
            Color.YELLOW,3,
            Color.GREEN,3,
            Color.BLUE,2);

    public  Property(String name, int location, int cost, int rent, Color color){
        super(name, location, cost);

        this.rent = rent;
        this.colorGroup = color;
    }

    //Getter and Setter
    public int getRent() {return rent;}

    public void setRent(int rent) {this.rent=rent;}

    public Color getColorGroup() {return colorGroup;}

    public void setColorGroup(Color colorGroup) {
        this.colorGroup = colorGroup;
    }
}


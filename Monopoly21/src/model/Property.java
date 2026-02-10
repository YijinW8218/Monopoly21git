package Monopoly21.src.model;

import java.awt.Color;
import java.util.Map;

public class Property extends LocationToBuy {
    private  int rent;
    private Color colorGroup;
    public static final Map<Color, Long> colorCount = Map.of(
            Color.DARK_GRAY, 2L, //Normally is Brown
            Color.CYAN, 3L,
            Color.PINK, 3L,
            Color.ORANGE,3L,
            Color.RED,3L,
            Color.YELLOW,3L,
            Color.GREEN,3L,
            Color.BLUE,2L);

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


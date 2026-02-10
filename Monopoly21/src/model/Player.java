package Monopoly21.src.model;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private List<LocationToBuy> ownedProperties;
    private Token token;
    private double balance;
    private boolean isBanker;
    private int currentLocation;
    private int railroadCount;
    private int utilityCount;

    public Player(String name, Token token, boolean isBanker) {
        this.name = name;
        this.token = token;
        this.isBanker = isBanker;
        // Default values
        ownedProperties = new ArrayList<>();
        balance = 1500;
        currentLocation = 0;
        railroadCount = 0;
        utilityCount = 0;
    }

    // Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBanker() {
        return isBanker;
    }

    public void setBanker(boolean banker) {
        isBanker = banker;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setOwnedProperties(List<LocationToBuy> ownedProperties) {
        this.ownedProperties = ownedProperties;
    }

    public int getRailroadCount() {
        return railroadCount;
    }

    public void setRailroadCount(int railroadCount) {
        this.railroadCount = railroadCount;
    }

    public int getUtilityCount() {
        return utilityCount;
    }

    public void setUtilityCount(int utilityCount) {
        this.utilityCount = utilityCount;
    }

    public int getRentalCost(int location) {
        //Check to see if location is owned by the Player
        Optional<LocationToBuy> exists = ownedProperties.stream()
                .filter(s -> s.getLocation() == location)
                .findFirst();

        if (exists.isEmpty()) {
            return 0; // dont own the Property
        }

        Object property = exists.get();

        //Determine the type of Location (Property vs Utility/Railroad)

        //if Utility/Railroad -> return getRent()
        if ( property instanceof Utility) {
            return ((Utility) property).getRent(utilityCount);
        } else if (property instanceof Railroad) {
            return ((Railroad) property).getRent(railroadCount);
        } else if (property instanceof  Property prop) {

            // Get a map of the owned color groups
            Map<Color, Long> colorCounts = ownedProperties.stream()
                    .filter(Property.class::isInstance) //Filter to only look at Property classes
                    .map(Property.class::cast)          //Create a temp map of just those classes
                    //Get a count of the color groups
                    .collect(Collectors.groupingBy(Property::getColorGroup, Collectors.counting()));

            //see if they own all of the properties of a color
            if (Objects.equals(Property.colorCount.get(prop.getColorGroup()),
                    colorCounts.get(prop.getColorGroup()))){
                //if so -> rent is doubled
                return prop.getRent() * 2;
            }else {
                //else -> return rent
                return prop.getRent();
            }
        }

        // else determine rent


        return 0;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ownedProperties=").append(ownedProperties);
        sb.append(", token=").append(token);
        sb.append(", balance=").append(balance);
        sb.append(", isBanker=").append(isBanker);
        sb.append(", currentLocation=").append(currentLocation);
        sb.append(", railroadCount=").append(railroadCount);
        sb.append(", utilityCount=").append(utilityCount);
        sb.append('}');
        return sb.toString();
    }
}

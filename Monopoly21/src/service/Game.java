package Monopoly21.src.service;

import Monopoly21.src.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private List<BoardLocation> locations;
    private int currentPlayer;

    public Game(){
        setupPlayers();
        setupLocations();

        // start at -1 sp the controller will call next turen to start the game.
        currentPlayer =-1;
    }


    public Player getCurrentPlayer() {
        //banker is always last on list
        return players.get(currentPlayer);
    }

    public void nextPlayer(){
        if (currentPlayer == players.size() -2) {
            currentPlayer = 0;
        }else {
            currentPlayer++;
        }
    }

    private void setupPlayers(){
        players = new ArrayList<>();

        //TODO: get player info
        //TODO: remove created players
        players.add(new Player("name1", Token.IRON,false));
        players.add(new Player("name2", Token.SOME, false));
        // I don't have the players example in class.
    }

    private void setupLocations(){
        locations = new ArrayList<>();

        //TODO: Tax location and CC/Chance need a special location created
        //Add all of the Monopoly locations
        locations.add(new BoardLocation("Go", 0));
        locations.add(new Property("Mediterranean Avenue", 1, 60, 2, Color.DARK_GRAY));
        locations.add(new BoardLocation("Community Chest", 2));
        locations.add(new Property("Baltic Avenue", 3, 60, 4, Color.DARK_GRAY));
        locations.add(new BoardLocation("Income Tax", 4));
        locations.add(new Railroad("Reading Railroad", 5));
        locations.add(new Property("Oriental Avenue", 6, 100, 6, Color.CYAN));
        locations.add(new BoardLocation("Chance", 7));
        locations.add(new Property("Vermont Avenue", 8, 100, 6, Color.CYAN));
        locations.add(new Property("Connecticut Avenue", 9, 120, 8, Color.CYAN));

        locations.add(new BoardLocation("Jail / Just Visiting", 10));
        locations.add(new Property("St. Charles Place", 11, 140, 10, Color.PINK));
        locations.add(new Utility("Electric Company", 12));
        locations.add(new Property("States Avenue", 13, 140, 10, Color.PINK));
        locations.add(new Property("Virginia Avenue", 14, 160, 12, Color.PINK));
        locations.add(new Railroad("Pennsylvania Railroad", 15));
        locations.add(new Property("St. James Place", 16, 180, 14, Color.ORANGE));
        locations.add(new BoardLocation("Community Chest", 17));
        locations.add(new Property("Tennessee Avenue", 18, 180, 14, Color.ORANGE));
        locations.add(new Property("New York Avenue", 19, 200, 14, Color.ORANGE));

        locations.add(new BoardLocation("Free Parking", 20));
        locations.add(new Property("Kentucky Avenue", 21, 220, 18, Color.RED));
        locations.add(new BoardLocation("Chance", 22));
        locations.add(new Property("Indiana Avenue", 23, 220, 18, Color.RED));
        locations.add(new Property("Illinois Avenue", 24, 240, 20, Color.RED));
        locations.add(new Railroad("B. & O. Railroad", 25));
        locations.add(new Property("Atlantic Avenue", 26, 260, 22, Color.YELLOW));
        locations.add(new Property("Ventnor Avenue", 27, 260, 22, Color.YELLOW));
        locations.add(new Utility("Water Works", 28));
        locations.add(new Property("Marvin Gardens", 29, 280, 24, Color.YELLOW));

        locations.add(new BoardLocation("Go To Jail", 30));
        locations.add(new Property("Pacific Avenue", 31, 300, 26, Color.GREEN));
        locations.add(new Property("North Carolina Avenue", 32, 300, 26, Color.GREEN));
        locations.add(new BoardLocation("Community Chest", 33));
        locations.add(new Property("Pennsylvania Avenue", 34, 320, 28, Color.GREEN));
        locations.add(new Railroad("Short Line", 35));
        locations.add(new BoardLocation("Chance", 36));
        locations.add(new Property("Park Place", 37, 350, 35, Color.BLUE));
        locations.add(new BoardLocation("Luxury Tax", 38));
        locations.add(new Property("Boardwalk", 39, 400, 50, Color.BLUE));


    }

}

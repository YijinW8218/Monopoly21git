package Monopoly21.src.controller;

import Monopoly21.src.model.Dice;
import Monopoly21.src.model.Player;
import Monopoly21.src.service.Game;
import Monopoly21.src.view.MainGameBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MonopolyController {

    private MainGameBoard view;
    private Game model;

    private static final String PLAYER_NAME = "Player name: ";
    private static final String CASH_VALUE = "Cash: $ ";
    private static final String CURRENT_LOCATION = "Current Location: ";
    private static final String DICE_VALUE = "Dice Value: ";

    public MonopolyController(MainGameBoard view, Game model) {
        this.model = new Game();
        this.view = new MainGameBoard();

        //set  the game to the first player
        nextTurn();

        //Setup the ActionListeners
        this.view.getRollDiceButton().addActionListener(ActionEvent e -> {
            int dice1 = Dice.rollDice();
            int dice2 = Dice.rollDice();

            //Roll double?
            boolean rollDice = dice1 == dice2;
            //TODO: Handle doubles

            this.view.getRolledLbl().setText(DICE_VALUE + (dice1+dice2));
        });

        this.view.getNextTurnButton().addActionListener(ActionEvent e ->{
            nextTurn();
        })
    }

    private void nextTurn() {
        //move to next player
        this.model.nextPlayer();
        //move to the next player and retuen the info
        Player currentPlayer = this.model.getCurrentPlayer();

        //set the value
        this.view.getNameLbl().setText(PLAYER_NAME + currentPlayer.getName());
        this.view.getCashLbel().setText(CASH_VALUE + currentPlayer.getBalance());

        //todo: get name of location
        this.view.getLocationLbel().setText(CURRENT_LOCATION + currentPlayer.getCurrentLocation());

        //reset the rolled value to blank
        this.view.getRolledLbel().setText(DICE_VALUE);

        //status to user
        this.view.getTextArea1().setText("click roll dice to ake you turn");

    }

    public MainGameBoard getView() {return view;}

    public Game getModel() {return model;}
}

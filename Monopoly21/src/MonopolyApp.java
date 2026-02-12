package Monopoly21.src;

import Monopoly21.src.controller.MonopolyController;
import Monopoly21.src.service.Game;
import Monopoly21.src.view.MainGameBoard;

import javax.swing.*;


public class MonopolyApp {
    public static void main(String[] args) {
        MonopolyController controller = new MonopolyController(new MainGameBoard(), new Game());

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Monopoly");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(controller.getView().getMainPanel());
            frame.setSize(1000,800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        }
    }
}
package Monopoly21.src.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MonopolyBoard extends JPanel {

    private static class Tile {
        final String name;
        final Color color;

        Tile(String name, Color color) {
            this.name = name;
            this.color = color;
        }
    }

    private final List<Tile> tiles = new ArrayList<>();

    public MonopolyBoard() {
        setPreferredSize(new Dimension(700, 700));
        setBackground(new Color(0x2E7D32));
        initTiles();
    }

    private void initTiles() {

        // Bottom row (11 tiles)
        tiles.add(new Tile("GO", Color.WHITE));                 // 0
        tiles.add(new Tile("Mediterranean Ave", Color.DARK_GRAY));
        tiles.add(new Tile("Community Chest", Color.WHITE));
        tiles.add(new Tile("Baltic Ave", Color.DARK_GRAY));
        tiles.add(new Tile("Income Tax", Color.LIGHT_GRAY));
        tiles.add(new Tile("Reading Railroad", Color.BLACK));
        tiles.add(new Tile("Oriental Ave", Color.CYAN));
        tiles.add(new Tile("Chance", Color.WHITE));
        tiles.add(new Tile("Vermont Ave", Color.CYAN));
        tiles.add(new Tile("Connecticut Ave", Color.CYAN));
        tiles.add(new Tile("Jail / Just Visiting", Color.WHITE)); // 10

        // Left side (9 tiles)
        tiles.add(new Tile("St. Charles Place", Color.PINK));     // 11
        tiles.add(new Tile("Electric Company", Color.YELLOW));
        tiles.add(new Tile("States Ave", Color.PINK));
        tiles.add(new Tile("Virginia Ave", Color.PINK));
        tiles.add(new Tile("Pennsylvania Railroad", Color.BLACK));
        tiles.add(new Tile("St. James Place", Color.ORANGE));
        tiles.add(new Tile("Community Chest", Color.WHITE));
        tiles.add(new Tile("Tennessee Ave", Color.ORANGE));
        tiles.add(new Tile("New York Ave", Color.ORANGE));        // 19

        // Top row (11 tiles)
        tiles.add(new Tile("Free Parking", Color.WHITE));         // 20
        tiles.add(new Tile("Kentucky Ave", Color.RED));
        tiles.add(new Tile("Chance", Color.WHITE));
        tiles.add(new Tile("Indiana Ave", Color.RED));
        tiles.add(new Tile("Illinois Ave", Color.RED));
        tiles.add(new Tile("B. & O. Railroad", Color.BLACK));
        tiles.add(new Tile("Atlantic Ave", Color.YELLOW));
        tiles.add(new Tile("Ventnor Ave", Color.YELLOW));
        tiles.add(new Tile("Water Works", Color.WHITE));
        tiles.add(new Tile("Marvin Gardens", Color.YELLOW));
        tiles.add(new Tile("Go To Jail", Color.WHITE));           // 30

        // Right side (9 tiles)
        tiles.add(new Tile("Pacific Ave", Color.GREEN));          // 31
        tiles.add(new Tile("North Carolina Ave", Color.GREEN));
        tiles.add(new Tile("Community Chest", Color.WHITE));
        tiles.add(new Tile("Pennsylvania Ave", Color.GREEN));
        tiles.add(new Tile("Short Line Railroad", Color.BLACK));
        tiles.add(new Tile("Chance", Color.ORANGE));
        tiles.add(new Tile("Park Place", Color.BLUE));
        tiles.add(new Tile("Luxury Tax", Color.LIGHT_GRAY));
        tiles.add(new Tile("Boardwalk", Color.BLUE));             // 39
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard((Graphics2D) g);
    }

    private void drawBoard(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int margin = 40;

        // Board is 11 tiles wide and 11 tiles tall
        int tilesWide = 11;
        int tileSize = (Math.min(w, h) - 2 * margin) / tilesWide;

        int boardSize = tileSize * tilesWide;
        int x0 = (w - boardSize) / 2;
        int y0 = (h - boardSize) / 2;

        // Outer border
        g2.setColor(Color.WHITE);
        g2.fillRect(x0, y0, boardSize, boardSize);
        g2.setColor(Color.BLACK);
        g2.drawRect(x0, y0, boardSize, boardSize);

        for (int i = 0; i < 40; i++) {
            Rectangle r = tileBounds(i, x0, y0, tileSize);
            Tile t = tiles.get(i);

            g2.setColor(t.color);
            g2.fill(r);

            g2.setColor(Color.BLACK);
            g2.draw(r);

            if (t.color == Color.BLACK) {
                g2.setColor(Color.WHITE);
            }
            drawCenteredString(g2, t.name, r, new Font("SansSerif", Font.PLAIN, 9));
        }
    }

    private Rectangle tileBounds(int index, int x0, int y0, int tileSize) {

        // Bottom row (0–10), right → left
        if (index <= 10) {
            int x = x0 + (10 - index) * tileSize;
            int y = y0 + 10 * tileSize;
            return new Rectangle(x, y, tileSize, tileSize);
        }

        // Left side (11–19), bottom → top
        if (index <= 19) {
            int pos = index - 11;
            int x = x0;
            int y = y0 + (9 - pos) * tileSize;
            return new Rectangle(x, y, tileSize, tileSize);
        }

        // Top row (20–30), left → right
        if (index <= 30) {
            int pos = index - 20;
            int x = x0 + pos * tileSize;
            int y = y0;
            return new Rectangle(x, y, tileSize, tileSize);
        }

        // Right side (31–39), top → bottom
        int pos = index - 31;
        int x = x0 + 10 * tileSize;
        int y = y0 + (pos + 1) * tileSize;
        return new Rectangle(x, y, tileSize, tileSize);
    }

    private void drawCenteredString(Graphics2D g2, String text, Rectangle rect, Font font) {
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();

        String[] lines = text.split(" ");
        int lineHeight = fm.getHeight();
        int totalHeight = lines.length * lineHeight;

        int y = rect.y + (rect.height - totalHeight) / 2 + fm.getAscent();

        for (String line : lines) {
            int x = rect.x + (rect.width - fm.stringWidth(line)) / 2;
            g2.drawString(line, x, y);
            y += lineHeight;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Monopoly");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new MonopolyBoard());
            frame.setSize(800, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

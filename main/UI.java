package main;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font pixelFont;
    public String currentDialogue = "";
    public boolean gameFinished = false;
    Font arial_40B, arial_80B;
    private String playerInput;
    public boolean awaitingInput = false;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40B = new Font("Arial", Font.BOLD, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        InputStream is = getClass().getResourceAsStream("/font/pixelFont.ttf");
        if (is == null) {
            throw new RuntimeException("Font file not found!");
        }
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException("Font format is incorrect", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred while reading the font file", e);
        }
    }

    public void promptPlayerInput() {
        System.out.println("Please enter the withdrawal amount: ");
        Scanner scanner = new Scanner(System.in);
        playerInput = scanner.nextLine();
    }

    public String getPlayerInput() {
        String tempInput = playerInput;
        playerInput = null; // Reset after getting input
        return tempInput;
    }

    public void showMessage(String text) {
    }

    public void draw(Graphics2D g2) {
        if (gameFinished) {
            g2.setFont(arial_40B);
            g2.setColor(Color.white);
            String text;
            int textLength;
            int x, y;

            text = "You have finished the game!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);
            text = "Congratulations!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight - (gp.tileSize * 5);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        } else {
            this.g2 = g2;
            g2.setFont(pixelFont);
            g2.setColor(Color.WHITE);

            if (gp.gameState == gp.playState) {

            } else if (gp.gameState == gp.sleepState) {
                drawDialogueScreen();
            } else if (gp.gameState == gp.pauseState) {
                drawPauseScreen();
            } else if (gp.gameState == gp.infoState) {

            } else if (gp.gameState == gp.dialogueState) {
                drawDialogueScreen();
            }
        }
    }

    public void drawDialogueScreen() {
        int x = gp.tileSize * 2;
        int y = 0;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24));
        x += gp.tileSize - 20;
        y += gp.tileSize;

        for (String line : currentDialogue.split("/n")) {
            g2.drawString(line, x, y);
            y += 20;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }
}

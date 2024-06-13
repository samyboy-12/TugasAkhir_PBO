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
    public int commandNum = 0;
    public boolean inPauseScreen;

    //untuk sub window
    public int titleScreenState = 0;



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
            }else if (gp.gameState == gp.titleState) {
                drawTitleScreen();
            }
        }
    }

    public void drawTitleScreen(){

        if (titleScreenState == 0){
            
            //TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 56));
            String text = "     KOSLIFE: SIMULASI ANAK KOS";
            int x = getXforCenteredText(text)-45;
            int y = gp.tileSize*2;
    
            //SHADOW
            g2.setColor(Color.GRAY);
            g2.drawString(text,x+4,y+4);
    
            //MAIN COLOR
            g2.setColor(Color.WHITE);
            g2.drawString(text,x,y);
    
            //MAIN CHARACTER IMAGE
            x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            y += gp.tileSize*2;
            g2.drawImage(gp.maincharacter.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
    
            //MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 46));
            text = "START SIMULATION";
            x = getXforCenteredText(text);
            y += gp.tileSize*4;
            g2.drawString(text, x, y);
            if (commandNum == 0){
                g2.drawString("->", x-gp.tileSize,y);
            }
    
            text = "STORY OF THE GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1){
                g2.drawString("->", x-gp.tileSize,y);
            }
    
            text = "HOW TO PLAY (CONTROL GUIDE)";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2){
                g2.drawString("->", x-gp.tileSize,y);
            }
    
            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 3){
                g2.drawString("->", x-gp.tileSize,y);
            }
        } else if (titleScreenState == 1) {
            commandNum = 0;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 46));
            String text = "        STORY OF 'KOSLIFE: SIMULASI ANAK KOS'";
            int x = getXforCenteredText(text)-45;
            int y = gp.tileSize*2;

            //SHADOW
            g2.setColor(Color.GRAY);
            g2.drawString(text,x+4,y+4);

            //MAIN COLOR
            g2.setColor(Color.WHITE);
            g2.drawString(text,x,y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32));
            text = "'KOS LIFE: GAME SIMULASI ANAK KOS' /n merupakan Lorem ipsum dolor sit amet, consectetur adipiscing elit, /n sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. /nUt enim ad minim veniam, quis nostrud exercitation ullamco";
            String[] lines = text.split("/n");
            y += gp.tileSize * 2; // Positioning the start of the instructions
            for (String line : lines) {
                x = getXforCenteredText(line);
                g2.drawString(line, x, y);
                y += gp.tileSize; // Move y position for next line
            }

            text = "QUIT TO MAIN MENU";
            x = getXforCenteredText(text);
            y = gp.tileSize*10;
            g2.drawString(text, x, y);
            if (commandNum == 0){
                g2.drawString("->", x-gp.tileSize,y);
            }
        } else if (titleScreenState == 2) {
            commandNum = 0;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 46));
            String text = "    CONTORL GUIDE FOR 'KOSLIFE: SIMULASI ANAK KOS'";
            int x = getXforCenteredText(text)-45;
            int y = gp.tileSize*2;
            //SHADOW
            g2.setColor(Color.GRAY);
            g2.drawString(text,x+4,y+4);
            //MAIN COLOR
            g2.setColor(Color.WHITE);
            g2.drawString(text,x,y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30));
            text = "PRESS '^' TO MOVE UP  /n PRESS '>' TO MOVE RIGHT /n PRESS '<' TO MOVE LEFT /n";
            String[] lines = text.split("/n");
            y += gp.tileSize * 2; // Positioning the start of the instructions
            for (String line : lines) {
                x = getXforCenteredText(line);
                g2.drawString(line, x, y);
                y += gp.tileSize; // Move y position for next line
            }
            text = "QUIT TO MAIN MENU";
            x = getXforCenteredText(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if (commandNum == 0){
                g2.drawString("->", x-gp.tileSize,y);
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
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 66));
        String text = "      --GAME PAUSED--";
        int x = getXforCenteredText(text)-45;
        int y = gp.tileSize*2;

        //SHADOW
        g2.setColor(Color.GRAY);
        g2.drawString(text,x+4,y+4);

        //MAIN COLOR
        g2.setColor(Color.WHITE);
        g2.drawString(text,x,y);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 42));
        text = "RESUME";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if (commandNum == 0){
            g2.drawString("->", x-gp.tileSize,y);
        }

        text = "HOW TO PLAY (CONTROL GUIDE)";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 1){
            g2.drawString("->", x-gp.tileSize,y);
        }

        text = "QUIT TO MAIN MENU";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 2){
            g2.drawString("->", x-gp.tileSize,y);
        }
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }
}

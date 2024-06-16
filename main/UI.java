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
    public int commandNumsleep = 0;
    public boolean inPauseScreen;

    //untuk sub window
    public int titleScreenState = 0;

    //turu
    public int sleepScreenState = 0;

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
        } else if (gp.gameState == gp.finishState) {
            drawFinish();
        }
    }


    public void drawFinish(){
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        if (sleepScreenState == 0){

            // TITLE NAME
            g2.setColor(new Color(0, 0, 0, 150));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            int x, y;
            String text = "Selamat! /n Kamu berhasil bertahan hidup /n sebagai 'Anak Kos' selama satu hari!";
            String[] lines = text.split("/n");

            // Set the font for the title
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 46f));

            // Draw each line
            y = gp.tileSize * 2;
            for (String line : lines) {
                // SHADOW
                g2.setColor(Color.BLACK);
                x = getXforCenteredText(line);
                g2.drawString(line, x, y);

                // MAIN COLOR
                g2.setColor(Color.WHITE);
                g2.drawString(line, x - 4, y - 4);

                // Adjust y for the next line
                y += g2.getFontMetrics().getHeight();
            }

            // MAIN CHARACTER IMAGE
            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
            y += gp.tileSize-70;
            g2.drawImage(gp.maincharacter.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            // MENU
            g2.setFont(g2.getFont().deriveFont(36f));
            text = "BACK TO MAIN MENU";
            x = getXforCenteredText(text);
            y += gp.tileSize * 4;
            g2.drawString(text, x, y);
            if (commandNumsleep == 0){
                g2.drawString("->", x - gp.tileSize, y);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y += 55;
            g2.drawString(text, x, y);
            if (commandNumsleep == 1){
                g2.drawString("->", x - gp.tileSize, y);
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

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
            text = "adalah game simulasi 2D yang mengajak pemain untuk merasakan kehidupan sehari-hari /n sebagai seorang anak kos.  Dalam game ini, pemain akan mengendalikan karakter untuk /n menjalani berbagai aktivitas mulai dari keluar kamar, makan di cafe, belajar  di kampus /n hingga tidur untuk mengakhiri hari. Dengan fitur-fitur seperti bergerak dalam empat arah, /n manajemen energi  dengan membeli makan dari hasil uang yang ditarik di ATM, dan interaksi /n dengan NPC  seperti teman dan dosen; pemain akan merasakan serunya menjalani kehidupan /n kos-kosan. Mulailah petualanganmu, nikmati kebebasan menjelajahi lingkungan sekitar,/n dan temukan keseimbangan antara kehidupan sosial dan akademis dalam \"KosLife\"!";
            String[] lines = text.split("/n");
            y += gp.tileSize; // Positioning the start of the instructions
            for (String line : lines) {
                x = getXforCenteredText(line);
                g2.drawString(line, x, y);
                y += gp.tileSize; // Move y position for next line
            }

            text = "QUIT TO MAIN MENU";
            x = getXforCenteredText(text);
            y = gp.tileSize*11;
            g2.drawString(text, x, y);
            if (commandNum == 0){
                g2.drawString("->", x-gp.tileSize,y);
            }
        } else if (titleScreenState == 2) {
            commandNum = 0;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 44));
            String text = "         CONTROL GUIDE";
            int x = getXforCenteredText(text)-45;
            int y = gp.tileSize;
            //SHADOW
            g2.setColor(Color.GRAY);
            g2.drawString(text,x+4,y+4);
            //MAIN COLOR
            g2.setColor(Color.WHITE);
            g2.drawString(text,x,y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
            text = "Tekan \" ^ \" untuk berjalan ke arah sumbu y+, " +
                    "Tekan \" v \" untuk berjalan ke arah sumbu y-, /n" +
                    "Tekan \" > \" untuk berjalan ke arah sumbu x+, " +
                    "Tekan \" < \" untuk berjalan ke arah sumbu x-, /n" +
                    "Tekan \" B \" untuk mulai belajar, " +
                    "Tekan \" S \" untuk tidur, " +
                    "Tekan \" C \" untuk /n berinteraksi dengan NPC, " +
                    "Tekan \" I \" untuk melihat informasi pemain/n" +
                    "Tekan \" T \" untuk melakukan transaksi ATM, " +
                    "Tekan \" Enter \" untuk memilih opsi menu, /n" +
                    "Tekan \" P \" untuk pause, " +
                    "Tekan \" J \" untuk melihat mata kuliah yang diajarkan /n" +
                    "Tekan tombol keyboard yang sama sebanyak 2 kali untuk memunculkan kotak dialog /n selanjutnya. " +

                    "Pemain bisa menamatkan permainan jika belajar minimal sekali/n" +
                    "Pemain hanya bisa melakukan aktivitas jika mendekat ke objek yang dituju";
            String[] lines = text.split("/n");
            y += gp.tileSize; // Positioning the start of the instructions
            for (String line : lines) {
                x = getXforCenteredText(line);
                g2.drawString(line, x, y);
                y += gp.tileSize; // Move y position for next line
            }
            text = "QUIT TO MAIN MENU";
            x = getXforCenteredText(text);
            y += gp.tileSize/4;
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

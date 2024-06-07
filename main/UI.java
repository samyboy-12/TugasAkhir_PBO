//package main;
//
//import java.awt.*;
//
//public class UI {
//    GamePanel gp;
//    Font arial_40;
//    Graphics2D g2;
//    public String currentdialogue = "";
//    public UI(GamePanel gp) {
//        this.gp = gp;
//        arial_40 = new Font("Arial", Font.PLAIN, 40);
//
//    }
//    public void draw(Graphics2D g2){
//        this.g2 = g2;
//        g2.setFont(arial_40);
//        g2.setColor(Color.white);
////        g2.drawString("bed", 50, 50);
//        if(gp.gameState == gp.sleep){
//            drawdialog();
//
//        }
//    }
//    public void drawdialog(){
//        int x = gp.mainCharacter.x * 2;
//        int y = gp.tileSize / 2;
//        int width = gp.screenWidth - (gp.tileSize * 4);
//        int height = gp.tileSize*4;
//
//        drawSubWindow(x, y, width, height);
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20));
//        x+= gp.tileSize;
//        y += gp.tileSize;
//        g2.drawString(currentdialogue, x, y);
//    }
//
//    public void drawSubWindow(int x , int y, int width, int height){
//        Color c = new Color(0,0,0,210);
//        g2.setColor(c);
//        g2.fillRoundRect(x, y, width, height, 35, 35);
//        c = new Color(255,255,255);
//        g2.setColor(c);
//        g2.setStroke(new BasicStroke(5));
//        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
//    }
//}
package main;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font pixelFont;
    public String currentDialogue = "";

    public  UI(GamePanel gp){
        this.gp = gp;
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

    public void showMessage(String text){
    }

    public  void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(pixelFont);
        g2.setColor(Color.WHITE);

         if ( gp.gameState == gp.playState) {

        }else if(gp.gameState == gp.sleepState){
             drawDialogueScreen();
        } else if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        } else if (gp.gameState == gp.infoState) {

         }else if (gp.gameState == gp.dialogueState) {
             drawDialogueScreen();
         }
    }

    public void drawDialogueScreen(){
//        System.out.println("drawDialogueScreen")    ;
        //WINDOW
        int x = gp.tileSize*2;
        int y = 0;
        int width = gp.screenWidth-(gp.tileSize*4);
        int height = gp.tileSize*3;

        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,24));
        x+=gp.tileSize-20;
        y+=gp.tileSize;

        //ini biar bisa teks nya di new line (pake /n)
        for (String line: currentDialogue.split("/n")){
            g2.drawString(line,x,y);
            y += 20;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80));
        String text ="PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text,x,y);
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2-length/2;
    }
}

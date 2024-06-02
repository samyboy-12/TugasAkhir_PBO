package main;

import java.awt.*;

public class UI {
    GamePanel gp;
    Font arial_40;
    Graphics2D g2;
    public String currentdialogue = "";
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);

    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
//        g2.drawString("bed", 50, 50);
        if(gp.gameState == gp.sleep){
            drawdialog();

        }
    }
    public void drawdialog(){
        int x = gp.mainCharacter.x * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);
        x+= gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentdialogue, x, y);
    }

    public void drawSubWindow(int x , int y, int width, int height){
        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
}

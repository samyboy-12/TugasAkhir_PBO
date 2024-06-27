package objects;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    GamePanel gp;
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public  Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public String[] interactText = new String[20];
    public int interactDialogueIndex = 0;

    public SuperObject(GamePanel gp){
        this.gp = gp;
    }

    public void interact(){};

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image,worldX,worldY,gp.tileSize, gp.tileSize, null);

    }


    public void setinteractText(){}
}

package objects;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public  Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public String[] dialogues = new String[20];
    public int dialogueIndex;


    public void speak(){};

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image,worldX,worldY,gp.tileSize, gp.tileSize, null);

    }
}

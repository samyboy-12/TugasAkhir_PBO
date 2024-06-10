package Entity;

import Entity.ManKind;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Lecturer extends ManKind {

    String[] coursesThougth;

    public Lecturer(GamePanel gp, String name, int age, int worldX, int worldY, String imgPath) {
        super(name, age, gp);
        this.solidArea = new Rectangle(0,0,48,48);
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream(imgPath));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.x = worldX;
        this.y = worldY;
    }

    @Override
    public void displayInfo() {
        this.setInfoMC("-----------------------INFO KARAKTER-----------------------/nNama : "+this.getName()+"/nUmur : "+this.getAge());
        gp.ui.currentDialogue = this.getInfoMC();
        gp.gameState = gp.dialogueState;
    }
}

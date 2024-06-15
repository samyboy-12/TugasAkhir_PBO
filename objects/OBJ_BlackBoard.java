package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_BlackBoard extends SuperObject {
    public OBJ_BlackBoard(int worldX, int worldY, GamePanel gp){
        super(gp);
        name = "BlackBoard";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/blackBoardInClassRoom.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.worldX = worldX;
        this.worldY = worldY;
        this.setinteractText();
        this.solidArea.width *= 5;
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, worldX, worldY, gp.tileSize*5, gp.tileSize, null);
    }

    public void interact(){
        gp.ui.currentDialogue = this.interactText[interactDialogueIndex];
    }

    public void setinteractText(){
        this.interactText[0] = "                   Materi Pembelajaran /n         Object Oriented Programming (OOP) Java. /n/n-Tekan huruf 'T' kembali untuk berhenti membaca papan tulis-";
    }
}

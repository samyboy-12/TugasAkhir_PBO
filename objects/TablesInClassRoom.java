package objects;

import Entity.MainCharacter;
import Entity.ManKind;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TablesInClassRoom extends SuperObject {

    public TablesInClassRoom(int worldX, int worldY, GamePanel gp){
        super(gp);
        this.name = "Table";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objects/tableInClassRoom.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.worldX = worldX;
        this.worldY = worldY;
        this.collision = true;
        this.setinteractText();
        this.solidArea.width *= 2;
    }

    public void interact(){
        if (this.interactDialogueIndex >= this.interactText.length || this.interactText[interactDialogueIndex] == null) {
            interactDialogueIndex = 0; // Reset ke awal jika null atau melewati batas
        }

// Set dialog saat ini dan increment index
        if (this.interactText[interactDialogueIndex] != null) {
            gp.ui.currentDialogue = this.interactText[interactDialogueIndex];
            interactDialogueIndex++;
        }
    }

    public void setinteractText(){
        this.interactText[0] = "/n                SAAT INI PEMAIN SEDANG BELAJAR. /n/n    ----Tekan huruf 'B' kembali untuk berhenti belajar---";
    }

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, worldX, worldY, gp.tileSize*2, gp.tileSize, null);
    }
}

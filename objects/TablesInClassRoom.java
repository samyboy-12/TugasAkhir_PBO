package objects;

import Entity.MainCharacter;
import Entity.ManKind;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class TablesInClassRoom extends SuperObject {

    public TablesInClassRoom(int worldX, int worldY, GamePanel gp){
        super(gp);
        this.name = "Table";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/object/tableInClassRoom.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.worldX = worldX;
        this.worldY = worldY;
        this.collision = true;
        this.setinteractText();
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
}

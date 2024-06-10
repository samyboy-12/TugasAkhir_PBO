package objects;

import Entity.MainCharacter;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_ATM extends SuperObject {
    public GamePanel gp;
    private int withdrawalAmount;

    public OBJ_ATM(GamePanel gp) {
        super(gp);
        name = "ATM";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectsPict/ATM.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;
        this.withdrawalAmount = 50000;

    }

    public void interact() {
        MainCharacter mainCharacter = gp.maincharacter;
        if (interactDialogueIndex == 0) {
            gp.ui.currentDialogue = "-----------------------ATM BIR-----------------------/nSALDO ANDA: "+mainCharacter.getMoneyInATM()+"/n/nAPAKAH KAMU YAKIN AKAN MENGAMBIL UANG Rp.50.000 ?/n(TEKAN HURUF 'T' KEMBALI)";
            interactDialogueIndex = 1;
        }
        else if (interactDialogueIndex == 1){
            if (mainCharacter.getMoneyInATM() >= withdrawalAmount) {
                mainCharacter.setCash(mainCharacter.getCash() + withdrawalAmount);
                mainCharacter.setMoneyInATM(mainCharacter.getMoneyInATM()-withdrawalAmount);
                gp.ui.currentDialogue = "/n/n       ANDA TELAH MENARIK UANG TUNAI SEBESAR : Rp. " + withdrawalAmount;
            } else {
                gp.ui.currentDialogue = "/n/n           UANG DI ATM ANDA TIDAK CUKUP!";
            }
            interactDialogueIndex = 0;
            System.out.println(interactDialogueIndex);
        }
    }

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}

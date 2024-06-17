package objects;

import Entity.MainCharacter;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_KASIRRESTAURANT extends SuperObject {
    public GamePanel gp;
    private int Harga;

    public OBJ_KASIRRESTAURANT(GamePanel gp) {
        super(gp);
        name = "KASIR";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/NPC/KASIR.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;
        this.Harga = 10000;

    }

    public void interact() {
        MainCharacter mainCharacter = gp.maincharacter;
        if (interactDialogueIndex == 0) {
            gp.ui.currentDialogue =  "SELAMAT DATANG DI WARMINDO, APAKAH ANDA INGIN MEMESAN?/n WARUNG INI MENJUAL INDOMIE TEKAN 'T' UNTUK MEMBELI";
            interactDialogueIndex = 1;
        }
        else if (interactDialogueIndex == 1){
            if (mainCharacter.getCash() >= Harga) {
                mainCharacter.setCash(mainCharacter.getCash() - Harga);
                mainCharacter.setEnergyBar(100);
                gp.ui.currentDialogue = "ANDA SUDAH MENGISI PERUT DAN TENAGA ANDA " ;
            } else {
                gp.ui.currentDialogue = "/n/n           UANG TIDAK CUKUP!";
            }
            interactDialogueIndex = 0;
            System.out.println(interactDialogueIndex);
        }
    }

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}

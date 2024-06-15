package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class OBJ_Bed extends SuperObject{
    public GamePanel gp;

    public OBJ_Bed(GamePanel gp) {
        super(gp);
        name= "Bed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/bed.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;
        setinteractText();

        //ngegedein ukuran solid area mengikuti gambar
        this.solidArea.width *= 2;
        this.solidArea.height *= 2;
    }


    public void setDialogue(){
        interactText[0] = "Do you want to sleep?";
        interactText[1] = "Press F to finish";
    }
    public void interact(){
        if (interactText[interactDialogueIndex] == null){
            interactDialogueIndex = 0;

        }else {
            gp.ui.currentDialogue = interactText[interactDialogueIndex];
            interactDialogueIndex++;

        }
    }

    @Override
    public void setinteractText() {
        interactText[0] = "Kamu belum bisa menyelesaikan game /nkarena belum beraktivitas layaknya anak kos.";
        interactText[1] = "Pergi beli makan dan belajarlah sekali /nuntuk menyelesaikan game ini!";
    }

    public void draw(Graphics2D g2, GamePanel gp){
        //buat ngegedein ukuran kasur
        g2.drawImage(image, worldX, worldY, gp.tileSize*2, gp.tileSize*2, null);
    }
}

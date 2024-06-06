package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import main.KeyHandler;


public class OBJ_Bed extends SuperObject{
    public GamePanel gp;

    public OBJ_Bed(GamePanel gp) {
        name= "Bed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectsPict/bed.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        setDialogue();
        this.gp = gp;
    }


    public void setDialogue(){
        dialogues[0] = "Do you want to sleep?";
        dialogues[1] = "Press F to finish";
    }
    public void speak(){
        if (dialogues[dialogueIndex] == null){
//            System.out.println(gp.gameState);
//            System.out.println("hi");
            dialogueIndex = 0;

        }else {
//            System.out.println(gp.gameState);
//            System.out.println("hi1");
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;

        }

//        gp.ui.currentdialogue = dialogues[0];
    }
}

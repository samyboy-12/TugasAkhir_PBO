package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Bed extends SuperObject{
    public OBJ_Bed() {
        name= "Bed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectsPict/bed.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        setDialogue();
    }
    GamePanel gp;
    public void setDialogue(){
        dialogues[0] = "hello";
    }
    public void speak(){
        gp.ui.currentdialogue = dialogues[0];
    }
}

package Entity;

import main.GamePanel;

import java.awt.*;

public class Bed {
    GamePanel gp;
    public String[] dialogues = new String[20];
    public Bed(){
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0] = "hello";
    }
    public void speak(){
        gp.ui.currentdialogue = dialogues[0];
    }
}

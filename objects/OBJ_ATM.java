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
        setDialogue();
        this.gp = gp;
    }

    public void setDialogue() {
        interactText[0] = "Berikut uang kamu!";
        interactText[1] = "ingin ambil berapa";
    }

    public void interact() {
        if (interactText[interactDialogueIndex] == null) {
            interactDialogueIndex = 0;
        } else {
            gp.ui.currentDialogue = interactText[interactDialogueIndex];
            interactDialogueIndex++;
        }

        if (interactDialogueIndex == 2) {
            // Logic to set withdrawalAmount, could be from user input
            withdrawalAmount = 5000; // Example fixed withdrawal amount
            MainCharacter mainCharacter = gp.mainCharacter; // Assuming gp.player is the main character
            if (mainCharacter.getMoney() >= withdrawalAmount) {
                mainCharacter.setMoney(mainCharacter.getMoney() - withdrawalAmount);
                gp.ui.currentDialogue = "You have withdrawn " + withdrawalAmount + " money.";
            } else {
                gp.ui.currentDialogue = "You don't have enough money.";
            }
            interactDialogueIndex = 0; // Reset the dialogue index
        }
    }

    @Override
    public void setinteractText() {
        interactText[0] = "Berikut uang kamu";
        interactText[1] = "ingin ambil berapa";
    }

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}

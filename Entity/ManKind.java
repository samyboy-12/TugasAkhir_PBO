package Entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ManKind {
    public int x,y;
    public int speed;
    public BufferedImage up1,up2, down1, down2, left1,left2, right1, right2;  // to store our image file
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea; //make abstract rect
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    private String name;
    private int age, money;
    public GamePanel gp;
    public String[] dialogues = new String[20];
    public int dialogueIndex;


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManKind(String name, int age, GamePanel gp) {
        this.name = name;
        this.age = age;
        this.gp = gp;
    }

    public abstract void displayInfo();

    public void communicate(){
        // Cek apakah dialog saat ini null atau jika indeks berada di luar batas array
        if (dialogueIndex >= dialogues.length || dialogues[dialogueIndex] == null) {
            dialogueIndex = 0; // Reset ke awal jika null atau melewati batas
        }

// Set dialog saat ini dan increment index
        if (dialogues[dialogueIndex] != null) {
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;
        }
    };



    public void draw(Graphics2D g2, GamePanel gp){
        //gambarin npc
        g2.drawImage(up1, x, y, gp.tileSize, gp.tileSize, null);
    }
}

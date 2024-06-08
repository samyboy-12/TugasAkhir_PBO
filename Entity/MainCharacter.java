package Entity;

import interfaces.iMovable;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainCharacter extends ManKind implements iMovable {

    KeyHandler keyH;
    private int money;
    private int energyBar;
    public boolean sudahMengeluh = false;
    private boolean eligibleToStudy = true;
    public String[] dialoguesMengeluh = new String[5];
    public int dialoguesMengeluhIndex;
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(int energyBar) {
        this.energyBar = energyBar;
    }
    public boolean isEligibleToStudy() {
        return eligibleToStudy;
    }

    public void setEligibleToStudy(boolean eligibleToStudy) {
        this.eligibleToStudy = eligibleToStudy;
    }

    public MainCharacter(GamePanel gp, KeyHandler keyH, String name, int age, int money, int energyBar) {
        super(name, age, gp);
        this.money = money;
        this.energyBar = energyBar;
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y=16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
        setDialogue();
        this.setMengeluh();
        this.energyBar = 100;
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_right_2.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        //hanya jika di press keybordnya, maka akan gerak karakternya
        if(keyH.upPressed== true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed==true){
            if(keyH.upPressed== true){
                direction ="up";
            } else if (keyH.downPressed == true) {
                direction = "down";

            }
            else if(keyH.leftPressed== true){
                direction = "left";

            }
            else if(keyH.rightPressed == true){
                direction = "right";

            }
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            int objIndex = gp.cChecker.checkObject(this,true);

//            check if collison false, can go
            if(collisionOn == false){
                switch (direction){
                    case "up":
                        y-=speed;
                        break;
                        case "down":
                           y+=speed;
                            break;
                            case "left":
                                x-=speed;
                                break;
                                case "right":
                                    x+=speed;
                                    break;
                }
            }
            // setiap hit 15 frames, the gambar will be change so it look like walking
            spriteCounter++ ;
            if(spriteCounter>15){
//                System.out.println("spirite coun : " + spriteCounter);
//                System.out.println(spriteNum == 2);
                if(spriteNum == 1){
                    spriteNum = 2;
//                    System.out.println("spirit num now : " + spriteNum);
                } else if (spriteNum ==2) {
                    spriteNum = 1;
//                    System.out.println("spirit num now : " + spriteNum);
                } spriteCounter = 0;
            }
        }
    }

    public void sleep(){
        int objIndex = gp.cChecker.checkObject(this,true);
        if(objIndex != 999){
//            gp.obj[i] = null;
//            System.out.println(gp.obj[objIndex]);
            gp.gameState = gp.sleepState;
            System.out.println(gp.gameState + "ini");

            gp.obj[objIndex].interact();

//            Bed bed = new Bed();
//            bed.speak();
//            System.out.println("hi");
        }
    }

    public void interactObject(){
        int objIndex = gp.cChecker.checkObject(this,true);
        if (objIndex != 999 && gp.obj[objIndex].name != "Table"){
            gp.obj[objIndex].interact();
            gp.gameState = gp.dialogueState;
        }
    }

    @Override
    public void communicate() {
        int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
        if (npcIndex != 999){
            gp.npc[npcIndex].communicate();
            gp.gameState = gp.dialogueState;
        }
    }

    public void study() {
        int objIndex = gp.cChecker.checkObject(this,true);
        if (this.energyBar-33>=0 && objIndex != 999){
            this.energyBar-=33;
            gp.obj[objIndex].interact();
            gp.gameState = gp.studyState;
        }else{
            if(objIndex != 999){
                gp.ui.currentDialogue ="   Saat ini anda tidak bisa belajar karena anda kecapean. /n/n      Istirahatlah sebentar dengan membeli makan!";
                gp.gameState = gp.dialogueState;
                this.eligibleToStudy = false;
            }
        }
    }

    public void mengeluh(){
        this.sudahMengeluh = true;
        if (dialoguesMengeluhIndex >= dialoguesMengeluh.length || dialoguesMengeluh[dialoguesMengeluhIndex] == null) {
            dialoguesMengeluhIndex = 0; // Reset ke awal jika null atau melewati batas
        }

        // Set dialog saat ini dan increment index
        if (dialoguesMengeluh[dialoguesMengeluhIndex] != null) {
            gp.ui.currentDialogue = dialoguesMengeluh[dialoguesMengeluhIndex];
            gp.gameState = gp.dialogueState;
            dialoguesMengeluhIndex++;
        }
    }

    public void setMengeluh(){
        dialoguesMengeluh[0] = "Pemain: /nKayaknya aku butuh me time dulu deh habis belajar ini /n/n       ---Tekan huruf 'B' untuk berhenti mengeluh---";
        dialoguesMengeluh[1] = "Pemain: /nHaduhhh, cape banget belajar. Padahal baru 2 SKS. /n/n      ---Tekan huruf 'B' untuk berhenti mengeluh---";
        dialoguesMengeluh[2] = "Pemain: /nCape banget belajar, pengen ternak lele aja. /n/n       ---Tekan huruf 'B' untuk berhenti mengeluh---";
    }

    public String[] dialogues = new String[20];
    public int dialogueIndex;

    public void displayInfo(){}


    public void setDialogue(){
        dialogues[0] = "Do you want to sleep?";
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





    public void draw(Graphics2D g2){
//        g2.setColor(Color.orange); // draw a orange rectangle
//        g2.fillRect(100,100,tileSize,tileSize);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(spriteNum== 1){
                    image = up1;
                }if(spriteNum == 2){
                image =up2;
            }
                break;
            case "down":
//                System.out.println(spriteNum);
                if(spriteNum== 1){
                    image = down1;
                }if(spriteNum== 2){
                image = down2;
            }
                break;
            case "left":
                if(spriteNum== 1){
                    image = left1;
                }if(spriteNum== 2){
                image = left2;
            }
                break;
            case "right":
                if(spriteNum== 1){
                    image = right1;
                }if(spriteNum== 2){
                image = right2;
            }
                break;
        }
        g2.drawImage(image,x,y, gp.tileSize, gp.tileSize, null);
    }


}

package Entity;

import interfaces.iMovable;
import main.GamePanel;
import main.KeyHandler;
import objects.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainCharacter extends ManKind implements iMovable {

    KeyHandler keyH;
    private int cash;
    private int moneyInATM;
    private int energyBar;
    public boolean sudahMengeluh = false;
    private boolean eligibleToStudy = true;
    public String[] dialoguesMengeluh = new String[5];
    public int dialoguesMengeluhIndex;

    public int getMoneyInATM() {
        return moneyInATM;
    }

    public void setMoneyInATM(int moneyInATM) {
        this.moneyInATM = moneyInATM;
    }
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
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
        this.cash = money;
        this.energyBar = energyBar;
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
        setDialogue();
        this.setMengeluh();
        this.energyBar = 100;
        this.moneyInATM = 10000000;
    }

    public void setDefaultValues() {
        x = 300;
        y = 300;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }
            collisionOn = false;
            gp.cChecker.checkTile(this);
            gp.cChecker.checkEntity(this, gp.npc);

            int objIndex = gp.cChecker.checkObject(this, true);

            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void sleep() {
        int objIndex = gp.cChecker.checkObject(this, true);
        if (objIndex != 999) {
            gp.gameState = gp.sleepState;
            gp.obj[objIndex].interact();
        }
    }

    public void interactObject() {
        int objIndex = gp.cChecker.checkObject(this, true);
        if (objIndex != 999 && gp.obj[objIndex].name != "Table") {
            gp.obj[objIndex].interact();
            gp.gameState = gp.dialogueState;
        }
    }


    //Overloading method transaction
    public void transaction(SuperObject atm){
        atm.interact();
        gp.gameState = gp.dialogueState;
    }

    public void transaction(ManKind penjual){
        penjual.communicate();
        gp.gameState = gp.dialogueState;

    }

    @Override
    public void communicate() {
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        if (npcIndex != 999) {
            gp.npc[npcIndex].communicate();
            gp.gameState = gp.dialogueState;
        }
    }

    public void finish() {
        gp.ui.gameFinished = true;
    }

    public void study() {
        int objIndex = gp.cChecker.checkObject(this, true);
        if (this.energyBar - 33 >= 0 && objIndex != 999) {
            this.energyBar -= 33;
            gp.obj[objIndex].interact();
            gp.gameState = gp.studyState;
        } else {
            if (objIndex != 999) {
                gp.ui.currentDialogue = "   Saat ini anda tidak bisa belajar karena anda kecapean. /n/n      Istirahatlah sebentar dengan membeli makan!";
                gp.gameState = gp.dialogueState;
                this.eligibleToStudy = false;
            }
        }
    }

    public void mengeluh() {
        this.sudahMengeluh = true;
        if (dialoguesMengeluhIndex >= dialoguesMengeluh.length || dialoguesMengeluh[dialoguesMengeluhIndex] == null) {
            dialoguesMengeluhIndex = 0;
        }
        if (dialoguesMengeluh[dialoguesMengeluhIndex] != null) {
            gp.ui.currentDialogue = dialoguesMengeluh[dialoguesMengeluhIndex];
            gp.gameState = gp.dialogueState;
            dialoguesMengeluhIndex++;
        }
    }

    public void setMengeluh() {
        dialoguesMengeluh[0] = "Pemain: /nKayaknya aku butuh me time dulu deh habis belajar ini /n/n       ---Tekan huruf 'B' untuk berhenti mengeluh---";
        dialoguesMengeluh[1] = "Pemain: /nHaduhhh, cape banget belajar. Padahal baru 2 SKS. /n/n      ---Tekan huruf 'B' untuk berhenti mengeluh---";
        dialoguesMengeluh[2] = "Pemain: /nCape banget belajar, pengen ternak lele aja. /n/n       ---Tekan huruf 'B' untuk berhenti mengeluh---";
    }

    public String[] dialogues = new String[20];
    public int dialogueIndex;

    public void displayInfo() {
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        if (npcIndex != 999) {
            gp.npc[npcIndex].displayInfo();
            gp.gameState = gp.dialogueState;
        } else if (npcIndex == 999) {
            this.setInfoMC("-----------------------INFO KARAKTER-----------------------/nNama : "+this.getName()+"/nUmur : "+this.getAge()+"/nUang Tunai : "+this.getCash()+"/nUang di ATM : "+this.getMoneyInATM()+" /nEnergi : "+this.getEnergyBar());
            gp.ui.currentDialogue = this.getInfoMC();
            gp.gameState = gp.dialogueState;
        }
    }

    public void setDialogue() {
        dialogues[0] = "Do you want to sleep?";
    }

    public void speak() {
        if (dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        } else {
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

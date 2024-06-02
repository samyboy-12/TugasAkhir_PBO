package Entity;

import interfaces.iMovable;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class MainCharacter extends ManKind implements iMovable {
    GamePanel gp;
    KeyHandler keyH;

    public MainCharacter(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
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
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_1.png"));
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

            //check object collision
            int objIndex = gp.cChecker.checkObject(this,true);
            sleep(objIndex);

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
            if(spriteCounter>10){
//                System.out.println("spirite coun : " + spriteCounter);
//                System.out.println(spriteNum == 2);
                if(spriteNum == 1){
                    spriteNum = 2;
                    System.out.println("spirit num now : " + spriteNum);
                } else if (spriteNum ==2) {
                    spriteNum = 1;
                    System.out.println("spirit num now : " + spriteNum);
                } spriteCounter = 0;
            }
        }
    }

    public void sleep(int i){
        if(i != 999){
//            gp.obj[i] = null;
            gp.gameState = gp.sleep;
            gp.obj[i].speak();
//            Bed bed = new Bed();
//            bed.speak();
//            System.out.println("hi");
        }
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

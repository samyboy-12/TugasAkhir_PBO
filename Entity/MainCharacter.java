package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class MainCharacter extends  ManKind{
    GamePanel gp;
    KeyHandler keyH;

    public MainCharacter(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y=16;
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
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum ==2) {
                    spriteNum = 1;
                } spriteNum = 0;
            }
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

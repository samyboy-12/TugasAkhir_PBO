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
        setSolidArea(new Rectangle(8,16,32,32));
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        setX(100);
        setY(100);
        setSpeed(4);
        setDirection("down");
    }
    public void getPlayerImage(){
        try{
            setUp1(ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_1.png")));
            setUp2( ImageIO.read(getClass().getResourceAsStream("/assets/boy_up_1.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/assets/boy_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/assets/boy_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/assets/boy_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/assets/boy_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/assets/boy_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/assets/boy_right_2.png")));


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        //hanya jika di press keybordnya, maka akan gerak karakternya
        if(keyH.isUpPressed()== true || keyH.isDownPressed() == true || keyH.isLeftPressed() == true || keyH.isRightPressed()==true){
            if(keyH.isUpPressed()== true){
                setDirection("up");
            } else if (keyH.isDownPressed() == true) {
                setDirection("down");

            }
            else if(keyH.isLeftPressed()== true){
                setDirection("left");

            }
            else if(keyH.isRightPressed() == true){
                setDirection("right");

            }
            //CHECK TILE COLLISION
            setCollisionOn(false);
            gp.cChecker.checkTile(this);

            if(isCollisionOn() == false){
                switch (getDirection()){
                    case "up":
                        setY(getY() - getSpeed());
                        break;
                        case "down":
                            setY(getY() + getSpeed());
                            break;
                            case "left":
                                setX(getX() - getSpeed());
                                break;
                                case "right":
                                    setX(getX() + getSpeed());
                                    break;
                }
            }
            // setiap hit 15 frames, the gambar will be change so it look like walking
            setSpriteCounter(getSpriteCounter() + 1);
            if(getSpriteCounter()>10){
                if(getSpriteNum() == 1){
                    setSpriteNum(2);
                } else if (getSpriteNum() ==2) {
                    setSpriteNum(1);
                } setSpriteNum(0);
            }
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.orange); // draw a orange rectangle
//        g2.fillRect(100,100,tileSize,tileSize);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch (getDirection()){
            case "up":
                if(getSpriteNum() == 1){
                    image = getUp1();
                }if(getSpriteNum()== 2){
                image = getUp2();
            }
                break;
            case "down":
                if(getSpriteNum() == 1){
                    image = getDown1();
                }if(getSpriteNum() == 2){
                image = getDown2();
            }
                break;
            case "left":
                if(getSpriteNum() == 1){
                    image = getLeft1();
                }if(getSpriteNum() == 2){
                image = getLeft2();
            }
                break;
            case "right":
                if(getSpriteNum() == 1){
                    image = getRight1();
                }if(getSpriteNum() == 2){
                image = getRight2();
            }
                break;
        }
        g2.drawImage(image,getX(),getY(), gp.tileSize, gp.tileSize, null);
    }
}

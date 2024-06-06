package main;

import Entity.MainCharacter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    GamePanel gp ;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
//    public KeyHandler(GamePanel gp){
//        this.gp = gp;
//    }
//    public boolean isUpPressed() {
//        return upPressed;
//    }
//
//    public void setUpPressed(boolean upPressed) {
//        this.upPressed = upPressed;
//    }
//
//    public boolean isDownPressed() {
//        return downPressed;
//    }
//
//    public void setDownPressed(boolean downPressed) {
//        this.downPressed = downPressed;
//    }
//
//    public boolean isLeftPressed() {
//        return leftPressed;
//    }
//
//    public void setLeftPressed(boolean leftPressed) {
//        this.leftPressed = leftPressed;
//    }
//
//    public boolean isRightPressed() {
//        return rightPressed;
//    }
//
//    public void setRightPressed(boolean rightPressed) {
//        this.rightPressed = rightPressed;
//    }



        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            if (gp.gameState == gp.playState) {
                if (code == KeyEvent.VK_UP) {
                    upPressed = true;
                }
                if (code == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
                if (code == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                if (code == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
                if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.pauseState;
                }
                if (code == KeyEvent.VK_S) {
                    gp.mainCharacter.sleep();
                }
                if (code == KeyEvent.VK_I) {
                    gp.mainCharacter.displayInfo();
                }
            } else if (gp.gameState == gp.pauseState) {
                if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.playState;
                }
            } else if (gp.gameState == gp.sleep) {
                if (code == KeyEvent.VK_S) {
                    gp.gameState = gp.playState;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_UP){
                upPressed = false;
            }
            if (code == KeyEvent.VK_DOWN){
                downPressed = false;
            }
            if (code == KeyEvent.VK_LEFT){
                leftPressed = false;
            }
            if (code == KeyEvent.VK_RIGHT){
                rightPressed = false;
            }
        }
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int code = e.getKeyCode();
//        if(gp.gameState == gp.playState){
//            if (code == KeyEvent.VK_UP){
//                upPressed = true;
//            }
//            if (code == KeyEvent.VK_DOWN){
//                downPressed = true;
//            }
//            if (code == KeyEvent.VK_LEFT){
//                leftPressed = true;
//            }
//            if (code == KeyEvent.VK_RIGHT) {
//                rightPressed = true;
//            }
//            if (code == KeyEvent.VK_S){
//                System.out.println();
//                gp.mainCharacter.sleep();
//
//            }if(code == KeyEvent.VK_P){
//                gp.gameState = gp.pauseState;
//            }
//        }
//
//        else if (code == KeyEvent.VK_P && gp.gameState == gp.pauseState) {
//            System.out.println("p dan pause");
//            gp.gameState = gp.playState;
//            System.out.println(gp.gameState);
//        }
//        else if (code == KeyEvent.VK_S && gp.gameState == gp.sleep) {
//            gp.mainCharacter.sleep();
//            System.out.println("s dan sleep1");
//            gp.gameState = gp.playState;
//        }
//
//
////        else if (gp.gameState == gp.pauseState) {
////            System.out.println("pause");
////            if (code == KeyEvent.VK_P) {
////            }
////        }
////        } else if (gp.gameState == gp.sleep) {
////            System.out.println("sleep");
////            if (code == KeyEvent.VK_S) {
////                gp.gameState = gp.playState;
////            }
////        }
//
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        int code = e.getKeyCode();
//        if (code == KeyEvent.VK_UP){
//            upPressed = false;
//        }
//        if (code == KeyEvent.VK_DOWN){
//            downPressed = false;
//        }
//        if (code == KeyEvent.VK_LEFT){
//            leftPressed = false;
//        }
//        if (code == KeyEvent.VK_RIGHT){
//            rightPressed = false;
//        }
//
//    }
//}

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    GamePanel gp ;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
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
                if (code == KeyEvent.VK_B) {
                    gp.mainCharacter.study();
                }
                if (code == KeyEvent.VK_C) {
                    gp.mainCharacter.communicate();
                }
                if (code == KeyEvent.VK_T) {
                    gp.mainCharacter.interactObject();
                }
            } else if (gp.gameState == gp.pauseState) {
                if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.playState;
                }
            } else if (gp.gameState == gp.sleepState) {
                if (code == KeyEvent.VK_S) {
                    gp.gameState = gp.playState;
                }
            } else if (gp.gameState == gp.dialogueState) {
                if (code == KeyEvent.VK_B) {
                    if (gp.mainCharacter.sudahMengeluh){
                        gp.gameState = gp.playState;
                        gp.mainCharacter.sudahMengeluh = false;
                    }else if(gp.mainCharacter.isEligibleToStudy()){
                        gp.mainCharacter.dialogueIndex++;
                        gp.mainCharacter.mengeluh();
                    }else{
                        gp.gameState = gp.playState;
                    }
                }
                if (code == KeyEvent.VK_T) {
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
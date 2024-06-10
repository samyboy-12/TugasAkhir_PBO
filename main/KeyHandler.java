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
                    gp.maincharacter.sleep();
                }
                if (code == KeyEvent.VK_I) {
                    gp.maincharacter.displayInfo();
                }
                if (code == KeyEvent.VK_B) {
                    gp.maincharacter.study();
                }
                if (code == KeyEvent.VK_C) {
                    gp.maincharacter.communicate();
                }
                if (code == KeyEvent.VK_J) {
                    gp.maincharacter.interactObject();
                }
                if (code == KeyEvent.VK_I) {
                    gp.maincharacter.displayInfo();
                }
                if (code == KeyEvent.VK_T) {
                    int objIndex = gp.cChecker.checkObject(gp.maincharacter, true);
                    int npcIndex = gp.cChecker.checkEntity(gp.maincharacter, gp.npc);
                    if (objIndex != 999){
                        gp.maincharacter.transaction(gp.obj[objIndex]);
                    }else if (npcIndex != 999) {
                        gp.maincharacter.transaction(gp.npc[npcIndex]);
                    }else{

                    }
                }

            } else if (gp.gameState == gp.pauseState) {
                if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.playState;
                }
            } else if (gp.gameState == gp.sleepState) {
                if (code == KeyEvent.VK_S) {
                    gp.gameState = gp.playState;
                }
                if (code == KeyEvent.VK_F) {
                    gp.maincharacter.finish();
                }
            } else if (gp.gameState == gp.dialogueState) {
                if (code == KeyEvent.VK_B) {
                    if (gp.maincharacter.sudahMengeluh){
                        gp.gameState = gp.playState;
                        gp.maincharacter.sudahMengeluh = false;
                    }else if(gp.maincharacter.isEligibleToStudy()){
                        gp.maincharacter.dialogueIndex++;
                        gp.maincharacter.mengeluh();
                    }else{
                        gp.gameState = gp.playState;
                    }
                }
                if (code == KeyEvent.VK_J) {
                    gp.gameState = gp.playState;
                }
                if (code == KeyEvent.VK_C) {
                    gp.gameState = gp.playState;
                }
                if (code == KeyEvent.VK_I) {
                    gp.gameState = gp.playState;
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
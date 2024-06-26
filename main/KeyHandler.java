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

            //title state
            if (gp.gameState == gp.titleState){
                if (gp.ui.titleScreenState == 0){
                    if (code == KeyEvent.VK_UP) {
                        gp.ui.commandNum--;
                        if (gp.ui.commandNum < 0){
                            gp.ui.commandNum = 3;
                        }
                    }
                    if (code == KeyEvent.VK_DOWN) {
                        gp.ui.commandNum++;
                        if (gp.ui.commandNum > 3){
                            gp.ui.commandNum = 0;
                        }
                    }
                    if(code ==  KeyEvent.VK_ENTER){
                        if (gp.ui.commandNum == 0){
                            gp.gameState = gp.playState;
                        }
                        if (gp.ui.commandNum == 1){
                            gp.ui.titleScreenState = 1;
                            //panggil draw method yg berisi informasi cerita dari game
                        }
                        if (gp.ui.commandNum == 2){
                            gp.ui.titleScreenState = 2;
                            //panggil draw method yg berisi informasi how to play game
                        }
                        if(gp.ui.commandNum == 3){
                            System.exit(0);
                        }
                    }
                }if (gp.ui.titleScreenState == 1){
                    if(code ==  KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 0) {
                            gp.ui.titleScreenState = 0;
                        }
                    }
                }if (gp.ui.titleScreenState == 2){
                    if(code ==  KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 0 && !gp.ui.inPauseScreen) {
                            gp.ui.titleScreenState = 0;
                        }else if (gp.ui.commandNum == 0 && gp.ui.inPauseScreen){
                            gp.ui.inPauseScreen = false;
                            gp.gameState = gp.pauseState;
                        }
                    }
                }
            }

            //play state
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
                    gp.ui.inPauseScreen = true;
                    gp.gameState = gp.pauseState;
                }
                if (code == KeyEvent.VK_S) {
                    int objIndex = gp.cChecker.checkObject(gp.maincharacter, true);
                    if (gp.obj[objIndex].name == "Bed"){
                        gp.maincharacter.sleep();
                    }
                }
                if (code == KeyEvent.VK_I) {
                    gp.maincharacter.displayInfo();
                }
                if (code == KeyEvent.VK_B) {
                    int objIndex = gp.cChecker.checkObject(gp.maincharacter, true);
                    if (objIndex != 999 && gp.obj[objIndex].name == "Table"){
                        gp.maincharacter.study();
                    }
                }
                if (code == KeyEvent.VK_C) {
                    int npcIndex = gp.cChecker.checkEntity(gp.maincharacter, gp.npc);
                    int objIndex = gp.cChecker.checkObject(gp.maincharacter, true);
                    if (npcIndex != 999 && objIndex != 999 &&  gp.npc[npcIndex].getName() != "Mba Ayu" && gp.obj[objIndex].name != "ATM") {
                        gp.maincharacter.communicate();
                    }
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
                    if (objIndex != 999 && gp.obj[objIndex].name == "ATM" ){
                        gp.maincharacter.transaction(gp.obj[objIndex]);
                    }else if (npcIndex != 999 && gp.npc[npcIndex].getName() == "Mba Ayu") {
                        gp.maincharacter.transaction(gp.npc[npcIndex]);
                    }else{

                    }
                }

            } else if (gp.gameState == gp.pauseState) {
                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
                }
                if(code ==  KeyEvent.VK_ENTER){
                    if (gp.ui.commandNum == 0){
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 1){
                        gp.gameState = gp.titleState;
                        gp.ui.titleScreenState = 2;
                        //panggil draw method yg berisi informasi how to play game
                    }
                    if(gp.ui.commandNum == 2){
                        gp.ui.titleScreenState = 0;
                        gp.gameState = gp.titleState;
                    }
                }
            } else if (gp.gameState == gp.sleepState) {
                if (code == KeyEvent.VK_S) {
                    gp.gameState = gp.playState;
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


            if (gp.gameState == gp.finishState ) {
                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNumsleep--;
                    if (gp.ui.commandNumsleep < 0){
                        gp.ui.commandNumsleep= 1;
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNumsleep++;
                    if (gp.ui.commandNumsleep > 1){
                        gp.ui.commandNumsleep = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNumsleep == 0) {
                        gp.gameState = gp.titleState;
                    } if(gp.ui.commandNumsleep == 1){
                        System.exit(0);
                    }
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
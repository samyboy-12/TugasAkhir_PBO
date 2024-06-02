package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // let window close properly when user click exit
        window.setResizable(false); // cannot resize the window
        window.setTitle("SIMULATION"); //GAME TITLE
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); //this window must be sized to fit the preferred size and laoyut of gamepanel

        window.setLocationRelativeTo(null); // window will be display on the center if the screen
        window.setVisible(true);//we can see the window
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }



}
package main;

import Entity.MainCharacter;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

//game panel works like a game screen
//to run thread must implement runnable interface
public class GamePanel extends JPanel implements Runnable{
    private JLabel backgroundLabel;
    // decide screen settings
    public final int originalTileSize = 16; //default 16 x 16 tiles that for npc
    //bc 16 x 16 npc is small we will scale it
    private final int scale = 3;
    //ukuran tiap kotak
    public final int tileSize = originalTileSize * scale; // actual tile size that will display on the screen

    //size our game screen for descide tahe window container that contain the tile
    //banyaknya kotak per row dan kolom
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    // besar screen
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;

    TileManager tileM  = new TileManager(this);

    main.KeyHandler keyH = new main.KeyHandler();
    Thread gameThread; //can stop and run  the game, when u want to loop the proceess again and again for ex liek u loop the character 60 times per sec for make them look like moving
    public CollisionChecker cChecker = new CollisionChecker(this);
    MainCharacter mainCharacter = new MainCharacter(this, keyH);


    //constructor
    public  GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //recognize key input
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);//passing game pannel class to this constructor . to initiate the thread
        gameThread.start(); //call the run method
    }
    @Override
    public void run() { //make a loop
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if(delta>=1){ //saat delta mencapai 1 detik
                //update an information such as current character position
                update();
                // draw a character based on the current position
                repaint(); //call paintComponent method
                delta--;//hapus ulang delta jadi 0
            }

        }
    }
    public void update(){ //change palyer position
        mainCharacter.update();

    }
    public void paintComponent(Graphics g){ //graphic class is a class that has many object
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; //convert g to g2 . Grpahics2d is a class that extend Graphics class
        tileM.draw(g2);
        mainCharacter.draw(g2);
        g2.dispose();

    }
}

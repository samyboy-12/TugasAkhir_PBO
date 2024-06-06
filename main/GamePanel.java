package main;

import Entity.MainCharacter;
import objects.OBJ_Bed;
import objects.SuperObject;
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

    main.KeyHandler keyH = new main.KeyHandler(this);
    Thread gameThread; //can stop and run  the game, when u want to loop the proceess again and again for ex liek u loop the character 60 times per sec for make them look like moving
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public  UI ui = new UI(this);
    public MainCharacter mainCharacter = new MainCharacter(this, keyH, "Budi",10, 500000, 10);
    public SuperObject obj[]=new SuperObject[10];


    //game state
    public int gameState;
    public final int sleep = 1;
    public final int pauseState = 2;
    public final int playState = 3;
    public final int infoState = 4;


    //constructor
    public  GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //recognize key input
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
//        gameState = sleep;
    }

    public void startGameThread(){
        gameThread = new Thread(this);//passing game pannel class to this constructor . to initiate the thread
        gameThread.start(); //call the run method
        gameState = playState;
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
        if(gameState == playState){
            mainCharacter.update();
        }else if (gameState == pauseState) {
        }

    }
    public void paintComponent(Graphics g){ //graphic class is a class that has many object
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; //convert g to g2 . Grpahics2d is a class that extend Graphics class
        tileM.draw(g2);
        for(int i = 0; i<obj.length; i++){
            if(obj[i]!=null){
                obj[i].draw(g2,this);
            }
        }
        mainCharacter.draw(g2);
        //ui
        ui.draw(g2);

        g2.dispose();

    }
}

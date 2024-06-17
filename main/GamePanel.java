package main;

import Entity.MainCharacter;
import Entity.ManKind;
import objects.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

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
    public MainCharacter maincharacter = new MainCharacter(this, keyH, "Budi",10, 0, 10);
    public SuperObject obj[]=new SuperObject[100];
    public ManKind[] npc = new ManKind[10];



    //game state
    public int gameState;
    public final int titleState = 0;
    public final int sleepState = 1;
    public final int pauseState = 2;
    public final int playState = 3;
    public final int infoState = 4;
    public final int dialogueState = 5;
    public final int transitionState = 6; // State for transition
    public final int studyState = 7; // State for transition
    public final int finishState = 8;


    //font
    Font pixelFont;

    // Transition
    private int transitionCounter = 0;
    private final int transitionDuration = 60; // Duration of transition in frames (1 second)



    //constructor
    public  GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //recognize key input
        this.setFocusable(true);

        //membuat font dari file
        InputStream is = getClass().getResourceAsStream("/font/pixelFont.ttf");
        if (is == null) {
            throw new RuntimeException("Font file not found!");
        }
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException("Font format is incorrect", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred while reading the font file", e);
        }
    }

    public void setUpGame() {
        if (tileM.currentMap == 1) {
            aSetter.setObject();
            aSetter.setNPC();
        } else {
            // Set objects and NPCs for other maps
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);//passing game pannel class to this constructor . to initiate the thread
        gameThread.start(); //call the run method
        gameState = titleState;
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
    public void update() {
        if (gameState == playState) {
            maincharacter.update();
            checkMapTransition();
        } else if (gameState == pauseState) {
            // Handle pause state
        } else if (gameState == transitionState) {
            transitionCounter++;
            if (transitionCounter >= transitionDuration) {
                gameState = playState;
                transitionCounter = 0;
            }
        } else if (gameState == studyState) {
            transitionCounter++;
            if (transitionCounter >= transitionDuration*5) {
                if (maincharacter.sudahMengeluh){
                    gameState = playState;
                    maincharacter.sudahMengeluh = false;
                }else if(maincharacter.isEligibleToStudy()){
                    maincharacter.mengeluh();
                }else{
                    gameState = playState;
                }
                transitionCounter = 0;
            }
        }
    }

    //Fungsi untuk berpindah map
    public void checkMapTransition() {

        //ini kondisi untuk pindah dari kamar ke map Jalan raya
        if (maincharacter.x / tileSize >= 14 && maincharacter.y / tileSize >= 10 && tileM.currentMap == 1) {
            startTransition();
            tileM.loadMap("/maps/mapJalan.txt");
            tileM.currentMap = 2;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 1*tileSize; //ini berarti baris ke 5
            maincharacter.y = 5*tileSize; //ini berarti kolom ke 5

            //dari kelas ke lobby
        } else if (maincharacter.x / tileSize >= 12 && maincharacter.y / tileSize < 1 && tileM.currentMap == 4) {
            startTransition();
            tileM.loadMap("/maps/mapLobbyUniv.txt");
            tileM.currentMap = 3;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 13*tileSize; //ini berarti baris ke 5
            maincharacter.y = 1*tileSize; //ini berarti kolom ke 5
        }

        //dari map Jalan raya ke kamar lagi
        else if (maincharacter.x / tileSize <= 0 && maincharacter.y / tileSize <=4 && tileM.currentMap == 2) {
            startTransition();
            tileM.loadMap("/maps/mapKamar.txt");
            tileM.currentMap = 1;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 13 * tileSize; //ini berarti baris ke 5
            maincharacter.y = 10 * tileSize; //ini berarti kolom ke 5
        }

        //dari jalan ke lobby univ
        else if (maincharacter.x / tileSize >= 15 && maincharacter.y / tileSize >= 4 && tileM.currentMap == 2) {
            startTransition();
            tileM.loadMap("/maps/mapLobbyUniv.txt");
            tileM.currentMap = 3;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 2 * tileSize; //ini berarti baris ke 5
            maincharacter.y = 9 * tileSize; //ini berarti kolom ke 5
        }

        //dari lobby ke kelas
        else if (maincharacter.x / tileSize >= 15 && maincharacter.y / tileSize >= 0 && tileM.currentMap == 3) {
            startTransition();
            tileM.loadMap("/maps/mapKelas.txt");
            tileM.currentMap = 4;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 14 * tileSize; //ini berarti baris ke 5
            maincharacter.y = 1 * tileSize; //ini berarti kolom ke 5
        }

        //dari lobby ke jalan
        else if (maincharacter.x / tileSize <= 1 && maincharacter.y / tileSize >= 9 && tileM.currentMap == 3) {
            startTransition();
            tileM.loadMap("/maps/mapJalan.txt");
            tileM.currentMap = 2;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 13 * tileSize; //ini berarti baris ke 5
            maincharacter.y = 5 * tileSize; //ini berarti kolom ke 5
        }

        //dari jalan ke Restaurant
        else if (maincharacter.x / tileSize == 6  && maincharacter.y / tileSize == 1 && tileM.currentMap == 2) {
            startTransition();
            tileM.loadMap("/maps/mapRestaurant.txt");
            tileM.currentMap = 5;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 13 * tileSize; //ini berarti baris ke 5
            maincharacter.y = 5 * tileSize; //ini berarti kolom ke 5
        }
        else if (maincharacter.x / tileSize == 11  && maincharacter.y / tileSize == 3 && tileM.currentMap == 5) {
            startTransition();
            tileM.loadMap("/maps/mapJalan.txt");
            tileM.currentMap = 2;

            //load npc dan karakter pada map baru
            aSetter.setObject();
            aSetter.setNPC();

            //set tempat spawn karakter pada map baru
            maincharacter.x = 6 * tileSize; //ini berarti baris ke 5
            maincharacter.y = 3 * tileSize; //ini berarti kolom ke 3
        }
    }

    //set transisi
    public void startTransition() {
        gameState = transitionState;
    }

    public void paintComponent(Graphics g){ //graphic class is a class that has many object
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; //convert g to g2 . Grpahics2d is a class that extend Graphics class

        //TITLE SCREEN
        if (gameState == titleState){
            ui.draw(g2);
        }
        //OTHERS
        else{
            tileM.draw(g2);
            for(int i = 0; i<obj.length; i++){
                if(obj[i]!=null){
                    obj[i].draw(g2,this);
                }
            }

            //NPC
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].draw(g2, this);
                }
            }

            maincharacter.draw(g2);
            //ui
            ui.draw(g2);
        }

        if (gameState == transitionState) {
            drawTransition(g2, false);
        } else if (gameState == studyState) {
            drawTransition(g2, true);
        }

        g2.dispose();

    }


    //Fungsi untuk membuat gambar transisi
    public void drawTransition(Graphics2D g2, boolean study) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, screenWidth, screenHeight);
        String text;

        // Set the desired font size, e.g., 24
        Font sizedFont = pixelFont.deriveFont(24 * 2f); // 24 is the font size in points
        g2.setFont(sizedFont);

        g2.setColor(Color.WHITE);
        if (study) {
            text = "SAAT INI PEMAIN SEDANG BELAJAR.\n\nTUNGGU BEBERAPA SAAT";
        } else {
            text = "Loading map...";
        }

        // Split the text into lines
        String[] lines = text.split("\n");

        // Calculate the total height of the text block
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        int lineHeight = metrics.getHeight();
        int textHeight = lines.length * lineHeight;

        // Calculate the starting y position
        int y = (screenHeight - textHeight) / 2 + metrics.getAscent();

        // Draw each line of text
        for (String line : lines) {
            int x = (screenWidth - metrics.stringWidth(line)) / 2;
            g2.drawString(line, x, y);
            y += lineHeight;
        }
    }
}

package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    public GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

//    public GamePanel getGp() {
//        return gp;
//    }
//
//    public void setGp(GamePanel gp) {
//        this.gp = gp;
//    }
//
//    public Tile[] getTile() {
//        return tile;
//    }
//
//    public void setTile(Tile[] tile) {
//        this.tile = tile;
//    }
//
//    public int[][] getMapTileNum() {
//        return mapTileNum;
//    }
//
//    public void setMapTileNum(int[][] mapTileNum) {
//        this.mapTileNum = mapTileNum;
//    }

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tile[1000]; // 10 kinds of tile
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/BG/mapswall.txt");
    }
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/BG/floor01.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/BG/wallblock.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/BG/mejaaset.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/BG/chair.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/BG/kursikiri.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/BG/kursidpn.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/BG/kursikanan.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream("/objectsPict/bed.png"));
            tile[7].collision = true;



//            tile[7].image = resizeImage(originalImage, gp.tileSize*2, gp.tileSize*2 );
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }


    public void loadMap(String filepath){
        try{
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); //read a content of txt
            int col = 0;
            int row = 0;
            while(col<gp.maxScreenRow && row<gp.maxScreenRow){
                String line = br.readLine(); // read single line and put in "line"
                String numbers[]=line.split(" ");
                while (col < gp.maxScreenCol){
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num; //simpan each number with its col and row to "mapTileNum"
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            } br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void draw(Graphics2D g2) {
//        int col = 0;
//        int row = 0;
//        int x = 0;
//        int y = 0;
//
//        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
//            int tileNum = mapTileNum[col][row];
//
//            if (tileNum == 7) {
//                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize*2 , gp.tileSize*2, null); // Gambar dengan ukuran 32x32
//                col += 2; // Lewati 1 kolom karena tile ini menempati 2 kolom
//                x += gp.tileSize * 2; // Geser posisi x untuk dua tile
//
//                if (col >= gp.maxScreenCol) {
//                    col = 0;
//                    x = 0;
//                    row++;
//                }
////                else {
////                    // If we're out of bounds, just draw a 1x1 tile to avoid exception
////                    g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
////                    col++;
////                    x += gp.tileSize;
////                }
//            } else {
//                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
//                col++;
//                x += gp.tileSize;
//
//            }if (col >= gp.maxScreenCol) {
//                col = 0;
//                x = 0;
//                row++;
//                y += gp.tileSize;
//            }
//
//
//        }
//    }



    public void draw (Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col<gp.maxScreenCol && row<gp.maxScreenRow ){
            int tileNum = mapTileNum[col][row];
//            if(tileNum == 7){
//                g2.drawImage(tile[tileNum].image,x,y,gp.tileSize*2, gp.tileSize*2, null);
//                col += 2; // Lewati 1 kolom karena tile ini menempati 2 kolom
//                x += gp.tileSize * 2; // Geser posisi x untuk dua tile
//                continue;
//            }if(tileNum == 8){
//                x += gp.tileSize; // Geser posisi x untuk dua tile
////                continue;
//            }
//            else {
//                g2.drawImage(tile[tileNum].image,x,y,gp.tileSize, gp.tileSize, null);
//            }

                g2.drawImage(tile[tileNum].image,x,y,gp.tileSize, gp.tileSize, null);

            col++;
            x += gp.tileSize;
            if(col== gp.maxScreenCol){
                col = 0;
                x=0;
                row++;
                y+= gp.tileSize;
            }
        }
    }
}

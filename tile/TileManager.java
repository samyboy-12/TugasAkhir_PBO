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
    public int currentMap = 1;

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tile[1000]; // 10 kinds of tile
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/maps/mapKamar.txt");
    }
    public void getTileImage(){
        try{

            //Tile untuk map kamar
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



            //Tile untuk map Kelas
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapKelas/classRoomFloor.png"));
            tile[8].collision = false;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapKelas/classRoomWall.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapKelas/clockInClassRoom.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapKelas/notesInClassRoom.png"));
            tile[11].collision = true;

            //Tile untuk map Jalan raya

            //...

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_1.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_2.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_1.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_2.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_1.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_2.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_20_1.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_22_8.png"));
            tile[19].collision = false;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_19_2.png"));
            tile[20].collision = false;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_20_0.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_20_16.png"));
            tile[22].collision = false;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_20_13.png"));
            tile[23].collision = false;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_22_16.png"));
            tile[24].collision = false;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_22_13.png"));
            tile[25].collision = false;


            //tile untuk map lobby univ
            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/cornerCollision.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/HorizontalCollision.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/VerticalCollision.png"));
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/lobbyFloor.png"));
            tile[29].collision = false;

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/lobbyWall.png"));
            tile[30].collision = false;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairFloor.png"));
            tile[31].collision = false;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairShadowFloor.png"));
            tile[32].collision = false;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairTopHead.png"));
            tile[33].collision = false;

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairBottomHeadTop.png"));
            tile[34].collision = false;

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairBottomHeadBot.png"));
            tile[35].collision = false;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/peganganStair.png"));
            tile[36].collision = false;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairFenceRight.png"));
            tile[37].collision = false;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/stairFenceLeft.png"));
            tile[38].collision = false;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetTopLeftTop.png"));
            tile[39].collision = false;

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetTopLeftBot.png"));
            tile[40].collision = false;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetTopRightTop.png"));
            tile[41].collision = false;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetTopRightBot.png"));
            tile[42].collision = false;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetBotRightTop.png"));
            tile[43].collision = false;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetBotRightBot.png"));
            tile[44].collision = false;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetBotLeftTop.png"));
            tile[45].collision = false;

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapLobbyUniv/carpetBotLeftBot.png"));
            tile[46].collision = false;



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

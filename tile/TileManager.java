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
            BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/bed.png"));
            tile[7].collision = true;

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/table.png"));
            tile[50].collision = true;

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/drawer.png"));
            tile[51].collision = true;

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/BG/carpet1.png"));

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/BG/carpet2.png"));

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/BG/carpet3.png"));

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/BG/carpet4.png"));

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/sofamini.png"));
            tile[56].collision = true;

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/pohon.png"));
            tile[57].collision = true;

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/BUKURAK.png"));
            tile[58].collision = true;

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/sofasepatu.png"));
            tile[59].collision = true;

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/BG/SHOES.png"));
            tile[60].collision = true;


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


            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_16_13.png"));
            tile[47].collision = true;

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_5_0.png"));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_5_1.png"));
            tile[49].collision = true;

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_5_2.png"));
            tile[70].collision = true;

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_6_0.png"));
            tile[71].collision = true;

            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_6_1.png"));
            tile[72].collision = true;

            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_6_2.png"));
            tile[73].collision = true;

            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_8_9.png"));
            tile[74].collision = true;

            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_8_10.png"));
            tile[75].collision = true;

            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_9_9.png"));
            tile[76].collision = true;

            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_9_10.png"));
            tile[77].collision = true;

            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_10_9.png"));
            tile[78].collision = true;

            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_10_10.png"));
            tile[79].collision = true;

            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_11_9.png"));
            tile[80].collision = true;

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_11_10.png"));
            tile[81].collision = true;

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_22_13.png"));
            tile[82].collision = true;

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_3.png"));
            tile[83].collision = true;

            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_4.png"));
            tile[84].collision = true;

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_3.png"));
            tile[85].collision = true;

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_4.png"));
            tile[86].collision = true;

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_3.png"));
            tile[87].collision = true;

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_4.png"));
            tile[88].collision = true;

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_6.png"));
            tile[89].collision = true;

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_7.png"));
            tile[90].collision = true;

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_6.png"));
            tile[91].collision = true;

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_7.png"));
            tile[92].collision = true;

            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_6.png"));
            tile[93].collision = true;

            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_7.png"));
            tile[94].collision = true;

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_9.png"));
            tile[95].collision = true;

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_1_10.png"));
            tile[96].collision = true;

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_9.png"));
            tile[97].collision = true;

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_10.png"));
            tile[98].collision = true;

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_9.png"));
            tile[99].collision = true;

            tile[100] = new Tile();

            tile[100].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_10.png"));

            tile[100].collision = true;

            tile[101] = new Tile();
            tile[101].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_3_8.png"));
            tile[101].collision = true;

            tile[102] = new Tile();
            tile[102].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_2_8.png"));
            tile[102].collision = true;

            tile[103] = new Tile();
            tile[103].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_0_0.png"));
            tile[103].collision = true;

            tile[104] = new Tile();
            tile[104].image = ImageIO.read(getClass().getResourceAsStream("/BG/tile_22_13.png"));
            tile[104].collision = true;


            //Tile Restaurant

            tile[105] = new Tile();
            tile[105].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_001.png"));
            tile[105].collision = true;

            tile[106] = new Tile();
            tile[106].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_002.png"));
            tile[106].collision = true;

            tile[107] = new Tile();
            tile[107].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_003.png"));
            tile[107].collision = true;

            tile[108] = new Tile();
            tile[108].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_004.png"));
            tile[108].collision = true;

            tile[109] = new Tile();
            tile[109].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_005.png"));
            tile[109].collision = true;

            tile[110] = new Tile();
            tile[110].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_006.png"));
            tile[110].collision = true;

            tile[111] = new Tile();
            tile[111].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_007.png"));
            tile[111].collision = true;

            tile[112] = new Tile();
            tile[112].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_008.png"));
            tile[112].collision = true;

            tile[113] = new Tile();
            tile[113].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_009.png"));
            tile[113].collision = true;

            tile[114] = new Tile();
            tile[114].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_010.png"));
            tile[114].collision = true;

            tile[115] = new Tile();
            tile[115].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_011.png"));
            tile[115].collision = true;

            tile[116] = new Tile();
            tile[116].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_012.png"));
            tile[116].collision = true;

            tile[117] = new Tile();
            tile[117].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_013.png"));
            tile[117].collision = true;

            tile[118] = new Tile();
            tile[118].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_014.png"));
            tile[118].collision = true;

            tile[119] = new Tile();
            tile[119].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_015.png"));
            tile[119].collision = true;

            tile[120] = new Tile();
            tile[120].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_016.png"));
            tile[120].collision = true;

            tile[121] = new Tile();
            tile[121].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_017.png"));
            tile[121].collision = true;

            tile[122] = new Tile();
            tile[122].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_018.png"));
            tile[122].collision = true;

            tile[123] = new Tile();
            tile[123].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_019.png"));
            tile[123].collision = true;

            tile[124] = new Tile();
            tile[124].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_020.png"));
            tile[124].collision = true;

            tile[125] = new Tile();
            tile[125].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_021.png"));
            tile[125].collision = true;

            tile[126] = new Tile();
            tile[126].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_022.png"));
            tile[126].collision = true;

            tile[127] = new Tile();
            tile[127].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_023.png"));
            tile[127].collision = true;

            tile[128] = new Tile();
            tile[128].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_024.png"));
            tile[128].collision = true;

            tile[129] = new Tile();
            tile[129].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_025.png"));
            tile[129].collision = true;

            tile[130] = new Tile();
            tile[130].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_026.png"));
            tile[130].collision = true;

            tile[131] = new Tile();
            tile[131].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_027.png"));
            tile[131].collision = true;

            tile[132] = new Tile();
            tile[132].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_028.png"));
            tile[132].collision = true;

            tile[133] = new Tile();
            tile[133].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_029.png"));
            tile[133].collision = true;

            tile[134] = new Tile();
            tile[134].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_030.png"));
            tile[134].collision = true;

            tile[135] = new Tile();
            tile[135].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_031.png"));
            tile[135].collision = true;

            tile[136] = new Tile();
            tile[136].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_032.png"));
            tile[136].collision = true;

            tile[137] = new Tile();
            tile[137].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_033.png"));
            tile[137].collision = true;

            tile[138] = new Tile();
            tile[138].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_034.png"));
            tile[138].collision = true;

            tile[139] = new Tile();
            tile[139].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_035.png"));
            tile[139].collision = true;

            tile[140] = new Tile();
            tile[140].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_036.png"));
            tile[140].collision = true;

            tile[141] = new Tile();
            tile[141].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_037.png"));
            tile[141].collision = true;

            tile[142] = new Tile();
            tile[142].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_038.png"));
            tile[142].collision = true;

            tile[143] = new Tile();
            tile[143].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_039.png"));
            tile[143].collision = true;

            tile[144] = new Tile();
            tile[144].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_040.png"));
            tile[144].collision = true;

            tile[145] = new Tile();
            tile[145].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_041.png"));
            tile[145].collision = true;

            tile[146] = new Tile();
            tile[146].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_042.png"));
            tile[146].collision = true;

            tile[147] = new Tile();
            tile[147].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_043.png"));
            tile[147].collision = true;

            tile[148] = new Tile();
            tile[148].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_044.png"));
            tile[148].collision = true;

            tile[149] = new Tile();
            tile[149].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_045.png"));
            tile[149].collision = true;

            tile[150] = new Tile();
            tile[150].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_046.png"));
            tile[150].collision = true;

            tile[151] = new Tile();
            tile[151].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_047.png"));
            tile[151].collision = true;

            tile[152] = new Tile();
            tile[152].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_048.png"));
            tile[152].collision = true;

            tile[153] = new Tile();
            tile[153].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_049.png"));
            tile[153].collision = true;

            tile[154] = new Tile();
            tile[154].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_050.png"));
            tile[154].collision = true;

            tile[155] = new Tile();
            tile[155].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_051.png"));
            tile[155].collision = true;

            tile[156] = new Tile();
            tile[156].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_052.png"));
            tile[156].collision = true;

            tile[157] = new Tile();
            tile[157].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_053.png"));
            tile[157].collision = true;

            tile[158] = new Tile();
            tile[158].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_054.png"));
            tile[158].collision = true;

            tile[159] = new Tile();
            tile[159].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_055.png"));
            tile[159].collision = true;

            tile[160] = new Tile();
            tile[160].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_056.png"));
            tile[160].collision = true;

            tile[161] = new Tile();
            tile[161].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_057.png"));
            tile[161].collision = true;

            tile[162] = new Tile();
            tile[162].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_058.png"));
            tile[162].collision = true;

            tile[163] = new Tile();
            tile[163].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_059.png"));
            tile[163].collision = true;

            tile[164] = new Tile();
            tile[164].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_060.png"));
            tile[164].collision = true;

            tile[165] = new Tile();
            tile[165].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_061.png"));
            tile[165].collision = true;

            tile[166] = new Tile();
            tile[166].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_062.png"));
            tile[166].collision = true;

            tile[167] = new Tile();
            tile[167].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_063.png"));
            tile[167].collision = true;

            tile[168] = new Tile();
            tile[168].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_064.png"));
            tile[168].collision = true;

            tile[169] = new Tile();
            tile[169].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_065.png"));
            tile[169].collision = true;

            tile[170] = new Tile();
            tile[170].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_066.png"));
            tile[170].collision = true;

            tile[171] = new Tile();
            tile[171].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_067.png"));
            tile[171].collision = true;

            tile[172] = new Tile();
            tile[172].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_068.png"));
            tile[172].collision = true;

            tile[173] = new Tile();
            tile[173].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_069.png"));
            tile[173].collision = true;

            tile[174] = new Tile();
            tile[174].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_070.png"));
            tile[174].collision = true;

            tile[175] = new Tile();
            tile[175].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_071.png"));
            tile[175].collision = true;

            tile[176] = new Tile();
            tile[176].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_072.png"));
            tile[176].collision = true;

            tile[177] = new Tile();
            tile[177].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_073.png"));
            tile[177].collision = true;

            tile[178] = new Tile();
            tile[178].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_074.png"));
            tile[178].collision = true;

            tile[179] = new Tile();
            tile[179].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_075.png"));
            tile[179].collision = true;

            tile[180] = new Tile();
            tile[180].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_076.png"));
            tile[180].collision = true;

            tile[181] = new Tile();
            tile[181].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_077.png"));
            tile[181].collision = false;

            tile[182] = new Tile();
            tile[182].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_078.png"));
            tile[182].collision = false;

            tile[183] = new Tile();
            tile[183].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_079.png"));
            tile[183].collision = false;

            tile[184] = new Tile();
            tile[184].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_080.png"));
            tile[184].collision = false;

            tile[185] = new Tile();
            tile[185].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_081.png"));
            tile[185].collision = false;

            tile[186] = new Tile();
            tile[186].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_082.png"));
            tile[186].collision = false;

            tile[187] = new Tile();
            tile[187].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_083.png"));
            tile[187].collision = false;

            tile[188] = new Tile();
            tile[188].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_084.png"));
            tile[188].collision = true;

            tile[189] = new Tile();
            tile[189].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_085.png"));
            tile[189].collision = true;

            tile[190] = new Tile();
            tile[190].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_086.png"));
            tile[190].collision = true;

            tile[191] = new Tile();
            tile[191].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_087.png"));
            tile[191].collision = true;

            tile[192] = new Tile();
            tile[192].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_088.png"));
            tile[192].collision = true;

            tile[193] = new Tile();
            tile[193].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_089.png"));
            tile[193].collision = true;

            tile[194] = new Tile();
            tile[194].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_090.png"));
            tile[194].collision = true;

            tile[195] = new Tile();
            tile[195].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_091.png"));
            tile[195].collision = true;

            tile[196] = new Tile();
            tile[196].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_092.png"));
            tile[196].collision = true;

            tile[197] = new Tile();
            tile[197].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_093.png"));
            tile[197].collision = false;

            tile[198] = new Tile();
            tile[198].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_094.png"));
            tile[198].collision = false;

            tile[199] = new Tile();
            tile[199].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_095.png"));
            tile[199].collision = true;

            tile[200] = new Tile();
            tile[200].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_096.png"));
            tile[200].collision = true;

            tile[201] = new Tile();
            tile[201].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_097.png"));
            tile[201].collision = false;

            tile[202] = new Tile();
            tile[202].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_098.png"));
            tile[202].collision = false;

            tile[203] = new Tile();
            tile[203].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_099.png"));
            tile[203].collision = false;

            tile[204] = new Tile();
            tile[204].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_100.png"));
            tile[204].collision = true;

            tile[205] = new Tile();
            tile[205].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_101.png"));
            tile[205].collision = true;

            tile[206] = new Tile();
            tile[206].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_102.png"));
            tile[206].collision = true;

            tile[207] = new Tile();
            tile[207].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_103.png"));
            tile[207].collision = true;

            tile[208] = new Tile();
            tile[208].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_104.png"));
            tile[208].collision = true;

            tile[209] = new Tile();
            tile[209].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_105.png"));
            tile[209].collision = true;

            tile[210] = new Tile();
            tile[210].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_106.png"));
            tile[210].collision = true;

            tile[211] = new Tile();
            tile[211].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_107.png"));
            tile[211].collision = true;

            tile[212] = new Tile();
            tile[212].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_108.png"));
            tile[212].collision = false;

            tile[213] = new Tile();
            tile[213].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_109.png"));
            tile[213].collision = false;

            tile[214] = new Tile();
            tile[214].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_110.png"));
            tile[214].collision = false;

            tile[215] = new Tile();
            tile[215].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_111.png"));
            tile[215].collision = true;

            tile[216] = new Tile();
            tile[216].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_112.png"));
            tile[216].collision = true;

            tile[217] = new Tile();
            tile[217].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_113.png"));
            tile[217].collision = false;

            tile[218] = new Tile();
            tile[218].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_114.png"));
            tile[218].collision = false;

            tile[219] = new Tile();
            tile[219].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_115.png"));
            tile[219].collision = false;

            tile[220] = new Tile();
            tile[220].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_116.png"));
            tile[220].collision = false;

            tile[221] = new Tile();
            tile[221].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_117.png"));
            tile[221].collision = true;

            tile[222] = new Tile();
            tile[222].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_118.png"));
            tile[222].collision = false;

            tile[223] = new Tile();
            tile[223].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_119.png"));
            tile[223].collision = true;

            tile[224] = new Tile();
            tile[224].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_120.png"));
            tile[224].collision = false;

            tile[225] = new Tile();
            tile[225].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_121.png"));
            tile[225].collision = false;

            tile[226] = new Tile();
            tile[226].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_122.png"));
            tile[226].collision = true;

            tile[227] = new Tile();
            tile[227].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_123.png"));
            tile[227].collision = true;

            tile[228] = new Tile();
            tile[228].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_124.png"));
            tile[228].collision = false;

            tile[229] = new Tile();
            tile[229].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_125.png"));
            tile[229].collision = true;

            tile[230] = new Tile();
            tile[230].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_126.png"));
            tile[230].collision = false;

            tile[231] = new Tile();
            tile[231].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_127.png"));
            tile[231].collision = false;

            tile[232] = new Tile();
            tile[232].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_128.png"));
            tile[232].collision = true;

            tile[233] = new Tile();
            tile[233].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_129.png"));
            tile[233].collision = false;

            tile[234] = new Tile();
            tile[234].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_130.png"));
            tile[234].collision = true;

            tile[235] = new Tile();
            tile[235].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_131.png"));
            tile[235].collision = true;

            tile[236] = new Tile();
            tile[236].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_132.png"));
            tile[236].collision = false;

            tile[237] = new Tile();
            tile[237].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_133.png"));
            tile[237].collision = false;

            tile[238] = new Tile();
            tile[238].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_134.png"));
            tile[238].collision = true;

            tile[239] = new Tile();
            tile[239].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_135.png"));
            tile[239].collision = true;

            tile[240] = new Tile();
            tile[240].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_136.png"));
            tile[240].collision = true;

            tile[241] = new Tile();
            tile[241].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_137.png"));
            tile[241].collision = false;

            tile[242] = new Tile();
            tile[242].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_138.png"));
            tile[242].collision = false;

            tile[243] = new Tile();
            tile[243].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_139.png"));
            tile[243].collision = true;

            tile[244] = new Tile();
            tile[244].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_140.png"));
            tile[244].collision = true;

            tile[245] = new Tile();
            tile[245].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_141.png"));
            tile[245].collision = true;

            tile[246] = new Tile();
            tile[246].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_142.png"));
            tile[246].collision = false;

            tile[247] = new Tile();
            tile[247].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_143.png"));
            tile[247].collision = false;

            tile[248] = new Tile();
            tile[248].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_144.png"));
            tile[248].collision = true;

            tile[249] = new Tile();
            tile[249].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_145.png"));
            tile[249].collision = true;

            tile[250] = new Tile();
            tile[250].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_146.png"));
            tile[250].collision = true;

            tile[251] = new Tile();
            tile[251].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_147.png"));
            tile[251].collision = true;

            tile[252] = new Tile();
            tile[252].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_148.png"));
            tile[252].collision = true;

            tile[253] = new Tile();
            tile[253].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_149.png"));
            tile[253].collision = true;

            tile[254] = new Tile();
            tile[254].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_150.png"));
            tile[254].collision = true;

            tile[255] = new Tile();
            tile[255].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_151.png"));
            tile[255].collision = true;

            tile[256] = new Tile();
            tile[256].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_152.png"));
            tile[256].collision = true;

            tile[257] = new Tile();
            tile[257].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_153.png"));
            tile[257].collision = true;

            tile[258] = new Tile();
            tile[258].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_154.png"));
            tile[258].collision = false;

            tile[259] = new Tile();
            tile[259].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_155.png"));
            tile[259].collision = true;

            tile[260] = new Tile();
            tile[260].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_156.png"));
            tile[260].collision = true;

            tile[261] = new Tile();
            tile[261].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_157.png"));
            tile[261].collision = true;

            tile[262] = new Tile();
            tile[262].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_158.png"));
            tile[262].collision = false;

            tile[263] = new Tile();
            tile[263].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_159.png"));
            tile[263].collision = false;

            tile[264] = new Tile();
            tile[264].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_160.png"));
            tile[264].collision = true;

            tile[265] = new Tile();
            tile[265].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_161.png"));
            tile[265].collision = true;

            tile[266] = new Tile();
            tile[266].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_162.png"));
            tile[266].collision = true;

            tile[267] = new Tile();
            tile[267].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_163.png"));
            tile[267].collision = true;

            tile[268] = new Tile();
            tile[268].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_164.png"));
            tile[268].collision = true;

            tile[269] = new Tile();
            tile[269].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_165.png"));
            tile[269].collision = true;

            tile[270] = new Tile();
            tile[270].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_166.png"));
            tile[270].collision = true;

            tile[271] = new Tile();
            tile[271].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_167.png"));
            tile[271].collision = true;

            tile[272] = new Tile();
            tile[272].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_168.png"));
            tile[272].collision = true;

            tile[273] = new Tile();
            tile[273].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_169.png"));
            tile[273].collision = true;

            tile[274] = new Tile();
            tile[274].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_170.png"));
            tile[274].collision = false;

            tile[275] = new Tile();
            tile[275].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_171.png"));
            tile[275].collision = true;

            tile[276] = new Tile();
            tile[276].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_172.png"));
            tile[276].collision = true;

            tile[277] = new Tile();
            tile[277].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_173.png"));
            tile[277].collision = true;

            tile[278] = new Tile();
            tile[278].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_174.png"));
            tile[278].collision = true;

            tile[279] = new Tile();
            tile[279].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_175.png"));
            tile[279].collision = false;

            tile[280] = new Tile();
            tile[280].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_176.png"));
            tile[280].collision = true;

            tile[281] = new Tile();
            tile[281].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_177.png"));
            tile[281].collision = false;

            tile[282] = new Tile();
            tile[282].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_178.png"));
            tile[282].collision = false;

            tile[283] = new Tile();
            tile[283].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_179.png"));
            tile[283].collision = false;

            tile[284] = new Tile();
            tile[284].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_180.png"));
            tile[284].collision = false;

            tile[285] = new Tile();
            tile[285].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_181.png"));
            tile[285].collision = false;

            tile[286] = new Tile();
            tile[286].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_182.png"));
            tile[286].collision = false;

            tile[287] = new Tile();
            tile[287].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_183.png"));
            tile[287].collision = false;

            tile[288] = new Tile();
            tile[288].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_184.png"));
            tile[288].collision = false;

            tile[289] = new Tile();
            tile[289].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_185.png"));
            tile[289].collision = false;

            tile[290] = new Tile();
            tile[290].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_186.png"));
            tile[290].collision = false;

            tile[291] = new Tile();
            tile[291].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_187.png"));
            tile[291].collision = false;

            tile[292] = new Tile();
            tile[292].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_188.png"));
            tile[292].collision = false;

            tile[293] = new Tile();
            tile[293].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_189.png"));
            tile[293].collision = false;

            tile[294] = new Tile();
            tile[294].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_190.png"));
            tile[294].collision = false;

            tile[295] = new Tile();
            tile[295].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_191.png"));
            tile[295].collision = false;

            tile[296] = new Tile();
            tile[296].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapRestaurant/image_part_192.png"));
            tile[296].collision = false;

            tile[297] = new Tile();
            tile[297].image = ImageIO.read(getClass().getResourceAsStream("/BG/bubble.png"));

            tile[298] = new Tile();
            tile[298].image = ImageIO.read(getClass().getResourceAsStream("/BG/bubblejalan.png"));

            tile[299] = new Tile();
            tile[299].image = ImageIO.read(getClass().getResourceAsStream("/BG/bubbleshop.png"));

            tile[300] = new Tile();
            tile[300].image = ImageIO.read(getClass().getResourceAsStream("/BG/bubblelobi.png"));

            tile[301] = new Tile();
            tile[301].image = ImageIO.read(getClass().getResourceAsStream("/BG/MapKelas/bubblekelas.png"));
            tile[301].collision = true;

            tile[302] = new Tile();
            tile[302].image = ImageIO.read(getClass().getResourceAsStream("/BG/loker.png"));




//            tile[7].image = resizeImage(originalImage, gp.tileize*2, gp.tileize*2 );
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
//                g2.drawImage(tile[tileNum].image,x,y,gp.tileize*2, gp.tileize*2, null);
//                col += 2; // Lewati 1 kolom karena tile ini menempati 2 kolom
//                x += gp.tileize * 2; // Geser posisi x untuk dua tile
//                continue;
//            }if(tileNum == 8){
//                x += gp.tileize; // Geser posisi x untuk dua tile
////                continue;
//            }
//            else {
//                g2.drawImage(tile[tileNum].image,x,y,gp.tileize, gp.tileize, null);
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

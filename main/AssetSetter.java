package main;

import Entity.Lecturer;
import Entity.Student;
import objects.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        for (int i = 0; i < gp.obj.length; i++) {
            gp.obj[i] = null;
        }

        //ini map kamar
        if (gp.tileM.currentMap == 1) {
            gp.obj[0] = new OBJ_Bed(gp);
            gp.obj[0].worldX = (4 * gp.tileSize);
            gp.obj[0].worldY = gp.tileSize;
            gp.obj[1] = new OBJ_SOFA(gp);
            gp.obj[1].worldX = (9 * gp.tileSize);
            gp.obj[1].worldY = gp.tileSize;
            gp.obj[2] = new OBJ_SOFA(gp);
            gp.obj[2].worldX = (12 * gp.tileSize)-50;
            gp.obj[2].worldY = gp.tileSize;
            gp.obj[3] = new OBJ_LEMARI(gp);
            gp.obj[3].worldX = (14*gp.tileSize);
            gp.obj[3].worldY = gp.tileSize+(gp.tileSize*4);
            gp.obj[4] = new OBJ_LEMARI(gp);
            gp.obj[4].worldX = (14*gp.tileSize);
            gp.obj[4].worldY = gp.tileSize+(gp.tileSize*6);
            gp.obj[5] = new OBJ_LEMARIBUKU(gp);
            gp.obj[5].worldX = (12*gp.tileSize);
            gp.obj[5].worldY = (gp.tileSize*4)+5;
            gp.obj[6] = new OBJ_LEMARIBAJU(gp);
            gp.obj[6].worldX = 20;
            gp.obj[6].worldY = (gp.tileSize);
            gp.obj[7] = new OBJ_MEJABLJR(gp);
            gp.obj[7].worldX = (gp.tileSize)-30;
            gp.obj[7].worldY = (gp.tileSize*4) + 30;
            gp.obj[8] = new OBJ_KURSISEPATU(gp);
            gp.obj[8].worldX = (gp.tileSize*10)+5;
            gp.obj[8].worldY = (gp.tileSize*10)+20;
            gp.obj[9] = new OBJ_BOOK(gp);
            gp.obj[9].worldX = (gp.tileSize)+15;
            gp.obj[9].worldY = (gp.tileSize*5);

            //ini map kelas
        } else if (gp.tileM.currentMap == 4) {
            gp.obj[0] = new TablesInClassRoom(3 * gp.tileSize, 3 * gp.tileSize, gp);
            gp.obj[1] = new TablesInClassRoom(6 * gp.tileSize, 3 * gp.tileSize, gp);
            gp.obj[2] = new TablesInClassRoom(9 * gp.tileSize, 3 * gp.tileSize, gp);
            gp.obj[3] = new TablesInClassRoom(3 * gp.tileSize, 5 * gp.tileSize, gp);
            gp.obj[4] = new TablesInClassRoom(6 * gp.tileSize, 5 * gp.tileSize, gp);
            gp.obj[5] = new TablesInClassRoom(9 * gp.tileSize, 5 * gp.tileSize, gp);
            gp.obj[6] = new TablesInClassRoom(3 * gp.tileSize, 7 * gp.tileSize, gp);
            gp.obj[7] = new TablesInClassRoom(6 * gp.tileSize, 7 * gp.tileSize, gp);
            gp.obj[8] = new TablesInClassRoom(9 * gp.tileSize, 7 * gp.tileSize, gp);
            gp.obj[9] = new TablesInClassRoom(3 * gp.tileSize, 9 * gp.tileSize, gp);
            gp.obj[10] = new TablesInClassRoom(6 * gp.tileSize, 9 * gp.tileSize, gp);
            gp.obj[11] = new TablesInClassRoom(9 * gp.tileSize, 9 * gp.tileSize, gp);
            gp.obj[13] = new BlackBoard(4 * gp.tileSize, 0 * gp.tileSize, gp);
        }

        //ini map jalan
        else if (gp.tileM.currentMap == 2) {
            gp.obj[0] = new OBJ_ATM(gp);
            gp.obj[0].worldX = (9 * gp.tileSize);
            gp.obj[0].worldY = 4 * gp.tileSize;
        }

    }

    public void setNPC(){
        for (int i = 0; i < gp.npc.length; i++) {
            gp.npc[i] = null;
        }

        if (gp.tileM.currentMap == 4) {
            gp.npc[0] = new Lecturer(gp, "Pak T.U", 40, 3 * gp.tileSize, 1 * gp.tileSize, "/assets/Lecturer.png");
            gp.npc[0].dialogues[0] = "Pak T.U: /nSelamat datang di kelas saya. /n/nSilahkan langsung baca materi /nyang sudah saya share di grup WA";
            gp.npc[0].dialogues[1] = "Pak T.U: /nSilahkan duduk, saya mau lanjut nonton YouTube dulu";
            gp.npc[0].dialogues[2] = "Pak T.U: /nSilahkan duduk!";

            gp.npc[1] = new Student(gp, "Kak Gem", 28, 3 * gp.tileSize, 4 * gp.tileSize, "/assets/Student.png", "Ilmu Hitam", 2);
            gp.npc[1].dialogues[0] = "Pemain: /nKak Gem Kak Gem, kata-katanya dong Kak Gem";
            gp.npc[1].dialogues[1] = "Kak Gem: /nJangan ditanya aku sedang apa...";
            gp.npc[1].dialogues[2] = "Kak Gem: /nSaat ini, aku sedang merasakan jatuh cinta....";
            gp.npc[1].dialogues[3] = "Kak Gem: /nSelain senyuman ibuku yang membuat aku bahagia...";
            gp.npc[1].dialogues[4] = "Kak Gem: /nSenyuman dia juga membuatku tergila-gila di setiap harinya...";
            gp.npc[1].dialogues[5] = "Kak Gem: /n/n                           PAHAMMMM!!!";
//
//            gp.npc[2] = new Student(gp, "Kak Gem", 40, 5 * gp.tileSize, 9 * gp.tileSize, "/assets/npc/Lecturer.png");
//            gp.npc[2].dialogues[0] = "Kak Gem: /nSelamat datang di kelas saya. /n/nSilahkan langsung baca materi /nyang sudah saya share di grup WA";
//            gp.npc[2].dialogues[1] = "Kak Gem: /nSilahkan duduk, saya mau lanjut nonton YouTube dulu";
//            gp.npc[2].dialogues[2] = "Kak Gem: /nSilahkan duduk!";
//
//            gp.npc[3] = new Student(gp, "Kak Gem", 40, 7 * gp.tileSize, 6 * gp.tileSize, "/assets/npc/Lecturer.png");
//            gp.npc[3].dialogues[0] = "Kak Gem: /nSelamat datang di kelas saya. /n/nSilahkan langsung baca materi /nyang sudah saya share di grup WA";
//            gp.npc[3].dialogues[1] = "Kak Gem: /nSilahkan duduk, saya mau lanjut nonton YouTube dulu";
//            gp.npc[3].dialogues[2] = "Kak Gem: /nSilahkan duduk!";
//        } else if (gp.tileM.currentMap == 2) {
//            gp.npc[0] = new Lecturer(gp,"Kak Gem", 40, 7 * gp.tileSize, 6 * gp.tileSize, "/assets/npc/Lecturer.png");
        }
    }
}

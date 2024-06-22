package main;

import Entity.Cashier;
import Entity.Lecturer;
import Entity.Student;
import objects.*;

import java.util.ArrayList;

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
            gp.obj[0] = new OBJ_TablesInClassRoom(3 * gp.tileSize, 3 * gp.tileSize, gp);
            gp.obj[1] = new OBJ_TablesInClassRoom(6 * gp.tileSize, 3 * gp.tileSize, gp);
            gp.obj[2] = new OBJ_TablesInClassRoom(9 * gp.tileSize, 3 * gp.tileSize, gp);
            gp.obj[3] = new OBJ_TablesInClassRoom(3 * gp.tileSize, 5 * gp.tileSize, gp);
            gp.obj[4] = new OBJ_TablesInClassRoom(6 * gp.tileSize, 5 * gp.tileSize, gp);
            gp.obj[5] = new OBJ_TablesInClassRoom(9 * gp.tileSize, 5 * gp.tileSize, gp);
            gp.obj[6] = new OBJ_TablesInClassRoom(3 * gp.tileSize, 7 * gp.tileSize, gp);
            gp.obj[7] = new OBJ_TablesInClassRoom(6 * gp.tileSize, 7 * gp.tileSize, gp);
            gp.obj[8] = new OBJ_TablesInClassRoom(9 * gp.tileSize, 7 * gp.tileSize, gp);
            gp.obj[9] = new OBJ_TablesInClassRoom(3 * gp.tileSize, 9 * gp.tileSize, gp);
            gp.obj[10] = new OBJ_TablesInClassRoom(6 * gp.tileSize, 9 * gp.tileSize, gp);
            gp.obj[11] = new OBJ_TablesInClassRoom(9 * gp.tileSize, 9 * gp.tileSize, gp);
            gp.obj[13] = new OBJ_BlackBoard(4 * gp.tileSize, 0 * gp.tileSize, gp);
        }

        //ini map jalan
        else if (gp.tileM.currentMap == 2) {
            gp.obj[0] = new OBJ_ATM(gp);
            gp.obj[0].worldX = (9 * gp.tileSize);
            gp.obj[0].worldY = 4 * gp.tileSize;
        }
        // Ini map Restaurant
        else if (gp.tileM.currentMap == 5) {

        }

        // Ini map Lobby
        else if (gp.tileM.currentMap == 3) {
            gp.obj[0] = new OBJ_LEMARIBUKU(gp);
            gp.obj[0].worldX = (2 * gp.tileSize);
            gp.obj[0].worldY = (2 * gp.tileSize);
            gp.obj[1] = new OBJ_LEMARIBUKU(gp);
            gp.obj[1].worldX = (2 * gp.tileSize);
            gp.obj[1].worldY = (5 * gp.tileSize);
            gp.obj[2] = new OBJ_LEMARIBUKU(gp);
            gp.obj[2].worldX = (5 * gp.tileSize);
            gp.obj[2].worldY = (2 * gp.tileSize);
            gp.obj[3] = new OBJ_LEMARIBUKU(gp);
            gp.obj[3].worldX = (5 * gp.tileSize);
            gp.obj[3].worldY = (5 * gp.tileSize);
            gp.obj[4] = new OBJ_LEMARIBUKU(gp);
            gp.obj[4].worldX = (8 * gp.tileSize);
            gp.obj[4].worldY = (2 * gp.tileSize);
            gp.obj[5] = new OBJ_LEMARIBUKU(gp);
            gp.obj[5].worldX = (8 * gp.tileSize);
            gp.obj[5].worldY = (5 * gp.tileSize);
        }


    }

    public void setNPC(){
        for (int i = 0; i < gp.npc.length; i++) {
            gp.npc[i] = null;
        }

        if (gp.tileM.currentMap == 4) {
            ArrayList<String> coursesTaught= new ArrayList<>();
            coursesTaught.add("Pemograman Berorientasi Objek");
            coursesTaught.add("Praktikum Pemograman Komputer");
            coursesTaught.add("Matematika Diskrit");

            gp.npc[0] = new Lecturer(gp, "Pak T.U", 40, 2 * gp.tileSize, 2 * gp.tileSize, "/assets/Lecturer.png", coursesTaught);
            gp.npc[0].dialogues[0] = "Pak T.U: /n/nSelamat datang di kelas saya. /n/nSilahkan langsung baca materi /nyang sudah saya share di grup WA";
            gp.npc[0].dialogues[1] = "Pak T.U: /n/nSilahkan duduk, saya mau lanjut nonton YouTube dulu";
            gp.npc[0].dialogues[2] = "Pak T.U: /n/nSilahkan duduk!";

            gp.npc[1] = new Student(gp, "Kak Gem", 28, 3 * gp.tileSize, 4 * gp.tileSize, "/assets/NPC/muslim_woman_resized.png", "Ilmu Kepahaman", 2);
            gp.npc[1].dialogues[0] = "Pemain: /nKak Gem Kak Gem, kata-katanya dong Kak Gem";
            gp.npc[1].dialogues[1] = "Kak Gem: /n/nJangan ditanya aku sedang apa...";
            gp.npc[1].dialogues[2] = "Kak Gem: /n/nSaat ini, aku sedang merasakan jatuh cinta....";
            gp.npc[1].dialogues[3] = "Kak Gem: /n/nSelain senyuman ibuku yang membuat aku bahagia...";
            gp.npc[1].dialogues[4] = "Kak Gem: /n/nSenyuman dia juga membuatku tergila-gila di setiap harinya...";
            gp.npc[1].dialogues[5] = "Kak Gem: /n/n                           PAHAMMMM!!!";

            gp.npc[2] = new Student(gp, "Noni", 20, 7 * gp.tileSize, 10 * gp.tileSize, "/assets/Student.png","TPRL", 2);
            gp.npc[2].dialogues[0] = "Noni: /n/nEhh kamu udah laprak PPBO belum???";
            gp.npc[2].dialogues[1] = "Pemain:/n/nBelomm WKWKKWKW";

            gp.npc[3] = new Student(gp, "Ketlin", 20, 7 * gp.tileSize, 6 * gp.tileSize, "/assets/NPC/chinese_woman_resized.png", "TPRL", 2);
            gp.npc[3].dialogues[0] = "Ketlin: /n/nEhh liat laprak PPBO-mu dong";
            gp.npc[3].dialogues[1] = "Pemain: /n/nGA MAU.";

            gp.npc[4] = new Student(gp, "Naufal", 20, 10 * gp.tileSize, 6 * gp.tileSize, "/assets/Student.png", "TPRL", 2);
            gp.npc[4].dialogues[0] = "Naufal: /n/nKamu lolos seleksi internal gemastik?";
            gp.npc[4].dialogues[1] = "Pemain: /n/nEngga :(";

            gp.npc[5] = new Student(gp, "Nathan", 22, 7 * gp.tileSize, 4 * gp.tileSize, "/assets/Student.png", "Ilmu Padi", 2);
            gp.npc[5].dialogues[0] = "Nathan: /n/nUdah baca materinya?";
            gp.npc[5].dialogues[1] = "Pemain: /n/nBELUM WKWKW";

            gp.npc[6] = new Student(gp, "Asep", 30, 9 * gp.tileSize, 4 * gp.tileSize, "/assets/Student.png", "TPRL", 1);
            gp.npc[6].dialogues[0] = "Asep: /n/nSsstt jangan ngajak ngobrol";
            gp.npc[6].dialogues[1] = "Pemain: /n/nSiap";


            gp.npc[7] = new Student(gp, "Budiono Siregar", 12, 4 * gp.tileSize, 6 * gp.tileSize, "/assets/Student.png", "TPRL", 2);
            gp.npc[7].dialogues[0] = "Budiono Siregar: /n/nPerkenalkan nama saya Budiono Siregar";
            gp.npc[7].dialogues[1] = "Pemain: /n/nCita-cita kamu apa? Sekjen? Kepala Desa? Atau apa?";
            gp.npc[7].dialogues[2] = "Budiono Siregar: /n/nCita-cita saya ..... KAPAL LAUD";

            gp.npc[8] = new Student(gp, "Dodol", 19, 3 * gp.tileSize, 8 * gp.tileSize, "/assets/NPC/KASIR.png", "TPRL", 2);
            gp.npc[8].dialogues[0] = "Dodol: /n/nKamu ngeselin juga ya ternyata, dasar dodol!";
            gp.npc[8].dialogues[1] = "Pemain: /n/Lah, nama kamu tuh yang dodol";

            gp.npc[9] = new Student(gp, "Ning Maghrib", 22, 9 * gp.tileSize, 8 * gp.tileSize, "/assets/NPC/muslim_woman_resized.png", "TPRL", 2);
            gp.npc[9].dialogues[0] = "Ning Maghrib: /n/nHalo mas";
            gp.npc[9].dialogues[1] = "Pemain: /n/nSssttt...";
        }
        //ini map lobby
        else if (gp.tileM.currentMap == 3) {
            //4,2  4,6  8,2        10,11   14,11
            ArrayList<String> coursesTaught= new ArrayList<>();
            coursesTaught.add("Praktikum OOP");
            coursesTaught.add("Pnegantar Teknologi Informasi");
            gp.npc[0] = new Lecturer(gp, "Bu Tera", 35, 2 * gp.tileSize, 4 * gp.tileSize, "/assets/NPC/KASIR.png", coursesTaught);
            gp.npc[0].dialogues[0] = "Buk Tera: /n/nHai Apa Kabar";
            gp.npc[0].dialogues[1] = "Pemain: /n/nKabar baik bu";

            gp.npc[1] = new Student(gp, "Mbak Restu", 23, 3 * gp.tileSize, 7 * gp.tileSize, "/assets/NPC/muslim_woman_resized.png", "TPRL", 8);
            gp.npc[1].dialogues[0] = "Mbak Restu: /n/nSemangat ngerjain Proyek PPBO!";
            gp.npc[1].dialogues[1] = "Pemain: /n/nMakasih, semangat ngerjain T.A nya juga mbak!";

            gp.npc[2] = new Student(gp, "Budi", 23, 8 * gp.tileSize, 4 * gp.tileSize, "/assets/Student.png", "TPRL", 6);
            gp.npc[2].dialogues[0] = "Budi: /n/nHalo! nama saya Budi";
            gp.npc[2].dialogues[1] = "Pemain: /n/nHalo Budi, salam kenal ya";

            gp.npc[3] = new Student(gp, "Mas Anton", 25, 6 * gp.tileSize, 4 * gp.tileSize, "/assets/Student.png", "TPRL", 10);
            gp.npc[3].dialogues[0] = "Mas Anton: /nApa yang dicari orang sigma?bintang sekibidi, bintang yang/npaling skibidi tertinggi itu,kecuali skibidi lima hanyalah/nmewing besar. Sigma kan? Aku juga dulu pingin/nmewing lima, tapi yaa takdir tidak mengizinkan,/nGibran temen saya ada yang mewing di posisi ngerizz....";
            gp.npc[3].dialogues[1] = "Pemain: /n/nMas, kalau stress laprak, mending berobat ke GMC aja";

            gp.npc[4] = new Student(gp, "Mas Farhan", 21, 8 * gp.tileSize, 11 * gp.tileSize, "/assets/Student.png", "TPRL", 4);
            gp.npc[4].dialogues[0] = "Mas Farhan: /n/nEhh masuk kelas cepet, itu Pak T.U udah dikelas";
            gp.npc[4].dialogues[1] = "Pemain: /n/nKelasnya dimana ya mas?";
            gp.npc[4].dialogues[2] = "Mas Farhan: /n/nItu ada di sebelah kanan atas";
            gp.npc[4].dialogues[3] = "Pemain: /n/nSiap makasih mas";

            ArrayList<String> coursesTaught1= new ArrayList<>();
            coursesTaught1.add("Basis Data");
            gp.npc[5] = new Lecturer(gp, "Pak Firman", 37, 10 * gp.tileSize, 11 * gp.tileSize, "/assets/Lecturer.png", coursesTaught1);
            gp.npc[5].dialogues[0] = "Pak Firman: /n/nJangan lupa shalat mas";
            gp.npc[5].dialogues[1] = "Pemain: /n/nTerima kasih sudah mengingatkan Pak";

            gp.npc[6] = new Student(gp, "Ica", 19, 9 * gp.tileSize, 1 * gp.tileSize, "/assets/NPC/chinese_woman_resized.png", "TPRL", 2);
            gp.npc[6].dialogues[0] = "Ica: /n/nHaii";
            gp.npc[6].dialogues[1] = "Pemain: /n/nHaii jugaaa";

        }
        // ini map resto
        else if (gp.tileM.currentMap == 5) {
            gp.npc[0] = new Cashier( "Mba Ayu", 22, gp,8 * gp.tileSize, 6 * gp.tileSize, "/assets/NPC/KASIR.png");
        }


    }
}

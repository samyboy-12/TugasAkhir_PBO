package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Cashier extends ManKind{
    private int totalPendapatan;

    public int getTotalPendapatan() {
        return totalPendapatan;
    }

    public void setTotalPendapatan(int totalPendapatan) {
        this.totalPendapatan = totalPendapatan;
    }

    public Cashier(String name, int age, GamePanel gp, int worldX, int worldY, String imgPath) {
        super(name, age, gp);
        this.solidArea = new Rectangle(0,0,48,48);
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream(imgPath));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.x = worldX;
        this.y = worldY;
    }

    @Override
    public void displayInfo() {
        String infoText = "-----------------------INFO KARAKTER-----------------------/nNama : "+this.getName()+"/nUmur : "+this.getAge()+"/nTotal Pendapatan : "+this.getTotalPendapatan();
        this.setInfoMC(infoText);
        gp.ui.currentDialogue = this.getInfoMC();
        gp.gameState = gp.dialogueState;
    }

    public void communicate(){
        MainCharacter mainCharacter = gp.maincharacter;
        if (dialogueIndex == 0) {
            gp.ui.currentDialogue =  this.getName()+":/nSELAMAT DATANG DI WARMINDO MONJALI !!!/nWARUNG INI MENJUAL INDOMIE GORENG SEHARGA 10 RIBU/nPASTIKAN ANDA MEMPUNYAI UANG CASH YA!/nSOAL E KAMI TIDAK MENERIMA QRIS :) /n/n         ---(TEKAN 'T' DUA KALI UNTUK MEMBELI)---";
            dialogueIndex = 1;
        }
        else if (dialogueIndex == 1){
            int hargaIndomie = 10000;
            if (mainCharacter.getCash() >= hargaIndomie) {
                mainCharacter.setCash(mainCharacter.getCash() - hargaIndomie);
                mainCharacter.setEnergyBar(100);
                mainCharacter.checkForFinish.put("sudahMakan", true);

                this.totalPendapatan += hargaIndomie;
                gp.ui.currentDialogue = this.getName()+":/nTERIMA KASIH SUDAH MEMBELI MAKANAN DI WARMINDO INI/n/n  ---(ANDA SUDAH MEMBELI DAN MAKAN INDOMIE)---/n  ---(SAAT INI ANDA MEMULIHKAN ENERGI SEBESAR 100)--- " ;
            } else {
                gp.ui.currentDialogue = this.getName()+":/n/nUANG ANDA TIDAK CUKUP! JIKA TIDAK PUNYA UANG CASH/nCOBA TARIK TUNAI di ATM SAMPING JALAN YA MAS!";
            }
            dialogueIndex = 0;
        }
    }
}

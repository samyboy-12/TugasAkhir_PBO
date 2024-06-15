package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Lecturer extends ManKind {

    private ArrayList<String> coursesTaught = new ArrayList<>();

    public Lecturer(GamePanel gp, String name, int age, int worldX, int worldY, String imgPath, ArrayList<String> coursesTaught){
        super(name, age, gp);
        this.solidArea = new Rectangle(0,0,48,48);
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream(imgPath));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.x = worldX;
        this.y = worldY;
        this.coursesTaught = coursesTaught;
    }

    @Override
    public void displayInfo() {
        String infoText = "-----------------------INFO KARAKTER-----------------------/nNama : "+this.getName()+"/nUmur : "+this.getAge()+"/nDaftar Mata Kuliah yang diampu : ";
        for (String course: coursesTaught){
            infoText += "/n"+course+",";
        }
        this.setInfoMC(infoText);
        gp.ui.currentDialogue = this.getInfoMC();
        gp.gameState = gp.dialogueState;
    }

    public ArrayList<String> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(String courseThougth) {
        this.coursesTaught.add(courseThougth);
    }
}

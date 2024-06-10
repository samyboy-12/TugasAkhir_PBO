package Entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Student extends ManKind{
    private String studyProgram;
    private int semester;


    public Student(GamePanel gp, String name, int age, int worldX, int worldY, String imgPath, String studyProgram, int semester) {
        super(name, age, gp);
        this.solidArea = new Rectangle(0,0,48,48);
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream(imgPath));
        }catch(IOException e){
            e.printStackTrace();
        }

        this.x = worldX;
        this.y = worldY;
        this.studyProgram = studyProgram;
        this.semester = semester;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    @Override
    public void displayInfo() {
        this.setInfoMC("-----------------------INFO KARAKTER-----------------------/nNama : "+this.getName()+"/nUmur : "+this.getAge()+"/nProgram Studi : "+this.getStudyProgram()+"/nSemester : "+this.getSemester());
        gp.ui.currentDialogue = this.getInfoMC();
        gp.gameState = gp.dialogueState;
    }
}

package objects;

import interfaces.iMovable;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_CAR extends SuperObject implements iMovable {
    public GamePanel gp;
    private int CARspeed;
    public int CARposition = 15;

    public OBJ_CAR(GamePanel gp) {
        super(gp);
        name = "CAR";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/CAR.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;
        this.CARspeed = 1; // Set the car speed
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }

    //implement interface move
    @Override
    public void move() {
        CARposition -= CARspeed;
        if (CARposition < -100) {
            CARposition = 100;
        }
        // Update worldX to reflect new CARposition
        worldX = CARposition * gp.tileSize;
    }
}

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
    private long lastUpdateTime;
    private final long updateInterval;

    public OBJ_CAR(GamePanel gp, int fps) {
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
        this.updateInterval = 100 / fps;
        this.lastUpdateTime = System.currentTimeMillis();
    }

    @Override
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }

    //implement interface move
    @Override
    public void move() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime >= updateInterval) {
            CARposition -= CARspeed;
            if (CARposition < -40) {
                CARposition = 40;
            }
            // Update worldX to reflect new CARposition
            worldX = CARposition * gp.tileSize;
            lastUpdateTime = currentTime;
  }
 }
}
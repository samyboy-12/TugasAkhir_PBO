package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_HIASAN extends SuperObject{
    public GamePanel gp;

    public OBJ_HIASAN (GamePanel gp) {
        super(gp);
        name= "Bunga";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/Tumbuhan.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;

        //ngegedein ukuran solid area mengikuti gambar
        this.solidArea.width *= 1;
        this.solidArea.height *= 1;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        //buat ngegedein ukuran kasur
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}

package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_LEMARI extends SuperObject{
    public GamePanel gp;

    public OBJ_LEMARI(GamePanel gp) {
        super(gp);
        name= "Lemari";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectsPict/cupbord.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;

        //ngegedein ukuran solid area mengikuti gambar
        this.solidArea.width *= 2;
        this.solidArea.height *= 2;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        //buat ngegedein ukuran kasur
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize*2, null);
    }
}

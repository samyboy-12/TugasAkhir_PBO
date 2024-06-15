package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_LEMARIBAJU extends SuperObject{
    public GamePanel gp;

    public OBJ_LEMARIBAJU(GamePanel gp) {
        super(gp);
        name= "Lemari baju";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectsPict/lemaribj.png"));

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
        g2.drawImage(image, worldX, worldY, gp.tileSize*2, gp.tileSize*2, null);
    }
}

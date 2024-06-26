package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_RESEPSIONIS extends SuperObject{
    public GamePanel gp;

    public OBJ_RESEPSIONIS(GamePanel gp) {
        super(gp);
        name= "Resepsionis";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/Resepsionis.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;

        //ngegedein ukuran solid area mengikuti gambar
        this.solidArea.width *= 3;
        this.solidArea.height *=1;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        //buat ngegedein ukuran kasur
        g2.drawImage(image, worldX, worldY, gp.tileSize *3, gp.tileSize, null);
    }
}

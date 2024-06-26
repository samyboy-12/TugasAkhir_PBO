package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_MEJALOBBY extends SuperObject{
    public GamePanel gp;

    public OBJ_MEJALOBBY(GamePanel gp) {
        super(gp);
        name= "Meja Belajar";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/objectsPict/Mejalobby.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        this.gp = gp;

        //ngegedein ukuran solid area mengikuti gambar
        this.solidArea.width *= 1;
        this.solidArea.height *= 2;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        //buat ngegedein ukuran kasur
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize*2, null);
    }
}

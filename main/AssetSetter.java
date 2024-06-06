package main;

import objects.OBJ_Bed;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new OBJ_Bed(gp);
        gp.obj[0].worldX = (3 * gp.tileSize);
        gp.obj[0].worldY = 3 * gp.tileSize;
    }
}

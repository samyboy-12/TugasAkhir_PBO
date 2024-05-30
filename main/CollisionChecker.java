package main;

import Entity.ManKind;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(ManKind manKind){
        int entityLeftWorldX = manKind.getX()+ manKind.getSolidArea().x;
        int entityRightWorldX = manKind.getX() + manKind.getSolidArea().x + manKind.getSolidArea().width;
        int entityTopWorldY = manKind.getY() + manKind.getSolidArea().y;
        int entityBottomWorldY = manKind.getY() + manKind.getSolidArea().y + manKind.getSolidArea().height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1,tileNum2;
        switch(manKind.getDirection()){
            case "up":
                entityTopRow = (entityTopWorldY- manKind.getSpeed())/gp.tileSize;
                tileNum1 = gp.tileM.setMapTileNum([entityLeftCol],[entityTopRow]);
                tileNum2 = gp.tileM.setMapTileNum([entityRightCol],[entityTopRow]);
                if(gp.tileM.setTile(tileNum1).collision == true){

                }
        }
    }
}

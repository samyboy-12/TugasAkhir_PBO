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
                tileNum1 = gp.tileM.getMapTileNum()[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.getMapTileNum()[entityRightCol][entityTopRow];
                if(gp.tileM.getTile()[tileNum1].isCollision() == true || gp.tileM.getTile()[tileNum2].isCollision() == true){
                    manKind.setCollisionOn(true);
                }
                break;
                case "down":
                    entityBottomRow = (entityBottomWorldY+manKind.getSpeed())/gp.tileSize;
                    tileNum1 = gp.tileM.getMapTileNum()[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.getMapTileNum()[entityRightCol][entityBottomRow];
                    if(gp.tileM.getTile()[tileNum1].isCollision() == true || gp.tileM.getTile()[tileNum2].isCollision() == true){
                        manKind.setCollisionOn(true);
                    }
                    break;
                    case "left":
                        entityLeftCol = (entityLeftWorldX- manKind.getSpeed())/gp.tileSize;
                        tileNum1 = gp.tileM.getMapTileNum()[entityLeftCol][entityTopRow];
                        tileNum2 = gp.tileM.getMapTileNum()[entityLeftCol][entityBottomRow];
                        if(gp.tileM.getTile()[tileNum1].isCollision() == true || gp.tileM.getTile()[tileNum2].isCollision() == true){
                            manKind.setCollisionOn(true);
                        }
                        break;
                        case "right":
                            entityRightCol = (entityRightWorldX+manKind.getSpeed())/gp.tileSize;
                            tileNum1 = gp.tileM.getMapTileNum()[entityRightCol][entityTopRow];
                            tileNum2 = gp.tileM.getMapTileNum()[entityRightCol][entityBottomRow];
                            if(gp.tileM.getTile()[tileNum1].isCollision() == true || gp.tileM.getTile()[tileNum2].isCollision() == true){
                                manKind.setCollisionOn(true);
                            }break;
        }
    }
}

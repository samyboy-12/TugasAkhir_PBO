package main;

import Entity.ManKind;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(ManKind manKind){
        int entityLeftWorldX = manKind.x+ manKind.solidArea.x;
        int entityRightWorldX = manKind.x + manKind.solidArea.x + manKind.solidArea.width;
        int entityTopWorldY = manKind.y + manKind.solidArea.y;
        int entityBottomWorldY = manKind.y + manKind.solidArea.y + manKind.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1,tileNum2;
        switch(manKind.direction){
            case "up":
                entityTopRow = (entityTopWorldY- manKind.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    manKind.collisionOn=true;
                }
                break;
                case "down":
                    entityBottomRow = (entityBottomWorldY+manKind.speed)/gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                    if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                        manKind.collisionOn=true;
                    }
                    break;
                    case "left":
                        entityLeftCol = (entityLeftWorldX- manKind.speed)/gp.tileSize;
                        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                        tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                        if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                            manKind.collisionOn=true;
                        }
                        break;
                        case "right":
                            entityRightCol = (entityRightWorldX+manKind.speed)/gp.tileSize;
                            System.out.println(entityRightCol);
                            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                                manKind.collisionOn=true;
                            }
                            break;
        }
    }
}

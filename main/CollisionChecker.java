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
                try{
                    entityTopRow = (entityTopWorldY- manKind.speed)/gp.tileSize;
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                        manKind.collisionOn=true;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(manKind.x == 724);
                    if(manKind.x == 724){
                        manKind.collisionOn=false;
                    }
                    manKind.collisionOn=false;
                }

                break;
                case "down":
                    try{
                        entityBottomRow = (entityBottomWorldY+manKind.speed)/gp.tileSize;
                        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                        tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                        if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true ){
                            manKind.collisionOn=true;
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        manKind.collisionOn=true;
                    }

                    break;
                    case "left":
                        try{
                            entityLeftCol = (entityLeftWorldX- manKind.speed)/gp.tileSize;
                            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                                manKind.collisionOn=true;
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.println(manKind.x == 724);
                            if(manKind.x == 724){
                                manKind.collisionOn=false;
                            }
                            manKind.collisionOn=false;
                        }

                        break;
                        case "right":
                            try{
                                entityRightCol = (entityRightWorldX+manKind.speed)/gp.tileSize;
                                System.out.println(entityRightCol);
                                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                                    manKind.collisionOn=true;
                                }
                            }catch (ArrayIndexOutOfBoundsException e){
                                System.out.println(manKind.x == 724);
                                if(manKind.x == 724){
                                    manKind.collisionOn=false;
                                }
                                manKind.collisionOn=false;
                            }

                            break;
        }
    }
    public int checkObject(ManKind manKind, boolean maincharacter){
        int index = 999;
        for(int i = 0; i<gp.obj.length; i++){
            if(gp.obj[i] != null){
                //get the entity's solid area position
                manKind.solidArea.x = manKind.x + manKind.solidArea.y;
                manKind.solidArea.y = manKind.y + manKind.solidArea.y;
                //object's absis and ordinate
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(manKind.direction){
                    case "up":
                        manKind.solidArea.y -= manKind.speed;
                        if(manKind.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                manKind.collisionOn=true;
                            }
                            if(maincharacter==true){
                                index = i;
                            }
                        }
                        break;
                        case "down":
                            manKind.solidArea.y += manKind.speed;
                            if(manKind.solidArea.intersects(gp.obj[i].solidArea)){
                                if(gp.obj[i].collision == true){
                                    manKind.collisionOn=true;
                                }
                                if(maincharacter==true){
                                    index = i;
                                }
                            }
                            break;
                            case "left":
                                manKind.solidArea.x -= manKind.speed;
                                if(manKind.solidArea.intersects(gp.obj[i].solidArea)){
                                    if(gp.obj[i].collision == true){
                                        manKind.collisionOn=true;
                                    }
                                    if(maincharacter==true){
                                        index = i;
                                    }
                                }
                                break;
                                case "right":
                                    manKind.solidArea.x += manKind.speed;
                                    if(manKind.solidArea.intersects(gp.obj[i].solidArea)){
                                        if(gp.obj[i].collision == true){
                                            manKind.collisionOn=true;
                                        }
                                        if(maincharacter==true){
                                            index = i;
                                        }
                                    }
                                    break;
                }
                manKind.solidArea.x = manKind.solidAreaDefaultX;
                manKind.solidArea.y = manKind.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}

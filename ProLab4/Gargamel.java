package ProLab4;

import javax.swing.*;
import java.awt.*;

public class Gargamel extends Enemy {

    private final Location grLoc;
    private int doorX,doorY;
    private final Image Gargamel;
    private int [] intDivideX;
    private int [] intDivideY;

    public Gargamel() {
        grLoc = new Location();
        ImageIcon img = new ImageIcon("pics6map\\g1.png");
        Gargamel = img.getImage();
       grLoc.setX(3);
       grLoc.setY(0);
    }

    public void shortestRoad(BrainySmurf bs, LazySmurf ls,boolean brainy) {

            int tempX ;
            int tempY ;
          if(!brainy){
                if(((ls.getTileX()-getTileX()==1 || ls.getTileX()-getTileX()==-1)  && ls.getTileY()==getTileY())^(ls.getTileX()==getTileX() && (ls.getTileY()-getTileY()==1 || ls.getTileY()-getTileY()==-1))){
                    tempX =getIntDivideX()[1]-getIntDivideX()[0];
                    tempY =getIntDivideY()[1]-getIntDivideY()[0];
                }
                else{
                    tempX = getIntDivideX()[2]-getIntDivideX()[0];
                    tempY = getIntDivideY()[2]-getIntDivideY()[0];
                }
            }
            else{
                if(((bs.getTileX()-getTileX()==1 || bs.getTileX()-getTileX()==-1)  && bs.getTileY()==getTileY())^(bs.getTileX()==getTileX() && (bs.getTileY()-getTileY()==1 || bs.getTileY()-getTileY()==-1))){
                    tempX = getIntDivideX()[1]-getIntDivideX()[0];
                    tempY = getIntDivideY()[1]-getIntDivideY()[0];
                }
                else{
                    tempX = getIntDivideX()[2]-getIntDivideX()[0];
                    tempY = getIntDivideY()[2]-getIntDivideY()[0];
                }
            }

        int tmp=grLoc.getX();
        tmp+=tempX;
        grLoc.setX(tmp);

        tmp=grLoc.getY();
        tmp+=tempY;
        grLoc.setY(tmp);

    }

    public void boldijkstrapath(LazySmurf ls,BrainySmurf bs,boolean brainy)
    {
       ShowGraph gs = new ShowGraph();
        String pathstring;
        if(brainy){
             pathstring= gs.enemyRoad(getTileY(),getTileX(),bs.getTileY(), bs.getTileX());
        }
        else{
             pathstring= gs.enemyRoad(getTileY(),getTileX(),ls.getTileY(), ls.getTileX());
        }

        String [] divide1 = pathstring.split(",");
        int j=0;
        int k=0;
        intDivideX= new int[divide1.length/2];
        intDivideY= new int [divide1.length/2];
        int x;
        int y;

        for(int i=0; i< divide1.length; i++ )
        {
            if(i%2==0)
            {
                x=Integer.parseInt(divide1[i]);
                intDivideX[k]=x;
                k++;
            }
            else
            {
                y=Integer.parseInt(divide1[i]);
                intDivideY[j]=y;
                j++;
            }
        }

    }

    public Image getGargamel(){
        return Gargamel;
    }

    public int[] getIntDivideX() {return intDivideX;}
    public int[] getIntDivideY() {return intDivideY;}

    public int getTileX() {
        return grLoc.getX();
    }
    public void setTileX(int tileX) {grLoc.setX(tileX);}

    public int getTileY() {
        return grLoc.getY();
    }
    public void setTileY(int tileY) {grLoc.setY(tileY);}

    public int getDoorX() {return doorX;}
    public void setDoorX(int doorX) {
        this.doorX=doorX;
        grLoc.setX(doorX);}
    public int getDoorY() {return doorY;}
    public void setDoorY(int doorY) {
        this.doorY=doorY;
        grLoc.setY(doorY);}
}

package ProLab4;

import javax.swing.*;
import java.awt.*;

public class Azman extends Enemy {

    private Location azLoc;
    private int doorX,doorY;
    private Image Azman;
    private int [] intDivideX;
    private int [] intDivideY;

    public Azman() {
        azLoc= new Location();
        ImageIcon img = new ImageIcon("pics6map\\a1.png");
        Azman=img.getImage();
        azLoc.setX(10);
        azLoc.setY(0);
    }

    public void shortestRoad() {

        int tempX = getIntDivideX()[1]-getIntDivideX()[0];
        int tempY = getIntDivideY()[1]-getIntDivideY()[0];

        int tmp=azLoc.getX();
         tmp+=tempX;
         azLoc.setX(tmp);

          tmp=azLoc.getY();
          tmp+=tempY;
          azLoc.setY(tmp);
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
        String [] divideX= new String[divide1.length/2];
        String [] divideY= new String[divide1.length/2];
        intDivideX= new int[divide1.length/2];
        intDivideY= new int [divide1.length/2];
        int x;
        int y;

        for(int i=0; i< divide1.length; i++ )
        {
            if(i%2==0)
            {
                x=Integer.valueOf(divide1[i]);
                intDivideX[k]=x;
                k++;
            }
            else
            {
                y=Integer.valueOf(divide1[i]);
                intDivideY[j]=y;
                j++;
            }
        }
    }

    public Image getAzman(){
        return Azman;
    }

    public int[] getIntDivideX() {return intDivideX;}
    public int[] getIntDivideY() {return intDivideY;}

    public int getTileX() {
        return azLoc.getX();
    }
    public void setTileX(int tileX) {azLoc.setY(tileX);}

    public int getTileY() {
        return azLoc.getY();
    }
    public void setTileY(int tileY) {azLoc.setY(tileY);}

    public int getDoorX() {return doorX;}
    public void setDoorX(int doorX) {
        this.doorX=doorX;
        azLoc.setX(doorX);}
    public int getDoorY() {return doorY;}
    public void setDoorY(int doorY) {
        this.doorY=doorY;
        azLoc.setY(doorY);}
}
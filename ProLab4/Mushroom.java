package ProLab4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Mushroom extends Object {

    private Image Mushroom;
    private int value=50;
    private Location mshrmLoc;
    private Map m;

    public Mushroom(){
        ImageIcon img = new ImageIcon("pics6map\\mushroom.png");
        Mushroom = img.getImage();
        mshrmLoc = new Location();
        m= new Map();
    }

    public void rand() {
        int temp=0;
        while(temp==0){
            Random rnd = new Random();
            int x1 = rnd.nextInt(13);
            Random rndy = new Random();
            int  y1 = rndy.nextInt(11);
            if (m.getMap(x1, y1).equals("1")) {
                mshrmLoc.setX(x1);
                mshrmLoc.setY(y1);
                temp++;
            }
            else{
                temp=0;
            }}

    }


    public Image getMushroom() {return Mushroom;}
    public int  getX(){return mshrmLoc.getX();}
    public int getY(){return mshrmLoc.getY();}

    public void setX(int x) {mshrmLoc.setX(x);}
    public void setY(int y) {mshrmLoc.setX(y);}

    public int getValue(){return value;}


}

package ProLab4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Gold extends Object {
    private final Image Gold;
    private final int value=15;
    private Location glLoc;
    private Map m;
    private ArrayList<Gold> goldL= new ArrayList(5);

    public Gold() {

        ImageIcon img = new ImageIcon("pics6map\\gold.png");
        Gold = img.getImage();
        glLoc = new Location();
        m= new Map();

    }


    public ArrayList<ProLab4.Gold> getGoldL() {return goldL;}
    public void setGoldL(ArrayList<ProLab4.Gold> goldL) {this.goldL = goldL;}

    public Image getGold() {
        return Gold;
    }
    public int getValue() {
        return value;
    }

    public int getX() {
        return glLoc.getX();
    }
    public int getY() {
        return glLoc.getY();
    }

    public void setX(int x) {glLoc.setX(x);}
    public void setY(int y) {glLoc.setY(y);}

    public void rand() {
        int temp=0;
        while(temp==0){
            Random rnd = new Random();
            int x1 = rnd.nextInt(13);
            Random rndy = new Random();
            int  y1 = rndy.nextInt(11);
            if (m.getMap(x1, y1).equals("1")) {
                glLoc.setX(x1);
                glLoc.setY(y1);
                temp++;
            }
            else{
                temp=0;
            }}

    }

}



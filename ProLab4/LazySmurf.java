package ProLab4;

import javax.swing.*;
import java.awt.*;

public class LazySmurf extends Player{

    private Location lsLoc;
    private Image LazySmurf;
    private int score=20;

    public LazySmurf() {
        lsLoc=new Location();

        ImageIcon img = new ImageIcon("pics6map\\s2.png");
        LazySmurf=img.getImage();

        lsLoc.setX(6);
        lsLoc.setY(5);
    }
    public void move(int tx,int ty) {
        int temp = lsLoc.getX()+tx;
        lsLoc.setX(temp);
        temp=lsLoc.getY()+ty;
        lsLoc.setY(temp);
    }


    public Image getLazySmurf(){
        return LazySmurf;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score += score;
    }

    public int getTileX() {
        return lsLoc.getX();
    }
    public int getTileY() {
        return lsLoc.getY();
    }


}


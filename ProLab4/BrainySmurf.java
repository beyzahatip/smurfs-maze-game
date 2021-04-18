package ProLab4;

import javax.swing.*;
import java.awt.*;

public class BrainySmurf extends Player {

    private Location bsLoc;
    private Image BrainySmurf;
    private int score=20;

    public BrainySmurf() {
        bsLoc = new Location();

        ImageIcon img = new ImageIcon("pics6map\\s3.png");
        BrainySmurf=img.getImage();

        bsLoc.setX(6);
        bsLoc.setY(5);
    }
    public void move(int tx,int ty) {

        int temp = bsLoc.getX()+tx;
        bsLoc.setX(temp);
        temp = bsLoc.getY()+ty;
        bsLoc.setY(temp);
    }



    public Image getBrainySmurf(){
        return BrainySmurf;
    }


    @Override
    public int getScore() {
        return score;
    }
    @Override
    public void setScore(int score) {this.score += score;}

    public int getTileX() {
        return bsLoc.getX();
    }
    public int getTileY() {
        return bsLoc.getY();
    }
}

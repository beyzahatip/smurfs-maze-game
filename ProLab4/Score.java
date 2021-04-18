package ProLab4;

import java.awt.*;
public class Score extends Player {
    private String Score= "";
    public Score() {
        Score ="SCORE: 20";
    }

    public void showScore(Graphics g,boolean kind,BrainySmurf bS,LazySmurf lS){
        //if kind is true Player Kind is Brainy Smurf
        if(kind){
            Score = "SCORE: " + String.valueOf(bS.getScore());
            g.setColor(new Color(168, 90, 16));
            g.setFont(new Font("Dialog", Font.BOLD, 9));
            g.drawString(Score, 650, 40);
        }
        else{
            Score = "SCORE: " + String.valueOf(lS.getScore());
            g.setColor(new Color(168, 90, 16));
            g.setFont(new Font("Dialog", Font.BOLD, 9));
            g.drawString(Score, 650, 40);
        }
    }


    public String getSscore() {return Score;}

    public void setScore(String score) {Score = score;}
}

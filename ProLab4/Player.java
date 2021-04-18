package ProLab4;

import java.awt.*;

public class Player extends Character {

    private int playerID;
    private String playerName;
    private String playerKind;
    private int score;

    public Player() {

    }

    public void showScore(Graphics g){}

    public int getPlayerID() {
        return playerID;
    }
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerKind() {
        return playerKind;
    }
    public void setPlayerKind(String playerKind) {
        this.playerKind = playerKind;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}

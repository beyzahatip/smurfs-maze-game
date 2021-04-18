package ProLab4;

public class Enemy extends Character {
    private int enemyID;
    private String enemyName;
    private String enemyKind;
    public Enemy(){

    }

    public void shortestRoad(int tx,int ty){}



    public int getEnemyID() {return enemyID;}
    public void setEnemyID(int enemyID) {this.enemyID = enemyID;}

    public String getEnemyKind() {return enemyKind;}
    public void setEnemyKind(String enemyKind) {this.enemyKind = enemyKind;}

    public String getEnemyName() {return enemyName;}
    public void setEnemyName(String enemyName) {this.enemyName = enemyName;}

}

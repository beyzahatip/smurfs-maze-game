package ProLab4;

public class Character {
    private int ID;
    private String name;
    private String characterKind;
    private Location locC;

    public  Character(){}
    public void shortestRoad(){}


    public String getCharacterKind() {return characterKind;}
    public void setCharacterKind(String characterKind) { this.characterKind = characterKind;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getID() {return ID;}
    public void setID(int ID) { this.ID = ID;}
    public int getX() {return locC.getX();}
    public void setX(int x) { locC.setX(x);}
    public int getY() {return locC.getY();}
    public void setY(int y) {locC.setY(y);}
}

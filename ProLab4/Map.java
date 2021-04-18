package ProLab4;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Map {
    private Scanner s,s1;
    private final String[] Map =new String[11];
    private String [] Character= new String[2];
    private final Image road,djG,djA;
    private final Image sirine;
    private final Image but1,but2;
    private final Image wall;
    private final Image entryA,entryB,entryC,entryD;
    private final Image startBackground,winScreen,lostScreen,nameTag;
    private String[] ENEMY,DOOR;

    public Map(){
        ImageIcon img=new ImageIcon("pics6map\\road.png");
        road = img.getImage();
        img=new ImageIcon("pics6map\\djG.png");
        djG = img.getImage();
        img=new ImageIcon("pics6map\\djA.png");
        djA = img.getImage();
        img=new ImageIcon("pics6map\\wall4.png");
        wall = img.getImage();
        img=new ImageIcon("pics6map\\s1.png");
        sirine = img.getImage();
        img = new ImageIcon("pics6map\\A.png");
        entryA=img.getImage();
        img = new ImageIcon("pics6map\\B.png");
        entryB=img.getImage();
        img = new ImageIcon("pics6map\\C.png");
        entryC=img.getImage();
        img = new ImageIcon("pics6map\\D.png");
        entryD=img.getImage();
        img = new ImageIcon("pics6map\\smurfs.jpg");
        startBackground=img.getImage();
        img = new ImageIcon("pics6map\\but1.png");
        but1=img.getImage();
        img = new ImageIcon("pics6map\\but2.png");
        but2=img.getImage();
        img = new ImageIcon("pics6map\\nametag.png");
        nameTag=img.getImage();
        img = new ImageIcon("pics6map\\winscreen.png");
        winScreen=img.getImage();
        img = new ImageIcon("pics6map\\lostscreen.png");
        lostScreen=img.getImage();


        openFile();
        readFile();
        closeFile();
    }

    public Image getRoad(){
        return road;
    }
    public Image getDJG(){return djG;}
    public Image getDJA(){return djA;}
    public Image getWall(){
        return wall;
    }
    public Image getSirine(){ return sirine;}
    public Image getEntryA(){return entryA;}
    public Image getEntryB(){return entryB;}
    public Image getEntryC(){return entryC;}
    public Image getEntryD(){return entryD;}

    public Image getStartBackground() {return startBackground;}
    public Image getWinScreen() {return winScreen;}
    public Image getLostScreen() {return lostScreen;}
    public Image getButton1() {return but1;}
    public Image getButton2() {return but2;}
    public Image getNameTag(){return nameTag;}

    public String[] getDOOR() {return DOOR;}
    public String[] getENEMY() {return ENEMY;}

    public String getMap(int x, int y){return Map[y].substring(x, x + 1);}
    public String[] getCharacter() {return Character;}

    public void openFile(){
        try {
            s = new Scanner(new File("pics6map\\map.txt"));
            s1 = new Scanner(new File("pics6map\\map.txt"));
        }catch (Exception e){
            System.out.println("!!!ERROR LOADING MAP!!!");
        }
    }
    public void readFile(){

       int count=0;
        while(s1.hasNext()){
            s1.next();
            count++;
            }

        Character =new String[count-11];
        ENEMY = new String[count-11];
        DOOR = new String[count-11];
        for(int i=0;i<count-11;i++){
            Character[i]=s.next();
            String[] splitted = Character[i].split("[:,]");
            ENEMY[i] = splitted[1];
            DOOR[i] = splitted[3];
        }
        while(s.hasNext()){
            for(int i=0;i<11;i++){
                Map[i]=s.next();
            }
        }
    }

    public void closeFile(){
    }
}

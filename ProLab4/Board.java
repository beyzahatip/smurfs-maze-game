package ProLab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    private final Map m;
    private final LazySmurf lySmurf;
    private final BrainySmurf brSmurf;
    private final Gold gl;


    private final Mushroom mrm;
    private final Gargamel gargamel;
    private final Azman azman;


    private boolean win = false;
    private boolean lost = false;
    private boolean startScreen = true;
    private boolean brainy = true;
    public boolean isDrawObjectG = false;
    public boolean isDrawObjectM = false;
    //if 0 enemy gargamel
    //if 1 enemy azman
    //if 2 both of them
    public int whichEnemy=0;

    private Random rand = new Random();
    int time = 0;
    int duration = 200;
    int random = rand.nextInt(10);
    int randomMantar = rand.nextInt(15);

    private final Score scr;

    public Board() {

        lySmurf = new LazySmurf();
        brSmurf = new BrainySmurf();

        mrm = new Mushroom();
        gl = new Gold();

        azman = new Azman();
        gargamel = new Gargamel();
        scr = new Score();


        addKeyListener(new Al());
        setFocusable(true);
        m = new Map();
        setBackground(new Color(153, 209, 130));
        initGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //kazanma durumu
        if (lySmurf.getTileX() == 13 && lySmurf.getTileY() == 7 || brSmurf.getTileX() == 13 && brSmurf.getTileY() == 7) {
            win = true;
        }
        if (lySmurf.getScore() <= 0 || brSmurf.getScore() <= 0) {
            lost = true;
        }
        time += 1;
        repaint();
    }

    private void initGame() {
        readEnemyAndDoor();
        Gold gl1 = new Gold();
        Gold gl2 = new Gold();
        Gold gl3 = new Gold();
        Gold gl4 = new Gold();
        Gold gl5 = new Gold();
        gl.getGoldL().add(gl1);
        gl.getGoldL().add(gl2);
        gl.getGoldL().add(gl3);
        gl.getGoldL().add(gl4);
        gl.getGoldL().add(gl5);
        for (int i = 0; i < 5; i++) {
            gl.rand();
            gl.getGoldL().get(i).setX(gl.getX());
            gl.getGoldL().get(i).setY(gl.getY());
        }
        mrm.rand();

        if (brainy) {
            switch (whichEnemy){
                case 0:
                    gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                case 1:
                    azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                case 2:
                    gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                    azman.boldijkstrapath(lySmurf, brSmurf, brainy);

            }}
        else {
            switch (whichEnemy){
                case 0:
                    gargamel.boldijkstrapath( lySmurf, brSmurf, brainy);
                case 1:
                    azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                case 2:
                    gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                    azman.boldijkstrapath( lySmurf, brSmurf, brainy);

            }
            }

        Timer timer = new Timer(25, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g);
        if (startScreen) {
            startSscreen(g);

        }
        if (!win && !startScreen && !lost) {

            drawMap(g);
            drawShortestRoad(g, gargamel.getIntDivideX(), gargamel.getIntDivideY(),azman.getIntDivideX(), azman.getIntDivideY(),whichEnemy);
            drawCharacter(g);
            drawObjects(g);
            checkCollision();

        }
        if (win) {
            winScreen(g);
        }
        if (lost) {
            lostScreen(g);
        }
    }

    public void drawObjects(Graphics g) {

        if (time > random * 40)
            if (time < random * 40 + duration) {
                isDrawObjectG=true;
                for (int i = 0; i < 5; i++) {
                    g.drawImage(gl.getGold(), gl.getGoldL().get(i).getX() * 52, gl.getGoldL().get(i).getY() * 52, null);
                }

            }

        if (time > randomMantar * 40)
            if (time < randomMantar * 40 + duration) {
                isDrawObjectM=true;
                    g.drawImage(mrm.getMushroom(), mrm.getX() * 50, mrm.getY() * 50, null);

            }


    }

    public void drawCharacter(Graphics g) {

        if (brainy) {
            g.drawImage(brSmurf.getBrainySmurf(), brSmurf.getTileX() * 50, brSmurf.getTileY() * 50, null);
        } else {
            g.drawImage(lySmurf.getLazySmurf(), lySmurf.getTileX() * 50, lySmurf.getTileY() * 50, null);
        }


    }

    public void checkCollision() {
        if (!brainy) {

            switch (whichEnemy){
                case 0:
                    if (lySmurf.getTileX() == gargamel.getTileX() && lySmurf.getTileY() == gargamel.getTileY()) {
                     gargamel.setTileY(gargamel.getDoorY());
                     gargamel.setTileX(gargamel.getDoorX());
                     lySmurf.setScore(-15);}

                case 1:
                    if (lySmurf.getTileX() == azman.getTileX() && lySmurf.getTileY() == azman.getTileY()) {
                     azman.setTileX(azman.getDoorX());
                     azman.setTileY(azman.getDoorY());
                     lySmurf.setScore(-5);}

                case 2:
                    if (lySmurf.getTileX() == gargamel.getTileX() && lySmurf.getTileY() == gargamel.getTileY()) {
                        gargamel.setTileY(gargamel.getDoorY());
                        gargamel.setTileX(gargamel.getDoorX());
                        lySmurf.setScore(-15);}

                    if (lySmurf.getTileX() == azman.getTileX() && lySmurf.getTileY() == azman.getTileY()) {
                        azman.setTileX(azman.getDoorX());
                        azman.setTileY(azman.getDoorY());
                        lySmurf.setScore(-5);}
            }

            if (isDrawObjectG) {
                for(int i=0;i<5;i++){
                    if (lySmurf.getTileY() == gl.getGoldL().get(i).getY() && lySmurf.getTileX() == gl.getGoldL().get(i).getX()) {
                        lySmurf.setScore(gl.getValue());
                        gl.getGoldL().get(i).setX(15);
                        gl.getGoldL().get(i).setY(16);
                    }
                }

            }
            if(isDrawObjectM){
                if (lySmurf.getTileX() == mrm.getX() && lySmurf.getTileY() == mrm.getY()) {
                    mrm.setX(15);
                    mrm.setY(15);
                    lySmurf.setScore(mrm.getValue());
                }
            }

        } else {
            if(isDrawObjectG){
                    for(int i=0;i<5;i++){
                        if (brSmurf.getTileY() == gl.getGoldL().get(i).getY() && brSmurf.getTileX() == gl.getGoldL().get(i).getX()) {
                            brSmurf.setScore(gl.getValue());
                            gl.getGoldL().get(i).setX(15);
                            gl.getGoldL().get(i).setY(16);
                        }
                    }
            }
            if(isDrawObjectM){
                if (brSmurf.getTileX() == mrm.getX() && brSmurf.getTileY() == mrm.getY()) {
                    mrm.setX(15);
                    mrm.setY(15);
                    brSmurf.setScore(mrm.getValue());
                }
            }
            switch (whichEnemy){
                case 0:
                    if (brSmurf.getTileX() == gargamel.getTileX() && brSmurf.getTileY() == gargamel.getTileY()) {
                        gargamel.setTileY(gargamel.getDoorY());
                        gargamel.setTileX(gargamel.getDoorX());
                        brSmurf.setScore(-15);
                    }
                case 1:
                    if (brSmurf.getTileX() == azman.getTileX() && brSmurf.getTileY() == azman.getTileY()) {
                        azman.setTileX(gargamel.getDoorX());
                        azman.setTileY(gargamel.getDoorY());
                        brSmurf.setScore(-5);
                    }
                case 2:
                    if (brSmurf.getTileX() == azman.getTileX() && brSmurf.getTileY() == azman.getTileY()) {
                        azman.setTileX(gargamel.getDoorX());
                        azman.setTileY(gargamel.getDoorY());
                        brSmurf.setScore(-5);
                    }
                    if (brSmurf.getTileX() == gargamel.getTileX() && brSmurf.getTileY() == gargamel.getTileY()) {
                        gargamel.setTileY(gargamel.getDoorY());
                        gargamel.setTileX(gargamel.getDoorX());
                        brSmurf.setScore(-15);
                    }

            }
        }

    }

    public void readEnemyAndDoor(){
        m.getDOOR();
        m.getENEMY();
        for(int i=0;i<m.getDOOR().length;i++) {
            switch (m.getDOOR()[i]) {
                case "A":
                    if(m.getENEMY()[i].equals("Gargamel")){
                        gargamel.setDoorX(3);
                        gargamel.setDoorY(0);
                        whichEnemy=0;
                    }
                    else if(m.getENEMY()[i].equals("Azman")){
                        azman.setDoorX(3);
                        azman.setDoorY(0);
                        whichEnemy=1;
                    }

                    break;
                case "B":
                    if(m.getENEMY()[i].equals("Gargamel")){
                        gargamel.setDoorX(10);
                        gargamel.setDoorY(0);
                        whichEnemy=0;
                    }
                    else if(m.getENEMY()[i].equals("Azman")){
                        azman.setDoorX(10);
                        azman.setDoorY(0);
                        whichEnemy=1;
                    }


                    break;
                case "C":
                    if(m.getENEMY()[i].equals("Gargamel")){
                        gargamel.setDoorX(0);
                        gargamel.setDoorY(5);
                        whichEnemy=0;
                    }
                    else if(m.getENEMY()[i].equals("Azman")){
                        azman.setDoorX(0);
                        azman.setDoorY(5);
                        whichEnemy=1;
                    }

                    break;
                case "D":
                    if(m.getENEMY()[i].equals("Gargamel")){
                        gargamel.setDoorX(3);
                        gargamel.setDoorY(10);
                        whichEnemy=0;
                    }
                    else if(m.getENEMY()[i].equals("Azman")){
                        azman.setDoorX(3);
                        azman.setDoorY(10);
                        whichEnemy=1;
                    }
                    break;
            }
        }
        if(m.getENEMY().length==2){
            whichEnemy=2;
        }
    }
    public void drawMap(Graphics g) {
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 13; x++) {
                if (m.getMap(x, y).equals("1")) {
                    if (x == 3 && y == 0) {
                        g.drawImage(m.getEntryA(), x * 50, y, null);
                    } else if (x == 10 && y == 0) {
                        g.drawImage(m.getEntryB(), x * 50, y, null);
                    } else if (x == 0 && y == 5) {
                        g.drawImage(m.getEntryC(), x, y * 50, null);
                    } else if (x == 3 && y == 10) {
                        g.drawImage(m.getEntryD(), x * 50, y * 50, null);
                    } else {
                        g.drawImage(m.getRoad(), x * 50, y * 50, null);
                    }
                }
                if (m.getMap(x, y).equals("0")) {
                    g.drawImage(m.getWall(), x * 50, y * 50, null);
                }
            }
        }
        g.drawImage(m.getSirine(), 13 * 50, 7 * 50, null);
        scr.showScore(g, brainy, brSmurf, lySmurf);
    }

    public void drawShortestRoad(Graphics g, int[] x, int[] y, int[] x1, int[] y1,int whichEnemy) {

                  if(whichEnemy==0){
                      for (int i = 1; i < x.length; i++) {
                          g.drawImage(m.getDJG(), x[i] * 50, y[i] * 50, null);
                          g.drawImage(gargamel.getGargamel(), gargamel.getTileX() * 50, gargamel.getTileY() * 50, null);
                      }
                  }
                  else if(whichEnemy==1){
                      for (int i = 1; i < x1.length; i++) {
                          g.drawImage(m.getDJA(), x1[i] * 50, y1[i] * 50, null);
                          g.drawImage(azman.getAzman(), azman.getTileX() * 50, azman.getTileY() * 50, null);
                      }
                  }
                  else if(whichEnemy==2) {

                      for (int i = 1; i < x.length; i++) {
                          g.drawImage(m.getDJG(), x[i] * 50, y[i] * 50, null);
                      }
                      for (int i = 1; i < x1.length; i++) {
                          g.drawImage(m.getDJA(), x1[i] * 50, y1[i] * 50, null);
                      }
                      g.drawImage(gargamel.getGargamel(), gargamel.getTileX() * 50, gargamel.getTileY() * 50, null);
                      g.drawImage(azman.getAzman(), azman.getTileX() * 50, azman.getTileY() * 50, null);
                  }

    }

    public void lostScreen(Graphics g) {
        g.drawImage(m.getLostScreen(), 0, 0, 718, 587, null);
    }

    public void winScreen(Graphics g) {
        g.drawImage(m.getWinScreen(), 0, 0, 718, 587, null);
        g.setColor(new Color(188, 206, 221));
        g.setFont(new Font("Dialog", Font.BOLD, 20));
        g.drawString(scr.getSscore(), 500, 30);
    }

    public void startSscreen(Graphics g) {
        g.drawImage(m.getStartBackground(), 0, 0, 718, 587, null);
        g.drawImage(m.getButton1(), 460, 220, null);
        g.drawImage(m.getButton2(), 460, 280, null);
        g.drawImage(m.getNameTag(), 400, 520, null);

    }


    public class Al extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (startScreen) {
                if (keycode == KeyEvent.VK_B) {
                    brainy = true;
                    startScreen = false;
                } else if (keycode == KeyEvent.VK_L) {
                    brainy = false;
                    startScreen = false;
                }
            }
            if (!brainy) {
                if (keycode == KeyEvent.VK_UP) {
                    if (!m.getMap(lySmurf.getTileX(), lySmurf.getTileY() - 1).equals("0")) {
                        gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                        azman.shortestRoad();
                        lySmurf.move(0, -1);
                       }
                        checkCollision();
                        azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                        gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);

                        }
                else if (keycode == KeyEvent.VK_DOWN) {
                    if (!m.getMap(lySmurf.getTileX(), lySmurf.getTileY() + 1).equals("0")) {

                                gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                azman.shortestRoad();
                                lySmurf.move(0, 1);

                               }
                                checkCollision();
                                azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);

                    }
                else if (keycode == KeyEvent.VK_LEFT) {
                    if (!m.getMap(lySmurf.getTileX() - 1, lySmurf.getTileY()).equals("0")) {
                            gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                            azman.shortestRoad();
                            lySmurf.move(-1, 0);
                                }
                                checkCollision();
                                azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);

                    }
                else if (keycode == KeyEvent.VK_RIGHT) {
                        if (lySmurf.getTileX() != 12 || lySmurf.getTileY() != 7) {
                            if (!m.getMap(lySmurf.getTileX() + 1, lySmurf.getTileY()).equals("0")) {
                                      gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                      azman.shortestRoad();
                                      lySmurf.move(1, 0);

                                        }
                                        checkCollision();
                                        azman.boldijkstrapath( lySmurf, brSmurf, brainy);
                                        gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                            }

                        else {
                            gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                            azman.shortestRoad();
                            lySmurf.move(1, 0);}
                            checkCollision();
                            azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                            gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);

                }
            }
            else {
                if (keycode == KeyEvent.VK_UP) {
                    if (!m.getMap(brSmurf.getTileX(), brSmurf.getTileY() - 1).equals("0") && !m.getMap(brSmurf.getTileX(), brSmurf.getTileY() - 2).equals("0")) {
                                gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                azman.shortestRoad();
                                brSmurf.move(0, -2);}
                                checkCollision();
                                azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                    }
                 else if (keycode == KeyEvent.VK_DOWN) {
                    if (!m.getMap(brSmurf.getTileX(), brSmurf.getTileY() + 1).equals("0") && !m.getMap(brSmurf.getTileX(), brSmurf.getTileY() + 2).equals("0")) {
                                gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                azman.shortestRoad();
                                brSmurf.move(0, 2);}
                                checkCollision();
                                azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                        }

                else if (keycode == KeyEvent.VK_LEFT) {
                        if (!m.getMap(brSmurf.getTileX() - 1, brSmurf.getTileY()).equals("0") && !m.getMap(brSmurf.getTileX() - 2, brSmurf.getTileY()).equals("0")) {
                                    gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                    azman.shortestRoad();
                                    brSmurf.move(-2, 0);}
                                    checkCollision();
                                    azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                    gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);
                            }

                else if (keycode == KeyEvent.VK_RIGHT) {
                        if (brSmurf.getTileX() != 12 || brSmurf.getTileY() != 7) {
                            if (!m.getMap(brSmurf.getTileX() + 1, brSmurf.getTileY()).equals("0") && !m.getMap(brSmurf.getTileX() + 2, brSmurf.getTileY()).equals("0")) {
                                        gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                        azman.shortestRoad();
                                        brSmurf.move(2, 0);}
                                        checkCollision();
                                        azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                        gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);

                            }
                        else  {
                                    gargamel.shortestRoad(brSmurf, lySmurf, brainy);
                                    azman.shortestRoad();
                                    brSmurf.move(1, 0);}
                                    checkCollision();
                                    azman.boldijkstrapath(lySmurf, brSmurf, brainy);
                                    gargamel.boldijkstrapath(lySmurf, brSmurf, brainy);

                        }
                }
        }
        public void keyRelased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent e) {

        }
    }
}


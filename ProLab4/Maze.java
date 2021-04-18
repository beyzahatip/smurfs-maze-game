package ProLab4;

import javax.swing.*;
import java.awt.*;

public class Maze {
    JFrame frame=new JFrame();
    public static void main(String[] args) {
        new Maze();
    }

    public Maze(){
        frame.setTitle("-Maze Game-");
        frame.setBackground(Color.GRAY);
        frame.add(new Board());
        frame.setSize(718,587);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

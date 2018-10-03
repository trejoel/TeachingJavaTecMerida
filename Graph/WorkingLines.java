package Graph;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorkingLines {

    public WorkingLines() {

        JFrame jf = new JFrame("Free Hand Drawing Example");
        JPanel draw = new DrawBoard();
        jf.add(new Label("Click....move mouse, click again"), BorderLayout.NORTH);
        jf.add(draw);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600, 500);
        jf.setVisible(true);
    }

    public static void main(String a[]) {
        new WorkingLines();
    }
}


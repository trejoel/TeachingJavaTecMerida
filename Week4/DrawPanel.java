package week4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int isCircle=1; //any other case is rectangle
    private ArrayList<Point> points;
    private ArrayList<Point> rectangles;

    public DrawPanel() {
        points = new ArrayList<Point>();
        rectangles=new ArrayList<Point>();
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	    if (isCircle==1) {
                      points.add(new Point(e.getX(), e.getY()));
                      repaint();            	    	
            	    }
            	    else {
                        rectangles.add(new Point(e.getX(), e.getY()));
                        repaint();                 	    	
            	    }
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        for (Point point : points) {
            g2.fillOval(point.x, point.y, 10, 10);
        }
        g2.setColor(Color.blue);
        for (Point point : rectangles) {
            g2.drawRect(point.x, point.y, 10, 10);
        }
    }
    
    public void setFigure(int x) {
    	   this.isCircle=x;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new DrawPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setVisible(true);
            }
        });
    }

}
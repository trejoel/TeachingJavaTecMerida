package Graph;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int isCircle=1; //any other case is rectangle
    private ArrayList<Point> points;
    private ArrayList<linea> lineas;
    private boolean enabled=true;
    Point pStart;
    Point pEnd;
    
    public ArrayList<Point> getPoints(){
    	   return this.points;
    }
    
    public ArrayList<linea> getlines(){
 	   return this.lineas;
 }

    public DrawPanel() {
        points = new ArrayList<Point>();
        lineas=new ArrayList<linea>();
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	if (enabled) {
            	    if (isCircle==1) {
                      points.add(new Point(e.getX(), e.getY()));
                      repaint();            	    	
            	    }
            	    else {
            	         	pStart = new Point(e.getPoint());             	    	
            	    }    
            	}
            }
            public void mouseReleased(MouseEvent e) {
            	   if (enabled) {
               // pStart = null;
               if (isCircle!=1) {
            	      pEnd = e.getPoint();

    	              linea l = new linea(new Point(pStart), new Point(pEnd));
            	      if (bothExtremesOfLine(l)) {
            	    	     int firstExtreme=verifyExists(l.getP1());
            	    	     int secondExtreme=verifyExists(l.getP2());
            	    	     l.setExtremes(firstExtreme, secondExtreme);
            	    		// System.out.println("Arista Nodo:"+firstExtreme+" con:"+secondExtreme);
        	              lineas.add(l);
            	      }
            	      else {
            	    	    pStart=pEnd=null;
            	      }
                  repaint();         	   
               }
            	   }
            }            
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                //pEnd = e.getPoint();
            }

            public void mouseDragged(MouseEvent e) {
               /* pEnd = e.getPoint();
    	           linea l = new linea(new Point(pStart), new Point(pEnd));
               lineas.add(l);               
                repaint();*/
            }
        });        
        
        
    }
    
    public boolean bothExtremesOfLine(linea l) {
    	   boolean  retVal=false;
    	   int firstExtreme=verifyExists(l.getP1());
    	   int secondExtreme=verifyExists(l.getP2());
    	   if (firstExtreme!=secondExtreme && 
    			   (firstExtreme>=0 && secondExtreme>=0)) {
    		   retVal=true;
    	   }
    	   return retVal;
    }
    
    public int verifyExists(Point pLine) {
    	   int retVal=-1;
    	   int posArrayList=0;
       for (Point point : points) {
    	        posArrayList++;
            if (getDistance(pLine, point)<20) {
            	   retVal=posArrayList;
            }
       }
    	   return retVal;
    }
    
    public double getDistance(Point xP1, Point xP2) {
    	   double retVal=0;
    	   double ejeX=Math.abs(xP1.getX()-xP2.getX());
    	   double ejeY=Math.abs(xP1.getY()-xP2.getY());
    	   retVal=Math.sqrt(ejeX*ejeX+ejeY*ejeY);
    	   return retVal;
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
        for (linea l : lineas) {
           // g2.drawRect(point.x, point.y, 10, 10);
        	    Point p1=l.getP1();
        	    Point p2=l.getP2();
        	    g2.drawLine(p1.x,p1.y,p2.x,p2.y);
        }
    }
    
    public void disable() {
    	 this.enabled=false;
    }
    
	public void removeLineas() {
		lineas.clear();
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

class linea{
	private Point p1;
	private Point p2;
	private int extremeOne;
	private int extremeTwo;
	
	linea (Point xp1, Point xp2){
		this.p1=xp1;
		this.p2=xp2;
		this.extremeOne=0;
		this.extremeTwo=0;
	}
	
	public void setExtremes(int X, int Y) {
		this.extremeOne=X;
		this.extremeTwo=Y;
	}
	
	public int getExtremeOne() {
		return this.extremeOne;
	}
	

	
	public int getExtremeTwo() {
		return this.extremeTwo;
	}
	
	public Point getP1() {
		return this.p1;
	}
	
	public Point getP2() {
		return this.p2;
	}	
}
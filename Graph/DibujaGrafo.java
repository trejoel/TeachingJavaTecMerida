package Graph;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DibujaGrafo extends JFrame
{
	private Graph G;
    private ArrayList<Point> points;
    private ArrayList<linea> lineas;
	
	public DibujaGrafo() {
	}
	
    public static void main(String[] args)
    {
        DibujaGrafo window = new DibujaGrafo();
        window.setVisible(true);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cont = window.getContentPane();
        cont.setLayout(new GridLayout(2,2));
        DrawPanel mypanel = new DrawPanel();
        JPanel BPanel = new JPanel();
        cont.add(mypanel);
        cont.add(BPanel);
        BPanel.setBackground(Color.blue);
        JButton button1,button2, button3, button4,button5,button6;
        button1 = new JButton("Línea");
        button2 = new JButton("Circulo");
        button3 = new JButton("Terminar");
        button4 = new JButton("Matriz Adj");
        button5=new JButton("Incidence");
        button6= new JButton("Complement");
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        BPanel.add(button1);
        BPanel.add(button2);
        BPanel.add(button3);
        BPanel.add(button4);
        BPanel.add(button5);
        BPanel.add(button6);
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
              	mypanel.setFigure(2);
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
              	mypanel.setFigure(1);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
              	mypanel.disable();
              	window.points=mypanel.getPoints();
              	window.lineas=mypanel.getlines();
              	int size=window.points.size();
              	window.G=new Graph(size);
              	int NodeId=0;
              	Node newNode;
              	for (Point p : window.points) {
              		NodeId++;
              		newNode=new Node(NodeId);
              		window.G.addNode(newNode);
              	}
                int exOne,exTwo;
               // Node node_one,node_two;
                //window.G.printAdjMatrix();
              	for (linea l : window.lineas) {
              		exOne=l.getExtremeOne();
              		exTwo=l.getExtremeTwo();
              		//node_one=window.G.getNode(exOne-1);
              	//	node_two=window.G.getNode(exTwo-1);
              		//Hacer metodo para obtener nodo de grafo por ID
              		//System.out.println("Nodo :"+exOne+" a:"+exTwo);
              		window.G.setEdge(exOne-1, exTwo-1);
              	}
              	button1.setEnabled(false);
              	button2.setEnabled(false);
              	button3.setEnabled(false);
              	button4.setEnabled(true);
              	button5.setEnabled(true);
              	button6.setEnabled(true);
              	//System.out.println("El grafo es de tamano:"+size);
            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
              	window.G.printAdjMatrix();
            }
        });    
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
              	window.G.printIncidenceList();
            }
        });  
        button6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	    window.G.ComplementGraph();
                mypanel.removeLineas();
                mypanel.repaint();
            }
        });        
    }
}
package week5;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DibujaGrafo extends JFrame
{
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
        JButton button1,button2;
        button1 = new JButton("Línea");
        button2 = new JButton("Circulo");
        BPanel.add(button1);
        BPanel.add(button2);
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
    }
}
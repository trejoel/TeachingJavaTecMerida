package week2;

import java.awt.*;
import javax.swing.*;

public class FrameLayout {
	public static void main(String[] args) {
		JFrame myFrame=new JFrame();
		myFrame.setForeground(Color.WHITE);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(new Point(10,50));
		myFrame.setSize(300, 120);
		myFrame.setTitle("Primer Forma");
		JButton button1=new JButton();
		button1.setText("Primer Boton");
		button1.setBackground(Color.blue);
        myFrame.add(button1);
		JButton button2=new JButton();
		button2.setText("Segundo Boton");
		button2.setBackground(Color.red);
		myFrame.add(button2);	
        myFrame.setResizable(false);
        myFrame.setLayout(new FlowLayout());
        myFrame.pack();
		myFrame.setVisible(true);
	}

}

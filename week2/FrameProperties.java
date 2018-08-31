package week2;

import java.awt.*;
import javax.swing.*;

public class FrameProperties {
	public static void main(String[] args) {
		JFrame myFrame=new JFrame();
		myFrame.setForeground(Color.WHITE);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(new Point(10,50));
		myFrame.setSize(300, 120);
		myFrame.setTitle("Primer Forma");
		myFrame.setResizable(false);
		myFrame.setVisible(true);
	}

}

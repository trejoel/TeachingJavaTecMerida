package week3;
import java.awt.*;  
import javax.swing.*;  
  
public class firstFlowLayout{  
  private JFrame f;  
  
  public firstFlowLayout(){  
    f=new JFrame(); 
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    JButton b1=new JButton("1");  
    JButton b2=new JButton("2");  
    JButton b3=new JButton("3");  
    JButton b4=new JButton("4");  
    JButton b5=new JButton("5");  
    //b5.setPreferredSize(new Dimension(100,45));

              
    f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);  
      
    f.setLayout(new FlowLayout(FlowLayout.RIGHT));  
    //setting flow layout of right alignment  
  
    f.setSize(100,100);  
    f.setVisible(true);  
  }  
  
  public static void main(String[] args) {  
    new firstFlowLayout();  
  }  
}  
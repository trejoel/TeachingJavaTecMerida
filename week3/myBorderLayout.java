package week3;
import java.awt.*;  
import javax.swing.*;  
  
public class myBorderLayout{  
  private JFrame f;  
  
  public myBorderLayout(){  
    f=new JFrame(); 
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    JButton b1=new JButton("Norte");  
    JButton b2=new JButton("Sur");  
    JButton b3=new JButton("Este");  
    JButton b4=new JButton("Oeste");  
    JButton b5=new JButton("Centro"); 
    f.setLayout(new BorderLayout());  
    f.add(b1,BorderLayout.NORTH);
    f.add(b2,BorderLayout.SOUTH);
    f.add(b3,BorderLayout.EAST);
    f.add(b4,BorderLayout.WEST);
    f.add(b5,BorderLayout.CENTER);  
    //setting flow layout of right alignment  
 
    f.setSize(300,300);  
    f.setVisible(true);  
  }  
  
  public static void main(String[] args) {  
    new myBorderLayout();  
  }  
}  
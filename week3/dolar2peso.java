package week3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dolar2peso {
   private JFrame myFrame;
   private JButton convertButton;
   private JTextField txtPeso;
   private JTextField txtDolar;
   
   public dolar2peso() {
	   createForm();
   }
   
   public void createForm() {
	   myFrame=new JFrame();
	   myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       myFrame.setSize(new Dimension(250, 150));
       myFrame.setResizable(false);
       JPanel panWest = new JPanel(new GridLayout(2, 1));
       panWest.add(new JLabel("Peso: "));
       panWest.add(new JLabel("Dolar: "));
       
       JPanel panCenter = new JPanel(new GridLayout(2, 1));
       txtPeso=new JTextField(10);
       txtPeso.setText("0");
       txtDolar=new JTextField(10);
       txtDolar.setEnabled(false);
       panCenter.add(txtPeso);
       panCenter.add(txtDolar); 
       
       convertButton=new JButton("Convertir");
       //Listener
       convertButton.addActionListener(new convert2dolar());
       
       JPanel panEast = new JPanel(new FlowLayout());
       panEast.add(convertButton);
       
       myFrame.setLayout(new FlowLayout());
       myFrame.add(panWest);
       myFrame.add(panCenter);
       myFrame.add(panEast);
       myFrame.setVisible(true);
   }
   
   // Sets the label's text to show whether the credit card number is valid.
   public class convert2dolar implements ActionListener {
       public void actionPerformed(ActionEvent event) {
           String text = txtPeso.getText();
           float numberPesos=Float.parseFloat(text);
           float numberDolar=numberPesos/19;
           txtDolar.setText(Float.toString(numberDolar));
       }
   }   
   
   public static void main(String args[]) {
	   dolar2peso dolarFrame=new dolar2peso();
   }
}

package week2;

// A graphical equivalent of the classic "Hello world" program.

import javax.swing.*; // for GUI components

public class OptionPaneChoice {
	  
  public static void main(String[] args) {
	  
	     String nombre=JOptionPane.showInputDialog(null,"Cual es tu nombre");
	     int opcion=JOptionPane.showConfirmDialog(null, "Te gusta la Pizza?");
	     if (opcion==JOptionPane.YES_OPTION) {
	    	    nombre="Muy bien "+nombre+" a todos les gusta";
	     }
	     else {
	    	    nombre="Oilo "+nombre+"!! vacilas!!";
	     }
	     nombre=nombre+" la opcion fue:"+opcion;
  	     JOptionPane.showMessageDialog(null, nombre);
     } 
  }
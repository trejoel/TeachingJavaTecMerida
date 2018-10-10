package Hilos;

public class hiloName extends Thread {
	
	public void run(){  
		   System.out.println("En ejecución "+this.getName()); 
    } 
	
		 public static void main(String args[]){  
	      hiloName t1=new hiloName();  
		  hiloName t2=new hiloName();  
		  System.out.println("Hilo 1:"+t1.getName());
		  System.out.println("Hilo 2:"+t2.getName());
		  t1.setName("Hilo 0");
		  t2.setName("Hilo 1");
		  t1.start();  
		  t2.start();  

		  System.out.println("Hilo 1 despues cambio:"+t1.getName());
		  System.out.println("Hilo 2 despues cambio:"+t2.getName());
		  //t1.resume();
		  //System.out.println("Despues de cambiar el hilo t1:"+t1.getName());  
		 }  
}

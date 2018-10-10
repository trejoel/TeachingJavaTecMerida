package Hilos;

public class HiloRunnable implements Runnable {

    public void run(){
       System.out.println("Hilo Runnable");
    }
    
	public static void main(String[] args ) {
		HiloRunnable H=new HiloRunnable();
		Thread myThread=new Thread(H);
	    myThread.start();	
	}
    
  }
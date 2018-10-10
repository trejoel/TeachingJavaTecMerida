package Hilos;

public class CrearHilo extends Thread {
  
	private int Id;
	
	public CrearHilo(int x) {
		this.Id=x;
	}
	
	public int getidentificador() {
		return Id;
	}
	
  @Override
	public void run() {
		 System.out.println("Hilo en ejecución "+getidentificador());
	}
	
	
	public static void main(String[] args ) {
		CrearHilo myThread=new CrearHilo(1);
		CrearHilo myThread2=new CrearHilo(2);
	    myThread.start();
	    myThread2.start();
	}

}

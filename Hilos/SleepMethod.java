package Hilos;

public class SleepMethod extends Thread{  
	private int ID;
	
	public SleepMethod(int xid) {
		this.ID=xid;
	}
	
	public int getIdent() {
		return this.ID;
	}
	
	 public void run(){  
	  for(int i=1;i<=5;i++){  
	    try{
	      	Thread.sleep(1000);
	    	}
	     catch(InterruptedException e)
	    {
	    		System.out.println(e);
	    	}  
	    System.out.println("Hilo:"+this.getIdent()+"ejecución"+i);  
	  }  
	 }  
	 public static void main(String args[]){  
	  SleepMethod t1=new SleepMethod(1);  
	  SleepMethod t2=new SleepMethod(2); 
	  SleepMethod t3=new SleepMethod(3);
	   
	  t1.start();  
	  t2.start();  
	  t3.start();
	 }  
	}  
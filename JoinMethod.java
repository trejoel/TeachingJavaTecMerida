package Hilos;

public class JoinMethod extends Thread{  
	private int ID;
	
	public JoinMethod(int xid) {
		this.ID=xid;
	}
	
	public int getIdent() {
		return this.ID;
	}
	
	 public void run(){  
	  for(int i=1;i<=5;i++){  
	    try{
	      	Thread.sleep(500);
	    	}
	     catch(InterruptedException e)
	    {
	    		System.out.println(e);
	    	}  
	    System.out.println("Hilo:"+this.getIdent()+"ejecución"+i);  
	  }  
	 }  
	 public static void main(String args[]){  
	  JoinMethod t1=new JoinMethod(1);  
	  JoinMethod t2=new JoinMethod(2);  
	  JoinMethod t3=new JoinMethod(3);  

	   
	  t1.start();  
	  try {
		  t1.join();
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  t2.start();  
	  t3.start();
	 }  
	}  
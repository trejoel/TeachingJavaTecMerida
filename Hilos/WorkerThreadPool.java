package Hilos;


public class WorkerThreadPool implements Runnable {  
    private String message;  
    
    public WorkerThreadPool(String s){  
        this.message=s;  
    }  
     public void run() {  
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
    }  
     
    private void processmessage() {  
        try {  
        	Thread.sleep(2000); 
        } 
        catch (InterruptedException e) 
        { 
        	   e.printStackTrace(); 
        	}  
    }  
    
    public static void main(String[] args) {  
        
        for (int i = 0; i < 10; i++) {  
            Runnable worker = new WorkerThreadPool("" + i);  
            //There exists 5 threads in Thread Pool
            worker.run();
            //worker.run();
          }  
        
  
        System.out.println("Finished all threads");  
    }     
}  
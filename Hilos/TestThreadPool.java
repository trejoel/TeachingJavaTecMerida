package Hilos;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  

public class TestThreadPool {  
    public static void main(String[] args) {  
       ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
       
       for (int i = 0; i < 10; i++) {  
           Runnable worker = new WorkerThreadPool("" + i);  
           //There exists 5 threads in Thread Pool
           //worker.run();
           executor.execute(worker);//calling execute method of ExecutorService  
         }  
       
       executor.shutdown();  
       while (!executor.isTerminated()) {   }  
 
       System.out.println("Finished all threads");  
   }  
}  

//Ejecutar varias veces e identificar el orden en que se ejecutan los threads
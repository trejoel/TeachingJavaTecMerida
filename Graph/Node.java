package Graph;

import java.util.Enumeration;
import java.util.Vector;

public class Node {
   private int Id;
   private Vector<Node> Neighbors= new Vector();
   
   public Node(int xID) {
	   this.Id =xID;
   }
   
   public void setNeighbor(Node X) {
	   Neighbors.addElement(X);
   }
   
   public int getId() {
	   return this.Id;
   }
   
   public Node getNeighbor(int idPos) {
	   Node x=Neighbors.get(idPos);
	   return x;
   }
   
   public void incidenceList() {
	   Node X;
	   Enumeration En=Neighbors.elements();
	   System.out.print("Lista Incidencia del nodo:"+this.getId()+"::");
	   while(En.hasMoreElements()) {
		   X=(Node)En.nextElement();
		   System.out.print(X.Id+"-");
	   }
	   System.out.print("\n");
   }

}

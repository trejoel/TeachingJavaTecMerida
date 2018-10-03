package Graph;

import java.util.Enumeration;
import java.util.Vector;

public class Graph {
	private Vector<Node> Nodes= new Vector();
	private Vector<Edge> Edges = new Vector();
	private int[][] adjacencyMatrix;
	private int[][] complementMatrix;
	private int size;
	
	public Graph() {
		
	}
	
	public void setSize(int xSize) {
		this.size=xSize;
	}
	
	public Graph(int xSize) {
		this.size=xSize;
		this.adjacencyMatrix=new int[xSize][xSize];
		initiallizeAdjMatrix();
	}
	 
	protected void initiallizeAdjMatrix() {
		for (int i=0;i<size;i++)
			for (int j=0;j<size; j++)
				adjacencyMatrix[i][j]=0;
	}
	
	   public void addNode(Node X) {
		   Nodes.addElement(X);
	   }
	   
	   public Node getNode(int posArray) {
		  // System.out.println("Elemento:"+Nodes.get(posArray));
		   return Nodes.get(posArray);
	   }
	   
	   public void setEdge(int posFirst, int posSecond) {
		   Node NodeX, NodeY;
		   NodeX=this.getNode(posFirst);
		   NodeY=this.getNode(posSecond);
		   Edge newEdge=new Edge(NodeX,NodeY);
		  // System.out.println("Une "+NodeX.getId()+"con "+NodeY.getId());
		   Edges.add(newEdge);
		   adjacencyMatrix[posFirst][posSecond]=1;
		   adjacencyMatrix[posSecond][posFirst]=1;
	   }
	   
	   public void printIncidenceList() {
		   Node X;
		   Enumeration En=Nodes.elements();
		   while(En.hasMoreElements()) {
			   X=(Node)En.nextElement();
			   X.incidenceList();
		   }
	   }
	   
	   public void printAdjMatrix() {
		   for (int i=0;i<this.size;i++)
		   {
			   for (int j=0; j<this.size; j++)
			   {
				   System.out.print(this.adjacencyMatrix[i][j]);
			   }
			   System.out.print("\n");
		   }
	   }
	   
	   public void ComplementGraph() {
		   for (int i=0;i<this.size;i++)
		   {
			   for (int j=0; j<this.size; j++)
			   {
				   if (i!=j) {
					   if (this.adjacencyMatrix[i][j]==0) {
						   this.adjacencyMatrix[i][j]=1;
					   }
					   else
					   {
						   this.adjacencyMatrix[i][j]=0;
					   }
				   }
			   }
			   System.out.print("\n");
		   }
	   }
	   
	   public static void main(String[] args)
	    {
		   Node Node1,Node2,Node3;
		   Graph G=new Graph(3);
		   G.printAdjMatrix();
		   Node1=new Node(1);
		   Node2=new Node(2);
		   Node3=new Node(3);
		   G.addNode(Node1);
		   G.addNode(Node2);
		   G.addNode(Node3);
		   G.setEdge(0, 1);
		   G.setEdge(1, 2);
		   G.printAdjMatrix();
		   G.printIncidenceList();
		   //System.out.println("Add Node");
	    }
}

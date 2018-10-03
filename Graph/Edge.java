package Graph;

public class Edge {
	private Node inNode;
	private Node outNode;
	private float weight;
	

	public Edge(Node inN, Node outN) {
		this.inNode=inN;
		this.outNode=outN;
		inN.setNeighbor(outN);
		outN.setNeighbor(inN);
	}
	
	public Edge(Node inN, Node outN, int xWeight) {
		this.inNode=inN;
		this.outNode=outN;
		this.weight=xWeight;
		inN.setNeighbor(outN);
		outN.setNeighbor(inN);
	}

}

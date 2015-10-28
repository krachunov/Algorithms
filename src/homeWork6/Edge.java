package homeWork6;

public class Edge implements Comparable<Edge> {
	private int startNode;
	private int endNode;
	private int wightl;
	private boolean connected;

	public Edge(int startNode, int endNode, int wightl, boolean connected) {
		setStartNode(startNode);
		setEndNode(endNode);
		setWightl(wightl);
		setConnected(connected);

	}

	public Edge(int startNode, int endNode, int wightl) {
		setStartNode(startNode);
		setEndNode(endNode);
		setWightl(wightl);
		setConnected(false);
	}

	public int getStartNode() {
		return startNode;
	}

	public void setStartNode(int startNode) {
		this.startNode = startNode;
	}

	public int getEndNode() {
		return endNode;
	}

	public void setEndNode(int endNode) {
		this.endNode = endNode;
	}

	public int getWightl() {
		return wightl;
	}

	public void setWightl(int wightl) {
		this.wightl = wightl;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	@Override
	public int compareTo(Edge other) {
		int wightCompared = (this.wightl > other.wightl ? 1
				: this.wightl < other.wightl ? -1 : 0);
		return wightCompared;
	}

	@Override
	public String toString() {
		return "(" + this.getStartNode() + " " + this.getEndNode() + ")-> "
				+ this.getWightl();

	}
}

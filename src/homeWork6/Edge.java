package homeWork6;

public class Edge<T> implements Comparable<Edge> {
	private T startNode;
	private T endNode;
	private int wightl;
	private boolean connected;

	public Edge(T startNode, T endNode, int wightl, boolean connected) {
		setStartNode(startNode);
		setEndNode(endNode);
		setWightl(wightl);
		setConnected(connected);

	}

	public Edge(T startNode, T endNode, int wightl) {
		setStartNode(startNode);
		setEndNode(endNode);
		setWightl(wightl);
		setConnected(false);
	}

	public T getStartNode() {
		return startNode;
	}

	public void setStartNode(T startNode) {
		this.startNode = startNode;
	}

	public T getEndNode() {
		return endNode;
	}

	public void setEndNode(T endNode) {
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

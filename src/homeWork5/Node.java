package homeWork5;

import java.util.List;

public class Node {
	int value;
	List<Node> child;
	boolean isVisit;

	public Node(int value) {
		setValue(value);
		setVisit(false);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Node> getChild() {
		return child;
	}

	public void setChild(List<Node> child) {
		this.child = child;
	}

	public boolean isVisit() {
		return isVisit;
	}

	public void setVisit(boolean visit) {
		this.isVisit = visit;
	}

}

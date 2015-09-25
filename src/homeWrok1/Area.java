package homeWrok1;

public class Area implements Comparable<Area> {
	private int positionX;
	private int positionY;
	private int size;

	public Area(int x, int y, int size) {
		setPositionX(x);
		setPositionY(y);
		setSize(size);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positiony) {
		this.positionY = positiony;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Area o) {
		if (this.getSize() > o.getSize()) {
			return 1;
		} else if (this.getSize() < o.getSize()) {
			return -1;
		} else {
			return 0;
		}
	}
	@Override
	public String toString(){
		return "Position X/Y: "+getPositionX()+"/"+getPositionY()+" size: "+getSize();
		
	}
}

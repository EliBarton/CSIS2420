package finalproject;

public class Instruction {
	
	int direction;
	int distance;
	
	public Instruction(int direction, int distance) {
		super();
		this.direction = direction;
		this.distance = distance;
	}

	@Override
	public String toString() {
		if (direction == 1) {
			return "Move up " + distance;
		}
		else if (direction == 2) {
			return "Move down " + distance;
		}
		else if (direction == 3) {
			return "Move left " + distance;
		}
		else if (direction == 4) {
			return "Move right " + distance;
		}else {
			return "Move weast " + distance;
		}
	}
	
}

package destruction;

public class Weapon {
	private String name;
	private final int capacity;
	
	public Weapon(String name, int capacity){
		this.name = name;
		this.capacity = capacity;
	}
	
	public String getName(){
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

}

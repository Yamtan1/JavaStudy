package Study0328;

public class Unit {
	private String name;
	private int energy;
	
	Unit(){}
	public Unit(String name, int energy) {
		this.name = name;
		this.energy = energy;
	}
	
	public void attack(Unit enemy) {
		enemy.decreaseEnemy();
		if(enemy.energy < 0 ) {
			enemy.setEnergy(0);
			System.out.println("더 이상 공격할 수 없습니다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public void decreaseEnemy() {
		energy--;
		
	}

	@Override
	public String toString() {
		return "[유닛=" + name + ", 남은 energy=" + energy + "]";
	}
}

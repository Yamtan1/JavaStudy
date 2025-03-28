package Study0328;

public class Personal {
	
	private String name;
	private String rrn;
	private char gender;
	
	Personal(){}
	
	public Personal(String name, String rrn, char gender) {
		this.name = name;
		this.rrn = rrn;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
}

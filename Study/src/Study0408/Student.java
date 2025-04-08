package Study0408;


public class Student {

	private static int cnt;
	private int sno;
	private String sname;
	private int score;

	
	public Student(String sname, int score) {
		sno = ++cnt;
		this.sname= sname;
		this.score= score;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String name) {
		this.sname = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + sname + ", score=" + score + "]";
	}
	
	
}

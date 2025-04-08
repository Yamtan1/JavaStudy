package Study0408;

public class Student2 {
	private static int cnt;
	private int sno;
	private String sname;
	private int score;
	// 강사님꺼
	//public Student() {}
	public Student2(String sname, int score) {
		//cnt++;
		sno = ++cnt;
		this.sname = sname;
		this.score = score;
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
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", score=" + score + "]";
	}
}

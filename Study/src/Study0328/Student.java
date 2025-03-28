package Study0328;

public class Student {
	
	private int grade;
	private int cls; 
	private int clsNum;
	private Personal info;
	
	public Student(Personal info, int grade, int cls, int clsNum) {
		this.info = info;
		this.grade = grade;
		this.cls = cls;
		this.clsNum = clsNum;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

	public int getClsNum() {
		return clsNum;
	}

	public void setClsNum(int clsNum) {
		this.clsNum = clsNum;
	}

	public Personal getInfo() {
		return info;
	}

	public void setInfo(Personal info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Student [학년=" + grade + ", 반=" + cls + ", 반번호=" + clsNum + ", 이름=" + info.getName() + ", 주민등록번호=" + info.getRrn() + ", 성별=" + info.getGender() + "]";
		}
	
}

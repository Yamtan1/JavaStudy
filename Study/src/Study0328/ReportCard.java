package Study0328;

public class ReportCard {
	
	private String name;
	private int grade;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int total;
	
	ReportCard(){}
	
	public ReportCard(String name, int grade, int num, int kor, int eng, int math){
		this.name = name;
		this.grade =grade;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	public void total() {
		this.total = kor + eng + math;
		
	
	}
	public void average()	{
		this.avg = (double)total / 3;
		}


	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "성적표 [이름=" + name + ", 학년=" + grade + ", 번호=" + num + ", 국어점수=" + kor + ", 영어점수=" + eng
				+ ", 수학점수=" + math + ", 평균점수=" + avg + ", 총점=" + total + "]";
	}
	
	
}

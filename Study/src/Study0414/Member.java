package Study0414;


//import lombok.Data;
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@Data

public class Member {

	private int mno;
	private String name;
	private String phone;

	/*
	@Override
	public boolean equals(Object obj) {
		if(this == obj)  
			return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Member target = (Member) obj;
		return mno == target.mno && name.equals(target.name) && phone.equals(target.phone);
	}
	@Override
	public int hashCode() {
		return Objects.hash(mno, name, phone);
		
	} */

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

package Study0418;

import lombok.Data;

enum Gender{
	Male, Female
}

@Data
public class Member {
	
	private String name;
	private Gender gender;
	
	Member(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
		
	}
	
			
	
}

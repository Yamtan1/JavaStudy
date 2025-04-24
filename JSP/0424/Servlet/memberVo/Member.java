package memberVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	String custno;
	String custname;
	String phone;
	String address;
	String joindate;
	String grade;
	String city;
}

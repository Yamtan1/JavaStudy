package Study0428.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@ToString
public class MemberDto { //계층간 데이터 전송(Dto)
	
	private final String id;
	private final String pw;
	private final String name;
	private final String phone;
	private String grade;
	
	

}

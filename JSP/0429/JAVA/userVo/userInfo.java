package userVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userInfo {

	private String id;
	private String pw;
	private String win;
	private String lose;
	private String draw;
	
}

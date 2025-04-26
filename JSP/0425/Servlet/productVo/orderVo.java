package productVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderVo {
	
	private String orderno;
	private String shopno;
	private String orderdate;
	private String pcode;
	private String amount;
	
}

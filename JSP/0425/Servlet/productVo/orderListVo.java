package productVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderListVo {
	
	private String shopno;
    private String shopname;
    private String orderno;
    private String orderdate;
    private String pcode;
    private String pname;
    private String amount;
    private String cost;
    private String originalPrice;
    private String discountPrice;
      
}

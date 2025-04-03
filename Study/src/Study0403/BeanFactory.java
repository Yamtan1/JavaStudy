package Study0403;

public class BeanFactory {
	
	
	TV getBean(int bean) {
	
		if(bean == 1) {
			TV x = new SamsungTv();
			return x;
		}
		else if(bean ==2) {
			TV y = new LgTv();
			return y;
		}
		else {
			return null;
		}
		
	}
}

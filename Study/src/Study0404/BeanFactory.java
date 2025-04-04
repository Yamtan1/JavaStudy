package Study0404;

public class BeanFactory {
	
	
	TV getBean(String a) {
	
		if(a.equals("samsung")) {
			TV x = new SamsungTv();
			return x;
		}
		else if(a.equals("lg")) {
			TV y = new LgTv();
			return y;
		}
		else {
			return null;
		}
		
	}
}

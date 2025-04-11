package Study0411;

import java.util.ArrayList;

public interface Ijdbc_Service<T> {
	
	void insert();
	void update();
	void delete();
	public ArrayList<T> select();
}

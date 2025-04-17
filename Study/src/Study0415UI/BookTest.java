package Study0415UI;

import java.sql.SQLException;

public class BookTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Dbcon db = new Dbcon();
		BookDAO dao = new BookDAO();
		Menu m1 = new Menu();
		db.connect();
		while(true) {
		m1.start(dao, db);	
		}
	}

}

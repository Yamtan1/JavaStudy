package Study0428.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtilTest {

	public static void main(String[] args) {
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM tbl_member");
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		DbUtil.close(conn, stmt, rs);

	}

}

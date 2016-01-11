package means.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	public static ResultSet execute(String sql) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:h2:./educationSystem", "sa", "sa");

		try{
			Statement st=conn.createStatement();
			try{
				ResultSet rs=st.executeQuery(sql);
				return rs;
			}finally{
//				st.close();
			}
		}finally{
//			conn.close();
		}
	}
}	
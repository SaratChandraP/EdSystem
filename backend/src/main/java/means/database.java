package means;

import java.sql.*;
//import org.h2.jdbcx.JdbcDataSource;

public class database{
	public static void connect() {
		try{
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/testdb", "sa", "");
			System.out.println("Connection success");
			Statement st=conn.createStatement();
			String sql="select * from test";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
			}
		}
}
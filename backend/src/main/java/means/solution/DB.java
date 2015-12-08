package means.solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	
	public static Connection connect(String db) {
		
		
		try{
						
			Connection conn = DriverManager.getConnection("jdbc:h2:./"+db, "sa", "sa");
			
			return conn;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	public static ResultSet execute(String sql) {
		try{
			Class.forName("org.h2.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:h2:./educationSystem", "sa", "sa");

			Statement st=conn.createStatement();
//			String sql="select * from questions";
			ResultSet rs=st.executeQuery(sql);
			
			System.out.println(conn);
//			conn.close();
			return rs;
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		return null;
		
	}
}	
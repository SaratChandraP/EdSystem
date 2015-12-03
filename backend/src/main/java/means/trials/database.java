package means.trials;

import java.sql.*;
//import org.h2.jdbcx.JdbcDataSource;
import java.util.ArrayList;
import java.util.List;

import means.solution.Questions;

public class database{
	
	static Questions Q1 = new Questions();
	
	public static Questions connect() {
		try{
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/testdb", "sa", "");  
			System.out.println("Connection success");
			
			Statement st=conn.createStatement();
			
			String sql="select * from questions";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				Q1.id = rs.getInt(1);
				Q1.question = rs.getString(2);
				Q1.answer = rs.getString(3);
			}
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			
			conn.close();
		}
		
		catch(Exception e){
			System.out.println(e);
			
		}
		return Q1;
		
	}
	
}
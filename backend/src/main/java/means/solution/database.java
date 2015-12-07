package means.solution;

import java.sql.*;
//import org.h2.jdbcx.JdbcDataSource;
import java.util.ArrayList;
import java.util.List;

public class database{
	
	public static Questions connect() {
		try{
			Class.forName("org.h2.Driver");
		
			Connection conn = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/educationSystem", "sa", "sa");  
			System.out.println("Connection success");
			
			Statement st=conn.createStatement();
			
			String sql="select * from questions";
			ResultSet rs=st.executeQuery(sql);
	
			Questions Q1 = new Questions();
			
			while(rs.next()){
				Q1.id = rs.getInt(1);
				Q1.question = rs.getString(2);
				Q1.answer.clear();
				Connection conn1 = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/educationSystem", "sa", "sa");  
				System.out.println("Connection success");
				
				Statement st1=conn1.createStatement();
				String sql1="select * from answers where questionnum="+Q1.id;
				ResultSet rs1 = st1.executeQuery(sql1);
				while(rs1.next()){
					Q1.answer.add(rs1.getString(3));
				}
				conn1.close();
//				break;
			}		
			conn.close();
			return Q1;
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}	
}
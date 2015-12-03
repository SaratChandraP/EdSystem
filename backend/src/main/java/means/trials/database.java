package means.trials;

import java.sql.*;
//import org.h2.jdbcx.JdbcDataSource;
import java.util.ArrayList;
import java.util.List;

public class database{
	
	static List<String> DBcontent = new ArrayList<String>();
	
	public static Object connect() {
		try{
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/testdb", "sa", "");  
			System.out.println("Connection success");
			
			Statement st=conn.createStatement();
			
			String sql="select * from test";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				DBcontent.add(Integer.toString(rs.getInt(1)));
				DBcontent.add(rs.getString(2));
			}
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			
			conn.close();
		}
		
		catch(Exception e){
			System.out.println(e);
			
		}
		return DBcontent;
		
	}
	
}
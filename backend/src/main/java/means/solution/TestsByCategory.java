package means.solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/category")
public class TestsByCategory
{
	private static Map<Integer, Questions> questions = new ConcurrentHashMap<>();
	
	@GET
    public Collection<Questions> getQuestions() throws SQLException
    {
		Connection connection = DriverManager.getConnection("jdbc:h2:./educationSystem", "sa", "sa");
		Statement statement;
		
		try{
//			Connection conn = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/educationSystem", "sa", "sa");  
				
			System.out.println(connection);
				
			statement=connection.createStatement();
			String sql="select * from questions";
			ResultSet rs=statement.executeQuery(sql);
				
			int i=0;
				
			while(rs.next()){
				Questions Q1 = new Questions();
				Q1.setId(rs.getInt(1));
				Q1.setQuestion(rs.getString(2));

				Statement st1=connection.createStatement();
				String sql1="select * from answers where questionnum="+Q1.id;
				ResultSet rs1 = st1.executeQuery(sql1);

				while(rs1.next())
					Q1.addAnswer(rs1.getString(3));
				
				questions.put(i++, Q1);
				}
		}
		finally{
			if(connection != null) connection.close();
		}

		return questions.values();
    }
	
	@GET
	@Path("{questionId}")
	public Questions get(@PathParam("questionId") String id) throws SQLException{
		
		Questions Q = new Questions();
		String sql="select * from questions where questionnum=";
//		String sql="select q1.questionnum, q1.question, answers.answer from (select * from questions where questionnum=1)q1 join answers on q1.questionnum=answers.questionnum";
		
		ResultSet rs=DB.execute(sql+id);
				
		while(rs.next()){
			Q.setId(rs.getInt(1));
			Q.setQuestion(rs.getString(2));
			
			ResultSet rs1=DB.execute("select * from answers where questionnum="+id);
			while(rs1.next())
				Q.addAnswer(rs1.getString(3));
			rs1.close();
		}
		rs.close();
		return Q;
	}	
}
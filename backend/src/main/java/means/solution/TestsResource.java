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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/test")
public class TestsResource
{
	private static Map<Integer, Questions> testMap = new ConcurrentHashMap<>();
		
	@GET
    public Collection<Questions> getQuestions() throws SQLException
    {
		Connection conn = DriverManager.getConnection("jdbc:h2:./educationSystem", "sa", "sa");
		// can use System.getProperty("user.dir") for project dir
		
		try{
			Statement st=conn.createStatement();
			String sql="select * from questions";
			ResultSet rs=st.executeQuery(sql);
			
			int i=0;
			
			while(rs.next()){
				Questions Q1 = new Questions();
				Q1.setId(rs.getInt(1));
				Q1.setQuestion(rs.getString(2));

				Statement st1=conn.createStatement();
				String sql1="select * from answers where questionnum="+Q1.id;
				ResultSet rs1 = st1.executeQuery(sql1);

				while(rs1.next())
					Q1.addAnswer(rs1.getString(3));

				testMap.put(i++, Q1);
				}
			conn.close();
		}finally{
//			conn.close();
		}

//		System.out.println(testMap.toString());
		return testMap.values();
    }
	
	@GET
	@Path("{questionId}")
	public Questions get(@PathParam("questionId") String id) throws SQLException
	{
		Questions Q = new Questions();
		ResultSet rs=DB.execute("select * from questions where questionnum="+id);
		
		while(rs.next()){
			Q.setId(rs.getInt(1));
			Q.setQuestion(rs.getString(2));
			
			ResultSet rs1=DB.execute("select * from answers where questionnum="+Q.getId());
			while(rs1.next())
				Q.addAnswer(rs1.getString(3));
		}
		return Q;
	}
	
	@POST
//	@Path("{questionId}")
	@Path("/new")
//	public void answered(@PathParam("questionId") String id, Questions qTest){
	public void answered(Questions qTest){
			System.out.println(qTest.getFullQuestion());
	}
	
	@PUT
	public void addQuestion(Questions question){
		System.out.println(question.getFullQuestion());
	}
}
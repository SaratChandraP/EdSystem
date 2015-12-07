package means.solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/test")
public class TestsResource
{
	private static Map<Integer, Questions> testMap = new ConcurrentHashMap<>();
//	private static List<String> names = new ArrayList<String>();
	
	@PUT
    public void create(Questions question)
    {
        
    }
	
	@GET
    public Collection<Questions> getQuestions()
    {
		try{
			Class.forName("org.h2.Driver");
		
//			Connection conn = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/educationSystem", "sa", "sa");  
			Connection conn = DriverManager.getConnection("jdbc:h2:./educationSystem", "sa", "sa");  
			
			System.out.println(conn);
			
			Statement st=conn.createStatement();
			String sql="select * from questions";
			ResultSet rs=st.executeQuery(sql);
			
			int i=0;
			
			while(rs.next()){
				Questions Q1 = new Questions();
				Q1.setId(rs.getInt(1));
				Q1.setQuestion(rs.getString(2));
				Q1.answer.clear();

				Statement st1=conn.createStatement();
				String sql1="select * from answers where questionnum="+Q1.id;
				ResultSet rs1 = st1.executeQuery(sql1);

				while(rs1.next())
					Q1.addAnswer(rs1.getString(3));

//				conn1.close();
				testMap.put(i++, Q1);
				}
			conn.close();
		}
		
		catch(Exception e){
			System.out.println(e);
		}
//		System.out.println(testMap.toString());
		return testMap.values();
    }
	
/*	@GET
    @Path("{testId}")
    public Questions get(@PathParam("testId") int testId)
    {
		testMap.put(ID_COUNTER, database.connect());
        Questions found = testMap.get(testId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return found;
    }	
	
	@DELETE
	@Path("{qId}")
	public void delete(@PathParam("qId") int qId){
		
	}
*/	
}

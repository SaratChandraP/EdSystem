package means.solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
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
	private static Map<AtomicInteger, Questions> testMap = new ConcurrentHashMap<>();
//	private static List<String> names = new ArrayList<String>();
	private static AtomicInteger ID_COUNTER = new AtomicInteger();
	
	@GET
    public Collection<Questions> getQuestions()
    {
		
/*		testMap.put(ID_COUNTER, database.connect());
		System.out.println(ID_COUNTER.incrementAndGet());
*/		
		try{
			Class.forName("org.h2.Driver");
		
			Connection conn = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/educationSystem", "sa", "sa");  
			System.out.println("Connection success");
			
			Statement st=conn.createStatement();
			String sql="select * from questions";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				Questions Q1 = new Questions();
				Q1.id = rs.getInt(1);
				Q1.question = rs.getString(2);
				Q1.answer.clear();

				Connection conn1 = DriverManager.getConnection("jdbc:h2:"+System.getProperty("user.dir")+"/educationSystem", "sa", "sa");  
				Statement st1=conn1.createStatement();
				String sql1="select * from answers where questionnum="+Q1.id;
				ResultSet rs1 = st1.executeQuery(sql1);

				while(rs1.next())
					Q1.answer.add(rs1.getString(3));

				conn1.close();
				testMap.put(ID_COUNTER, Q1);
				ID_COUNTER.incrementAndGet();
				}
			conn.close();
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		
		return testMap.values();
    }
	
	@GET
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
	
}

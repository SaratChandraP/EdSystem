package means.solution;

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

import means.trials.database;

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
		
		testMap.put(ID_COUNTER, database.connect());
		return testMap.values();

//		return database.connect();
		
    }
	
	@GET
    @Path("{testId}")
    public Questions get(@PathParam("testId") int testId)
    {
        Questions found = testMap.get(testId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return found;
    }
	
}

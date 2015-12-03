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
@Path("/tests")
public class TestsResource
{
	private static Map<Integer, List<String>> testMap = new ConcurrentHashMap<>();
	private static List<String> names = new ArrayList<String>();
	private static AtomicInteger ID_COUNTER = new AtomicInteger();
	
	@GET
    public Object getQuestions()
    {
//		testMap.put(ID_COUNTER, database.connect());
        return database.connect();
    }
    
    @GET
    @Path("{quesitonId}")
    public Object get(@PathParam("questionId") int questionId)
    {
        List<String> found = testMap.get(questionId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return found;
    }
        
}

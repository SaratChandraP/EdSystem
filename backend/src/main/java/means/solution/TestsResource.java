package means.solution;

import java.util.Collection;
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
    private static Map<Integer, Test> DATA = new ConcurrentHashMap<>();
    private static AtomicInteger ID_COUNTER = new AtomicInteger();
    
    @PUT
    public Test create(Test test)
    {
        test.setId(ID_COUNTER.incrementAndGet());
        DATA.put(test.getId(), test);
        return test;
    }
    
    @GET
    public Collection<Test> getTests()
    {
        return DATA.values();
    }
    
    @GET
    @Path("{testId}")
    public Test get(@PathParam("testId") int testId)
    {
        Test found = DATA.get(testId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return found;
    }
    
    @DELETE
    @Path("{testId}")
    public void delete(@PathParam("testId") int testId)
    {
        Test found = DATA.remove(testId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return;
    }
    
}

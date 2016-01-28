package means.resources;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import means.core.Questions;
import means.db.QuestionsDao;
import means.exception.ResponseException;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionsResource {

	private final QuestionsDao qDao;
	
	public QuestionsResource(QuestionsDao qDao){
		this.qDao = qDao;
	}
	
	@GET
    public Set<Questions> getAll() {
        Set<Questions> questionsAll = qDao.retrieveAll();
        if (questionsAll == null) {
			ResponseException
				.formatAndThrow(Response.Status.NOT_FOUND, "Unable to retrieve");
		}
        return questionsAll;
    }

	@GET
	@Path("/{id}")
	@Timed
	@ExceptionMetered
	public Questions getById(@PathParam("id") String id) {
		Questions existingContent = qDao.retrieveById(id);
		if (existingContent == null) {
			ResponseException
				.formatAndThrow(Response.Status.NOT_FOUND, "Question "+id+" does not exist" );
		}
		return existingContent;
	}
	
	@POST
	@Path("/submit")
	public void submitTest(){
		
	}
	
}

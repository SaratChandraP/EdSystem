package means.resources;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import means.core.Questions;
import means.db.QuestionsDao;

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
        return questionsAll;
    }

	@GET
	@Path("/{id}")
	@Timed
	@ExceptionMetered
	public Questions getById(@PathParam("id") String id) {
		Questions existingContent = qDao.retrieveById(id);
		return existingContent;
	}
	
	@POST
	@Path("/submit")
	public void submitTest(){
		
	}
	
}

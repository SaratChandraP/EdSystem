package means.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import means.db.QuestionsDao;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionsResource {

	private final QuestionsDao qDao;
	
	public QuestionsResource(QuestionsDao qDao){
		this.qDao = qDao;
	}
}

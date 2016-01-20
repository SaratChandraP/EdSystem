package means.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import means.core.Questions;

public class QuestionsMapper implements ResultSetMapper<Questions>{
	
	public Questions map(int id, ResultSet rs, StatementContext ctx) throws SQLException {
		Questions question = new Questions();
		question.setId(rs.getInt(1));
		question.setQuestion(rs.getString(2));
//		question.setAnswer(answer);
		
		return question;
	}

}

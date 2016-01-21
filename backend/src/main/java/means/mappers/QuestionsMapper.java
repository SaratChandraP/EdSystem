package means.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import means.core.Questions;

public class QuestionsMapper implements ResultSetMapper<Questions>{
	
	public Questions map(int id, ResultSet rs, StatementContext ctx) throws SQLException {
		Questions question = new Questions();
		question.setId(rs.getInt("id"));
		question.setQuestion(rs.getString("question"));
		question.setOption1(rs.getString("option1"));
		question.setOption2(rs.getString("option2"));
		question.setOption3(rs.getString("option3"));
		question.setOption4(rs.getString("option4"));
//		question.setAnswer(answer);
		
		return question;
	}

}

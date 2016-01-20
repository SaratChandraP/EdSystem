package means.db;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import means.core.Questions;
import means.mappers.QuestionsMapper;

@RegisterMapper(QuestionsMapper.class)
public interface QuestionsDao {
	
	@SqlQuery("select * from questions where questionnum= :id")
	public Questions retrieveById(@Bind("id") String id);

}

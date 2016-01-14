package means.db;

import means.core.Content;
import means.core.Questions;
import means.mappers.ContentMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Set;

@RegisterMapper(ContentMapper.class)
public interface ContentDao {

    @SqlUpdate("insert into questions (questionnum, question, category, answerid) values (:id, :question, :category, :answerId)")
    public void create(@BindBean Content content);

    @SqlQuery("select content.id, content.title, content.description, coalesce(ratings.rating, 0) as rating from content left join (select AVG(rating) as rating, MAX(content) as content from ratings group by content) as ratings on content.id = ratings.content where content.id = :id")
    public Content retrieve(@Bind("id") String id);

    @SqlQuery("select * from questions where questionnum = :id")
    public Questions retrieveById(@Bind("id") String id);
    
    @SqlQuery("select content.id, content.title, content.description,  coalesce(ratings.rating, 0) as rating from content left join (select AVG(rating) as rating, MAX(content) as content from ratings group by content) as ratings on content.id = ratings.content")
    public Set<Content> retrieveAll();

    @SqlUpdate("update content set title = :title, description = :description where id = :id")
    public void update(@BindBean Content content);

    @SqlUpdate("delete from content where id = :id")
    public void delete(@BindBean Content content);
}
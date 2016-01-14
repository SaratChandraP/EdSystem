package means.mappers;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import means.core.Content;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentMapper implements ResultSetMapper<Content> {

    public Content map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Content content = new Content();
        content.setId(r.getString("id"));
        content.setTitle(r.getString("title"));
        content.setDescription(r.getString("description"));
        content.setRating(r.getDouble("rating"));
        return content;
    }
}
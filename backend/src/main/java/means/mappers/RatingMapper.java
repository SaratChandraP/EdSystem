package means.mappers;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import means.core.Rating;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingMapper implements ResultSetMapper<Rating> {

    public Rating map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Rating rating = new Rating();
        rating.setUser(r.getString("ptuser"));
        rating.setContent(r.getString("content"));
        rating.setRating(r.getInt("rating"));
        return rating;
    }
}
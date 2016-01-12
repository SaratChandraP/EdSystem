package means.mappers;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import means.core.User;
import means.core.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {

    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        User user = new User();
        user.setEmail(r.getString("email"));
        user.setPassword(r.getString("password"));
        user.setSalt(r.getString("salt"));
        user.setRole(UserRole.fromString(r.getString("role")));
        return user;
    }
}
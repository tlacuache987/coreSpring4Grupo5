package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object;

import java.sql.Types;

import javax.sql.DataSource;

import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UserSqlUpdate extends SqlUpdate {

	private static final String UPDATE = "UPDATE USER_TBL SET USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?";

	public UserSqlUpdate(DataSource dataSource) {

		super(dataSource, UPDATE);
		declareParameter(new SqlParameter("USERNAME", Types.VARCHAR));
		declareParameter(new SqlParameter("PASSWORD", Types.VARCHAR));
		declareParameter(new SqlParameter("USER_ID", Types.INTEGER));

		compile();
	}

	public int execute(Long id, String username, String password) {
		return update(username, password, id);
	}

	public int execute(User user) {
		return update(user.getUsername(), user.getPassword(), user.getId());
	}

}

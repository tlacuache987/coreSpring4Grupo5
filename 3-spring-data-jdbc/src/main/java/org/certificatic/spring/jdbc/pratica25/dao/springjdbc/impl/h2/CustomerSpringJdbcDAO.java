package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.impl.h2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.certificatic.spring.jdbc.pratica25.dao.api.ICustomerDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.GenericSpringJdbcDAO;
import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.rowmapper.CustomerRowMapper;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@Profile({ "h2-in-memory", "h2-local" })
public class CustomerSpringJdbcDAO extends GenericSpringJdbcDAO<Customer, Long>
		implements ICustomerDAO {

	private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER_TBL VALUES (null, :name, :lastName)";
	private static final String INSERT_USER = "INSERT INTO USER_TBL VALUES (null, :fkCustomerId, :username, :password)";

	private static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER_TBL SET NAME = :name, LAST_NAME = :lastName WHERE CUSTOMER_ID = :customerId";
	private static final String UPDATE_USER = "UPDATE USER_TBL SET USERNAME = :username, PASSWORD = :password WHERE USER_ID = :userId";

	private static final String SELECT_CUSTOMER = "SELECT * FROM CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";
	private static final String SELECT_USER_WHERE_CUSTOMER_ID = "SELECT * FROM USER_TBL WHERE FK_CUSTOMER_ID = :customerId";

	private static final String SELECT_ALL_CUSTOMER_USER = "SELECT * FROM CUSTOMER_TBL, USER_TBL WHERE CUSTOMER_ID = FK_CUSTOMER_ID";

	private static final String DELETE_ACCOUNT_TABLE_WHERE_CUSTOMER_ID = "DELETE FROM ACCOUNT_TBL WHERE FK_CUSTOMER_ID = :customerId";
	private static final String DELETE_USER_WHERE_USER_ID = "DELETE FROM USER_TBL WHERE USER_ID = :userId";
	private static final String DELETE_CUSTOMER_WHERE_CUSTOMER_ID = "DELETE FROM CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId";

	@Override
	public void insert(Customer entity) {

		// INSERT CUSTOMER
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();

		// Implementar Settear parametros a parameterSource
		parameterSource.addValue("name", entity.getName());
		parameterSource.addValue("lastName", entity.getLastName());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Implementar pasar argumentos a update
		// INSERT INTO CUSTOMER_TBL VALUES (null, :name, :lastName)
		this.namedJdbcTemplate.update(INSERT_CUSTOMER, parameterSource, keyHolder);

		entity.setId(keyHolder.getKey().longValue());

		// INSERT USER
		parameterSource = new MapSqlParameterSource();

		// Implementar Settear parametros a parameterSource
		parameterSource.addValue("fkCustomerId", entity.getId());
		parameterSource.addValue("username", entity.getUser().getUsername());
		parameterSource.addValue("password", entity.getUser().getPassword());

		keyHolder = new GeneratedKeyHolder();

		// Implementar pasar argumentos a update
		this.namedJdbcTemplate.update(INSERT_USER, parameterSource, keyHolder);

		entity.getUser().setId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(Customer entity) {

		// UPDATE CUSTOMER
		Map<String, Object> mapParameters = new HashMap<>();

		// Implementar Settear parametros a mapParameters
		mapParameters.put("name", entity.getName());
		mapParameters.put("lastName", entity.getLastName());
		mapParameters.put("customerId", entity.getId());

		// Implementar NamedParameterJdbcTemplate y pasar argumentos a update
		this.namedJdbcTemplate.update(UPDATE_CUSTOMER, mapParameters);

		// UPDATE USER
		mapParameters = new HashMap<>();

		// Implementar Settear parametros a mapParameters
		mapParameters.put("username", entity.getUser().getUsername());
		mapParameters.put("password", entity.getUser().getPassword());
		mapParameters.put("userId", entity.getUser().getId());

		// Implementar NamedParameterJdbcTemplate y pasar argumentos a update
		this.namedJdbcTemplate.update(UPDATE_USER, mapParameters);
	}

	@Override
	public Customer findById(Long id) {
		Customer customer = null;

		// FIND CUSTOMER BY ID
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", id);

		try {
			// SELECT * FROM CUSTOMER_TBL WHERE CUSTOMER_ID = :customerId
			customer = this.namedJdbcTemplate.queryForObject(SELECT_CUSTOMER,
					parameterSource,
					new RowMapper<Customer>() {
						@Override
						public Customer mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							// Implementar Customer solo.
							Customer customer = new Customer();
							customer.setId(rs.getLong("CUSTOMER_ID"));
							customer.setName(rs.getString("NAME"));
							customer.setLastName(rs.getString("LAST_NAME"));
							return customer;
						}
					});

		} catch (EmptyResultDataAccessException ex) {
			// Cuando se usa queryForObject se espera al menos 1 resultado.
			return null;
		}

		// FIND USER OF CUSTOMER BY CUSTOMER_ID
		parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("customerId", customer.getId());

		// SELECT * FROM USER_TBL WHERE FK_CUSTOMER_ID = :customerId
		User user = this.namedJdbcTemplate.queryForObject(
				SELECT_USER_WHERE_CUSTOMER_ID, parameterSource,
				(ResultSet rs, int rowNum) -> {

					// Implementar User solo
					User u = new User();
					u.setId(rs.getLong("USER_ID"));
					u.setUsername(rs.getString("USERNAME"));
					u.setPassword(rs.getString("PASSWORD"));
					return u;
				});

		customer.setUser(user);
		user.setCustomer(customer);

		return customer;
	}

	@Override
	public Customer delete(Long id) {
		Customer customer = this.findById(id);
		return this.delete(customer);
	}

	@Override
	public Customer delete(Customer entity) {
		if (entity == null)
			return entity;

		// DELETE COMPLETE RELATIONS OF CUSTOMER WITH ALL TABLES
		Map<String, Object> mapParameters = new HashMap<>();

		mapParameters.put("customerId", entity.getId());
		mapParameters.put("userId", entity.getUser().getId());

		// Implementar DELETE's utilizando NamedParameterJdbcTemplate y
		// mapParameters

		this.namedJdbcTemplate.update(DELETE_ACCOUNT_TABLE_WHERE_CUSTOMER_ID, mapParameters);

		this.namedJdbcTemplate.update(DELETE_USER_WHERE_USER_ID, mapParameters);

		this.namedJdbcTemplate.update(DELETE_CUSTOMER_WHERE_CUSTOMER_ID, mapParameters);

		return entity;
	}

	@Override
	public List<Customer> findAll() {

		final List<Customer> customerList = new ArrayList<>();

		// FIND COMPLETE ALL CUSTOMER (WITH USER)

		// Implementar query utilizando NamedParameterJdbcTemplate y
		// RowCallbackHandler
		this.namedJdbcTemplate.query(SELECT_ALL_CUSTOMER_USER, new RowCallbackHandler() {

			private CustomerRowMapper customerRowMapper = new CustomerRowMapper();
			private int i = 0;

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Customer customer = customerRowMapper.mapRow(rs, ++i);
				customerList.add(customer);
			}
		});

		return customerList;
	}

}

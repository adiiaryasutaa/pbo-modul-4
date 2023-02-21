package ceceply.pbo.mod4.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * Database Query class
 */
public class DatabaseQuery {
	/**
	 * Database connection
	 */
	protected DatabaseConnection databaseConnection;

	/**
	 * Database query constructor
	 *
	 * @param databaseConnection
	 */
	public DatabaseQuery(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	/**
	 * Get all data from a table
	 *
	 * @param table
	 * @return
	 */
	public LinkedList<LinkedHashMap<String, Object>> all(String table) {
		LinkedList<LinkedHashMap<String, Object>> data = new LinkedList<>();

		try {
			String sql = String.format("SELECT * FROM `%s`", table);
			PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			final int columnCount = resultSetMetaData.getColumnCount();

			while (resultSet.next()) {
				LinkedHashMap<String, Object> datum = new LinkedHashMap<>();

				for (int i = 1; i <= columnCount; ++i) {
					datum.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
				}

				data.add(datum);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return data;
	}

	/**
	 * Add data to a table
	 *
	 * @param table
	 * @param data
	 * @return
	 */
	public boolean add(String table, HashMap<String, Object> data) {
		var columns = Arrays.asList(data.keySet().toArray());
		var values = Arrays.asList(data.values().toArray());

		Collections.reverse(columns);
		Collections.reverse(values);

		// Query Builder
		StringBuilder sqlQueryBuilder = new StringBuilder("INSERT INTO `%s` (");

		for (int i = 0; i < columns.size(); i++) {
			sqlQueryBuilder
				.append("`")
				.append(columns.get(i))
				.append("`");

			if (i != columns.size() - 1) {
				sqlQueryBuilder.append(", ");
			}
		}

		sqlQueryBuilder.append(") VALUES (");

		for (int i = 0; i < values.size(); i++) {
			sqlQueryBuilder.append("?");

			if (i != columns.size() - 1) {
				sqlQueryBuilder.append(", ");
			}
		}

		sqlQueryBuilder.append(")");
		// Query Builder

		String sql = String.format(sqlQueryBuilder.toString(), table);

		try {
			PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);

			for (int i = 1; i <= values.size(); i++) {
				Object value = values.toArray()[i - 1];

				if (value instanceof String) {
					preparedStatement.setString(i, (String) value);
				} else if (value instanceof Integer) {
					preparedStatement.setInt(i, (Integer) value);
				} else if (value instanceof Long) {
					preparedStatement.setLong(i, (Long) value);
				} else if (value instanceof Boolean) {
					preparedStatement.setBoolean(i, (Boolean) value);
				}
			}

			preparedStatement.execute();

			System.out.printf("Data added to table %s%n", table);

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Update values in a table
	 *
	 * @param table
	 * @param data
	 * @param wheres
	 * @return
	 */
	public boolean update(String table, LinkedHashMap<String, Object> data, LinkedHashMap<String, Object> wheres) {
		var dataColumns = Arrays.asList(data.keySet().toArray());
		var whereColumns = Arrays.asList(wheres.keySet().toArray());
		var values = new LinkedList<>(List.of(data.values().toArray()));
		values.addAll(List.of(wheres.values().toArray()));

		StringBuilder sqlQueryBuilder = new StringBuilder("UPDATE `%s` SET ");

		for (int i = 0; i < dataColumns.size(); i++) {
			sqlQueryBuilder.append("`").append(dataColumns.get(i)).append("` = ?");

			if (i != dataColumns.size() - 1) {
				sqlQueryBuilder.append(", ");
			}
		}

		if (!wheres.isEmpty()) {
			sqlQueryBuilder.append(" WHERE ");

			for (int i = 0; i < whereColumns.size(); i++) {
				sqlQueryBuilder.append("`").append(whereColumns.get(i)).append("` = ?");

				if (i != whereColumns.size() - 1) {
					sqlQueryBuilder.append(" AND ");
				}
			}
		}

		String sql = String.format(sqlQueryBuilder.toString(), table);

		System.out.println(sql);
		System.out.println(Arrays.toString(values.toArray()));

		try {
			PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);

			for (int i = 1; i <= values.size(); i++) {
				Object value = values.get(i - 1);

				if (value instanceof String) {
					preparedStatement.setString(i, (String) value);
				} else if (value instanceof Integer) {
					preparedStatement.setInt(i, (Integer) value);
				} else if (value instanceof Long) {
					preparedStatement.setLong(i, (Long) value);
				} else if (value instanceof Boolean) {
					preparedStatement.setBoolean(i, (Boolean) value);
				}
			}

			preparedStatement.execute();
			System.out.println(preparedStatement.getParameterMetaData().getParameterCount());

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Delete rows in a table
	 *
	 * @param table
	 * @param data
	 * @return
	 */
	public boolean delete(String table, HashMap<String, Object> data) {
		var columns = Arrays.asList(data.keySet().toArray());
		var values = Arrays.asList(data.values().toArray());

		Collections.reverse(columns);
		Collections.reverse(values);

		// Query Builder
		StringBuilder sqlQueryBuilder = new StringBuilder("DELETE FROM `%s` WHERE ");

		for (int i = 0; i < columns.size(); i++) {
			sqlQueryBuilder.append("`").append(columns.get(i)).append("` = ?");

			if (i != columns.size() - 1) {
				sqlQueryBuilder.append(" AND ");
			}
		}

		String sql = String.format(sqlQueryBuilder.toString(), table);

		try {
			PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);

			for (int i = 1; i <= values.size(); i++) {
				Object value = values.toArray()[i - 1];

				if (value instanceof String) {
					preparedStatement.setString(i, (String) value);
				} else if (value instanceof Integer) {
					preparedStatement.setInt(i, (Integer) value);
				} else if (value instanceof Long) {
					preparedStatement.setLong(i, (Long) value);
				} else if (value instanceof Boolean) {
					preparedStatement.setBoolean(i, (Boolean) value);
				}
			}

			preparedStatement.execute();

			System.out.println(preparedStatement.getParameterMetaData().getParameterCount());

			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}

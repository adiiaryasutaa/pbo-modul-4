package pbo.module4.database;

import java.sql.*;

public class DatabaseConnection {
	private String host;
	private String database;
	private String user;
	private String password;

	private Connection connection;

	public DatabaseConnection(String host, String database, String user, String password) {
		this.host = host;
		this.database = database;
		this.user = user;
		this.password = password;
	}

	public Connection connect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = String.format("jdbc:mysql://%s/%s", this.host, this.database);
			this.connection = DriverManager.getConnection(url, this.user, this.password);

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}

		return this.connection;
	}

	public Connection getConnection() {
		return this.connection;
	}
}

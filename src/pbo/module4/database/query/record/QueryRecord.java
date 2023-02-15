package pbo.module4.database.query.record;

import pbo.module4.Application;

import java.sql.Connection;

public class QueryRecord {
	protected static Connection connection;

	static {
		connection = Application.getDatabaseConnection().getConnection();
	}
}

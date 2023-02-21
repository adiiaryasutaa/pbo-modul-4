package ceceply.pbo.mod4.database.query.record;

import ceceply.pbo.mod4.Application;

import java.sql.Connection;

public class QueryRecord {
	protected static Connection connection;

	static {
		connection = Application.getDatabaseConnection().getConnection();
	}
}

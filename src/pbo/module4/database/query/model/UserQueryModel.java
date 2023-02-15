package pbo.module4.database.query.model;

import pbo.module4.Application;
import pbo.module4.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQueryModel {
	public static User get(String username) {
		Connection connection = Application.getDatabaseConnection().getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");

			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
				return null;
			}

			return new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("level"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

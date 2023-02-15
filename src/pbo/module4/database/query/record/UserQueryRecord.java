package pbo.module4.database.query.record;

import pbo.module4.record.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQueryRecord extends QueryRecord {
	public static User get(String username) {
		try {
			String query = String.format(
				"SELECT * FROM `%s` WHERE `%s` = ?",
				User.TABLE_NAME,
				User.USERNAME_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
				return null;
			}

			return new User(
				resultSet.getInt("id"),
				resultSet.getString("username"),
				resultSet.getString("password"),
				resultSet.getInt("level"),
				resultSet.getDate("diperbarui_pada"),
				resultSet.getDate("dibuat_pada")
			);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

package pbo.module4.database.query.record;

import pbo.module4.record.Mapel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MapelQueryRecord extends QueryRecord {
	public static LinkedList<Mapel> all() {
		try {
			String query = String.format(
				"SELECT * FROM `%s` ORDER BY `%s`",
				Mapel.TABLE_NAME,
				Mapel.TANGGAL_DIBUAT_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			LinkedList<Mapel> mapelLinkedList = new LinkedList<>();

			while (resultSet.next()) {
				mapelLinkedList.add(new Mapel(
					resultSet.getInt(Mapel.ID_COLUMN),
					resultSet.getString(Mapel.KODE_COLUMN),
					resultSet.getString(Mapel.NAMA_COLUMN),
					resultSet.getDate(Mapel.TANGGAL_DIPERBARUI_COLUMN),
					resultSet.getDate(Mapel.TANGGAL_DIBUAT_COLUMN)
				));
			}

			return mapelLinkedList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean insert(String kode, String nama) {
		try {
			String query = String.format(
				"INSERT INTO `%s` (`%s`, `%s`) VALUES (?, ?)",
				Mapel.TABLE_NAME,
				Mapel.KODE_COLUMN,
				Mapel.NAMA_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, kode);
			preparedStatement.setString(2, nama);

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean update(Mapel mapel, String kode, String nama) {
		try {
			String query = String.format(
				"UPDATE `%s` SET `%s` = ?, `%s` = ? WHERE `%s` = ?",
				Mapel.TABLE_NAME,
				Mapel.KODE_COLUMN,
				Mapel.NAMA_COLUMN,
				Mapel.ID_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, kode);
			preparedStatement.setString(2, nama);
			preparedStatement.setInt(3, mapel.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean delete(Mapel mapel) {
		try {
			String query = String.format(
				"DELETE FROM `%s` WHERE `%s` = ?",
				Mapel.TABLE_NAME,
				Mapel.ID_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, mapel.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}

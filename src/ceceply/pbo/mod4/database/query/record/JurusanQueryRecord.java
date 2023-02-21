package ceceply.pbo.mod4.database.query.record;

import ceceply.pbo.mod4.record.Jurusan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class JurusanQueryRecord extends QueryRecord {
	public static LinkedList<Jurusan> all() {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jurusan ORDER BY dibuat_pada DESC");

			ResultSet resultSet = preparedStatement.executeQuery();

			LinkedList<Jurusan> jurusanLinkedList = new LinkedList<>();

			while (resultSet.next()) {
				jurusanLinkedList.add(new Jurusan(
					resultSet.getInt(Jurusan.ID_COLUMN),
					resultSet.getString(Jurusan.KODE_COLUMN),
					resultSet.getString(Jurusan.NAMA_COLUMN),
					resultSet.getString(Jurusan.TANGGAL_DIPERBARUI_COLUMN),
					resultSet.getString(Jurusan.TANGGAL_DIBUAT_COLUMN)
				));
			}

			return jurusanLinkedList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean insert(String kode, String nama) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
				String.format("INSERT INTO `jurusan` (`%s`, `%s`) VALUES (?, ?)", Jurusan.KODE_COLUMN, Jurusan.NAMA_COLUMN)
			);

			preparedStatement.setString(1, kode);
			preparedStatement.setString(2, nama);

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean update(Jurusan old, String kode, String nama) {
		try {
			String query = String.format("UPDATE `%s` SET `%s` = ?, `%s` = ?, `%s` = CURRENT_TIMESTAMP() WHERE `%s` = ?", Jurusan.TABLE_NAME, Jurusan.KODE_COLUMN, Jurusan.NAMA_COLUMN, Jurusan.TANGGAL_DIPERBARUI_COLUMN, Jurusan.ID_COLUMN);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, kode);
			preparedStatement.setString(2, nama);
			preparedStatement.setInt(3, old.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean delete(Jurusan jurusan) {
		try {
			String query = String.format("DELETE FROM `%s` WHERE `%s` = ?", Jurusan.TABLE_NAME, Jurusan.ID_COLUMN);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, jurusan.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}

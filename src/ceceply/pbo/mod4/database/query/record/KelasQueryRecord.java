package ceceply.pbo.mod4.database.query.record;

import ceceply.pbo.mod4.record.Kelas;
import ceceply.pbo.mod4.record.Jurusan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class KelasQueryRecord extends QueryRecord {
	public static LinkedList<Kelas> all() {
		try {
			String query = String.format("SELECT * FROM `%s` INNER JOIN `%s` ON `%s`.`%s` = `%s`.`%s` ORDER BY `%s`.`%s` DESC",
				Kelas.TABLE_NAME,
				Jurusan.TABLE_NAME,
				Jurusan.TABLE_NAME,
				Jurusan.ID_COLUMN,
				Kelas.TABLE_NAME,
				Kelas.ID_JURUSAN_COLUMN,
				Kelas.TABLE_NAME,
				Kelas.TANGGAL_DIBUAT_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			LinkedList<Kelas> kelasLinkedList = new LinkedList<>();

			while (resultSet.next()) {
				kelasLinkedList.add(new Kelas(
					resultSet.getInt(Kelas.TABLE_NAME + "." + Kelas.ID_COLUMN),
					resultSet.getString(Kelas.TABLE_NAME + "." + Kelas.KODE_COLUMN),
					resultSet.getString(Kelas.TABLE_NAME + "." + Kelas.NAMA_COLUMN),
					new Jurusan(
						resultSet.getInt(Jurusan.TABLE_NAME + "." + Jurusan.ID_COLUMN),
						resultSet.getString(Jurusan.TABLE_NAME + "." + Jurusan.KODE_COLUMN),
						resultSet.getString(Jurusan.TABLE_NAME + "." + Jurusan.NAMA_COLUMN),
						resultSet.getString(Jurusan.TABLE_NAME + "." + Jurusan.TANGGAL_DIPERBARUI_COLUMN),
						resultSet.getString(Jurusan.TABLE_NAME + "." + Jurusan.TANGGAL_DIBUAT_COLUMN)
						),
					resultSet.getDate(Kelas.TABLE_NAME + "." + Kelas.TANGGAL_DIPERBARUI_COLUMN),
					resultSet.getDate(Kelas.TABLE_NAME + "." + Kelas.TANGGAL_DIBUAT_COLUMN)
				));
			}

			return kelasLinkedList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean insert(String kode, String nama, Jurusan jurusan) {
		try {
			String query = String.format("INSERT INTO `%s` (`%s`, `%s`, `%s`) VALUES (?, ?, ?)", Kelas.TABLE_NAME, Kelas.KODE_COLUMN, Kelas.NAMA_COLUMN, Kelas.ID_JURUSAN_COLUMN);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, kode);
			preparedStatement.setString(2, nama);
			preparedStatement.setInt(3, jurusan.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

		public static Boolean update(Kelas old, String kode, String nama, Jurusan jurusan) {
		try {
			String query = String.format(
				"UPDATE `%s` SET `%s` = ?, `%s` = ?, `%s` = ? WHERE `%s` = ?",
				Kelas.TABLE_NAME,
				Kelas.KODE_COLUMN,
				Kelas.NAMA_COLUMN,
				Kelas.ID_JURUSAN_COLUMN,
				Kelas.ID_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, kode);
			preparedStatement.setString(2, nama);
			preparedStatement.setInt(3, jurusan.id());
			preparedStatement.setInt(4, old.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

		public static Boolean delete(Kelas kelas) {
		try {
			String query = String.format(
				"DELETE FROM %s WHERE `%s` = ?",
				Kelas.TABLE_NAME,
				Kelas.ID_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, kelas.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}

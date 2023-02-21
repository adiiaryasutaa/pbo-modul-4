package ceceply.pbo.mod4.database.query.record;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.record.Jurusan;
import ceceply.pbo.mod4.record.Kelas;
import ceceply.pbo.mod4.record.Siswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class SiswaQueryRecord extends QueryRecord {
	public static LinkedList<Siswa> all() {
		try {
			String query = String.format(
				"""
						SELECT * FROM `%s`
						INNER JOIN `%s` ON `%s`.`%s` = `%s`.`%s`
						INNER JOIN `%s` ON `%s`.`%s` = `%s`.`%s`
						ORDER BY `%s`.`%s`
				""",
				Siswa.TABLE_NAME,
				Kelas.TABLE_NAME,
				Siswa.TABLE_NAME,
				Siswa.ID_KELAS_COLUMN,
				Kelas.TABLE_NAME,
				Kelas.ID_COLUMN,
				Jurusan.TABLE_NAME,
				Jurusan.TABLE_NAME,
				Jurusan.ID_COLUMN,
				Kelas.TABLE_NAME,
				Kelas.ID_JURUSAN_COLUMN,
				Siswa.TABLE_NAME,
				Siswa.TANGGAL_DIBUAT_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			LinkedList<Siswa> siswaLinkedList = new LinkedList<>();

			while (resultSet.next()) {
				siswaLinkedList.add(new Siswa(
					resultSet.getInt(Siswa.TABLE_NAME + "." + Siswa.ID_COLUMN),
					resultSet.getString(Siswa.TABLE_NAME + "." + Siswa.NIS_COLUMN),
					resultSet.getString(Siswa.TABLE_NAME + "." + Siswa.NAMA_COLUMN),
					resultSet.getString(Siswa.TABLE_NAME + "." + Siswa.NO_TELEPON_COLUMN),
					resultSet.getString(Siswa.TABLE_NAME + "." + Siswa.ALAMAT_COLUMN),
					new Kelas(
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
						resultSet.getDate(Kelas.TABLE_NAME + "." + Kelas.TANGGAL_DIBUAT_COLUMN),
						resultSet.getDate(Kelas.TABLE_NAME + "." + Kelas.TANGGAL_DIPERBARUI_COLUMN)
					),
					resultSet.getDate(Siswa.TABLE_NAME + "." + Siswa.TANGGAL_DIPERBARUI_COLUMN),
					resultSet.getDate(Siswa.TABLE_NAME + "." + Siswa.TANGGAL_DIBUAT_COLUMN)
				));
			}

			return siswaLinkedList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean insert(String nis, String nama, String noTelepon, String alamat, Kelas kelas) {
		Connection connection = Application.getDatabaseConnection().getConnection();

		try {
			String query = String.format(
				"INSERT INTO `%s` (`%s`, `%s`, `%s`, `%s`, `%s`) VALUES (?, ?, ?, ?, ?)",
				Siswa.TABLE_NAME,
				Siswa.NIS_COLUMN,
				Siswa.NAMA_COLUMN,
				Siswa.NO_TELEPON_COLUMN,
				Siswa.ALAMAT_COLUMN,
				Siswa.ID_KELAS_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, nis);
			preparedStatement.setString(2, nama);
			preparedStatement.setString(3, noTelepon);
			preparedStatement.setString(4, alamat);
			preparedStatement.setInt(5, kelas.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean update(Siswa siswa, String nis, String nama, String noTelepon, String alamat, Kelas kelas) {
		try {
			String query = String.format(
				"UPDATE `%s` SET `%s` = ?, `%s` = ?, `%s` = ?, `%s` = ?, `%s` = ?, `%s` = CURRENT_TIMESTAMP() WHERE `%s` = ?",
				Siswa.TABLE_NAME,
				Siswa.NIS_COLUMN,
				Siswa.NAMA_COLUMN,
				Siswa.NO_TELEPON_COLUMN,
				Siswa.ALAMAT_COLUMN,
				Siswa.ID_KELAS_COLUMN,
				Siswa.TANGGAL_DIPERBARUI_COLUMN,
				Siswa.ID_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, nis);
			preparedStatement.setString(2, nama);
			preparedStatement.setString(3, noTelepon);
			preparedStatement.setString(4, alamat);
			preparedStatement.setInt(5, kelas.id());
			preparedStatement.setInt(6, siswa.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean delete(Siswa siswa) {
		try {
			String query = String.format(
				"DELETE FROM `%s` WHERE `%s` = ?",
				Siswa.TABLE_NAME,
				Siswa.ID_COLUMN
			);
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, siswa.id());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}

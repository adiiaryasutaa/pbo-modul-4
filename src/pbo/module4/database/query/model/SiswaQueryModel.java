package pbo.module4.database.query.model;

import pbo.module4.Application;
import pbo.module4.record.Mapel;
import pbo.module4.record.Siswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class SiswaQueryModel {
	public static LinkedList<Siswa> getAllSiswa() {
		Connection connection = Application.getDatabaseConnection().getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM murid");

			ResultSet resultSet = preparedStatement.executeQuery();

			LinkedList<Siswa> mapelLinkedList = new LinkedList<>();

			while (resultSet.next()) {
				mapelLinkedList.add(new Siswa(
					resultSet.getString(Siswa.NIS_COLUMN),
					resultSet.getString(Siswa.NAMA_COLUMN),
					resultSet.getString(Siswa.PHONE_COLUMN),
					resultSet.getString(Siswa.ALAMAT_COLUMN)
				));
			}

			return mapelLinkedList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Boolean insertSiswa(Siswa siswa) {
		Connection connection = Application.getDatabaseConnection().getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO murid VALUES (?, ?, ?, ?)");

			preparedStatement.setString(1, siswa.nis());
			preparedStatement.setString(2, siswa.nama());
			preparedStatement.setString(3, siswa.nomorTelp());
			preparedStatement.setString(4, siswa.alamat());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean updateSiswa(String nis, Siswa update) {
		Connection connection = Application.getDatabaseConnection().getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
				"UPDATE murid SET " + Siswa.NIS_COLUMN + " = ?, " + Siswa.NAMA_COLUMN + " = ?, " + Siswa.PHONE_COLUMN + " = ?, " + Siswa.ALAMAT_COLUMN + " = ? WHERE " + Siswa.NIS_COLUMN + " = ?"
			);

			preparedStatement.setString(1, update.nis());
			preparedStatement.setString(2, update.nama());
			preparedStatement.setString(3, update.nomorTelp());
			preparedStatement.setString(4, update.alamat());
			preparedStatement.setString(5, nis);

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static Boolean deleteSiswa(Siswa siswa) {
		Connection connection = Application.getDatabaseConnection().getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM murid WHERE " + Siswa.NIS_COLUMN + " = ?");

			preparedStatement.setString(1, siswa.nis());

			preparedStatement.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}

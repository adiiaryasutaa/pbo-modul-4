//package pbo.module4.database.query.model;
//
//import pbo.module4.Application;
//import pbo.module4.record.Kelas;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//
//public class KelasQueryModel {
//	public static LinkedList<Kelas> getAllKelas() {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM kelas");
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			LinkedList<Kelas> kelasLinkedList = new LinkedList<>();
//
//			while (resultSet.next()) {
//				kelasLinkedList.add(new Kelas(
//					resultSet.getString(Kelas.KODE_KELAS_COLUMN),
//					resultSet.getString(Kelas.NAMA_KELAS_COLUMN)
//				));
//			}
//
//			return kelasLinkedList;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public static Boolean insertKelas(Kelas kelas) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO kelas VALUES (?, ?)");
//
//			preparedStatement.setString(1, kelas.kode());
//			preparedStatement.setString(2, kelas.nama());
//
//			preparedStatement.execute();
//
//			return true;
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return false;
//		}
//	}
//
//	public static Boolean updateKelas(String kode, Kelas update) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE kelas SET " + Kelas.KODE_KELAS_COLUMN + " = ?, " + Kelas.NAMA_KELAS_COLUMN + " = ? WHERE " + Kelas.KODE_KELAS_COLUMN + " = ?");
//
//			preparedStatement.setString(1, update.kode());
//			preparedStatement.setString(2, update.nama());
//			preparedStatement.setString(3, kode);
//
//			preparedStatement.execute();
//
//			return true;
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return false;
//		}
//	}
//
//	public static Boolean deleteKelas(Kelas kelas) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM kelas WHERE " + Kelas.KODE_KELAS_COLUMN + " = ?");
//
//			preparedStatement.setString(1, kelas.kode());
//
//			preparedStatement.execute();
//
//			return true;
//		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			return false;
//		}
//	}
//}

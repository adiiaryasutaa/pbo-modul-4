//package pbo.module4.database.query.model;
//
//import pbo.module4.Application;
//import pbo.module4.model.Jurusan;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//
//public class JurusanQueryModel {
//	public static LinkedList<Jurusan> getAllJurusan() {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jurusan");
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			LinkedList<Jurusan> jurusanLinkedList = new LinkedList<>();
//
//			while (resultSet.next()) {
//				jurusanLinkedList.add(new Jurusan(
//					resultSet.getString(Jurusan.KODE_JURUSAN_COLUMN),
//					resultSet.getString(Jurusan.NAMA_JURUSAN_COLUMN)
//				));
//			}
//
//			return jurusanLinkedList;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public static Boolean insertJurusan(Jurusan jurusan) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jurusan VALUES (?, ?)");
//
//			preparedStatement.setString(1, jurusan.kode());
//			preparedStatement.setString(2, jurusan.nama());
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
//	public static Boolean updateJurusan(String kode, Jurusan update) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE jurusan SET " + Jurusan.KODE_JURUSAN_COLUMN + " = ?, " + Jurusan.NAMA_JURUSAN_COLUMN + " = ? WHERE " + Jurusan.KODE_JURUSAN_COLUMN + " = ?");
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
//	public static Boolean deleteJurusan(Jurusan jurusan) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM jurusan WHERE " + Jurusan.KODE_JURUSAN_COLUMN + " = ?");
//
//			preparedStatement.setString(1, jurusan.kode());
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

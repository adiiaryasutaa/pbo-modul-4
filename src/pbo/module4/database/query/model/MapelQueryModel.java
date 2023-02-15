//package pbo.module4.database.query.model;
//
//import pbo.module4.Application;
//import pbo.module4.record.Mapel;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//
//public class MapelQueryModel {
//	public static LinkedList<Mapel> getAllMapel() {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mapel");
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			LinkedList<Mapel> mapelLinkedList = new LinkedList<>();
//
//			while (resultSet.next()) {
//				mapelLinkedList.add(new Mapel(
//					resultSet.getString(Mapel.ID_MAPEL_COLUMN),
//					resultSet.getString(Mapel.NAMA_MAPEL_COLUMN)
//				));
//			}
//
//			return mapelLinkedList;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public static Boolean insertMapel(Mapel mapel) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mapel VALUES (?, ?)");
//
//			preparedStatement.setString(1, mapel.id());
//			preparedStatement.setString(2, mapel.nama());
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
//	public static Boolean updateMapel(String id, Mapel update) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mapel SET " + Mapel.ID_MAPEL_COLUMN + " = ?, " + Mapel.NAMA_MAPEL_COLUMN + " = ? WHERE " + Mapel.ID_MAPEL_COLUMN + " = ?");
//
//			preparedStatement.setString(1, update.id());
//			preparedStatement.setString(2, update.nama());
//			preparedStatement.setString(3, id);
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
//	public static Boolean deleteMapel(Mapel mapel) {
//		Connection connection = Application.getDatabaseConnection().getConnection();
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mapel WHERE " + Mapel.ID_MAPEL_COLUMN + " = ?");
//
//			preparedStatement.setString(1, mapel.id());
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

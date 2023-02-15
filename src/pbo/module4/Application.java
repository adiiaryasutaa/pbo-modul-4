package pbo.module4;

import pbo.module4.auth.AuthManager;
import pbo.module4.database.DatabaseConnection;
import pbo.module4.database.DatabaseQuery;
import pbo.module4.forms.MainForm;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class Application {
	private static DatabaseConnection databaseConnection;
	private static DatabaseQuery databaseQuery;
	private static AuthManager authManager = new AuthManager();

	public static void main(String[] args) {
		Application.makeDatabaseConnection();
		Application.start();
	}

	private static void makeDatabaseConnection() {
//		Application.databaseConnection = new DatabaseConnection("localhost:3310", "db_pbo", "root", "fr33pass");
		Application.databaseConnection = new DatabaseConnection("localhost:3310", "nilai_sekolah", "root", "fr33pass");
		Application.databaseConnection.connect();
		Application.databaseQuery = new DatabaseQuery(Application.databaseConnection);
	}

	private static void start() {
		(new MainForm()).run();
	}

	public static File getResource(String path) throws URISyntaxException, IOException {
		URI resourceURI = Objects.requireNonNull(Application.class.getResource("resources\\" + path)).toURI();
		return new File(resourceURI);
	}

	public static URL getResourceURL(String path) throws URISyntaxException, IOException {
		return Application.getResource(path).toURI().toURL();
	}

	public static DatabaseConnection getDatabaseConnection() {
		return Application.databaseConnection;
	}

	public static DatabaseQuery getDatabaseQuery() {
		return Application.databaseQuery;
	}

	public static AuthManager getAuthManager() {
		return Application.authManager;
	}
}

package pbo.module4;

import pbo.module4.database.DatabaseConnection;
import pbo.module4.database.DatabaseQuery;
import pbo.module4.forms.MainForm;
import pbo.module4.forms.SplashForm;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class Application {
	private static DatabaseConnection databaseConnection;
	private static DatabaseQuery databaseQuery;

	private static SplashForm splashForm;

	public static void main(String[] args) throws URISyntaxException, IOException {
		Application.makeDatabaseConnection();
		Application.start();
	}

	private static void makeDatabaseConnection() {
		Application.databaseConnection = new DatabaseConnection("localhost:3310", "db_pbo", "root", "fr33pass");
		Application.databaseConnection.connect();
		Application.databaseQuery = new DatabaseQuery(Application.databaseConnection);
	}

	private static void start() throws URISyntaxException, IOException {
		Application.splashForm = new SplashForm();

		Application.splashForm.setVisible(true);
		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(10);

				if (i == 100) {
					Application.splashForm.setVisible(false);
					(new MainForm()).setVisible(true);
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
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
}

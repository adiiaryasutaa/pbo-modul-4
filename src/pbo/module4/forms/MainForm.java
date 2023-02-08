package pbo.module4.forms;

import pbo.module4.forms.component.MenuBar;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
	private JPanel panel;

	private static JMenuBar menuBar = new MenuBar();
	private static final SplashScreen splashScreen = new SplashScreen();
	private static final LoginForm loginForm = new LoginForm();
	private static final HomeScreen homeScreen = new HomeScreen();
	private static final JurusanForm jurusanForm = new JurusanForm();
	private static final KelasForm kelasForm = new KelasForm();
	private static final MapelForm mapelForm = new MapelForm();
	private static final SiswaForm siswaForm = new SiswaForm();

	public MainForm() {
		this.init();
	}

	private void init() {
		this.setContentPane(this.panel);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 1400, 780);
		this.setLocationRelativeTo(null);

		this.setJMenuBar(MainForm.menuBar);

		this.panel.add(MainForm.splashScreen).setVisible(false);
		this.panel.add(MainForm.loginForm).setVisible(false);
		this.panel.add(MainForm.homeScreen).setVisible(false);
		this.panel.add(MainForm.jurusanForm).setVisible(true);
		this.panel.add(MainForm.kelasForm).setVisible(false);
		this.panel.add(MainForm.mapelForm).setVisible(false);
		this.panel.add(MainForm.siswaForm).setVisible(false);
	}

	public static void beforeAuthenticatedScene() {
		MainForm.menuBar.setVisible(false);
		MainForm.loginForm.setVisible(true);
		MainForm.homeScreen.setVisible(false);
		MainForm.jurusanForm.setVisible(false);
		MainForm.kelasForm.setVisible(false);
		MainForm.mapelForm.setVisible(false);
		MainForm.siswaForm.setVisible(false);
	}

	public static void authenticatedScene() {
		MainForm.menuBar.setVisible(true);
		MainForm.loginForm.setVisible(false);
		MainForm.homeScreen.setVisible(true);
		MainForm.jurusanForm.setVisible(false);
		MainForm.kelasForm.setVisible(false);
		MainForm.mapelForm.setVisible(false);
		MainForm.siswaForm.setVisible(false);
	}

	public void run() {
		this.setVisible(true);
		MainForm.splashScreen.setVisible(true);

		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(10);

				if (i == 100) {
					MainForm.splashScreen.setVisible(false);
					MainForm.beforeAuthenticatedScene();
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static SplashScreen getSplashScreen() {
		return MainForm.splashScreen;
	}

	public static LoginForm getLoginForm() {
		return MainForm.loginForm;
	}

	public static HomeScreen getHomeScreen() {
		return MainForm.homeScreen;
	}

	public static JurusanForm getJurusanForm() {
		return MainForm.jurusanForm;
	}

	public static KelasForm getKelasForm() {
		return MainForm.kelasForm;
	}

	public static MapelForm getMapelForm() {
		return MainForm.mapelForm;
	}

	public static SiswaForm getSiswaForm() {
		return MainForm.siswaForm;
	}
}

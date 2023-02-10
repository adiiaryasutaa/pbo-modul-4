package pbo.module4.forms;

import pbo.module4.forms.component.MenuBar;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
	private static ScreenRepository screenRepository;
	private static JMenuBar menuBar;

	static {
		MainForm.screenRepository = new ScreenRepository();
		MainForm.menuBar = new MenuBar();

		MainForm.screenRepository.put("splash", new SplashScreen());
		MainForm.screenRepository.put("login", new LoginForm());
		MainForm.screenRepository.put("home", new HomeScreen());
		MainForm.screenRepository.put("jurusan", new JurusanForm());
		MainForm.screenRepository.put("kelas", new KelasForm());
		MainForm.screenRepository.put("mapel", new MapelForm());
		MainForm.screenRepository.put("siswa", new SiswaForm());
	}

//	private static final SplashScreen splashScreen = new SplashScreen();
//	private static final LoginForm loginForm = new LoginForm();
//	private static final TestScreen testScreen = new TestScreen();
//	private static final HomeScreen homeScreen = new HomeScreen();
//	private static final JurusanForm jurusanForm = new JurusanForm();
//	private static final KelasForm kelasForm = new KelasForm();
//	private static final MapelForm mapelForm = new MapelForm();
//	private static final SiswaForm siswaForm = new SiswaForm();

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

//		this.panel.add(MainForm.splashScreen).setVisible(false);
//		this.panel.add(MainForm.loginForm).setVisible(false);
//		this.panel.add(MainForm.homeScreen).setVisible(false);
//		this.panel.add(MainForm.testScreen).setVisible(false);
//		this.panel.add(MainForm.jurusanForm).setVisible(false);
//		this.panel.add(MainForm.kelasForm).setVisible(false);
//		this.panel.add(MainForm.mapelForm).setVisible(false);
//		this.panel.add(MainForm.siswaForm).setVisible(false);
	}

	public static void beforeAuthenticatedScene() {
		MainForm.screenRepository.show("login");

//		MainForm.menuBar.setVisible(false);
//		MainForm.loginForm.setVisible(true);
//		MainForm.homeScreen.setVisible(false);
//		MainForm.testScreen.setVisible(false);
//		MainForm.jurusanForm.setVisible(false);
//		MainForm.kelasForm.setVisible(false);
//		MainForm.mapelForm.setVisible(false);
//		MainForm.siswaForm.setVisible(false);
	}

	public static void authenticatedScene() {
		MainForm.screenRepository.show("home");

//		MainForm.menuBar.setVisible(true);
//		MainForm.loginForm.setVisible(false);
//		MainForm.homeScreen.setVisible(true);
//		MainForm.testScreen.setVisible(false);
//		MainForm.jurusanForm.setVisible(false);
//		MainForm.kelasForm.setVisible(false);
//		MainForm.mapelForm.setVisible(false);
//		MainForm.siswaForm.setVisible(false);
	}

	public void run() {
		this.setVisible(true);

		MainForm.screenRepository.show("splash");

		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(10);

				if (i == 100) {
					MainForm.beforeAuthenticatedScene();
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static ScreenRepository getScreenRepository() {
		return MainForm.screenRepository;
	}

//	public static SplashScreen getSplashScreen() {
//		return MainForm.splashScreen;
//	}
//
//	public static LoginForm getLoginForm() {
//		return MainForm.loginForm;
//	}
//
//	public static HomeScreen getHomeScreen() {
//		return MainForm.homeScreen;
//	}
//
//	public static JurusanForm getJurusanForm() {
//		return MainForm.jurusanForm;
//	}
//
//	public static KelasForm getKelasForm() {
//		return MainForm.kelasForm;
//	}
//
//	public static MapelForm getMapelForm() {
//		return MainForm.mapelForm;
//	}
//
//	public static SiswaForm getSiswaForm() {
//		return MainForm.siswaForm;
//	}

	private JPanel panel;
}

package pbo.module4.forms;

import pbo.module4.forms.component.MenuBar;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
	private static ScreenRepository screenRepository;
	private static MenuBar menuBar;

	static {
		MainForm.screenRepository = new ScreenRepository();
		MainForm.menuBar = new MenuBar();

		MainForm.screenRepository.put("splash", new SplashScreen());
		MainForm.screenRepository.put("login", new LoginForm());
		MainForm.screenRepository.put("home", new HomeScreen());
		MainForm.screenRepository.put("jurusan", new JurusanForm());
		MainForm.screenRepository.put("kelas", new KelasForm());
		MainForm.screenRepository.put("mapel", new MapelForm());
//		MainForm.screenRepository.put("siswa", new SiswaForm());
	}

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

		for (JComponent screen : MainForm.screenRepository.values()) {
			this.add(screen).setVisible(false);
		}
	}

	public static void beforeAuthenticatedScene() {
		MainForm.menuBar.setVisible(false);
		MainForm.screenRepository.show("login");
	}

	public static void authenticatedScene() {
		MainForm.menuBar.setVisible(true);
		MainForm.screenRepository.show("home");
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

	private JPanel panel;
}

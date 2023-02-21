package ceceply.pbo.mod4.gui;

import ceceply.pbo.mod4.gui.component.MenuBar;
import ceceply.pbo.mod4.gui.screen.SplashScreen;
import ceceply.pbo.mod4.gui.screen.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private static ScreenRepository screenRepository;
	private static MenuBar menuBar;

	static {
		MainFrame.screenRepository = new ScreenRepository();
		MainFrame.menuBar = new MenuBar();

		MainFrame.screenRepository.put("splash", new SplashScreen());
		MainFrame.screenRepository.put("login", new LoginScreen());
		MainFrame.screenRepository.put("home", new HomeScreen());
		MainFrame.screenRepository.put("jurusan", new JurusanScreen());
		MainFrame.screenRepository.put("kelas", new KelasScreen());
		MainFrame.screenRepository.put("mapel", new MapelScreen());
		MainFrame.screenRepository.put("siswa", new SiswaScreen());
	}

	public MainFrame() {
		this.init();
	}

	private void init() {
		this.setContentPane(this.panel);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 1400, 780);
		this.setLocationRelativeTo(null);

		this.setJMenuBar(MainFrame.menuBar);

		for (JComponent screen : MainFrame.screenRepository.values()) {
			this.add(screen).setVisible(false);
		}
	}

	public static void beforeAuthenticatedScene() {
		MainFrame.menuBar.setVisible(false);
		MainFrame.screenRepository.show("login");
	}

	public static void authenticatedScene() {
		MainFrame.menuBar.setVisible(true);
		MainFrame.screenRepository.show("home");
	}

	public void run() {
		this.setVisible(true);

		MainFrame.screenRepository.show("splash");

		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(10);

				if (i == 100) {
					MainFrame.beforeAuthenticatedScene();
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static ScreenRepository getScreenRepository() {
		return MainFrame.screenRepository;
	}

	private JPanel panel;
}

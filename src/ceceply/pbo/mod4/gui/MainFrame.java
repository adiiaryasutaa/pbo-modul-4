package ceceply.pbo.mod4.gui;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.auth.UserLevel;
import ceceply.pbo.mod4.gui.component.MenuBar;
import ceceply.pbo.mod4.gui.screen.*;
import ceceply.pbo.mod4.gui.screen.SplashScreen;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private ScreenRepository screenRepository;
	private MenuBar menuBar;

	public MainFrame() {
		this.screenRepository = new ScreenRepository(this);
		this.menuBar = new MenuBar(this);
		this.init();
	}

	private void init() {
		this.setContentPane(this.panel);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 1400, 780);
		this.setLocationRelativeTo(null);

		this.setJMenuBar(this.menuBar);
	}

	public void authenticationScene() {
		this.menuBar.update();

		this.screenRepository.clear();
		this.screenRepository.put("login", new LoginScreen(this));
		this.screenRepository.addAllScreenToContext();

		this.screenRepository.show("login");
	}

	public void authenticatedScene() {
		this.menuBar.update();

		UserLevel userLevel = Application.getAuthManager().getUser().userLevel();

		this.screenRepository.clear();

		this.screenRepository.put("home", new HomeScreen(this));

		if (userLevel == UserLevel.ADMIN) {
			this.screenRepository.put("jurusan", new JurusanScreen(this));
			this.screenRepository.put("kelas", new KelasScreen(this));
			this.screenRepository.put("mapel", new MapelScreen(this));
			this.screenRepository.put("siswa", new SiswaScreen(this));
		} else if (userLevel == UserLevel.SISWA) {

		}

		this.screenRepository.addAllScreenToContext();

		this.screenRepository.show("home");
	}

	public void run() {
		this.screenRepository.clear();
		this.screenRepository.put("splash", new SplashScreen());
		this.screenRepository.addAllScreenToContext();

		this.setVisible(true);
		this.screenRepository.show("splash");

		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(10);

				if (i == 100) {
					this.authenticationScene();
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public ScreenRepository getScreenRepository() {
		return this.screenRepository;
	}

	private JPanel panel;
}

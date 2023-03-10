package ceceply.pbo.mod4.gui.screen;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.gui.MainFrame;
import ceceply.pbo.mod4.gui.listener.screen.HomeScreenComponentListener;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class HomeScreen extends JPanel {
	private MainFrame context;

	public HomeScreen(MainFrame context) {
		this.context = context;
		this.init();
	}

	private void init() {
		this.add(this.panel);

		this.addComponentListener(new HomeScreenComponentListener(this.welcomeLabel));

		try {
			Icon image = new ImageIcon(Application.getResourceURL("skensa-gif.gif"));
			this.imageLabel.setIcon(image);
			this.imageLabel.setSize(100, 100);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private JPanel panel;
	private JLabel welcomeLabel;
	private JLabel imageLabel;
}

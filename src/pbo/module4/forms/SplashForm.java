package pbo.module4.forms;

import pbo.module4.Application;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SplashForm extends JFrame {
	private JPanel panel;

	private JLabel splashImageLabel;

	public SplashForm() throws HeadlessException, IOException, URISyntaxException {
		this.init();
		this.prepareSplashImage();
	}

	private void init() {
		this.setContentPane(this.panel);
		this.setUndecorated(true);
		this.setResizable(false);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 400, 400);
		this.setLocationRelativeTo(null);
	}

	private void prepareSplashImage() throws IOException, URISyntaxException {
		URL splashImageURL = Application.getResource("splash.png").toURI().toURL();
		ImageIcon splashImageIcon = new ImageIcon(splashImageURL);
		Image splashImage = splashImageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		splashImageIcon.setImage(splashImage);
		this.splashImageLabel.setIcon(splashImageIcon);
	}
}

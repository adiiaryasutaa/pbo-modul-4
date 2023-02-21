package ceceply.pbo.mod4.gui.screen;

import ceceply.pbo.mod4.Application;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SplashScreen extends JPanel {
	private JPanel panel;
	private JLabel splashIcon;

	public SplashScreen() {
		this.add(this.panel);
		this.prepareSplashImage();
	}

	private void prepareSplashImage() {
		try {
			URL splashImageURL = Application.getResource("logo-skensa.png").toURI().toURL();
			ImageIcon splashImageIcon = new ImageIcon(splashImageURL);
			Image splashImage = splashImageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			splashImageIcon.setImage(splashImage);
			this.splashIcon.setIcon(splashImageIcon);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}

package pbo.module4.forms;

import pbo.module4.Application;
import pbo.module4.forms.listener.screen.HomeScreenComponentListener;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class HomeScreen extends JPanel implements FocusListener {
	private JPanel panel;
	private JLabel welcomeLabel;
	private JLabel imageLabel;

	public HomeScreen() {
		this.add(this.panel);
		this.init();
	}

	private void init() {
		this.addComponentListener(new HomeScreenComponentListener(this.welcomeLabel));

		try {
			Icon image = new ImageIcon(Application.getResourceURL("skensa-gif.gif"));
			this.imageLabel.setIcon(image);
			this.imageLabel.setSize(100, 100);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}

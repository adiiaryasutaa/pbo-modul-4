package ceceply.pbo.mod4.gui.listener.screen;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.auth.AuthManager;
import ceceply.pbo.mod4.auth.AuthModel;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class HomeScreenComponentListener implements ComponentListener {
	private JLabel welcomeLabel;

	public HomeScreenComponentListener(JLabel welcomeLabel) {
		this.welcomeLabel = welcomeLabel;
	}

	@Override
	public void componentResized(ComponentEvent e) {

	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {
		AuthManager auth = Application.getAuthManager();

		AuthModel user = auth.getUser();
		if (user != null) {
			this.welcomeLabel.setText(String.format(this.welcomeLabel.getText(), user.username()));
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}
}

package pbo.module4.forms.listener.screen;

import pbo.module4.Application;
import pbo.module4.auth.AuthManager;
import pbo.module4.auth.AuthModel;

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
//			if (user.role())
			this.welcomeLabel.setText(String.format(this.welcomeLabel.getText(), user.username()));
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}
}

package ceceply.pbo.mod4.gui.screen;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.gui.MainFrame;
import ceceply.pbo.mod4.gui.listener.LoginSubmitButtonMouseListener;
import ceceply.pbo.mod4.gui.style.TextFieldFocusListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LoginScreen extends JPanel {
	private MainFrame context;

	public LoginScreen(MainFrame context) {
		this.context = context;
		this.init();
	}

	private void init() {
		this.add(this.panel);

		this.prepareLoginImageIcon();

		this.usernameTextField.addFocusListener(new TextFieldFocusListener(this.usernameTextField));
		this.passwordPasswordField.addFocusListener(new TextFieldFocusListener(this.passwordPasswordField));

		this.submitButton.setBorder(this.usernameTextField.getBorder());
		this.submitButton.addMouseListener(new LoginSubmitButtonMouseListener(this.context, this.submitButton, this.usernameTextField, this.passwordPasswordField));
	}

	private void prepareLoginImageIcon() {
		try {
			URL splashImageURL = Application.getResource("logo-skensa.png").toURI().toURL();
			ImageIcon splashImageIcon = new ImageIcon(splashImageURL);
			Image splashImage = splashImageIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
			splashImageIcon.setImage(splashImage);
			this.loginImageIcon.setIcon(splashImageIcon);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private JPanel panel;
	private JTextField usernameTextField;
	private JPasswordField passwordPasswordField;
	private JLabel loginImageIcon;
	private JButton submitButton;
}

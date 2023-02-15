package pbo.module4.forms;

import pbo.module4.Application;
import pbo.module4.forms.listener.LoginSubmitButtonMouseListener;
import pbo.module4.forms.style.TextFieldFocusListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LoginForm extends JPanel {
	private JPanel panel;
	private JTextField usernameTextField;
	private JPasswordField passwordPasswordField;
	private JLabel loginImageIcon;
	private JButton submitButton;

	public LoginForm() {
		this.init();
		this.prepareLoginImageIcon();
	}

	private void init() {
		this.add(this.panel);

		this.usernameTextField.addFocusListener(new TextFieldFocusListener(this.usernameTextField));
		this.passwordPasswordField.addFocusListener(new TextFieldFocusListener(this.passwordPasswordField));

		this.submitButton.setBorder(this.usernameTextField.getBorder());
		this.submitButton.addMouseListener(new LoginSubmitButtonMouseListener(this, this.submitButton, this.usernameTextField, this.passwordPasswordField));
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
}

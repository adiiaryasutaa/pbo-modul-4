package pbo.module4.forms.listener;

import pbo.module4.forms.MainForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSubmitButtonMouseListener extends MouseAdapter {
	private Component context;
	private JButton button;

	public LoginSubmitButtonMouseListener(Component context, JButton button) {
		this.context = context;
		this.button = button;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		MainForm.authenticatedScene();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		this.button.setBackground(new Color(30, 64, 175));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		this.button.setBackground(new Color(29, 78, 216));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
		context.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.button.setBackground(new Color(29, 78, 216));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		super.mouseExited(e);
		context.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.button.setBackground(new Color(37, 99, 235));
	}
}

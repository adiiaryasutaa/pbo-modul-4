package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.Application;
import ceceply.pbo.mod4.gui.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class LogOutMenuMouseListener extends MenuMouseListener {
	public LogOutMenuMouseListener(MainFrame context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int selection = JOptionPane.showConfirmDialog(this.context, "Apakah Anda yakin ingin keluar?", "Keluar", JOptionPane.YES_NO_OPTION);
		if (selection == 0) {
			Application.getAuthManager().logout();
			this.context.authenticationScene();
		}
	}
}

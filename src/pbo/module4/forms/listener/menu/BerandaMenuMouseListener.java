package pbo.module4.forms.listener.menu;

import pbo.module4.forms.MainForm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BerandaMenuMouseListener extends MenuMouseListener {
	public BerandaMenuMouseListener(Component context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainForm.getHomeScreen().setVisible(true);
		MainForm.getJurusanForm().setVisible(false);
		MainForm.getKelasForm().setVisible(false);
		MainForm.getMapelForm().setVisible(false);
		MainForm.getSiswaForm().setVisible(false);
	}
}

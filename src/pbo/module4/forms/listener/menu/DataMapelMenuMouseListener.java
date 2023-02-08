package pbo.module4.forms.listener.menu;

import pbo.module4.forms.MainForm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DataMapelMenuMouseListener extends MenuMouseListener {
	public DataMapelMenuMouseListener(Component context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainForm.getHomeScreen().setVisible(false);
		MainForm.getJurusanForm().setVisible(false);
		MainForm.getKelasForm().setVisible(false);
		MainForm.getMapelForm().setVisible(true);
		MainForm.getSiswaForm().setVisible(false);
	}
}

package pbo.module4.forms.listener.menubar;

import pbo.module4.forms.MainForm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DataMapelMenuMouseListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		MainForm.getJurusanForm().setVisible(false);
		MainForm.getKelasForm().setVisible(false);
		MainForm.getMapelForm().setVisible(true);
		MainForm.getSiswaForm().setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}

package pbo.module4.forms.listener.menu;

import pbo.module4.forms.MainForm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DataKelasMenuMouseListener extends MenuMouseListener {
	public DataKelasMenuMouseListener(Component context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainForm.getScreenRepository().show("kelas");
	}
}

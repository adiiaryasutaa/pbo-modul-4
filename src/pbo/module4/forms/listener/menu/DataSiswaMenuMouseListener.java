package pbo.module4.forms.listener.menu;

import pbo.module4.forms.MainForm;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DataSiswaMenuMouseListener extends MenuMouseListener {
	public DataSiswaMenuMouseListener(Component context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainForm.getScreenRepository().show("siswa");
	}
}

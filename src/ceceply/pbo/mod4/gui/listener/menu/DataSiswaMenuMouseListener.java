package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.gui.MainFrame;

import java.awt.event.MouseEvent;

public class DataSiswaMenuMouseListener extends MenuMouseListener {
	public DataSiswaMenuMouseListener(MainFrame context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.context.getScreenRepository().show("siswa");
	}
}

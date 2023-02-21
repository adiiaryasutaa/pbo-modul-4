package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.gui.MainFrame;

import java.awt.event.MouseEvent;

public class DataJurusanMenuMouseListener extends MenuMouseListener {
	public DataJurusanMenuMouseListener(MainFrame context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.context.getScreenRepository().show("jurusan");
	}
}

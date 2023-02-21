package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.gui.MainFrame;

import java.awt.event.MouseEvent;

public class DataKelasMenuMouseListener extends MenuMouseListener {
	public DataKelasMenuMouseListener(MainFrame context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.context.getScreenRepository().show("kelas");
	}
}

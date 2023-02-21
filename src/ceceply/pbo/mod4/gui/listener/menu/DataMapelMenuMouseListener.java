package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.gui.MainFrame;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DataMapelMenuMouseListener extends MenuMouseListener {
	public DataMapelMenuMouseListener(Component context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainFrame.getScreenRepository().show("mapel");
	}
}

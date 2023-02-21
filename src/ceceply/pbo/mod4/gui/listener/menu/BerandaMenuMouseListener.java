package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.gui.MainFrame;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BerandaMenuMouseListener extends MenuMouseListener {
	public BerandaMenuMouseListener(Component context) {
		super(context);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainFrame.getScreenRepository().show("home");
	}
}

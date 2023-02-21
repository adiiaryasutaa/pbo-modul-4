package ceceply.pbo.mod4.gui.listener.menu;

import ceceply.pbo.mod4.gui.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuMouseListener extends MouseAdapter {
	protected MainFrame context;

	public MenuMouseListener(MainFrame context) {
		this.context = context;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		super.mouseEntered(e);
		this.context.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		super.mouseExited(e);
		this.context.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}

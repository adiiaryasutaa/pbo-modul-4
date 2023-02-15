/*
 * Created by JFormDesigner on Sat Feb 11 11:11:23 WITA 2023
 */

package pbo.module4.gui.screen;

import pbo.module4.forms.component.MenuBar;

import javax.swing.*;
import java.awt.*;

/**
 * @author adiar
 */
public class MainFrame extends JFrame {
	public MainFrame() {
		initComponents();
		this.setJMenuBar(new MenuBar());
		this.add(new JurusanScreen());

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);

		this.setBounds(x, y, 1400, 780);
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

		//======== this ========
		var contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(675, 475);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

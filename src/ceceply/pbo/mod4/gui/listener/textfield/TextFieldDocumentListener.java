package ceceply.pbo.mod4.gui.listener.textfield;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldDocumentListener implements DocumentListener {
	private JButton editButton;

	public TextFieldDocumentListener(JButton editButton) {
		this.editButton = editButton;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {

	}

	@Override
	public void removeUpdate(DocumentEvent e) {

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("Value changed");
	}
}

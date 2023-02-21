package ceceply.pbo.mod4.gui.style;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TextFieldFocusListener extends FocusAdapter {
	private JTextField textField;
	private Color defaultBorderColor = new Color(148, 163, 184);
	private Color focusBorderColor = new Color(59, 130, 246);
	private Border border = BorderFactory.createEmptyBorder(10, 8, 10, 8);

	public TextFieldFocusListener(JTextField textField) {
		this.textField = textField;

		this.textField.setBorder(BorderFactory.createCompoundBorder(
			new LineBorder(this.defaultBorderColor, 1),
			border
		));
	}

	@Override
	public void focusGained(FocusEvent e) {
		super.focusGained(e);
		this.textField.setBorder(BorderFactory.createCompoundBorder(
			new LineBorder(this.focusBorderColor, 1),
			border
		));
	}

	@Override
	public void focusLost(FocusEvent e) {
		super.focusLost(e);
		this.textField.setBorder(BorderFactory.createCompoundBorder(
			new LineBorder(this.defaultBorderColor, 1),
			border
		));
	}
}

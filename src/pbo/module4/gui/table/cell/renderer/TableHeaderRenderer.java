package pbo.module4.gui.table.cell.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHeaderRenderer implements TableCellRenderer {
	DefaultTableCellRenderer tableCellRenderer;

	public TableHeaderRenderer(JTable table) {
		this.tableCellRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();

		this.tableCellRenderer.setHorizontalAlignment(JLabel.LEFT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		return null;
	}
}

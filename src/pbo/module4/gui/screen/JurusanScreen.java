/*
 * Created by JFormDesigner on Sat Feb 11 11:01:39 WITA 2023
 */

package pbo.module4.gui.screen;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import pbo.module4.forms.table.model.JurusanTableModel;

import javax.swing.*;
import java.awt.*;

public class JurusanScreen extends JPanel {
	public JurusanScreen() {
		initComponents();
		this.setSize(new Dimension());
		this.table.setModel(new JurusanTableModel());
		this.table.getTableHeader().setFont(new Font("Inter", Font.BOLD, 16));
		this.table.getTableHeader().setPreferredSize(new Dimension(0, 24));
//		this.table.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(this.table));
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		mainPanel = new JPanel();
		label1 = new JLabel();
		separator1 = new JSeparator();
		scrollPane1 = new JScrollPane();
		table = new JTable();

		//======== this ========
		setLayout(new GridLayoutManager(1, 1, new Insets(24, 24, 24, 24), 5, -1));

		//======== mainPanel ========
		{

			//---- label1 ----
			label1.setText("Data Jurusan");
			label1.setFont(new Font("Inter", Font.PLAIN, 24));

			//---- separator1 ----
			separator1.setPreferredSize(new Dimension(200, 3));

			//======== scrollPane1 ========
			{

				//---- table ----
				table.setFont(new Font("Inter", Font.PLAIN, 16));
				table.setIntercellSpacing(new Dimension(0, 0));
				table.setRowHeight(36);
				table.setRowMargin(12);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane1.setViewportView(table);
			}

			GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
			mainPanel.setLayout(mainPanelLayout);
			mainPanelLayout.setHorizontalGroup(
				mainPanelLayout.createParallelGroup()
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(mainPanelLayout.createParallelGroup()
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 811, GroupLayout.PREFERRED_SIZE)
							.addComponent(label1)
							.addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			mainPanelLayout.setVerticalGroup(
				mainPanelLayout.createParallelGroup()
					.addGroup(mainPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(24, 24, 24)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
		}
		add(mainPanel, new GridConstraints(0, 0, 1, 1,
			GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
			GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
			GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
			null, null, null));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	private JPanel mainPanel;
	private JLabel label1;
	private JSeparator separator1;
	private JScrollPane scrollPane1;
	private JTable table;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

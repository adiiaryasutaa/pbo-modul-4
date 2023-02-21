package ceceply.pbo.mod4.gui.screen;

import ceceply.pbo.mod4.database.query.record.MapelQueryRecord;
import ceceply.pbo.mod4.gui.MainFrame;
import ceceply.pbo.mod4.gui.table.model.MapelTableModel;

import javax.swing.*;

public class MapelScreen extends JPanel {
	private MainFrame context;

	public MapelScreen(MainFrame context) {
		this.context = context;
		this.init();
	}

	private void init() {
		this.add(this.panel);
		this.tableModel = new MapelTableModel();
		this.table.setModel(this.tableModel);

		this.editButton.setEnabled(false);
		this.hapusButton.setEnabled(false);
		this.batalButton.setEnabled(false);

		this.tambahButton.addActionListener(e -> this.addMapel());

		this.editButton.addActionListener(e -> this.editMapel());

		this.hapusButton.addActionListener(e -> this.deleteMapel());

		this.batalButton.addActionListener(e -> {
			this.table.getSelectionModel().clearSelection();

			this.clearInputs();
		});

		this.table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRowIndex = this.table.getSelectedRow();

			boolean selectionEmpty = this.table.getSelectionModel().isSelectionEmpty();

			if (!selectionEmpty) {
				this.kodeTextField.setText(this.table.getValueAt(selectedRowIndex, 0).toString());
				this.namaTextField.setText(this.table.getValueAt(selectedRowIndex, 1).toString());
			}

			this.tambahButton.setEnabled(selectionEmpty);
			this.editButton.setEnabled(!selectionEmpty);
			this.hapusButton.setEnabled(!selectionEmpty);
			this.batalButton.setEnabled(!selectionEmpty);
		});
	}

	private void addMapel() {
		String kode = this.kodeTextField.getText().trim();
		String nama = this.namaTextField.getText().trim();

		if (kode.isEmpty() || kode.isBlank() || nama.isEmpty() || nama.isBlank()) {
			JOptionPane.showMessageDialog(this, "Input tidak boleh kosong", "Gagal Menambah Mapel", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (MapelQueryRecord.insert(kode, nama)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menambahkan mapel");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menambahkan mapel", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void editMapel() {
		String kode = this.kodeTextField.getText().trim();
		String nama = this.namaTextField.getText().trim();

		int selectedRow = this.table.getSelectedRow();

		if (MapelQueryRecord.update(this.tableModel.getData().get(selectedRow), kode, nama)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil mengedit mapel");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal mengedit mapel", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteMapel() {
		int selectedRowIndex = this.table.getSelectedRow();

		if (MapelQueryRecord.delete(this.tableModel.getData().get(selectedRowIndex))) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menghapus kelas");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menghapus kelas", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void clearInputs() {
		this.kodeTextField.setText("");
		this.namaTextField.setText("");
	}

	private JPanel panel;
	private JTextField kodeTextField;
	private JTextField namaTextField;
	private JButton tambahButton;
	private JButton editButton;
	private JButton hapusButton;
	private JButton batalButton;
	private JTable table;
	private MapelTableModel tableModel;
}

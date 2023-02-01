package pbo.module4.forms;

import pbo.module4.database.query.model.KelasQueryModel;
import pbo.module4.forms.table.model.KelasTableModel;

import javax.swing.*;

public class KelasForm extends JPanel {
	private JPanel panel;
	private JTextField kodeTextField;
	private JTextField namaTextField;
	private JButton tambahButton;
	private JButton editButton;
	private JButton hapusButton;
	private JButton batalButton;
	private JTable table;
	private KelasTableModel tableModel;

	public KelasForm() {
		this.add(this.panel);
		this.tableModel = new KelasTableModel();
		this.table.setModel(this.tableModel);

		this.editButton.setEnabled(false);
		this.hapusButton.setEnabled(false);
		this.batalButton.setEnabled(false);

		this.tambahButton.addActionListener(e -> this.addKelas());

		this.editButton.addActionListener(e -> this.editKelas());

		this.hapusButton.addActionListener(e -> this.deleteKelas());

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

	private void addKelas() {
		String kode = this.kodeTextField.getText().trim();
		String nama = this.namaTextField.getText().trim();

		if (kode.isEmpty() || kode.isBlank() || nama.isEmpty() || nama.isBlank()) {
			JOptionPane.showMessageDialog(this, "Input tidak boleh kosong", "Gagal Menambah Kelas", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (KelasQueryModel.insertKelas(new pbo.module4.record.Kelas(kode, nama))) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menambahkan kelas");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menambahkan kelas", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void editKelas() {
		String kode = this.kodeTextField.getText().trim();
		String nama = this.namaTextField.getText().trim();

		int selectedRow = this.table.getSelectedRow();

		if (KelasQueryModel.updateKelas(
			(String) this.table.getValueAt(selectedRow, 0),
			new pbo.module4.record.Kelas(kode, nama)
		)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil mengedit kelas");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal mengedit kelas", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteKelas() {
		int selectedRowIndex = this.table.getSelectedRow();

		if (KelasQueryModel.deleteKelas(this.tableModel.getData().get(selectedRowIndex))) {
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
}

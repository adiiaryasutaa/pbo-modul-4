package pbo.module4.forms;

import pbo.module4.database.query.model.SiswaQueryModel;
import pbo.module4.forms.table.model.SiswaTableModel;

import javax.swing.*;

public class SiswaForm extends JPanel {
	private JPanel panel;
	private JTextField nisTextField;
	private JTextField alamatTextField;
	private JButton tambahButton;
	private JButton editButton;
	private JButton hapusButton;
	private JButton batalButton;
	private JTextField noTlpTextField;
	private JTextField namaTextField;
	private JTable table;
	private SiswaTableModel tableModel;

	public SiswaForm() {
		this.add(this.panel);
		this.tableModel = new SiswaTableModel();
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
				this.nisTextField.setText(this.table.getValueAt(selectedRowIndex, 0).toString());
				this.namaTextField.setText(this.table.getValueAt(selectedRowIndex, 1).toString());
				this.noTlpTextField.setText(this.table.getValueAt(selectedRowIndex, 2).toString());
				this.alamatTextField.setText(this.table.getValueAt(selectedRowIndex, 3).toString());
			}

			this.tambahButton.setEnabled(selectionEmpty);
			this.editButton.setEnabled(!selectionEmpty);
			this.hapusButton.setEnabled(!selectionEmpty);
			this.batalButton.setEnabled(!selectionEmpty);
		});
	}

	private void addKelas() {
		String nis = this.nisTextField.getText().trim();
		String nama = this.namaTextField.getText().trim();
		String noTlp = this.noTlpTextField.getText().trim();
		String alamat = this.alamatTextField.getText().trim();

		if (
			nis.isEmpty() || nis.isBlank() ||
			nama.isEmpty() || nama.isBlank() ||
			noTlp.isEmpty() || noTlp.isBlank() ||
			alamat.isEmpty() || alamat.isBlank()
		) {
			JOptionPane.showMessageDialog(this, "Input tidak boleh kosong", "Gagal Menambah Siswa", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (SiswaQueryModel.insertSiswa(new pbo.module4.record.Siswa(nis, nama, noTlp, alamat))) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menambahkan kelas");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menambahkan kelas", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void editKelas() {
		String nis = this.nisTextField.getText().trim();
		String nama = this.namaTextField.getText().trim();
		String noTlp = this.noTlpTextField.getText().trim();
		String alamat = this.alamatTextField.getText().trim();

		int selectedRow = this.table.getSelectedRow();

		if (SiswaQueryModel.updateSiswa(
			(String) this.table.getValueAt(selectedRow, 0),
			new pbo.module4.record.Siswa(nis, nama, noTlp, alamat)
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

		if (SiswaQueryModel.deleteSiswa(this.tableModel.getData().get(selectedRowIndex))) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menghapus mapel");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menghapus mapel", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void clearInputs() {
		this.nisTextField.setText("");
		this.namaTextField.setText("");
		this.noTlpTextField.setText("");
		this.alamatTextField.setText("");
	}
}

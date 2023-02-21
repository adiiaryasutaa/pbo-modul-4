package ceceply.pbo.mod4.gui.screen;

import ceceply.pbo.mod4.database.query.record.KelasQueryRecord;
import ceceply.pbo.mod4.database.query.record.SiswaQueryRecord;
import ceceply.pbo.mod4.record.Kelas;
import ceceply.pbo.mod4.gui.table.model.SiswaTableModel;

import javax.swing.*;

public class SiswaScreen extends JPanel {
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
	private JComboBox<Kelas> kelasComboBox;
	private SiswaTableModel tableModel;

	public SiswaScreen() {
		this.add(this.panel);
		this.init();
	}

	private void init() {
		this.tableModel = new SiswaTableModel();
		this.table.setModel(this.tableModel);

		for (Kelas kelas : KelasQueryRecord.all()) {
			this.kelasComboBox.addItem(kelas);
		}

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
		Kelas kelas = this.kelasComboBox.getItemAt(this.kelasComboBox.getSelectedIndex());

		if (
			nis.isEmpty() || nis.isBlank() ||
			nama.isEmpty() || nama.isBlank() ||
			noTlp.isEmpty() || noTlp.isBlank() ||
			alamat.isEmpty() || alamat.isBlank()
		) {
			JOptionPane.showMessageDialog(this, "Input tidak boleh kosong", "Gagal Menambah Siswa", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (SiswaQueryRecord.insert(nis, nama, noTlp, alamat, kelas)) {
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
		Kelas kelas = this.kelasComboBox.getItemAt(this.kelasComboBox.getSelectedIndex());

		int selectedRow = this.table.getSelectedRow();

		if (SiswaQueryRecord.update(this.tableModel.getData().get(selectedRow), nis, nama, noTlp, alamat, kelas)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil mengedit kelas");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal mengedit kelas", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteKelas() {
		int selectedRowIndex = this.table.getSelectedRow();

		if (SiswaQueryRecord.delete(this.tableModel.getData().get(selectedRowIndex))) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menghapus kelas");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menghapus kelas", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void clearInputs() {
		this.nisTextField.setText("");
		this.namaTextField.setText("");
		this.noTlpTextField.setText("");
		this.alamatTextField.setText("");
		this.kelasComboBox.setSelectedIndex(0);
	}
}

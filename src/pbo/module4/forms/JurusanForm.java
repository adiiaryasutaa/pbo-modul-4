package pbo.module4.forms;

import pbo.module4.forms.table.model.JurusanTableModel;
import pbo.module4.model.Jurusan;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JurusanForm extends JPanel {
	private JPanel panel;
	private JTextField kodeJurusanTextField;
	private JTextField namaJurusanTextField;
	private JButton tambahButton;
	private JButton editButton;
	private JButton hapusButton;
	private JButton batalButton;
	private JTable table;
	private JurusanTableModel tableModel;

	public JurusanForm() {
		this.add(this.panel).setSize(800, 400);
		this.tableModel = new JurusanTableModel();
		this.table.setModel(tableModel);

		this.editButton.setEnabled(false);
		this.hapusButton.setEnabled(false);
		this.batalButton.setEnabled(false);

		this.tambahButton.addActionListener(e -> this.addJurusan());

		this.editButton.addActionListener(e -> this.editJurusan());

		this.hapusButton.addActionListener(e -> this.deleteJurusan());

		this.batalButton.addActionListener(e -> {
			System.out.println(this.table.getSelectionModel().isSelectionEmpty());

			this.table.getSelectionModel().clearSelection();

			this.clearInputs();
		});

		this.table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRowIndex = this.table.getSelectedRow();

			boolean selectionEmpty = this.table.getSelectionModel().isSelectionEmpty();

			if (!selectionEmpty) {
				this.kodeJurusanTextField.setText(this.table.getValueAt(selectedRowIndex, 0).toString());
				this.namaJurusanTextField.setText(this.table.getValueAt(selectedRowIndex, 1).toString());
			}

			this.tambahButton.setEnabled(selectionEmpty);
			this.editButton.setEnabled(!selectionEmpty);
			this.hapusButton.setEnabled(!selectionEmpty);
			this.batalButton.setEnabled(!selectionEmpty);
		});
	}

	protected void addJurusan() {
		String kodeJurusan = this.kodeJurusanTextField.getText().trim();
		String namaJurusan = this.namaJurusanTextField.getText().trim();

		if (kodeJurusan.isEmpty() || kodeJurusan.isBlank() || namaJurusan.isEmpty() || namaJurusan.isBlank()) {
			return;
		}

		HashMap<String, Object> data = new HashMap<>();
		data.put(Jurusan.KODE_JURUSAN_COLUMN, kodeJurusan);
		data.put(Jurusan.NAMA_JURUSAN_COLUMN, namaJurusan);

		if (Jurusan.add(data)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menambahkan jurusan");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menambahkan jurusan");
		}
	}

	protected void editJurusan() {
		String kodeJurusan = this.kodeJurusanTextField.getText().trim();
		String namaJurusan = this.namaJurusanTextField.getText().trim();

		int selectedRow = this.table.getSelectedRow();

		LinkedHashMap<String, Object> data = new LinkedHashMap<>();
		data.put(Jurusan.KODE_JURUSAN_COLUMN, kodeJurusan);
		data.put(Jurusan.NAMA_JURUSAN_COLUMN, namaJurusan);

		LinkedHashMap<String, Object> wheres = new LinkedHashMap<>();
		wheres.put(Jurusan.KODE_JURUSAN_COLUMN, this.table.getValueAt(selectedRow, 0));

		if (Jurusan.update(data, wheres)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil mengedit jurusan");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal mengedit jurusan");
		}
	}

	protected void deleteJurusan() {
		int selectedRowIndex = this.table.getSelectedRow();

		HashMap<String, Object> data = new HashMap<>();
		data.put(Jurusan.KODE_JURUSAN_COLUMN, this.table.getValueAt(selectedRowIndex, 0));

		if (Jurusan.delete(data)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menghapus jurusan");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menghapus jurusan");
		}
	}

	public void clearInputs() {
		this.kodeJurusanTextField.setText("");
		this.namaJurusanTextField.setText("");
	}
}

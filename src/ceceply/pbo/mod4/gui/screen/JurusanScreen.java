package ceceply.pbo.mod4.gui.screen;

import ceceply.pbo.mod4.database.query.record.JurusanQueryRecord;
import ceceply.pbo.mod4.gui.MainFrame;
import ceceply.pbo.mod4.gui.listener.textfield.TextFieldDocumentListener;
import ceceply.pbo.mod4.gui.table.model.JurusanTableModel;
import ceceply.pbo.mod4.record.Jurusan;

import javax.swing.*;

public class JurusanScreen extends JPanel {
	private MainFrame context;

	public JurusanScreen(MainFrame context) {
		this.context = context;
		this.init();
	}

	private void init() {
		this.add(this.panel).setSize(800, 400);
		this.tableModel = new JurusanTableModel();
		this.table.setModel(tableModel);

		this.namaJurusanTextField.getDocument().addDocumentListener(new TextFieldDocumentListener(this.editButton));

		this.editButton.setEnabled(false);
		this.hapusButton.setEnabled(false);
		this.batalButton.setEnabled(false);

		this.tambahButton.addActionListener(e -> this.addJurusan());

		this.editButton.addActionListener(e -> this.editJurusan());

		this.hapusButton.addActionListener(e -> this.deleteJurusan());

		this.batalButton.addActionListener(e -> {
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
			JOptionPane.showMessageDialog(this, "Input tidak boleh kosong", "Gagal Menambah Jurusan", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (JurusanQueryRecord.insert(kodeJurusan, namaJurusan)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menambahkan jurusan");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menambahkan jurusan", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void editJurusan() {
		String kodeJurusan = this.kodeJurusanTextField.getText().trim();
		String namaJurusan = this.namaJurusanTextField.getText().trim();

		int selectedRow = this.table.getSelectedRow();
		Jurusan jurusan = this.tableModel.getData().get(selectedRow);

		if (JurusanQueryRecord.update(jurusan, kodeJurusan, namaJurusan)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil mengedit jurusan");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal mengedit jurusan", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void deleteJurusan() {
		int selectedRowIndex = this.table.getSelectedRow();
		Jurusan jurusan = this.tableModel.getData().get(selectedRowIndex);

		if (JurusanQueryRecord.delete(jurusan)) {
			this.clearInputs();
			this.tableModel.refresh();
			JOptionPane.showMessageDialog(this, "Berhasil menghapus jurusan");
		} else {
			JOptionPane.showMessageDialog(this, "Gagal menghapus jurusan", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void clearInputs() {
		this.kodeJurusanTextField.setText("");
		this.namaJurusanTextField.setText("");
	}

	private JPanel panel;
	private JTextField kodeJurusanTextField;
	private JTextField namaJurusanTextField;
	private JButton tambahButton;
	private JButton editButton;
	private JButton hapusButton;
	private JButton batalButton;
	private JTable table;
	private JurusanTableModel tableModel;
}

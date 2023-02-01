package pbo.module4.forms.table.model;

import pbo.module4.database.query.model.SiswaQueryModel;
import pbo.module4.record.Siswa;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class SiswaTableModel extends AbstractTableModel {
	private LinkedList<Siswa> data;
	private Vector<String> columnNameVector;
	private Vector<Vector<Object>> dataVector;

	public SiswaTableModel() {
		this.columnNameVector = new Vector<>(List.of("NIS", "Nama", "No. Tlp", "Alamat"));
		this.dataVector = new Vector<>();
		this.refresh();
	}

	public void refresh() {
		this.fetchData();
	}

	private void fetchData() {
		this.data = SiswaQueryModel.getAllSiswa();

		this.dataVector.removeAllElements();

		this.data.forEach(siswa ->
			SiswaTableModel.this.dataVector.add(
				new Vector<>(List.of(siswa.nis(), siswa.nama(), siswa.nomorTelp(), siswa.alamat())))
		);

		this.fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return this.dataVector.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNameVector.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return dataVector.elementAt(rowIndex).elementAt(columnIndex);
	}

	@Override
	public String getColumnName(int index) {
		return this.columnNameVector.elementAt(index);
	}

	public LinkedList<Siswa> getData() {
		return this.data;
	}
}
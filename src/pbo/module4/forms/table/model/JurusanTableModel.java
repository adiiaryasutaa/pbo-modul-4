package pbo.module4.forms.table.model;

import pbo.module4.model.Jurusan;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class JurusanTableModel extends AbstractTableModel {
	private Vector<String> columnNameVector;
	private Vector<Vector<Object>> dataVector;

	public JurusanTableModel() {
		this.columnNameVector = new Vector<>(List.of("Kode Jurusan", "Nama Jurusan"));
		this.dataVector = new Vector<>();
		this.refresh();
	}

	public void refresh() {
		this.getData();
		System.out.println("Table refreshed");
	}

	private void getData() {
		var data = Jurusan.all();

		this.dataVector.removeAllElements();

		data.forEach(jurusan ->
			JurusanTableModel.this.dataVector.add(
				new Vector<>(List.of(jurusan.getKodeJurusan(), jurusan.getNamaJurusan())))
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
}
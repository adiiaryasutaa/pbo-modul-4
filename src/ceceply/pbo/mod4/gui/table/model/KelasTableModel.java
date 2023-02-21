package ceceply.pbo.mod4.gui.table.model;

import ceceply.pbo.mod4.database.query.record.KelasQueryRecord;
import ceceply.pbo.mod4.record.Kelas;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class KelasTableModel extends AbstractTableModel {
	private LinkedList<Kelas> data;
	private Vector<String> columnNameVector;
	private Vector<Vector<Object>> dataVector;

	public KelasTableModel() {
		this.columnNameVector = new Vector<>(List.of("Kode Kelas", "Nama Kelas", "Jurusan"));
		this.dataVector = new Vector<>();
		this.refresh();
	}

	public void refresh() {
		this.fetchData();
	}

	private void fetchData() {
		this.data = KelasQueryRecord.all();

		this.dataVector.removeAllElements();

		this.data.forEach(kelas ->
			KelasTableModel.this.dataVector.add(
				new Vector<>(List.of(kelas.kode(), kelas.nama(), kelas.jurusan().nama())))
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

	public LinkedList<Kelas> getData() {
		return this.data;
	}
}
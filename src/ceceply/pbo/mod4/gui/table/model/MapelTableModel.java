package ceceply.pbo.mod4.gui.table.model;

import ceceply.pbo.mod4.database.query.record.MapelQueryRecord;
import ceceply.pbo.mod4.record.Mapel;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class MapelTableModel extends AbstractTableModel {
	private LinkedList<Mapel> data;
	private Vector<String> columnNameVector;
	private Vector<Vector<Object>> dataVector;

	public MapelTableModel() {
		this.columnNameVector = new Vector<>(List.of("Kode", "Nama"));
		this.dataVector = new Vector<>();
		this.refresh();
	}

	public void refresh() {
		this.fetchData();
	}

	private void fetchData() {
		this.data = MapelQueryRecord.all();

		this.dataVector.removeAllElements();

		this.data.forEach(mapel ->
			MapelTableModel.this.dataVector.add(
				new Vector<>(List.of(mapel.kode(), mapel.nama())))
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

	public LinkedList<Mapel> getData() {
		return this.data;
	}
}
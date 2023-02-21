package ceceply.pbo.mod4.gui.table.model;

import ceceply.pbo.mod4.database.query.record.SiswaQueryRecord;
import ceceply.pbo.mod4.record.Siswa;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class SiswaTableModel extends AbstractTableModel {
	private LinkedList<Siswa> data;
	private Vector<String> columnNameVector;
	private Vector<Vector<Object>> dataVector;

	public SiswaTableModel() {
		this.columnNameVector = new Vector<>(List.of("NIS", "Nama", "No. Tlp", "Alamat", "Kelas"));
		this.dataVector = new Vector<>();
		this.refresh();
	}

	public void refresh() {
		this.fetchData();
	}

	private void fetchData() {
		this.data = SiswaQueryRecord.all();

		this.dataVector.removeAllElements();

		this.data.forEach(siswa ->
			SiswaTableModel.this.dataVector.add(
				new Vector<>(List.of(siswa.nis(), siswa.nama(), siswa.noTelepon(), siswa.alamat(), siswa.kelas().nama())))
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
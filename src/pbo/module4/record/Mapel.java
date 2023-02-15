package pbo.module4.record;

import java.sql.Date;

public record Mapel(int id, String kode, String nama, Date tanggalDiperbarui, Date tanggalDibuat) {
	public static final String TABLE_NAME = "mapel";
	public static final String ID_COLUMN = "id";
	public static final String KODE_COLUMN = "kode";
	public static final String NAMA_COLUMN = "nama";
	public static final String TANGGAL_DIPERBARUI_COLUMN = "diperbarui_pada";
	public static final String TANGGAL_DIBUAT_COLUMN = "dibuat_pada";

}

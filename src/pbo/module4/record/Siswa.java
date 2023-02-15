package pbo.module4.record;

import java.sql.Date;

public record Siswa(int id, String nis, String nama, String noTelepon, String alamat, Kelas kelas, Date tanggalDiperbarui, Date tanggalDibuat) {
	public static final String TABLE_NAME = "siswa";
	public static final String ID_COLUMN = "id";
	public static final String NIS_COLUMN = "nis";
	public static final String NAMA_COLUMN = "nama";
	public static final String NO_TELEPON_COLUMN = "no_telepon";
	public static final String ALAMAT_COLUMN = "alamat";
	public static final String ID_KELAS_COLUMN = "id_kelas";
	public static final String TANGGAL_DIPERBARUI_COLUMN = "diperbarui_pada";
	public static final String TANGGAL_DIBUAT_COLUMN = "dibuat_pada";
}

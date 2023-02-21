package ceceply.pbo.mod4.record;

public record Jurusan(int id, String kode, String nama, String tanggalDiperbarui, String tanggalDibuat) {
	public static final String TABLE_NAME = "jurusan";
	public static final String ID_COLUMN = "id";
	public static final String KODE_COLUMN = "kode";
	public static final String NAMA_COLUMN = "nama";
	public static final String TANGGAL_DIPERBARUI_COLUMN = "diperbarui_pada";
	public static final String TANGGAL_DIBUAT_COLUMN = "dibuat_pada";

	@Override
	public String toString() {
		return nama;
	}
}

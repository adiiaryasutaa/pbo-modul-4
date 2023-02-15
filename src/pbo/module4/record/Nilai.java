package pbo.module4.record;

public record Nilai(String idMapel, String nis, String kodeJurusan, String nilai) {
	public static final String TABLE_NAME = "nilai";
	public static final String ID_COLUMN = "id";
	public static final String ID_MAPEL_COLUMN = "id_mapel";
	public static final String ID_SISWA_COLUMN = "id_siswa";
	public static final String NILAI_COLUMN = "nilai";
	public static final String TANGGAL_DIPERBARUI_COLUMN = "diperbarui_pada";
	public static final String TANGGAL_DIBUAT_COLUMN = "dibuat_pada";
}

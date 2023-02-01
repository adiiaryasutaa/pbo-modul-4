package pbo.module4.record;

public record Siswa(String nis, String nama, String nomorTelp, String alamat) {
	public static final String NIS_COLUMN = "nis";
	public static final String NAMA_COLUMN = "nama";
	public static final String PHONE_COLUMN = "phone";
	public static final String ALAMAT_COLUMN = "alamat";
}

package pbo.module4.record;

public record Jurusan(String kode, String nama) {
	public static final String KODE_JURUSAN_COLUMN = "kode_jurusan";
	public static final String NAMA_JURUSAN_COLUMN = "nama_jurusan";
}

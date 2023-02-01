package pbo.module4.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Jurusan extends Model {
	private static String table = "jurusan";
	private String kodeJurusan;
	private String namaJurusan;

	public Jurusan(String kodeJurusan, String namaJurusan) {
		this.kodeJurusan = kodeJurusan;
		this.namaJurusan = namaJurusan;
	}

	public static LinkedList<Jurusan> all() {
		return Model.all(Jurusan.table);
	}

	public static boolean update(LinkedHashMap<String, Object> data, LinkedHashMap<String, Object> wheres) {
		return Model.update(Jurusan.table, data, wheres);
	}

	public String getKodeJurusan() {
		return kodeJurusan;
	}

	public String getNamaJurusan() {
		return namaJurusan;
	}

	public static final String KODE_JURUSAN_COLUMN = "kode_jurusan";
	public static final String NAMA_JURUSAN_COLUMN = "nama_jurusan";
}

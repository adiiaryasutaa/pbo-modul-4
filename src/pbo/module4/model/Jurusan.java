package pbo.module4.model;

import pbo.module4.Application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Jurusan {
	private static final String table = "jurusan";
	private String kodeJurusan;
	private String namaJurusan;

	public Jurusan(String kodeJurusan, String namaJurusan) {
		this.kodeJurusan = kodeJurusan;
		this.namaJurusan = namaJurusan;
	}

	public static LinkedList<Jurusan> all() {
		LinkedList<LinkedHashMap<String, Object>> data = Application.getDatabaseQuery().all(Jurusan.table);
		LinkedList<Jurusan> list = new LinkedList<>();

		data.forEach(k -> {
			list.add(new Jurusan(
				(String) k.get(Jurusan.KODE_JURUSAN_COLUMN),
				(String) k.get(Jurusan.NAMA_JURUSAN_COLUMN)
			));
		});

		return list;
	}

	public static boolean add(HashMap<String, Object> data) {
		return Application.getDatabaseQuery().add(Jurusan.table, data);
	}

	public static boolean update(LinkedHashMap<String, Object> data, LinkedHashMap<String, Object> wheres) {
		return Application.getDatabaseQuery().update(Jurusan.table, data, wheres);
	}

	public static boolean delete(HashMap<String, Object> data) {
		return Application.getDatabaseQuery().delete(Jurusan.table, data);
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

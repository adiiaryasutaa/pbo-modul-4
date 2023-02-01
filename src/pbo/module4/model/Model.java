package pbo.module4.model;

import pbo.module4.Application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public abstract class Model {
	protected static String table;

	public static LinkedList<Jurusan> all(String table) {
		LinkedList<LinkedHashMap<String, Object>> data = Application.getDatabaseQuery().all(table);
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
		return Application.getDatabaseQuery().add(Model.table, data);
	}

	public static boolean update(String table, LinkedHashMap<String, Object> data, LinkedHashMap<String, Object> wheres) {
		return Application.getDatabaseQuery().update(table, data, wheres);
	}

	public static boolean delete(HashMap<String, Object> data) {
		return Application.getDatabaseQuery().delete(Model.table, data);
	}
}

package pbo.module4.model;

public abstract class Model {
	protected static String table;

	public Model(String table) {
		this.table = table;
	}
}

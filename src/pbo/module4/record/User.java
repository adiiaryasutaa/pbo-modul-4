package pbo.module4.record;

import pbo.module4.auth.AuthModel;

import java.sql.Date;

public record User(int id, String username, String password, int level, Date tanggalDiperbarui, Date tanggalDibuat) implements AuthModel {
	@Override
	public String username() {
		return username;
	}

	@Override
	public String password() {
		return password;
	}

	@Override
	public String role() {
		 switch (level) {
			 case 1:
				 return UserLevel.ADMIN.name();
			 case 2:
			 default:
				 return UserLevel.PETUGAS.name();
		 }
	}

	public static final String TABLE_NAME = "user";
	public static final String ID_COLUMN = "id";
	public static final String USERNAME_COLUMN = "username";
	public static final String PASSWORD_COLUMN = "password";
	public static final String LEVEL_COLUMN = "level";
	public static final String TANGGAL_DIPERBARUI_COLUMN = "diperbarui_pada";
	public static final String TANGGAL_DIBUAT_COLUMN = "dibuat_pada";
}

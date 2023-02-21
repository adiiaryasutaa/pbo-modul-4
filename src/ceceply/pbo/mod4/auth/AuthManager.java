package ceceply.pbo.mod4.auth;

import ceceply.pbo.mod4.database.query.record.SiswaQueryRecord;
import ceceply.pbo.mod4.database.query.record.UserQueryRecord;
import ceceply.pbo.mod4.record.Siswa;
import ceceply.pbo.mod4.record.User;

public class AuthManager {
	private AuthModel model = null;

	public AuthManager() {}

	public boolean attempt(String username, String password) {
		User user = UserQueryRecord.get(username);

		if (user != null && user.password().equals(password)) {
			this.login(user);
			return true;
		}

		Siswa siswa = SiswaQueryRecord.get(username);

		if (siswa != null && siswa.password().equals(password)) {
			this.login(siswa);
			return true;
		}

		return false;
	}

	public void login(AuthModel user) {
		this.model = user;
	}

	public void logout() {
		this.model = null;
	}

	public AuthModel getUser() {
		return this.model;
	}
}

package pbo.module4.auth;

import pbo.module4.database.query.record.UserQueryRecord;
import pbo.module4.record.User;

public class AuthManager {
	private AuthModel model = null;

	public AuthManager() {}

	public boolean attempt(String username, String password) {
		User user = UserQueryRecord.get(username);

		if (user != null && user.password().equals(password)) {
			this.login(user);
			return true;
		}

		return false;
	}

	public void login(AuthModel user) {
		this.model = user;
	}

	public AuthModel getUser() {
		return this.model;
	}
}

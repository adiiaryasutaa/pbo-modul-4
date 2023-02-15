package pbo.module4.model;

public record User(String username, String password, String level) {
	@Override
	public String toString() {
		return "User{" +
			"username='" + username + '\'' +
			", password='" + password + '\'' +
			", level='" + level + '\'' +
			'}';
	}
}

package Model.Bean;

import java.util.Objects;

public class User {
	private int userid;
	private String username;
	private String password;
	private int autoLogin;
	private String autoLogout;
	private String refresh;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public User(int userid, String username, int autoLogin, String autoLogout, String refresh) {
		super();
		this.userid = userid;
		this.username = username;
		this.autoLogin = autoLogin;
		this.autoLogout = autoLogout;
		this.refresh = refresh;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(int autoLogin) {
		this.autoLogin = autoLogin;
	}

	public String getAutoLogout() {
		return autoLogout;
	}

	public void setAutoLogout(String autoLogout) {
		this.autoLogout = autoLogout;
	}

	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userid, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && userid == other.userid
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}

}

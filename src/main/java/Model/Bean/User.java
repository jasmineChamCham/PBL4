package Model.Bean;

import java.util.Objects;

public class User {
	public int userid;
	public String username;
	public int autoLogin;
	public String autoLogout;
	public String refresh; // Automatic refresh period
	
	public User() {
		// TODO Auto-generated constructor stub
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
		return Objects.hash(autoLogin, autoLogout, refresh, userid, username);
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
		return autoLogin == other.autoLogin && Objects.equals(autoLogout, other.autoLogout)
				&& Objects.equals(refresh, other.refresh) && userid == other.userid
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", autoLogin=" + autoLogin + ", autoLogout="
				+ autoLogout + ", refresh=" + refresh + "]";
	}
}

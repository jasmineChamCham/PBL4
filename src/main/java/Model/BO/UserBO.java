package Model.BO;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Model.DAO.HostDAO;
import Model.Bean.User;
import Model.DAO.UserDAO;

public class UserBO {

	public static String checkLogin(String username, String password) {
		JSONObject r = HostDAO.request(HostDAO.loginJSON(username, password));
		System.out.println(r);
		String auth = r.getString("result");
		return auth;
	}
	
	public static String changePassword(String auth, String userid, String passwd)  {
		JSONObject r_error = UserDAO.request(UserDAO.changePasswordJSON(auth, userid, passwd)).getJSONObject("error");
		if (r_error == null) return null; // successful
		else return r_error.getString("data"); // fail to change
	}
	
	public static List<User> getAllUsers(String auth) {
		List<User> list = new ArrayList<>();
		JSONArray r_Users = UserDAO.request(UserDAO.getUserJSON(auth)).getJSONArray("result");
		for (int i = 0; i < r_Users.size(); i++) {
			JSONObject r = r_Users.getJSONObject(i);
			int userid = r.getIntValue("userid");
			String username = r.getString("username");
			int autoLogin = r.getIntValue("autoLogin");
			String autoLogout = r.getString("autoLogout"); 
			String refresh = r.getString("refresh");
			list.add(new User(userid, username, autoLogin, autoLogout, refresh));
		}
		return list;
	}	
}

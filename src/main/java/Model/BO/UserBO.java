package Model.BO;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Model.DAO.ZabbixDAO;
import Model.Bean.User;
import Model.DAO.UserDAO;

public class UserBO {

	public static String checkLogin(String username, String password) {
		JSONObject r = ZabbixDAO.request(ZabbixDAO.loginJSON(username, password));
		System.out.println(r);
		String auth = r.getString("result");
		return auth;
	}
	
	public static int changePassword(String auth, String userid, String passwd)  {
//		System.out.println("r1 " + UserDAO.changePasswordJSON(auth, userid, passwd));
		JSONObject r = UserDAO.request(UserDAO.changePasswordJSON(auth, userid, passwd));
//		System.out.println("r UserBO: " + r);
		JSONObject r_error = UserDAO.request(UserDAO.changePasswordJSON(auth, userid, passwd)).getJSONObject("error");
//		System.out.println("r_error : " + r_error);
		if (r_error != null) return 1; // successful
		else return 0; // fail to change
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

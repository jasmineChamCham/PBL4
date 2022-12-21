package Model.BO;

import com.alibaba.fastjson.JSONObject;

import Model.DAO.ZabbixDAO;

public class ZabbixBO {

	ZabbixDAO ZabbixDAO = new ZabbixDAO();
	
	public String checkLogin(String username, String password) {

		JSONObject r = ZabbixDAO.request(ZabbixDAO.loginJSON(username, password));
		System.out.println(r);
		String auth = r.getString("result");
		return auth;
	}
}

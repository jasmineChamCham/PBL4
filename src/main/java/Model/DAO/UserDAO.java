package Model.DAO;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserDAO {

	public static JSONObject request(JSONObject obj)
	{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://192.168.1.151/zabbix/api_jsonrpc.php");
		StringEntity entity;
		try {
			entity = new StringEntity(obj.toJSONString());
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity entityr = response.getEntity();
			byte[] data = EntityUtils.toByteArray(entityr);
			client.close();
			return (JSONObject) JSON.parse(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static JSONObject loginJSON(String username, String password)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "user.login");
		JSONObject temp = new JSONObject();
		temp.put("username", username);
		temp.put("password", password);
		obj.put("params", temp);
		obj.put("id", 1);
		return obj;
	}
	
	
	public static JSONObject getUserJSON(String auth)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "user.get");
		JSONObject temp = new JSONObject();
		temp.put("output", "extend");
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject changePasswordJSON(String auth, String userid, String passwd) {
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "user.update");
		JSONObject temp = new JSONObject();
		temp.put("userid", userid);
		temp.put("passwd", passwd);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject changeautoLoginJSON(String auth, String userid, int autologin)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "user.update");
		JSONObject temp = new JSONObject();
		temp.put("userid", userid);
		temp.put("autologin", autologin);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject changeautoLogoutJSON(String auth, String userid, int autologout) {
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "user.update");
		JSONObject temp = new JSONObject();
		temp.put("userid", userid);
		if (autologout == 1)
			temp.put("autologout", "15m");
		else // autologout == 0
			temp.put("autologout", "0s");
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
}

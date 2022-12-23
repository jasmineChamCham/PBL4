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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HostDAO {

	public static JSONObject request(JSONObject obj)
	{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://192.168.1.78/zabbix/api_jsonrpc.php");
		StringEntity entity;
		try {
			entity = new StringEntity(obj.toJSONString());
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity entityr = response.getEntity();
			byte[] data = EntityUtils.toByteArray(entityr);
			//System.out.print((JSONObject) JSON.parse(data));
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
	
	public static JSONObject getHostJSON(String auth)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "host.get");
		JSONObject temp = new JSONObject();
		temp.put("output", "extend");
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject getItemsJSON(String auth, String hostid)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "item.get");
		JSONObject temp = new JSONObject();
		temp.put("output", "extend");
		temp.put("hostids", hostid);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject getHistoryJSON(String auth, String itemid, int datatype)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "history.get");
		JSONObject temp = new JSONObject();
		temp.put("output", "extend");
		temp.put("history", datatype);
		temp.put("itemids", itemid);
		temp.put("sortfield", "clock");
		temp.put("sortorder", "DESC");
		temp.put("limit", 1);
		obj.put("params", temp);
		obj.put("auth", auth);
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
	public static JSONObject changePasswordJSON(String auth, String userid, String passwd)
	{
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
	
	public static JSONObject createHostJSON(String auth, String hostname, String ip, String port)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "host.create");
		JSONObject temp = new JSONObject();
		temp.put("host", hostname);
		
		JSONObject zinterface = new JSONObject();
		zinterface.put("type", "1");
		zinterface.put("main", "1");
		zinterface.put("useip", "1");
		zinterface.put("ip", ip);
		zinterface.put("dns", "");
		zinterface.put("port", port);
		temp.put("interfaces", zinterface);
		
		JSONArray groups = new JSONArray();
		JSONObject group1 = new JSONObject();
		group1.put("groupid", 5);
		groups.add(group1);
		JSONObject group2 = new JSONObject();
		group2.put("groupid", 10);
		groups.add(group2);
		//System.out.print(group);
		temp.put("groups", groups);

		JSONArray templates = new JSONArray();
		JSONObject template = new JSONObject();
		template.put("templateid", "10538");
		templates.add(template);
		temp.put("templates", templates);
		
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject getInterfaceJSON(String auth, String hostid)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "hostinterface.get");
		JSONObject temp = new JSONObject();
		temp.put("output", "extend");
		temp.put("hostids", hostid);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	
	public static JSONObject updateHostInterfaceJSON(String auth, String interfaceid, String IP, String port)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "hostinterface.update");
		JSONObject temp = new JSONObject();
		temp.put("interfaceid", interfaceid);
		temp.put("ip", IP);
		temp.put("port", port);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	public static JSONObject updateHostnameJSON(String auth, String hostid, String hostname)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "host.update");
		JSONObject temp = new JSONObject();
		temp.put("hostid", hostid);
		temp.put("host", hostname);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
	public static JSONObject deleteHostJSON(String auth, String hostid)
	{
		JSONObject obj = new JSONObject();
		obj.put("jsonrpc", "2.0");
		obj.put("method", "host.delete");
		JSONArray temp = new JSONArray();
		temp.add(hostid);
		obj.put("params", temp);
		obj.put("auth", auth);
		obj.put("id", 1);
		return obj;
	}
}

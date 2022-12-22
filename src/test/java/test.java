
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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


import Model.Bean.Host;
import Model.DAO.HostDAO;

class test { 

	public static JSONObject request(JSONObject obj)
	{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://192.168.1.54/zabbix/api_jsonrpc.php");
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
//		temp.put("output", "extend");
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
	
	public static JSONObject createHostJSON(String auth, String hostname, String ip)
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
		zinterface.put("port", "10050");
		temp.put("interfaces", zinterface);
		
		JSONArray groups = new JSONArray();
		JSONObject group = new JSONObject();
		group.put("groupid", 5);
		groups.add(group);
		group.clear();
		group.put("groupid", 10);
		groups.add(group);
		//System.out.print(group);
		temp.put("groups", group);

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
	public static void main(String[] args) 
	{
//		JSONObject r = request(loginJSON("Admin","123qwe!@#"));
//		System.out.println(r);
//		JSONObject er = r.getJSONObject("error");
//		System.out.println(er);
//		System.out.print((r.getJSONObject("error")).getString("data"));

		String auth = request(loginJSON("Admin","123qwe!@#")).getString("result");
		JSONArray result = request(getHostJSON(auth)).getJSONArray("result");
		//System.out.println(result);
		for (int k = 1; k < result.size(); k++)
		{
			String hostip = result.getJSONObject(k).getString("hostid");
			String hostName = result.getJSONObject(k).getString("host");
			JSONArray r = request(getInterfaceJSON(auth,hostip)).getJSONArray("result");
			String active_available = r.getJSONObject(0).getString("available");
			String ipaddress = r.getJSONObject(0).getString("ip");
			String port = r.getJSONObject(0).getString("port");
			Host host = new Host(hostip, hostName, active_available, ipaddress, port);
			System.out.println(host.getHostID() + " " + host.getHostName() + " " + host.getAvailability() + " " + host.getIpAddress() + " " + host.getPort());
			List<String> nameList = new ArrayList<String>();
			List<String> idList = new ArrayList<String>();
			JSONArray r1 = request(getItemsJSON(auth,hostip)).getJSONArray("result");
			for (int i = 0; i< r1.size(); i++)
			{
				idList.add(r1.getJSONObject(i).getString("itemid"));
				nameList.add(r1.getJSONObject(i).getString("name"));
			}
			String itemid = idList.get(nameList.indexOf("Available memory in %"));
			JSONArray r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setAvailableMemoryInPS(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Memory utilization"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setMemoryUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("/: Space utilization"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setSpaceUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("sda: Disk utilization"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setDiskUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("CPU utilization"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setCPUutilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Load average (15m avg)"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setLoadAverage15m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Load average (1m avg)"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setLoadAverage1m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Load average (5m avg)"));
			r2 = request(getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setLoadAverage5m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Available memory"));
			r2 = request(getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setAvailableMemory(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("/: Used space"));
			r2 = request(getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setUsedSpace(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("/: Total space"));
			r2 = request(getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setTotalSpace(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("System uptime"));
			r2 = request(getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setSystemUptime(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Number of CPUs"));
			r2 = request(getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setNumberOfCPUs(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Number of processes"));
			r2 = request(getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setNumberOfProcesses(Long.parseLong(r2.getJSONObject(0).getString("value")));
		}
		
//		JSONArray result = request(getHostJSON(auth)).getJSONArray("result");
//		String hostip = result.getJSONArray("result").getJSONObject(2).getString("hostid");
		
//		String interfaceip = result.getJSONArray("result").getJSONObject(0).getString("interfaceid");
//		result = request(updateHostInterfaceJSON(auth,interfaceip,"192.168.1.200","10030"));
//		System.out.print(result.getString("result"));
		
//		for (int i=0; i< result.size(); i++)
//		{
//			String hostid = result.getJSONObject(i).getString("hostid");
//			System.out.println(hostid + " " + result.getJSONObject(i).getString("host"));
//			JSONArray r = request(getItemsJSON(auth,hostid)).getJSONArray("result");
////			System.out.print(r.indexOf("Number of CPUs"));
//			for (int j=0; j< r.size(); j++)
//			{
//				String itemid = r.getJSONObject(j).getString("itemid");
//				System.out.print("\t+ "+ itemid + " " + r.getJSONObject(j).getString("name"));
//				JSONArray r2 = request(getHistoryJSON(auth, itemid)).getJSONArray("result");
//				if (!r2.isEmpty())
//					System.out.print(": "+ r2.getJSONObject(0).getString("value"));
//				System.out.print("\n");
//			}
//		}
		
	}
}
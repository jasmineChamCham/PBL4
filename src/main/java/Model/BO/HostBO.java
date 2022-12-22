package Model.BO;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Model.Bean.Host;
import Model.DAO.HostDAO;

public class HostBO {

	HostDAO hostDAO = new HostDAO();
	
	public String checkLogin(String username, String password) {

		JSONObject r = hostDAO.request(hostDAO.loginJSON(username, password));
		//System.out.println(r);
		String auth = r.getString("result");
		return auth;
	}
	
	public ArrayList<Host> getHosts(String auth)
	{
		JSONArray result = hostDAO.request(hostDAO.getHostJSON(auth)).getJSONArray("result");
		ArrayList<Host> hosts = new ArrayList<Host>();
		for (int k = 1; k < result.size(); k++)
		{
			String hostid = result.getJSONObject(k).getString("hostid");
			String hostName = result.getJSONObject(k).getString("host");
			JSONArray r = hostDAO.request(hostDAO.getInterfaceJSON(auth,hostid)).getJSONArray("result");
			String active_available = r.getJSONObject(0).getString("available");
			String ipaddress = r.getJSONObject(0).getString("ip");
			String port = r.getJSONObject(0).getString("port");
			Host host = new Host(hostid, hostName, active_available, ipaddress, port);
//			System.out.println(host.getHostID() + " " + host.getHostName() + " " + host.getAvailability() + " " + host.getIpAddress() + " " + host.getPort());
			List<String> nameList = new ArrayList<String>();
			List<String> idList = new ArrayList<String>();
			JSONArray r1 = hostDAO.request(hostDAO.getItemsJSON(auth, hostid)).getJSONArray("result");
			for (int i = 0; i < r1.size(); i++)
			{
				idList.add(r1.getJSONObject(i).getString("itemid"));
				nameList.add(r1.getJSONObject(i).getString("name"));
			}
			String itemid = idList.get(nameList.indexOf("Available memory in %"));
			JSONArray r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setAvailableMemoryInPS(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Memory utilization"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setMemoryUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("/: Space utilization"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setSpaceUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("sda: Disk utilization"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setDiskUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("CPU utilization"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setCPUutilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Load average (15m avg)"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setLoadAverage15m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Load average (1m avg)"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setLoadAverage1m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Load average (5m avg)"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 0)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setLoadAverage5m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Available memory"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setAvailableMemory(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("/: Used space"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setUsedSpace(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("/: Total space"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setTotalSpace(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("System uptime"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setSystemUptime(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Number of CPUs"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setNumberOfCPUs(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = idList.get(nameList.indexOf("Number of processes"));
			r2 = hostDAO.request(hostDAO.getHistoryJSON(auth, itemid, 3)).getJSONArray("result");
			if (!r2.isEmpty())
				host.setNumberOfProcesses(Long.parseLong(r2.getJSONObject(0).getString("value")));
			hosts.add(host);
		}
		return hosts;
	}
	
	public Host GetHostByHostID(String auth, String hostid)
	{
		ArrayList<Host> hosts = getHosts(auth);
		for (int i = 0; i < hosts.size(); i++)
		{
			if (hosts.get(i).getHostID().equals(hostid))
			{
				return hosts.get(i);
			}
		}
		return null;
	}
}


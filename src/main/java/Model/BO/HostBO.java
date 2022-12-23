package Model.BO;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Model.Bean.Host;
import Model.DAO.HostDAO;

public class HostBO {
	public String checkLogin(String username, String password) {

		JSONObject r = HostDAO.request(HostDAO.loginJSON(username, password));
		//System.out.println(r);
		String auth = r.getString("result");
		return auth;
	}
	
	public ArrayList<Host> getHosts(String auth)
	{
		JSONArray result = HostDAO.request(HostDAO.getHostJSON(auth)).getJSONArray("result");
		ArrayList<Host> hosts = new ArrayList<Host>();
		for (int k = 1; k < result.size(); k++)
		{
			String hostid = result.getJSONObject(k).getString("hostid");
			String hostName = result.getJSONObject(k).getString("host");
			JSONArray r = HostDAO.request(HostDAO.getInterfaceJSON(auth,hostid)).getJSONArray("result");
			String active_available = r.getJSONObject(0).getString("available");
			String ipaddress = r.getJSONObject(0).getString("ip");
			String port = r.getJSONObject(0).getString("port");
			Host host = new Host(hostid, hostName, active_available, ipaddress, port);
//			System.out.println(host.getHostID() + " " + host.getHostName() + " " + host.getAvailability() + " " + host.getIpAddress() + " " + host.getPort());
			List<String> nameList = new ArrayList<String>();
			List<String> idList = new ArrayList<String>();
			JSONArray r1 = HostDAO.request(HostDAO.getItemsJSON(auth, hostid)).getJSONArray("result");
			for (int i = 0; i < r1.size(); i++)
			{
				idList.add(r1.getJSONObject(i).getString("itemid"));
				nameList.add(r1.getJSONObject(i).getString("name"));
			}
			String itemid = idList.get(nameList.indexOf("Available memory in %"));
			JSONArray r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setAvailableMemoryInPS(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Memory utilization") != -1)?idList.get(nameList.indexOf("Memory utilization")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setMemoryUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("/: Space utilization") != -1)?idList.get(nameList.indexOf("/: Space utilization")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setSpaceUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("sda: Disk utilization") != -1)?idList.get(nameList.indexOf("sda: Disk utilization")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setDiskUtilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("CPU utilization") != -1)?idList.get(nameList.indexOf("CPU utilization")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setCPUutilization(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Load average (15m avg)") != -1)?idList.get(nameList.indexOf("Load average (15m avg)")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setLoadAverage15m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Load average (1m avg)") != -1)?idList.get(nameList.indexOf("Load average (1m avg)")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setLoadAverage1m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Load average (5m avg)") != -1)?idList.get(nameList.indexOf("Load average (5m avg)")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setLoadAverage5m(Double.parseDouble(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Available memory") != -1)?idList.get(nameList.indexOf("Available memory")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 3,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setAvailableMemory(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("/: Used space") != -1)?idList.get(nameList.indexOf("/: Used space")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 3,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setUsedSpace(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("/: Total space") != -1)?idList.get(nameList.indexOf("/: Total space")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 3,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setTotalSpace(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("System uptime") != -1)?idList.get(nameList.indexOf("System uptime")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 3,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setSystemUptime(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Number of CPUs") != -1)?idList.get(nameList.indexOf("Number of CPUs")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 3,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
				host.setNumberOfCPUs(Long.parseLong(r2.getJSONObject(0).getString("value")));
			itemid = (nameList.indexOf("Number of processes") != -1)?idList.get(nameList.indexOf("Number of processes")):null;
			r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 3,1)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
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
	public String GreateHost(String auth, String hostname, String ipaddress, String port)
	{
		JSONObject r = HostDAO.request(HostDAO.createHostJSON(auth, hostname, ipaddress, port));
		if (r.getString("result") == null)
		{
			return (r.getJSONObject("error")).getString("data");
		}
		else 
			return null;
	}
	public String UpdateHostname(String auth, String hostid, String hostname)
	{
		JSONObject r = HostDAO.request(HostDAO.updateHostnameJSON(auth, hostid, hostname));
		if (r.getString("result") == null)
		{
			return (r.getJSONObject("error")).getString("data");
		}
		else 
			return null;
	}

	public String UpdateInterface(String auth, String hostid, String ipaddress, String port)
	{
		JSONObject result = HostDAO.request(HostDAO.getInterfaceJSON(auth, hostid));
		String interfaceip = result.getJSONArray("result").getJSONObject(0).getString("interfaceid");
		JSONObject r = HostDAO.request(HostDAO.updateHostInterfaceJSON(auth, interfaceip, ipaddress, port));
		if (r.getString("result") == null)
		{
			return (r.getJSONObject("error")).getString("data");
		}
		else 
			return null;
	}

	public String DeleteHost(String auth, String hostid)
	{
		JSONObject result = HostDAO.request(HostDAO.deleteHostJSON(auth, hostid));
		if (result.getString("result") == null)
		{
			return (result.getJSONObject("error")).getString("data");
		}
		else 
			return null;
	}
	
	public ArrayList<ArrayList<Double>> getCPUutilization(String auth)
	{
		ArrayList<ArrayList<Double>> CPUutilizations = new ArrayList<ArrayList<Double>>();
		JSONArray result = HostDAO.request(HostDAO.getHostJSON(auth)).getJSONArray("result");
		for (int k = 1; k < result.size(); k++)
		{
			String hostid = result.getJSONObject(k).getString("hostid");
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> idList = new ArrayList<String>();
			ArrayList<Double> CPUutilization = new ArrayList<Double>();
			JSONArray r1 = HostDAO.request(HostDAO.getItemsJSON(auth, hostid)).getJSONArray("result");
			for (int i = 0; i < r1.size(); i++)
			{
				idList.add(r1.getJSONObject(i).getString("itemid"));
				nameList.add(r1.getJSONObject(i).getString("name"));
			}
			String itemid = (nameList.indexOf("CPU utilization") != -1)?idList.get(nameList.indexOf("CPU utilization")):null;
			JSONArray r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0, 10)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
			{
				for (int i=0; i< r2.size(); i++)
				{
					CPUutilization.add(Double.parseDouble(r2.getJSONObject(i).getString("value")));
				}
			}
			else
			{
				for (int i=0; i< 10; i++)
				{
					CPUutilization.add(0.0);
				}
			}
			CPUutilizations.add(CPUutilization);
		}
		return CPUutilizations;
	}
	
	public ArrayList<ArrayList<Double>> getMemoryUtilization(String auth)
	{
		ArrayList<ArrayList<Double>> MemoryUtinizations = new ArrayList<ArrayList<Double>>();
		JSONArray result = HostDAO.request(HostDAO.getHostJSON(auth)).getJSONArray("result");
		for (int k = 1; k < result.size(); k++)
		{
			String hostid = result.getJSONObject(k).getString("hostid");
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> idList = new ArrayList<String>();
			ArrayList<Double> MemoryUtinization = new ArrayList<Double>();
			JSONArray r1 = HostDAO.request(HostDAO.getItemsJSON(auth, hostid)).getJSONArray("result");
			for (int i = 0; i < r1.size(); i++)
			{
				idList.add(r1.getJSONObject(i).getString("itemid"));
				nameList.add(r1.getJSONObject(i).getString("name"));
			}
			String itemid = (nameList.indexOf("Memory utilization") != -1)?idList.get(nameList.indexOf("Memory utilization")):null;
			JSONArray r2 = HostDAO.request(HostDAO.getHistoryJSON(auth, itemid, 0, 10)).getJSONArray("result");
			if (!r2.isEmpty() && itemid!=null)
			{
				for (int i=0; i< r2.size(); i++)
				{
					MemoryUtinization.add(Double.parseDouble(r2.getJSONObject(i).getString("value")));
				}
			}
			else
			{
				for (int i=0; i< 10; i++)
				{
					MemoryUtinization.add(0.0);
				}
			}
			MemoryUtinizations.add(MemoryUtinization);
		}
		return MemoryUtinizations;
	}
}


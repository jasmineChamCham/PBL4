package Model.BO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Model.Bean.Process;
import Model.DAO.ProcessDAO;

public class ProcessBO {

	public static boolean sshConnect(String username, String password, String host) {
		return ProcessDAO.sshConnect(username, password, host);
	}

	public static List<Process> getAllProcesses(String username, String password, String host) throws Exception {
		return ProcessDAO.getAllProcesses(username, password, host);
	}

	public static void killProcess(String username, String password, String host, String ProcessId) throws Exception {
		ProcessDAO.killProcess(username, password, host, ProcessId);
	}

	public static List<Process> getProcessesWithHighCpu(String username, String password, String host)
			throws Exception {
		return ProcessDAO.getProcessesWithHighCpu(username, password, host);
	}
	public static List<Process> getProcessesWithHighMemory(String username, String password, String host)
			throws Exception {
		
		return ProcessDAO.getProcessesWithHighMemory(username, password, host);
	}
}
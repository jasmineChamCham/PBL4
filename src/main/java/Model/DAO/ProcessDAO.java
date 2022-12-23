package Model.DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import Model.Bean.Process;

public class ProcessDAO {

	public static boolean sshConnect(String username, String password, String host) {
		try {
			Session session = new JSch().getSession(username, host, 22);
			if (session != null)
				return true;
			else
				return false;
		} 
		catch (JSchException e) {
			return false;
		}

	}

	public static String sshExecute(String username, String password, String host, String command) throws Exception {

		Session session = null;
		ChannelExec channel = null;
		String responseString = "";

		try {
			session = new JSch().getSession(username, host, 22); // 22 is ssh port
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();

			channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(command);
			ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			channel.setOutputStream(responseStream);
			channel.connect();

			while (channel.isConnected()) {
				Thread.sleep(100);
			}

			responseString = new String(responseStream.toByteArray());
		} finally {
			if (session != null) {
				session.disconnect();
			}
			if (channel != null) {
				channel.disconnect();
			}
		}
		return responseString;
	}

	public static List<Process> getAllProcesses(String username, String password, String host) throws Exception {
		List<Process> result = new ArrayList<>();
		String command = "ps -u " + username;
		String response = sshExecute(username, password, host, command);
		String[] listProcesses = response.split("\n");
		for (int i = 1; i < listProcesses.length; i++) {
			String processString = listProcesses[i];
			String[] processInfo = processString.split("\\s+");
			Process process = new Process(processInfo[1].trim(), processInfo[4].trim());
			result.add(process);
		}
		return result;
	}

	public static void killProcess(String username, String password, String host, String ProcessId) throws Exception {
		String command = "kill " + ProcessId;
		sshExecute(username, password, host, command);
	}

	public static List<Process> getProcessesWithHighCpu(String username, String password, String host)
			throws Exception {
		List<Process> result = new ArrayList<>();
		String command = "ps -eo pid,cmd,%cpu --sort=-%cpu | head";
		String response = sshExecute(username, password, host, command);
		String[] listProcesses = response.split("\n");
		listProcesses = response.split("\n");
		for (int i = 1; i < listProcesses.length; i++) {
			String processString = listProcesses[i];
			String[] processInfo = processString.split("\\s+");
			String processId = processInfo[1].trim();
			String cmd = "";
			for (int j = 2; j <= processInfo.length - 2; j++) {
				cmd += processInfo[j].trim() + " ";
			}
			String[] processCmd = cmd.split("/");
			String processName = processCmd[processCmd.length - 1];
			Double processCpu = Double.parseDouble(processInfo[processInfo.length - 1].trim());
			Process process = new Process(processId, processName, processCpu);
			result.add(process);
		}
		return result;
	}
	
	public static List<Process> getProcessesWithHighMemory(String username, String password, String host) throws Exception {
		List<Process> result = new ArrayList<>();
		String command = "ps -eo pid,cmd,%mem --sort=-%mem | head";
		String response = sshExecute(username, password, host, command);
		String[] listProcesses = response.split("\n");
		listProcesses = response.split("\n");
		for (int i = 1; i < listProcesses.length; i++) {
			String processString = listProcesses[i];
			String[] processInfo = processString.split("\\s+");
			String processId = processInfo[1].trim();
			String cmd = "";
			for (int j = 2; j <= processInfo.length - 2; j++) {
				cmd += processInfo[j].trim() + " ";
			}
			String[] processCmd = cmd.split("/");
			String processName = processCmd[processCmd.length - 1].trim();
			Float processMemory = Float.parseFloat(processInfo[processInfo.length - 1].trim());
			Process process = new Process();
			if (processName.equals("")) {
				process = new Process(processId, cmd, processMemory);
			}
			else {
				process = new Process(processId, processName, processMemory);
			}
			System.out.println(process);
			result.add(process);
		}
		return result;
	}
}

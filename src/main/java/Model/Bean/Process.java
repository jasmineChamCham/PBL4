package Model.Bean;

import java.io.Serializable;
import java.util.Objects;

public class Process implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ProcessId;
	private String ProcessName; 
	private Double ProcessCpu;
	private Float ProcessMemory;
	
	public Process() {
		// TODO Auto-generated constructor stub
	}

	public Process(String ProcessId, String ProcessName) {
		super();
		this.ProcessId = ProcessId;
		this.ProcessName = ProcessName;
	}

	public Process(String processId, String processName, Double processCpu, Float processMemory) {
		super();
		ProcessId = processId;
		ProcessName = processName;
		ProcessCpu = processCpu;
		ProcessMemory = processMemory;
	}

	public Process(String processId, String processName, Double processCpu) {
		super();
		ProcessId = processId;
		ProcessName = processName;
		ProcessCpu = processCpu;
	}
	
	public Process(String processId, String processName, Float processMemory) {
		super();
		ProcessId = processId;
		ProcessName = processName;
		ProcessMemory = processMemory;
	}

	public String getProcessId() {
		return ProcessId;
	}

	public void setProcessId(String ProcessId) {
		this.ProcessId = ProcessId;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public void setProcessName(String ProcessName) {
		this.ProcessName = ProcessName;
	}

	public double getProcessCpu() {
		return ProcessCpu;
	}

	public void setProcessCpu(Double processCpu) {
		ProcessCpu = processCpu;
	}

	public float getProcessMemory() {
		return ProcessMemory;
	}

	public void setProcessMemory(Float processMemory) {
		ProcessMemory = processMemory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ProcessId, ProcessName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Process other = (Process) obj;
		return Objects.equals(ProcessId, other.ProcessId) && Objects.equals(ProcessName, other.ProcessName);
	}

	@Override
	public String toString() {
		return "Process [ProcessId=" + ProcessId + ", ProcessName=" + ProcessName + ", ProcessCpu=" + ProcessCpu
				+ ", ProcessMemory=" + ProcessMemory + "]";
	}
	
}

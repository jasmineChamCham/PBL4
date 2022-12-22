package Model.Bean;

public class Host {
	private String hostId;
	private String hostName;
	private String availability;
	private String ipAddress;
	private String port;
	
	private long NumberOfProcesses;
	private long NumberOfCPUs;
	private long SystemUptime;
	private long TotalSpace;
	private long UsedSpace;
	private long AvailableMemory;
	
	private double LoadAverage15m;
	private double LoadAverage1m;
	private double LoadAverage5m;
	private double CPUutilization;
	private double DiskUtilization;
	private double SpaceUtilization;
	private double AvailableMemoryInPS;
	private double MemoryUtilization;
	public Host(String hostId, String hostName, String availability, String ipAddress, String port) {
		super();
		this.hostId = hostId;
		this.hostName = hostName;
		this.availability = availability;
		this.ipAddress = ipAddress;
		this.port = port;
		
		this.NumberOfProcesses = 0;
		this.NumberOfCPUs = 0;
		this.SystemUptime = 0;
		this.TotalSpace = 0;
		this.UsedSpace = 0;
		this.AvailableMemory = 0;
		
		this.LoadAverage15m = 0;
		this.LoadAverage1m = 0;
		this.LoadAverage5m = 0;
		this.CPUutilization = 0;
		this.DiskUtilization = 0;
		this.SpaceUtilization = 0;
		this.AvailableMemoryInPS = 0;
		this.MemoryUtilization = 0;
	}
	
	public String gethostId() {
		return this.hostId;
	}

	public void setId(String id) {
		this.hostId = id;
	}

	public String getHostname() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setMssv(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	public long getNumberOfProcesses() {
		return this.NumberOfProcesses;
	}

	public void setNumberOfProcesses(long NumberOfProcesses) {
		this.NumberOfProcesses = NumberOfProcesses;
	}

	public long getNumberOfCPUs() {
		return this.NumberOfCPUs;
	}

	public void setNumberOfCPUs(long NumberOfCPUs) {
		this.NumberOfCPUs = NumberOfCPUs;
	}
	public long getSystemUptime() {
		return this.SystemUptime;
	}

	public void setSystemUptime(long SystemUptime) {
		this.SystemUptime = SystemUptime;
	}

	public long getTotalSpace() {
		return this.TotalSpace;
	}

	public void setTotalSpace(long TotalSpace) {
		this.TotalSpace = TotalSpace;
	}

	public long getUsedSpace() {
		return this.UsedSpace;
	}

	public void setUsedSpace(long UsedSpace) {
		this.UsedSpace = UsedSpace;
	}
	public long getAvailableMemory() {
		return this.AvailableMemory;
	}

	public void setAvailableMemory(long AvailableMemory) {
		this.AvailableMemory = AvailableMemory;
	}

	public double getLoadAverage15m() {
		return this.LoadAverage15m;
	}

	public void setLoadAverage15m(double LoadAverage15m) {
		this.LoadAverage15m = LoadAverage15m;
	}
	public double getLoadAverage1m() {
		return this.LoadAverage1m;
	}

	public void setLoadAverage1m(double LoadAverage1m) {
		this.LoadAverage1m = LoadAverage1m;
	}

	public double getLoadAverage5m() {
		return this.LoadAverage5m;
	}

	public void setLoadAverage5m(double LoadAverage5m) {
		this.LoadAverage5m = LoadAverage5m;
	}
	public double getCPUutilization() {
		return this.CPUutilization;
	}

	public void setCPUutilization(double CPUutilization) {
		this.CPUutilization = CPUutilization;
	}
	public double getDiskUtilization() {
		return this.DiskUtilization;
	}

	public void setDiskUtilization(double DiskUtilization) {
		this.DiskUtilization = DiskUtilization;
	}
	public double getSpaceUtilization() {
		return this.SpaceUtilization;
	}

	public void setSpaceUtilization(double SpaceUtilization) {
		this.SpaceUtilization = SpaceUtilization;
	}
	public double getAvailableMemoryInPS() {
		return this.AvailableMemoryInPS;
	}

	public void setAvailableMemoryInPS(double AvailableMemoryInPS) {
		this.AvailableMemoryInPS = AvailableMemoryInPS;
	}
	public double getMemoryUtilization() {
		return this.MemoryUtilization;
	}

	public void setMemoryUtilization(double MemoryUtilization) {
		this.MemoryUtilization = MemoryUtilization;
	}
}

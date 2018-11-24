package messgeclient;

public class Clientinfo {
	int serverprot;
	int clientprot;
	String serveraddress;
	String clientaddress;
	public Clientinfo() {
		super();
		this.serverprot = 10086;
		this.clientprot = 10000;
		this.serveraddress = "192.168.2.103";
		this.clientaddress = "127.0.0.1";
	}
	public Clientinfo(int serverprot, int clientprot, String serveraddress, String clientaddress) {
		super();
		this.serverprot = serverprot;
		this.clientprot = clientprot;
		this.serveraddress = serveraddress;
		this.clientaddress = clientaddress;
	}
	public int getServerprot() {
		return serverprot;
	}
	public void setServerprot(int serverprot) {
		this.serverprot = serverprot;
	}
	public int getClientprot() {
		return clientprot;
	}
	public void setClientprot(int clientprot) {
		this.clientprot = clientprot;
	}
	public String getServeraddress() {
		return serveraddress;
	}
	public void setServeraddress(String serveraddress) {
		this.serveraddress = serveraddress;
	}
	public String getClientaddress() {
		return clientaddress;
	}
	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}
	
	

}

package client;


public class Client {
	String id;
	String name,password;
	int size;
	public Client() {
		
		// TODO 自动生成的构造函数存根
	}
	public Client(String id, String name, String password) {
		super();
		this.id = "1";
		this.name = "1";
		this.password = "1";
		this.size=id.length()+name.length()+password.length();
	}
	

}

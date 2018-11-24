package server;


public class Client {
	long id;
	String name,password;
	int size;
	public Client() {
		
		// TODO 自动生成的构造函数存根
	}
	public Client(String id, String name, String password) {
		super();
		this.id = 0;
		this.name = "";
		this.password = "";
		this.size=id.length()+name.length()+password.length();
	}
	

}

package server;


public class Client {
	long id;
	String name,password;
	int size;
	public Client() {
		
		// TODO �Զ����ɵĹ��캯�����
	}
	public Client(String id, String name, String password) {
		super();
		this.id = 0;
		this.name = "";
		this.password = "";
		this.size=id.length()+name.length()+password.length();
	}
	

}

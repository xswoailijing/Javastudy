package messgeclient;


public class Client {
	String id,name,password;
	int size;
	public Client() {
		
		// TODO �Զ����ɵĹ��캯�����
	}
	public Client(String id, String name, String password) {
		super();
		this.id = "";
		this.name = "";
		this.password = "";
		this.size=id.length()+name.length()+password.length();
	}
	public String getId() {
		return id;
	}
	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

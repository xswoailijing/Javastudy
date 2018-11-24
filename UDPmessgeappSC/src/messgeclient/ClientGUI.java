package messgeclient;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.html.parser.Entity;

public abstract class ClientGUI extends JFrame {
	/**
	 * 客户端抽象类UI
	 */
	private static final long serialVersionUID = -8496252907368380466L;
	int window_width;
	int window_height;
	int window_x;	
	int window_y;
	public void ClientGUI() {
	}
	public void drawwindow() throws SocketException{
	}
	public  void showwindow(){
		EventQueue.invokeLater(()->{
			try {
				this.drawwindow();
			} catch (SocketException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			this.setVisible(true);			
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);;
				}			
			    });
		  }
				);
	}
}

class ClientGUIMessgeWindow extends ClientGUI {
	/**
	 * 客户端消息框类ui
	 */
	TextArea  messgeshowTextArea;
	TextArea  messgesendTextArea;
	String receivemessge;
	String sendmessge;
	Client client;
	Clientinfo clientinfo;
	ClientLinkService clientLinkService;
	private static final long serialVersionUID = 325334855022493826L;
	public ClientGUIMessgeWindow(Client client, Clientinfo clientinfo) throws SocketException {
		super();
		window_height=500;
		window_width=490;
		window_x=400;
		window_y=100;
		this.clientinfo=clientinfo;
		this.client=client;
		this.clientLinkService=new MessgeClient(clientinfo,client);
	}
	public void drawwindow() throws SocketException {
		//添加配置组件
		this.setSize(this.window_width, this.window_height);
		this.setLocation(this.window_x, this.window_y);	
		this.setTitle("消息窗口");
		this.setBackground( Color.blue);
		this.setForeground(Color.blue);
		this.messgeshowTextArea=new TextArea();
		this.messgesendTextArea=new TextArea();
		Button sendButton=new Button("发送");
		Button exitButton=new Button("退出");
		messgeshowTextArea.setBounds(15, 15, 450, 250);
		messgesendTextArea.setBounds(15, 320, 450, 140);
		sendButton.setBounds(30, 290, 50, 20);
		exitButton.setBounds(200, 290, 50, 20);	
//	添加组件到窗口容器
//		JPanel contentPane=new JPanel();
//		contentPane.add(loginButton);
//		this.setContentPane(contentPane);
		this.add(messgesendTextArea);
		this.add(messgeshowTextArea);
		this.add(sendButton);
		this.add(exitButton);
		//布局管理类
//		this.setLayout(new FlowLayout());
//		this.setLayout(new GridLayout(3, 3, 10, 10));
		this.setLayout(new BorderLayout(20, 20));
		//添加按钮监听
		sendButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {				
		    try {
				clientLinkService.sendmessge(messgesendTextArea.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
			}
		});
		//添加消息接收后台线程
		new Clientthread().start();
	}
	public void showmessge(String messge) {
		this.messgeshowTextArea.setText(messge);
	}
	class Clientthread extends Thread{
		public void run() {	
			while (true) {
				try {				
					clientLinkService.receive();
					showmessge(clientLinkService.messge);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}	
			}	
		}
	}
}
class ClientGUILoginWindow extends ClientGUI {
	/**
	 * 客户端登录类ui
	 */
	TextField userTextField;
	TextField passwordTextField;
	Clientinfo clientinfo;
	public ClientGUILoginWindow() {
		super();
		window_height=180;
		window_width=250;
		window_x=500;
		window_y=200;
		clientinfo=new Clientinfo();
	}					
	public void drawwindow() {	
		this.setSize(this.window_width, this.window_height);
		this.setLocation(this.window_x, this.window_y);	
		this.setTitle("登录窗口");
		this.setBackground(Color.red);
		this.setResizable(false);
		this.userTextField=new TextField("请输入用户名");
		this.passwordTextField=new TextField("请输入密码");
		Button loginButton=new Button("登录");
		Button exitButton=new Button("退出");
		passwordTextField.setBounds(30, 60, 200, 20);
		userTextField.setBounds(30, 20, 200, 20);
		loginButton.setBounds(30, 100, 50, 20);
		exitButton.setBounds(150, 100, 50, 20);
		this.add(passwordTextField);
		this.add(loginButton);
		this.add(exitButton);
		this.add(userTextField);
		//布局管理类
//		this.setLayout(new FlowLayout());
//		this.setLayout(new GridLayout(3, 3, 10, 10));
		this.setLayout(new BorderLayout(20, 20));
		//调用连接服务器方法,验证成功则启动messge窗口
		loginButton.addActionListener(new ActionListener() {	
				public void actionPerformed(ActionEvent e) {				
				boolean login;
		try {
			login = new MessgeClient(clientinfo)
					.login(userTextField.getText(),passwordTextField.getText());
			if (login) {
				dispose();
			}
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}					
			}
		});	


		
		

	
		

	}


	

}


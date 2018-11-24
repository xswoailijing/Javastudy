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
	 * �ͻ��˳�����UI
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
				// TODO �Զ����ɵ� catch ��
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
	 * �ͻ�����Ϣ����ui
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
		//����������
		this.setSize(this.window_width, this.window_height);
		this.setLocation(this.window_x, this.window_y);	
		this.setTitle("��Ϣ����");
		this.setBackground( Color.blue);
		this.setForeground(Color.blue);
		this.messgeshowTextArea=new TextArea();
		this.messgesendTextArea=new TextArea();
		Button sendButton=new Button("����");
		Button exitButton=new Button("�˳�");
		messgeshowTextArea.setBounds(15, 15, 450, 250);
		messgesendTextArea.setBounds(15, 320, 450, 140);
		sendButton.setBounds(30, 290, 50, 20);
		exitButton.setBounds(200, 290, 50, 20);	
//	����������������
//		JPanel contentPane=new JPanel();
//		contentPane.add(loginButton);
//		this.setContentPane(contentPane);
		this.add(messgesendTextArea);
		this.add(messgeshowTextArea);
		this.add(sendButton);
		this.add(exitButton);
		//���ֹ�����
//		this.setLayout(new FlowLayout());
//		this.setLayout(new GridLayout(3, 3, 10, 10));
		this.setLayout(new BorderLayout(20, 20));
		//��Ӱ�ť����
		sendButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {				
		    try {
				clientLinkService.sendmessge(messgesendTextArea.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}		
			}
		});
		//�����Ϣ���պ�̨�߳�
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}	
			}	
		}
	}
}
class ClientGUILoginWindow extends ClientGUI {
	/**
	 * �ͻ��˵�¼��ui
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
		this.setTitle("��¼����");
		this.setBackground(Color.red);
		this.setResizable(false);
		this.userTextField=new TextField("�������û���");
		this.passwordTextField=new TextField("����������");
		Button loginButton=new Button("��¼");
		Button exitButton=new Button("�˳�");
		passwordTextField.setBounds(30, 60, 200, 20);
		userTextField.setBounds(30, 20, 200, 20);
		loginButton.setBounds(30, 100, 50, 20);
		exitButton.setBounds(150, 100, 50, 20);
		this.add(passwordTextField);
		this.add(loginButton);
		this.add(exitButton);
		this.add(userTextField);
		//���ֹ�����
//		this.setLayout(new FlowLayout());
//		this.setLayout(new GridLayout(3, 3, 10, 10));
		this.setLayout(new BorderLayout(20, 20));
		//�������ӷ���������,��֤�ɹ�������messge����
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
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}					
			}
		});	


		
		

	
		

	}


	

}


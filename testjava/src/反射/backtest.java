package ����;

import java.io.IOException;
import java.util.Random;
public class backtest {
	
	
	//���䣬��̬��������.
	//ͨ����ͬ������̬���� ���صĶ���.
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		String ssString="sad";
		Class<?> class1=ssString.getClass();
		class1=String.class;
		String string;
		//���ģ���������󣬶�̬�������ַ����������
		if ( 0==new Random().nextInt(2)) {
			System.err.println(0);
			string="httpserver.Httpserver";
		}else {
			System.err.println(1);
			string="backclass.Httpserver";
		}
		Class<?> h=Class.forName(string);
		System.err.println(h);
		//�ÿչ��촴������.�����û�пչ����������ܻᱨ��
//		Httpserver httpserver=(Httpserver)h.newInstance();
//		System.err.println(httpserver);
//		Httpserver httpserver2=new Httpserver();
//		System.err.println(httpserver2);
		
		
	}

}

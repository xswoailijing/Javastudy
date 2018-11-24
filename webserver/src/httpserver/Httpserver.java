package httpserver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import map.*;

public class Httpserver  {

	@SuppressWarnings("unused")
	public Httpserver() throws IOException, SAXException, ParserConfigurationException {
		//���ò�����������
		//��������ԴĿ¼
		String path = "C:\\Users\\Administrator\\Desktop\\test1_files";
		//�����������ļ�
		String configfile="./httpserver/xml.xml";
		//��ʼ��������
		Mapinterfece mapinterfece=new Servermap(path, configfile);
		//���÷������˿ڲ�����
		ServerThread serverThread = new ServerThread(10086);
	}
	public static void main(String[] args) {
		try {
			new Httpserver();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}

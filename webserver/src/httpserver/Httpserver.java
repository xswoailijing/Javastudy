package httpserver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import map.*;

public class Httpserver  {

	@SuppressWarnings("unused")
	public Httpserver() throws IOException, SAXException, ParserConfigurationException {
		//配置并启动服务器
		//服务器资源目录
		String path = "C:\\Users\\Administrator\\Desktop\\test1_files";
		//服务器配置文件
		String configfile="./httpserver/xml.xml";
		//初始化服务器
		Mapinterfece mapinterfece=new Servermap(path, configfile);
		//设置服务器端口并启动
		ServerThread serverThread = new ServerThread(10086);
	}
	public static void main(String[] args) {
		try {
			new Httpserver();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

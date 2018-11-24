package map;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
/**
 * 
 * ���������ʵ�ַ�������map�ӿڵĹ���
 * @author Administrator
 *
 */
public class Servermap implements Mapinterfece {
	// ������������
	SAXParserFactory factory;
	// ��ý�����
	SAXParser parser;
	// �����д�Ľ�����
	MapHandler personHandler;
	String configfile;
	String path;
	public Servermap(String path, String configfile) throws SAXException, IOException, ParserConfigurationException {
		super();
		this.path = path;
		this.configfile=configfile;
		factory = SAXParserFactory.newInstance();
		parser = factory.newSAXParser();
		personHandler = new MapHandler();
		File file = new File(path);
		Mapinterfece.resmap.put("path", path);
		setmap(file);
	}
	private void setresmap(File file) {
		//���õݹ�ɨ�����õ���Դ·��������Դ�ļ���map
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				setresmap(file2);
				String string = file2.getPath().substring(path.length());
				string = string.replace("\\", "/");
				Mapinterfece.resmap.put(string, file2.getPath());
			}
		}
	}
	public void setmap(File file) throws SAXException, IOException {
		//������д�Ľ��������������ļ�����urlmap��servlet
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(configfile),personHandler);
		setresmap(file);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public Map getservlet() {
		return servlet;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public Map geturlmap() {
		return urlmap;
	}
	@Override
	public Map<String, String> getresmap() {
		return resmap;
	}
}

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
 * 这个类用于实现服务器的map接口的构建
 * @author Administrator
 *
 */
public class Servermap implements Mapinterfece {
	// 构建解析工厂
	SAXParserFactory factory;
	// 获得解析器
	SAXParser parser;
	// 获得重写的解析器
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
		//利用递归扫描设置的资源路径构建资源文件夹map
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
		//利用重写的解析器解析配置文件构建urlmap和servlet
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

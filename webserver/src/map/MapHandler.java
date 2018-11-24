package map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 重写解析器用于处理xml配置文件
 * 
 * 
 * @author Administrator
 *
 */
public class MapHandler extends DefaultHandler {
	//map用于接收配置文件key velue内容
	String[] map=new String[2];
	//标记
	String tag;
	public MapHandler() {
	}
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (null!=qName) {
			tag=qName;
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("servlet")&&qName!=null) {
			Mapinterfece.servlet.put(map[0], map[1]);
		}
		if (qName.equals("urlmap")&&qName!=null) {
			Mapinterfece.urlmap.put(map[1], map[0]);
		}
		tag=null;
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		//注意！！tag!=null&&一定要加在前面，否则不会报空指针异常
		if (tag!=null&&tag.equals("servlet-name")) {
			map[0]=(new String(ch,start,length));
		}
		if (tag!=null&&tag.equals("servlet-class") ){
			map[1]=(new String(ch,start,length));
		}
		if (tag!=null&&tag.equals("url-pattern")) {
			map[1]=(new String(ch,start,length));
		}

	}
}

package respones;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import map.Mapinterfece;
import request.MyRequest;
/**
 * ������д�ķ�����url������
 * �жϿͻ��������ͽ���Ԥ�����Ե��÷��ط�ʽ.
 * @author Administrator
 *
 */
import request.Requsetmap;
/**
 * �����û������ж��û��ķ������ͣ��������ͷ�����Ӧ���ݶ���.
 * @author Administrator
 *
 */
public class MyRespones {
	public BufferedInputStream bufferedInputStream;
	public StringBuilder hand;
	public Requsetmap requsetmap;
	public String url;
	public MyRespones(MyRequest myRequest) throws SAXException, IOException, ParserConfigurationException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.requsetmap=myRequest.requsetmap;
		this.url=requsetmap.getrequestmapdata("url");
		analyzerequest();
		new PushResponesdata(myRequest.socket, this);
	}
	public void analyzerequest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException   {
		//�ж������url�Ƿ���ڣ������ڷ���404
		if (Mapinterfece.urlmap.containsKey(url)) {
				//�жϿͻ��Ķ�̬�����Ƿ��Ѵ���,�����ڷ���500
			if (Mapinterfece.servlet.containsKey(Mapinterfece.urlmap.get(url))) {
				//���÷��䴴��һ�����ڶ�̬�������ݵĶ���
				Class<?> respones=Class.forName(Mapinterfece.servlet.get(Mapinterfece.urlmap.get(url)));
				Inputouptinterface resObject=(Inputouptinterface) respones.newInstance();
				resObject.setbufferedInputStream(this.requsetmap);
				bufferedInputStream=resObject.getBufferedInputStream();
				this.hand = new Responeshand(url,"200", resObject.getinlen(),"utf8").hand;
				if (bufferedInputStream==null) {
					bufferedInputStream =new BufferedInputStream(new ByteArrayInputStream("正在建设".getBytes(),0,"正在建设".getBytes().length));
					this.hand = new Responeshand(url,"500", "正在建设".getBytes().length,"utf8").hand;
					return;
				}
				return;
			}else {
				bufferedInputStream =new BufferedInputStream(new ByteArrayInputStream("正在建设".getBytes(),0,"正在建设".getBytes().length));
				this.hand = new Responeshand(url,"500","正在建设".getBytes().length,"utf8").hand;
				return;
			}	
		//�ж������url�Ƿ�ֻ����Դ������Դ��ֱ�ӷ�����Դ.
		}else if (Mapinterfece.resmap.containsKey(url)) {
			File file = new File(Mapinterfece.resmap.get(url));
			long len = file.length();
			this.hand  = new Responeshand(url,"200", len,"UTF-8").hand;
			bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			return;
		} else {
			bufferedInputStream =new BufferedInputStream(new ByteArrayInputStream("正在建设".getBytes(),0,"正在建设".getBytes().length));
			this.hand = new Responeshand(url,"404", "正在建设".getBytes().length,"utf8").hand;
			return;
		}
	}
}

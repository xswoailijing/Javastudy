package map;
import java.util.HashMap;
import java.util.Map;
/**
 * �ӿ����ڷ��ʷ�����������map ������Դmap resmap urlmap ��̬������map servlet
 * 
 * @author Administrator
 *
 */
public interface Mapinterfece {
	Map<String, String> urlmap = new HashMap<String, String>();
	Map<String, String> resmap = new HashMap<String, String>();
	Map<String, String> servlet = new HashMap<String, String>();

	@SuppressWarnings("rawtypes")
	public abstract Map geturlmap();

	@SuppressWarnings("rawtypes")
	public abstract Map getservlet();

	@SuppressWarnings("rawtypes")
	public abstract Map getresmap();

}

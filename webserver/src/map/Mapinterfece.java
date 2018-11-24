package map;
import java.util.HashMap;
import java.util.Map;
/**
 * 接口用于访问服务器的所有map 其中资源map resmap urlmap 动态返回类map servlet
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

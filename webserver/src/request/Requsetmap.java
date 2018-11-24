package request;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Requsetmap {
	public static final String CRLF = "\r\n";
	String request = "";
	String mathod = "";
	String url = "";
	String cookic="";
	Socket socket;
	public Map<String, List<String>> requestmap = new HashMap<String, List<String>>();
	public Requsetmap(String request,Socket socket) {
		this.request=request;
		this.socket=socket;
		setrequestmap();
	}
	public String decode(String value, String code) {
		try {
			return URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setrequestmap() {
		/**
		 * 把客户端请求分割保存在requestmap。
		 * 
		 * @throws UnsupportedEncodingException
		 * 
		 */
		String data = "";
		if (null == request || (request = request.trim()).equals("")) {
			return;
		}
		String firstline = decode(request.substring(0, request.indexOf(CRLF)), "utf8");
		int idx = firstline.indexOf("/");
		mathod = firstline.substring(0, idx).trim();
		this.url = firstline.substring(idx , firstline.indexOf("HTTP/")).trim();
		if (mathod.equals("POST")) {
			Pattern pattern=Pattern.compile("uname=[a-zA-z0-9&=]+");
			Matcher matcher=pattern.matcher(request);
			if (matcher.find()) {
				data = matcher.group();
			}
		} else if (mathod.equals("GET")) {
			if (url.contains("?")) {
				String[] urlarray = url.split("\\?");
				this.url = urlarray[0].trim();
				data = urlarray[1];
			} else {
				this.url = firstline.substring(idx , firstline.indexOf("HTTP/")).trim();
			}
		}

		
		//获得COOKIC
		String keyString="cookic";
		if (!requestmap.containsKey(keyString)) {
			requestmap.put(keyString, new ArrayList<String>());
		}
		List<String> valueList = requestmap.get(keyString);
		valueList.add(cookic);
		
		
		//获得URL
		keyString="url";
		if (!requestmap.containsKey(keyString)) {
			requestmap.put(keyString, new ArrayList<String>());
		}
		valueList = requestmap.get(keyString);
		valueList.add(url);
		//获得方法
		keyString="mathod";
		if (!requestmap.containsKey(keyString)) {
			requestmap.put(keyString, new ArrayList<String>());
		}
		valueList = requestmap.get(keyString);
		valueList.add(mathod);
		//获得请求附加数据
		// 分割请求data字符串成数组
		if (data.equals("")) {
			return;
		}
		StringTokenizer stringTokenizer = new StringTokenizer(data, "&");
		while (stringTokenizer.hasMoreTokens()) {
			String keyvalue = stringTokenizer.nextToken();
			String keyvalues[] = keyvalue.split("=");
			if (keyvalues.length == 1) {
				keyvalues = Arrays.copyOf(keyvalues, 2);
				keyvalues[1] = null;
			}
			String key = keyvalues[0].trim();
			String value = null == keyvalues[1] ? null : decode(keyvalues[1].trim(), "utf8");
			if (!requestmap.containsKey(key)) {
				requestmap.put(key, new ArrayList<String>());
			}
			valueList = requestmap.get(key);
			valueList.add(value);
		}
	}
	public String[] getrequestmapdatas(String name) {
		List<String> valueStrings = null;
		if ((valueStrings = requestmap.get(name)) == null) {
			return null;
		} else {
			return valueStrings.toArray(new String[0]);
		}
	}
	public String getrequestmapdata(String name) {
		String[] valueStrings = getrequestmapdatas(name);
		if (valueStrings == null) {
			return null;
		} else {
			return valueStrings[0];
		}
	}

}

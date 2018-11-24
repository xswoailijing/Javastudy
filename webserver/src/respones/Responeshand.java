package respones;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 根据需要返回的类型构造返回头
 * @author Administrator
 *
 */

public class Responeshand {
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static final String js = "text/javascript;";
	public static final String png = "image/png;";
	public static final String jpg = "image/jpeg;";
	public static final String html = "text/html;";
	public static final String font = "font/opentype;";
	public static final String gif = "image/gif;";
	public static final String css = "text/css;";
	public static final String php = "text/php;";
	public StringBuilder hand = new StringBuilder();
	String contenttype = html;
	String code = "200";
	String url;
	public long contentlength = 0;
//	public String charset = "GBK";
	public String charset = "UTF-8";
	public Responeshand(String url,String code,long contentlength,String charset) {
		this.code=code;
		this.url=url;
		this.charset=charset;
		this.contentlength=contentlength;
		getcontenttype();
		handbuilder();
	}
	public Responeshand(String url,String code,long contentlength) {
		this.code=code;
		this.url=url;
		this.contentlength=contentlength;
		getcontenttype();
		handbuilder();
	}
	public void handbuilder() {
		hand.append("HTTP/1.1").append(BLANK).append(code).append(BLANK).append("OK").append(CRLF);
		hand.append("server: Apache").append(CRLF);
		hand.append("date:").append(new Date()).append(CRLF);
		hand.append("content-type:").append(contenttype).append("charset=").append(charset).append(CRLF);
		hand.append("content-length:").append(this.contentlength).append(CRLF);
		hand.append(CRLF);
	}
	public void getcontenttype() {
		String string = "";
		if (!url.equals("")&&url!=null) {
			Pattern pattern=Pattern.compile(""
			+ "\\.jpg|\\.png|\\.js|\\.html|\\.gif|\\.css|\\.php");
			Matcher m=pattern.matcher(url);
		if (m.find()) {
			string=m.group();
		}
			switch (string) {
			case ".jpg":
				this.contenttype = jpg;
				break;
			case ".png":
				this.contenttype = png;
				break;
			case ".php":
				this.contenttype = php;
				break;
			case ".js":
				this.contenttype = js;
				break;
			case ".html":
				this.contenttype = html;
				break;
			case ".gif":
				this.contenttype = gif;
				break;
			case ".css":
				this.contenttype = css;
				break;
			default:
				this.contenttype = html;
			}
		}
	}

}

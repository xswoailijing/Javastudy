package IOtest;

import java.io.UnsupportedEncodingException;

public class decodeandencoding {
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//默认的编码解码是gbk
		String string="撒旦法";
		byte[] b=new byte[20];
		b=string.getBytes("utf8");
		System.err.println(new String(b,0,b.length,"utf8"));
		//流转换
		
		
		
		
	}

}

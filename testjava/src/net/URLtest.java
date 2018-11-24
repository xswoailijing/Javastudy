package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.print.attribute.standard.RequestingUserName;

import org.omg.CORBA.Request;

public class URLtest {
	public URLtest() {
		// TODO 自动生成的构造函数存根
	}
	public void name() {
		
		try {
			URL url=new URL("http://www.baidu.com:80");
			try {
				InputStream stream=url.openStream();
				//返回url的字节流，用utf8解码 成字符流.
				BufferedReader bR=
			new BufferedReader(new InputStreamReader(stream,"utf8"));
				
				byte[] b=new byte[9999];
				String l=null;
				while ((l=bR.readLine())!=null) {
					
					System.err.println();
				}
				System.out.println(l);
				stream.close();
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}

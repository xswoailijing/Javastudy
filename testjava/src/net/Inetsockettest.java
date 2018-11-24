package net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Inetsockettest {
	public Inetsockettest() {
		// 这个接口可以设置和保存一个接口的IP地址和端口，打包要发送的数据时会调用
	}
	public void name() {
		
		InetSocketAddress inetsockettest=new InetSocketAddress(9999);
		
		inetsockettest.getAddress();
		System.err.println(inetsockettest.getPort());
	}
	

}

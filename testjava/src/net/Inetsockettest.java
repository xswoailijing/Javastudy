package net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Inetsockettest {
	public Inetsockettest() {
		// ����ӿڿ������úͱ���һ���ӿڵ�IP��ַ�Ͷ˿ڣ����Ҫ���͵�����ʱ�����
	}
	public void name() {
		
		InetSocketAddress inetsockettest=new InetSocketAddress(9999);
		
		inetsockettest.getAddress();
		System.err.println(inetsockettest.getPort());
	}
	

}

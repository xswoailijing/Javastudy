package net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inetaddresstest {
	public Inetaddresstest() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public void name() throws UnknownHostException {
		InetAddress inet4Address=Inet4Address.getLocalHost();
		System.err.println(inet4Address.getHostAddress());
		System.err.println(inet4Address.getHostAddress());
		System.err.println(inet4Address.getHostName());
	}
	public static void main(String[] args) throws UnknownHostException {
		new Inetaddresstest().name();
	}

}

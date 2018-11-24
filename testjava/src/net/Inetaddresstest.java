package net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inetaddresstest {
	public Inetaddresstest() {
		// TODO 自动生成的构造函数存根
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

package net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;

import com.google.common.net.InetAddresses;

import base.main;
import base.shuzu;

public class UDPtest {
	public UDPtest() {
		// TODO 自动生成的构造函数存根
	}
	public void name() throws IOException, InterruptedException {
		

//				//创建客户端
			DatagramSocket datagramSockets=new DatagramSocket(10086);
//			//创服务端
			
			DatagramSocket datagramSocketc=new DatagramSocket(10000);
			//打包客户端数据
			ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
			DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream);
			dataOutputStream.writeChars("发送时时间");
			dataOutputStream.writeLong(new Date().getTime());
			dataOutputStream.writeChars("发送完成");
			
			byte[] t =byteArrayOutputStream.toByteArray();
			

			
			DatagramPacket datagramPackets=new DatagramPacket		
			(t,t.length ,new InetSocketAddress("127.0.0.1",10000));
			//发送到服务端
			datagramSockets.send(datagramPackets);
			datagramSockets.close();
			//服务端准备接受
			byte[] buf=new byte[1000];
			DatagramPacket datagramPacketc=new DatagramPacket(buf, buf.length);
			datagramSocketc.receive(datagramPacketc);
			datagramSocketc.close();
			
			//服务端显示
			ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(datagramPacketc.getData());
			DataInputStream dataInputStream=new DataInputStream(byteArrayInputStream);
//			System.err.println(new Date(Long.parseLong(new String(datagramPacketc.getData(),0,datagramPacketc.getLength()))));
			for (int i = 0; i < 5; i++) {
				System.err.print(dataInputStream.readChar());
				
			}
			Thread.sleep(3000);
			System.err.println(new Date(dataInputStream.readLong()));	
			System.err.println(new Date());
				
				
			
			
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new UDPtest().name();
	}

}

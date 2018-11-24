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
		// TODO �Զ����ɵĹ��캯�����
	}
	public void name() throws IOException, InterruptedException {
		

//				//�����ͻ���
			DatagramSocket datagramSockets=new DatagramSocket(10086);
//			//�������
			
			DatagramSocket datagramSocketc=new DatagramSocket(10000);
			//����ͻ�������
			ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
			DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream);
			dataOutputStream.writeChars("����ʱʱ��");
			dataOutputStream.writeLong(new Date().getTime());
			dataOutputStream.writeChars("�������");
			
			byte[] t =byteArrayOutputStream.toByteArray();
			

			
			DatagramPacket datagramPackets=new DatagramPacket		
			(t,t.length ,new InetSocketAddress("127.0.0.1",10000));
			//���͵������
			datagramSockets.send(datagramPackets);
			datagramSockets.close();
			//�����׼������
			byte[] buf=new byte[1000];
			DatagramPacket datagramPacketc=new DatagramPacket(buf, buf.length);
			datagramSocketc.receive(datagramPacketc);
			datagramSocketc.close();
			
			//�������ʾ
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

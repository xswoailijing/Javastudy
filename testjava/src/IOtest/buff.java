package IOtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class buff {
	public static void main(String[] args) throws IOException {
		new buff().name();
		
	}
public void name() throws IOException {
	//===========================================================================
	//buff
	//���������ļ�����
	File file=new File("./src/IOtest/1.txt");
	File file1=new File("./src/IOtest/2.txt");
	//�����ļ�����������ֽ�������
	InputStream inputStream=new FileInputStream(file);
	OutputStream outputstream=new FileOutputStream(file1,true);
	//�ļ���ȡд���ַ���
	Reader inputStreamw=new FileReader(file);
	Writer outputstreamw=new FileWriter(file1,true);
	//�ֽ����������
	BufferedInputStream bufferedReader=new BufferedInputStream(inputStream);
	BufferedOutputStream bufferedWriter=new BufferedOutputStream(outputstream);
	
//	byte[] b=new byte[10];
//	int l=0;
//	while (-1!=(l=bufferedReader.read(b))) {
//		System.err.println(b);
//		System.err.println(new String(b,0,l));
	//}
	//==============================================================================	
		//�ַ���buff
		BufferedReader  bufferedReaderw=new BufferedReader(inputStreamw);
		BufferedWriter bufferedWriterww=new BufferedWriter(outputstreamw);
		//�����ӵ���������
		
//		System.err.println(bufferedReaderw.readLine());
		//�½�����
		bufferedWriterww.newLine();
		//ת����InputStreamReader �������ֽ���ת�����ַ���
		//OutputStreamWriter ������ֽ���ת�����ַ���
		BufferedReader  bufferedReadera=new BufferedReader(
			new InputStreamReader(inputStream,"gbk")	);
//			System.err.println(bufferedReadera.readLine());
		BufferedWriter bufferedWriterwa=new BufferedWriter(			
		new	OutputStreamWriter(	outputstream,"gbk"));
		//ѡ����������ѡ�������������
		DataOutputStream dosDataOutputStream=new DataOutputStream(outputstream);
		DataInputStream dis=new DataInputStream(inputStream);
	System.err.println(dis.readByte());
	//���л���
	ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
	ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputstream);
	
	
}
}

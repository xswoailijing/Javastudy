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
	//创建抽象文件对象
	File file=new File("./src/IOtest/1.txt");
	File file1=new File("./src/IOtest/2.txt");
	//创建文件输入输出流字节流对象
	InputStream inputStream=new FileInputStream(file);
	OutputStream outputstream=new FileOutputStream(file1,true);
	//文件读取写入字符流
	Reader inputStreamw=new FileReader(file);
	Writer outputstreamw=new FileWriter(file1,true);
	//字节流缓冲对象
	BufferedInputStream bufferedReader=new BufferedInputStream(inputStream);
	BufferedOutputStream bufferedWriter=new BufferedOutputStream(outputstream);
	
//	byte[] b=new byte[10];
//	int l=0;
//	while (-1!=(l=bufferedReader.read(b))) {
//		System.err.println(b);
//		System.err.println(new String(b,0,l));
	//}
	//==============================================================================	
		//字符流buff
		BufferedReader  bufferedReaderw=new BufferedReader(inputStreamw);
		BufferedWriter bufferedWriterww=new BufferedWriter(outputstreamw);
		//新增加的两个方法
		
//		System.err.println(bufferedReaderw.readLine());
		//新建空行
		bufferedWriterww.newLine();
		//转换流InputStreamReader 把输入字节流转换成字符流
		//OutputStreamWriter 把输出字节流转换成字符流
		BufferedReader  bufferedReadera=new BufferedReader(
			new InputStreamReader(inputStream,"gbk")	);
//			System.err.println(bufferedReadera.readLine());
		BufferedWriter bufferedWriterwa=new BufferedWriter(			
		new	OutputStreamWriter(	outputstream,"gbk"));
		//选择流，可以选择输出输入类型
		DataOutputStream dosDataOutputStream=new DataOutputStream(outputstream);
		DataInputStream dis=new DataInputStream(inputStream);
	System.err.println(dis.readByte());
	//序列化流
	ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
	ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputstream);
	
	
}
}

package IOtest;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.Scanner;

public class iotest{
	public static void main(String[] args) throws IOException {
		File file=new File("./src/iotest/1.txt");
		File file1=new File("./src/iotest/2.txt");
		File file2=new File("./src/iotest/3.txt");
		
		//�ļ������������byte�����ڵ���
		InputStream inputStream=new FileInputStream(file);
		OutputStream outputstream=new FileOutputStream(file1,true);
		//FileDescriptor.in out err���ǿ���̨������ļ�
		OutputStream printStream=new FileOutputStream(FileDescriptor.out);
//			byte[] b=new byte [10];
//			int l=0;
//				while (-1!=(l=inputStream.read(b))) {
//					System.err.println(new String(b,0,l));
//				}
					//�Ͽ����ļ�������
//					inputStream.close();
//		outputstream.write("asderwt\n".getBytes());
		//�ַ����� ��ȡΪ�ַ�������ַ�����
		Reader reader=new FileReader(file1);
		Writer writer=new FileWriter(file,true);
		//��ӡ��
		PrintStream pStream=new PrintStream(printStream);	
//		pStream.println("asdf");
		//����������
		InputStream pStream2=System.in;
		Scanner scanner=new Scanner(pStream2);
//		System.err.println(scanner.next());
		
		//����ض����ļ������
		System.setOut(pStream);
		//�Ѽ���������������ض�����ļ����������ʹ��ϵͳ����̨��ӡ��.
		System.out.println(scanner.next());
		//װ��
		
		
		
		
	
		
		//���������
		writer.flush();
		
	}
	
	
}


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
		
		//文件输入与输出流byte流，节点流
		InputStream inputStream=new FileInputStream(file);
		OutputStream outputstream=new FileOutputStream(file1,true);
		//FileDescriptor.in out err就是控制台定向的文件
		OutputStream printStream=new FileOutputStream(FileDescriptor.out);
//			byte[] b=new byte [10];
//			int l=0;
//				while (-1!=(l=inputStream.read(b))) {
//					System.err.println(new String(b,0,l));
//				}
					//断开对文件的引用
//					inputStream.close();
//		outputstream.write("asderwt\n".getBytes());
		//字符串流 读取为字符数组或字符串，
		Reader reader=new FileReader(file1);
		Writer writer=new FileWriter(file,true);
		//打印流
		PrintStream pStream=new PrintStream(printStream);	
//		pStream.println("asdf");
		//键盘输入流
		InputStream pStream2=System.in;
		Scanner scanner=new Scanner(pStream2);
//		System.err.println(scanner.next());
		
		//输出重定向到文件输出流
		System.setOut(pStream);
		//把键盘输入流输出到重定向的文件输出流，不使用系统控制台打印流.
		System.out.println(scanner.next());
		//装饰
		
		
		
		
	
		
		//清空数据流
		writer.flush();
		
	}
	
	
}


package IOtest;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class copyfiletext {
	public static void main(String[] args) throws IOException {
		File file0=new File("d:/temp");
		File file1=new File("d:/temp1");
		long t1=new Date().getTime();
		new copyfiletext().copy(file0, file1);
		long t2=new Date().getTime();
		System.err.println((t2-t1)/1000);
		
		
	}
	//用递归的方式copy文件夹。
	public void copy(File srcObject,File targetoObject ) throws IOException {
		if (srcObject.isDirectory()) {
			File dirFile=new File(targetoObject.getPath(),srcObject.getName());
			dirFile.mkdirs();
			File[] list=srcObject.listFiles();
			for (File file : list) {
				copy(file, dirFile);
			}
		}
		if(srcObject.isFile()) {
			//使用buff流后拷贝1.5g的文件减少了大概6秒时间，用1024byte60秒变55秒左右
			//使用4096后反而下降速度
			
//			InputStream inputStream=new FileInputStream(srcObject);
//			OutputStream outputStream=new FileOutputStream(new File(targetoObject.getPath(),srcObject.getName()));
			BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream(srcObject));
			BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(new File(targetoObject.getPath(),srcObject.getName())));	

			byte[] b=new byte[2048];
			int l=0;
			while (-1!=(l=inputStream.read(b))) {
				outputStream.write(b,0,l);	
			}
			inputStream.close();
			outputStream.close();
			System.err.printf("文件%s拷贝完毕\n",srcObject.getAbsoluteFile());	
			
			}		
	}

}

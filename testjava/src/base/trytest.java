package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class trytest {
	
	public void name() throws IOException {
FileReader reader=null;
		
		char temp='a';
		try {
			reader = new FileReader("D:\\javawork\\testjava\\src\\1.txt");
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
		temp = (char)reader.read();
		
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			System.out.println(temp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		reader.read();

//		reader.read();
		//异常类
		IOException zhi=new IOException("aasdfsaf");
		throw zhi;
	}

}

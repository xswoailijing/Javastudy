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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
		temp = (char)reader.read();
		
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		reader.read();

//		reader.read();
		//�쳣��
		IOException zhi=new IOException("aasdfsaf");
		throw zhi;
	}

}

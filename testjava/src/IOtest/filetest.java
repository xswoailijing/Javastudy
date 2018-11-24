package IOtest;

import java.awt.List;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class filetest {
	public static void main(String[] args) throws IOException, InterruptedException {
	
		
		File file=new File("1.txt");
		 file=new File(new File("./src/fileio"),"1.txt");
		System.err.println(file.pathSeparator);
		System.err.println(file.separator);
		System.err.println(file.getPath());
		System.err.println(file.getAbsolutePath());
		System.out.println(file.canWrite());
		System.out.println(file.exists());
		System.err.println(file.length());
//		file.delete();
		file.createNewFile();
		
		File file1=new File("./");
		//创建临时文件，文件名扩展名加路径
		File tp=File.createTempFile("tep", ".temp",file1);
//		System.err.println(tp.getAbsolutePath());
//		Thread.sleep(3000);		//加线程看临时文件状态
		tp.deleteOnExit();
		//判断对象是文件还是目录
		file.isFile();
		file.isDirectory();
		
		File file2=new File("./");
		file2.createNewFile();
		//列出文件夹列表
		File[] files=file2.listFiles(new FilenameFilter() {
			//匿名内部类文件过滤
			@Override
			public boolean accept(File dir,String name) {
				//重写过滤条件为真则过滤
			return new File(dir,name).isFile()&& name.endsWith("a.txt");
			}
		})	;
//		file2.mkdir();
		for (File string : files) {
			System.err.println(string.getAbsolutePath());
		}
		//列出根目录
		System.err.println(Arrays.toString(File.listRoots()));
		
		//分割文件RandomAccessFile 方法seek指定文件位置.
	}
}

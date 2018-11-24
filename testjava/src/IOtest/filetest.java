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
		//������ʱ�ļ����ļ�����չ����·��
		File tp=File.createTempFile("tep", ".temp",file1);
//		System.err.println(tp.getAbsolutePath());
//		Thread.sleep(3000);		//���߳̿���ʱ�ļ�״̬
		tp.deleteOnExit();
		//�ж϶������ļ�����Ŀ¼
		file.isFile();
		file.isDirectory();
		
		File file2=new File("./");
		file2.createNewFile();
		//�г��ļ����б�
		File[] files=file2.listFiles(new FilenameFilter() {
			//�����ڲ����ļ�����
			@Override
			public boolean accept(File dir,String name) {
				//��д��������Ϊ�������
			return new File(dir,name).isFile()&& name.endsWith("a.txt");
			}
		})	;
//		file2.mkdir();
		for (File string : files) {
			System.err.println(string.getAbsolutePath());
		}
		//�г���Ŀ¼
		System.err.println(Arrays.toString(File.listRoots()));
		
		//�ָ��ļ�RandomAccessFile ����seekָ���ļ�λ��.
	}
}

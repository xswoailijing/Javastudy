package base;

import java.util.Arrays;

public class Str{
public Str() {
	String string;
	
	// TODO 自动生成的构造函数存根
}
public static void main(String[] args) {
	StringBuilder stringBuilder=new StringBuilder();
	
	
	stringBuilder.append(true).append(false).append(false);
	
	System.out.print(stringBuilder);
	int[] i= {1,2,3,4,5};
	
	System.err.println(Arrays.toString(i));
	int fivelineidx="asdfasdfAccept:asdfasdf".indexOf("Accept:");
	System.err.println(fivelineidx);
	
	
}

}

package IOtest;

import java.lang.reflect.Array;

import javax.print.attribute.IntegerSyntax;

import com.google.common.base.MoreObjects.ToStringHelper;

public class fileutil {
	public static void main(String[] args) {
		new fileutil().name(1,2,3,4,5);
	}
	//点代表可变参数，可以设置多个参数
	//处理对象方式和数组一致
	
	//泛型方法设置方参数法的泛型.
	public <T extends Integer>  void name(T ... io) {
	 for (T i:io) {
		 System.out.println(i);
	}
	}

	public fileutil() {
		// TODO 自动生成的构造函数存根
	}
	
	
}

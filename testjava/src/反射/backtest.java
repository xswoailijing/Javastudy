package 反射;

import java.io.IOException;
import java.util.Random;
public class backtest {
	
	
	//反射，动态创建对象.
	//通过不同的请求动态创建 返回的对象.
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		String ssString="sad";
		Class<?> class1=ssString.getClass();
		class1=String.class;
		String string;
		//随机模拟两种请求，动态返回两种服务器类对象
		if ( 0==new Random().nextInt(2)) {
			System.err.println(0);
			string="httpserver.Httpserver";
		}else {
			System.err.println(1);
			string="backclass.Httpserver";
		}
		Class<?> h=Class.forName(string);
		System.err.println(h);
		//用空构造创建对象.这个类没有空构造器，可能会报错
//		Httpserver httpserver=(Httpserver)h.newInstance();
//		System.err.println(httpserver);
//		Httpserver httpserver2=new Httpserver();
//		System.err.println(httpserver2);
		
		
	}

}

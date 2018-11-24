package collectiont;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.MailcapCommandMap;
import javax.management.Attribute;

public class Collectiontest  {
	Collection collection0;
	public Collectiontest() {
		// TODO 自动生成的构造函数存根
	}
	public void collection() {
		
		//java的列表，同pytho的列表大致一样只是啰嗦了很多。
		List list=new ArrayList();
		Thread thread0=new Thread();
		Thread thread1=new Thread();
		list.add("asdasd");
		list.add("12341");
		list.add(thread0);
		list.remove("12341");
		System.out.println(list.size());
	Thread thread2=(Thread)list.get(1);
	System.out.println(thread2);
	((Thread) list.get(1)).start();
	
	   
		
	}
	
}




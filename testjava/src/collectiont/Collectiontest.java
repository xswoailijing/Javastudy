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
		// TODO �Զ����ɵĹ��캯�����
	}
	public void collection() {
		
		//java���б�ͬpytho���б����һ��ֻ�ǆ����˺ܶࡣ
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




package collectiont;

import java.util.HashMap;
import java.util.Map;

public class Maptest {
//java的map约等于python的字典。
	public void maptest() {
		Map map=new HashMap(); //hashmap效率高线程不安全，hashteble线程安全。
		map.put("name","name");
		map.put("name0","name");
		map.put("name1","name");
		Thread thread0 =new Thread();
		map.put("thread", thread0);
		System.out.println(map.get("thread"));
		System.err.println(map.hashCode());
		//hashmap的实现方式：用对象hash值取余后做为key再用数组保存序列.
		//数组序列指向链表头,用链表保存重复key。
		
	}
	
	
	
}

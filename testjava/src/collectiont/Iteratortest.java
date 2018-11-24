package collectiont;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Iteratortest {
	//迭代器测试
	public void name() {
		List list =new ArrayList();
		Set set =new HashSet();
		list.add("asdf");
		list.add("a2df");
		list.add("as3f");
		set.add("as4df");
		set.add("as1f");
		set.add("a2df");
		set.add("as3f");
		set.add("as4df");
//把可迭代对象作为迭代器的构建参数，python使用for的时候自动给每个对象添加了迭代器
		Iterator iterator=set.iterator();
		while (iterator.hasNext()) {	
			System.err.println(iterator.next());
			iterator.remove();//删除游标左边的元素
		}
		while (iterator.hasNext()) {	
			System.err.println(iterator.next());
			iterator.remove();
		}
	
		
	}

}

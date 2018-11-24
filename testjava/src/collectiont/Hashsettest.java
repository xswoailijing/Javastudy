package collectiont;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.soap.Node;

public class Hashsettest {
	public void name() {
		Set set=new HashSet();//无序不可重复容器,利用map设置一个单独值保存不同的key。
		set.add("asdfasdf");
		set.add("askkfasdf");
		set.add("ahhsdf");
		
		System.err.println(set);
	}

}

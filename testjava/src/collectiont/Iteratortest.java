package collectiont;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Iteratortest {
	//����������
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
//�ѿɵ���������Ϊ�������Ĺ���������pythonʹ��for��ʱ���Զ���ÿ����������˵�����
		Iterator iterator=set.iterator();
		while (iterator.hasNext()) {	
			System.err.println(iterator.next());
			iterator.remove();//ɾ���α���ߵ�Ԫ��
		}
		while (iterator.hasNext()) {	
			System.err.println(iterator.next());
			iterator.remove();
		}
	
		
	}

}

package collectiont;

import java.util.HashMap;
import java.util.Map;

public class Maptest {
//java��mapԼ����python���ֵ䡣
	public void maptest() {
		Map map=new HashMap(); //hashmapЧ�ʸ��̲߳���ȫ��hashteble�̰߳�ȫ��
		map.put("name","name");
		map.put("name0","name");
		map.put("name1","name");
		Thread thread0 =new Thread();
		map.put("thread", thread0);
		System.out.println(map.get("thread"));
		System.err.println(map.hashCode());
		//hashmap��ʵ�ַ�ʽ���ö���hashֵȡ�����Ϊkey�������鱣������.
		//��������ָ������ͷ,���������ظ�key��
		
	}
	
	
	
}

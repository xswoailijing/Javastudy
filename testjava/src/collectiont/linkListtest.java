package collectiont;

//��Ͻڵ�nodetest����һ������ָ�����Ե�����
public class linkListtest {
	Nodetest first;
	Nodetest last;
	int size;
	//�����ڴ�ָ����д������
	public void add(Object o) {
		Nodetest nodetest=new Nodetest();
		if(first==null) {
			nodetest.setprecious(null);//first����null����ӵ�һ���ڵ�
			nodetest.setobject(o);//�������
			nodetest.setnext(null);//��һ���ڵ�ָ���
			first=nodetest;
			last=nodetest;
		}else {
			nodetest.setprecious(last);
			nodetest.setobject(o);
			nodetest.setnext(null);
			last.setnext(nodetest);//first��Ϊ�գ���һ����ӵĽڵ�βָ������ڵ��ͷ��
			last=nodetest;
		}
		size++;
	}
	public int size() {
		return size;
	}
	public Object get(int index) {
		if (first==null) {
			return null;
		}else {
			
			Nodetest temp=first;
			
			for (int i = 1; i < index; i++) {
				if (i>=size) {
					return null ;
				}
				temp=temp.next;	
			}	
			if (temp.object!=null) {
				return temp.object;
			}
		}
		
		return null;
		
	}
	

}

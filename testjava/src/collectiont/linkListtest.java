package collectiont;

//配合节点nodetest创建一个依靠指针特性的链表。
public class linkListtest {
	Nodetest first;
	Nodetest last;
	int size;
	//利用内存指针手写的链表
	public void add(Object o) {
		Nodetest nodetest=new Nodetest();
		if(first==null) {
			nodetest.setprecious(null);//first等于null则添加第一个节点
			nodetest.setobject(o);//保存对象
			nodetest.setnext(null);//下一个节点指向空
			first=nodetest;
			last=nodetest;
		}else {
			nodetest.setprecious(last);
			nodetest.setobject(o);
			nodetest.setnext(null);
			last.setnext(nodetest);//first不为空，上一个添加的节点尾指向这个节点的头。
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

package collectiont;

public class Nodetest {
	Nodetest previous;//��һ���ڵ�ָ��NEXTָ������ڵ�ͷ
	Object object;//��Ŷ���
	Nodetest next;//nextָ��ָ����һ���ڵ�ͷ
	public Nodetest() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public Nodetest(Nodetest previous,Object object,Nodetest next) {
		super();
		this.previous=previous;
		this.object=object;
		this.next=next;
		
	}
	public Object getprevious() {
		return previous;
	}
	public Object getobject() {
		return object;
	}
	public Object getnext() {
		return next;
	}
	public void setprecious(Nodetest previous) {
		this.previous=previous;
	}
	public void setobject(Object object) {
		this.object=object;
	}
	public void setnext(Nodetest next) {
		this.next=next;
	}
	
	

}

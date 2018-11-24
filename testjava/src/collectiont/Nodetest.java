package collectiont;

public class Nodetest {
	Nodetest previous;//上一个节点指针NEXT指向这个节点头
	Object object;//存放对象
	Nodetest next;//next指针指向下一个节点头
	public Nodetest() {
		// TODO 自动生成的构造函数存根
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

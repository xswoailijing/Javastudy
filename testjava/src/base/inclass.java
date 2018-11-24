package base;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class inclass {
	int a;
	public inclass() {
		// TODO 自动生成的构造函数存根
	}

	
	public static void main(String[] args) {
		cptcpu cptcpu=new cptcpu();
		cptcpu.xinhao();
		cptcpu.cpuxinghao1 cpuxinghao1=new cptcpu.cpuxinghao1();
		cpuxinghao1.yunxing();
		
		
		
	}
}

class  cptcpu {
	// TODO 自动生成的方法存根
	
	private String amdString;
	private String intel;
	DEFAULT vis;
	
	//内部类'
	class cpuxinghao{
		int i=32;
		int a=64;
		void yunxing() {
			
			System.out.print(intel);
		}
	}
	static class cpuxinghao1{
		int i=32;
		int a=64;
		void yunxing() {
			
			System.out.print(a);
		}
	}	
	public void xinhao() {
		cptcpu.cpuxinghao xinhao=new cpuxinghao();
		xinhao.yunxing();
		
	}
}
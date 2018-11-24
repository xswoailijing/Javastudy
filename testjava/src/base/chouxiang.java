package base;

public abstract class chouxiang {
	int a;
	public abstract void chouxiang(); 
	
	public void chouxiang1() {
		chouxiang();
	}
	public chouxiang(){
		this.a=100;
	}
		
}

class chouxiang1 extends chouxiang {
	
	
	public void chouxiang() {
		 a=1;	
//		System.out.print(false);
		
		chouxiang testchouxiang=new chouxiang() {
			public void chouxiang() {
				// TODO 自动生成的方法存根
				
			}
		};
		testchouxiang.chouxiang1();
		System.out.print(testchouxiang.a);
	}
	
}
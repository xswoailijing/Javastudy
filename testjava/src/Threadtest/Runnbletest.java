package Threadtest;

import java.io.IOException;
import java.nio.CharBuffer;

public class Runnbletest implements Runnable {
	long i=1;
	int t;
	long is;
	@Override
	public void run() {
		runtest();
		name();
		
	}
	private void name() {
		while (true) {
			this.i+=1;
//			System.err.println(i);
			System.err.printf("进程%s序号%s\n",this.t,this.i);
//			runtest();
			if (i>is) {
				break;
			}
		}
	}
	public Runnbletest() {
		// TODO 自动生成的构造函数存根
	}
	public Runnbletest(long i,int t,long is) {
		super();
		this.i = i;
		this.t=t;
		this.is=is;
	}
	public void runtest() {
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				neme();
				// TODO 自动生成的方法存根
			}
		});
		thread.start();
	}
	protected void neme() {
		while (this.i<200) {
			System.err.printf("守护线程%s正在运行%s\n",this.t,this.i);
			
		}
		this.is=0;
		System.err.printf("尝试阻断进程%s\n",this.t);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.err.printf("守护线程%s已退出i=%s\n",this.t,this.i);
		
		// TODO 自动生成的方法存根
		
	}
	

}

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
			System.err.printf("����%s���%s\n",this.t,this.i);
//			runtest();
			if (i>is) {
				break;
			}
		}
	}
	public Runnbletest() {
		// TODO �Զ����ɵĹ��캯�����
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
				// TODO �Զ����ɵķ������
			}
		});
		thread.start();
	}
	protected void neme() {
		while (this.i<200) {
			System.err.printf("�ػ��߳�%s��������%s\n",this.t,this.i);
			
		}
		this.is=0;
		System.err.printf("������Ͻ���%s\n",this.t);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.err.printf("�ػ��߳�%s���˳�i=%s\n",this.t,this.i);
		
		// TODO �Զ����ɵķ������
		
	}
	

}

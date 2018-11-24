package Threadtest;

import java.awt.List;
import java.util.ArrayList;

public class Threadsafe implements Runnable {
	long i;
	int t;
	
public static void main(String[] args) {
	
	Threadsafe threadsafe=new Threadsafe();
	Thread thread1 =new Thread(threadsafe,"name1");
	Thread thread2 =new Thread(threadsafe,"name2");
	Thread thread3 =new Thread(threadsafe,"name3");
	thread1.start();
	thread2.start();
	thread3.start();
	
	
}
public Threadsafe(long i, int t) {
	super();
	this.i = 0;
	this.t = t;
}
public Threadsafe() {
	// TODO �Զ����ɵĹ��캯�����
}//synchronized ���������߳�ģ��.class������ʱ�ò���
//�����̰߳�ȫ. synchronized ͬ��������������.���˹ؼ��ֵĿ���߷���ͬʱֻ��һ���̷߳���
//����̲߳���ȫ�ĸ���ԭ���Ƕ���߳�ͬʱ����ͬһ������ķ���ʱ�����ӳ����⣬�Զ������ԵĲ�����ͻ��
public synchronized void name() {
	run();
	
}
public  void run() {
	while (true) synchronized(this)  {
		i+=1;
		System.err.printf("%s>>>>%s\n",new Thread().currentThread(),i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		if (i>=100) {
			break;
		}
	}
	
	
	
}
}

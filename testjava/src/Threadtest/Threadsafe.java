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
	// TODO 自动生成的构造函数存根
}//synchronized 可以锁定线程模板.class锁定块时用参数
//测试线程安全. synchronized 同步方法，方法锁.加了关键字的块或者方法同时只能一个线程访问
//造成线程不安全的根本原因是多个线程同时调用同一个对象的方法时，因延迟问题，对对象属性的操作冲突。
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if (i>=100) {
			break;
		}
	}
	
	
	
}
}

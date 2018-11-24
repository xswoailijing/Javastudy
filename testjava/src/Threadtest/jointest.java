package Threadtest;

public class jointest implements Runnable {
	long i=1;
	boolean start=false;
public static void main (String[] args) throws InterruptedException {
jointest jointest=	new jointest();
long i=1;
	Thread thread =new Thread(jointest,"name");
	jointest.start=true;
	thread.start();

	//用线程的join阻塞其他程序运行,在调用join的线程执行完之后被join的线程才会执行.
	//暂停线程yield,等待cpu再次调用，如果被暂停的线程优先级相同则cpu随机选择执行
//	thread.join();
//	thread.yield();
	while (true) {
		i+=1;
		System.err.printf("main%s\n",i);
		if (i>500) {
//			thread.join();
//			thread.yield();
			//优先级只是概率不是绝对先后
			thread.setPriority(Thread.MAX_PRIORITY);
			
		}
		if (i>1000) {
			break;
		}
			
	}
	System.err.println(thread.isAlive());
	System.err.println(thread.isAlive());
	System.err.println(thread.currentThread());
	System.err.println(thread.getName());

//	new Thread().join();
//	new Thread().sleep(1000,1000);
}
	public void name() {
		
		
	}
	@Override
	public void run() {
		
		while (start) {
			i+=1;
			System.err.printf("jonin%s\n",i);
			if (i>1000) {
				break;
			}
				
		}
		
	}
	
}

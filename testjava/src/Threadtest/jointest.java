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

	//���̵߳�join����������������,�ڵ���join���߳�ִ����֮��join���̲߳Ż�ִ��.
	//��ͣ�߳�yield,�ȴ�cpu�ٴε��ã��������ͣ���߳����ȼ���ͬ��cpu���ѡ��ִ��
//	thread.join();
//	thread.yield();
	while (true) {
		i+=1;
		System.err.printf("main%s\n",i);
		if (i>500) {
//			thread.join();
//			thread.yield();
			//���ȼ�ֻ�Ǹ��ʲ��Ǿ����Ⱥ�
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

package Threadtest;


class Threadtest extends Thread{
	
	
	public static void main(String[] args) {
		Runnbletest runnbletest=new Runnbletest(1,1,1000);
	Thread t1=	new Thread(runnbletest,"�߳�1");
	Thread t2=	new Thread(runnbletest,"�߳�2");
	t1.getName();
				t1.start();
				t2.start();
//		new Thread(new Runnbletest(1L,1,10000)).start();
//		new Thread(new Runnbletest(2L,2,20000)).start();
//		new Threadtest().start();
	}
	public void run() {
		new Thread(new Runnbletest(3L,3,30000)).start();	
		
		try {
			Threadtest.sleep(1000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
}


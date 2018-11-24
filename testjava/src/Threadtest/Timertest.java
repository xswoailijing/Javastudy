package Threadtest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.omg.CORBA.DATA_CONVERSION;

public class Timertest extends TimerTask {
	public Timertest() {
	}
	public static void main(String[] args) {
		//测试定时器.指定时间运行TimerTask类.
		Timer timer= new Timer();
		timer.schedule(new Timertest(), new Date(),2000);
		timer.schedule(new Timertest(), new Date(),2000);
		timer.schedule(new Timertest(), new Date(),2000);
//		timer.notify();
//		timer.cancel();

		
		
	}
	
	public void name() {
		
	}
	@Override
	public void run() {
			new Runnbletest(1,1,300).run();
			new Runnbletest(1,2,300).run();
			new Runnbletest(1,3,300).run();

		
	}
}

package collectiont;

import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;

public class queue {
	public static void main(String[] args) {
		Queue queue=new ArrayDeque<>();
		
		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");		
		Properties properties=new Properties();
		System.gc();
		System.runFinalization();
		for (Object pr : queue) {
			System.err.println(pr);
			
			
		}
		
	}

}

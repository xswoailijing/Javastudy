package base;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class timetest {
	
	public static void main(String[] args) {
		//ʱ����
		java.util.Date date = new java.util.Date();
		System.err.println(date.getTime());
		Calendar calendar = new GregorianCalendar();
		System.err.println(calendar.getTimeInMillis());
		System.err.println(new java.util.Date());
		//ʱ��������

		
	}
	java.util.Date date = new java.util.Date();
	
	long t = System.currentTimeMillis();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//�򵥸�ʽ��ʱ����
	Calendar calendar = new GregorianCalendar();

	public void name() {

	}

}

class timetestshow extends timetest {

	public void timetestshow() {

	}

	public void showtime() {
		 System.out.println("�������ڣ�");
		 Scanner scanner=new Scanner(System.in);
		 String inString=scanner.nextLine();
//		String inString = "2018-11-09";
		try {
			date = dateFormat.parse(inString);
			calendar.setTime(date);
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(date);
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		int jintian = calendar.get(Calendar.DAY_OF_MONTH);
		
		calendar.set(calendar.DATE, 1);
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.printf("\t");
		}
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
			if (i == jintian) {
				System.out.printf("*");
			}
			System.out.printf("%s\t", i);
			if (calendar.get(calendar.DAY_OF_WEEK) > 6) {
				System.out.printf("\n");
			}

			calendar.add(calendar.DATE, 1);
		}
	}

}

package Threadtest;

import java.util.ArrayList;
import java.util.Random;

public class Classtest {
public static void main(String[] args) {
	//调用方式,多线程调用时可能结果会不同 加入同步后可以解决这个问题
	Class class1=Class.name();
	Class class2=Class.name();
	Class class3=Class.name();
	System.out.println(class1.hashCode());//打印对象的hashcode
	System.err.println(System.identityHashCode(class2));
	System.err.println(System.identityHashCode(class3));//打印对象的内存地址
	System.err.println(System.identityHashCode(100000));
	System.err.println(System.identityHashCode(100000));
	System.err.println(System.identityHashCode(100000));
	System.err.println(System.identityHashCode(100000));
	
}
///单类对象，一个类只有一个对象
}
//定义方式 懒汉式定义方式
class Class {
	private int i;
	private static Class class1=null;
	//私有化构造器
	private Class() {	
	}
	public static Class name() {
		if (class1==null) {			
			class1=new Class();
		}
		return class1;	
	}
}
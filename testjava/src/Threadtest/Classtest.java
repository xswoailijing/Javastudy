package Threadtest;

import java.util.ArrayList;
import java.util.Random;

public class Classtest {
public static void main(String[] args) {
	//���÷�ʽ,���̵߳���ʱ���ܽ���᲻ͬ ����ͬ������Խ���������
	Class class1=Class.name();
	Class class2=Class.name();
	Class class3=Class.name();
	System.out.println(class1.hashCode());//��ӡ�����hashcode
	System.err.println(System.identityHashCode(class2));
	System.err.println(System.identityHashCode(class3));//��ӡ������ڴ��ַ
	System.err.println(System.identityHashCode(100000));
	System.err.println(System.identityHashCode(100000));
	System.err.println(System.identityHashCode(100000));
	System.err.println(System.identityHashCode(100000));
	
}
///�������һ����ֻ��һ������
}
//���巽ʽ ����ʽ���巽ʽ
class Class {
	private int i;
	private static Class class1=null;
	//˽�л�������
	private Class() {	
	}
	public static Class name() {
		if (class1==null) {			
			class1=new Class();
		}
		return class1;	
	}
}
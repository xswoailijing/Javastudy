package IOtest;

import java.lang.reflect.Array;

import javax.print.attribute.IntegerSyntax;

import com.google.common.base.MoreObjects.ToStringHelper;

public class fileutil {
	public static void main(String[] args) {
		new fileutil().name(1,2,3,4,5);
	}
	//�����ɱ�������������ö������
	//�������ʽ������һ��
	
	//���ͷ������÷��������ķ���.
	public <T extends Integer>  void name(T ... io) {
	 for (T i:io) {
		 System.out.println(i);
	}
	}

	public fileutil() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	
}

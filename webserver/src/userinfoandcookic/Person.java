package userinfoandcookic;

public class Person {
	String name;
	String age;
	public Person() {
		// TODO 自动生成的构造函数存根
	}
	public void show() {
		System.err.println(name+"\t"+age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}

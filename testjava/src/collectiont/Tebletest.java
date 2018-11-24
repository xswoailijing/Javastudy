package collectiont;
//自建泛型类
public class Tebletest <T extends Object> {
	int id;
	int hp;
	int mp;
	T name;
	//泛型<>：在构建容器时指定类型，get时省去强制转类 型，添加时判断类型
	//python默认就是泛型。
	
	public  <Tebletest> Tebletest() {
		
			
			
		// TODO 自动生成的构造函数存根
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}

}

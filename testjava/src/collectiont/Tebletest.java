package collectiont;
//�Խ�������
public class Tebletest <T extends Object> {
	int id;
	int hp;
	int mp;
	T name;
	//����<>���ڹ�������ʱָ�����ͣ�getʱʡȥǿ��ת�� �ͣ����ʱ�ж�����
	//pythonĬ�Ͼ��Ƿ��͡�
	
	public  <Tebletest> Tebletest() {
		
			
			
		// TODO �Զ����ɵĹ��캯�����
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

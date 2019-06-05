

import java.awt.Image;

public abstract class Poketmonster implements Fightable{
	private String name;//���ϸ� �̸� ex)��ī��, ���̸�
	private String type;//���ϸ� Ÿ�� ex)fire, grass
	private String condition;//�������
	private int current_HP;
	private int max_HP;
	private int atk;//���ݷ�
	private int def;//����
	private int E_LV;//���� ��ȭ �ܰ�
	private int M_LV;//�ִ� ��ȭ �ܰ�
	private int speed;//���ݼӵ�(������ ���� ����)
	private int kill_score;
	private Image current_img;
	private Image[] image_list;//�ش� ���ϸ� ��ȭ �ܰ躰 �̹���
	private Skill[] skill_list;//�ش� ���ϸ��� ����� �� �ִ� ��ų(4����)
	
	//������
	public Poketmonster() {
		image_list = new Image[3];
		current_img = image_list[0];
		skill_list = new Skill[4];
	}

	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getCurrent_HP() {
		return current_HP;
	}

	public void setCurrent_HP(int current_HP) {
		this.current_HP = current_HP;
	}
	
	public void changeCurrent_HP(int num) {
		this.current_HP += num;
		if(this.current_HP < 0) {
			this.current_HP = 0;
		}
		else if (this.current_HP > this.max_HP) {
			this.current_HP = this.max_HP;
		}
	}

	public int getMax_HP() {
		return max_HP;
	}

	public void setMax_HP(int max_HP) {
		this.max_HP = max_HP;
	}
	
	public void changeMax_HP(int num) {
		this.max_HP += num;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void changeAtk(int num) {
		this.atk += num;
	}
	
	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	public void changeDef(int num) {
		this.def += num;
	}

	public int getE_LV() {
		return E_LV;
	}

	public void setE_LV(int e_LV) {
		this.E_LV = e_LV;
	}
	
	public void changeE_LV(int num) {
		this.E_LV += num;
	}

	public int getM_LV() {
		return M_LV;
	}

	public void setM_LV(int m_LV) {
		this.M_LV = m_LV;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void changeSpeed(int num) {
		this.speed += num;
	}

	public int getKill_score() {
		return kill_score;
	}

	public void setKill_score(int kill_score) {
		this.kill_score = kill_score;
	}

	public Image[] getImage_list() {
		return image_list;
	}

	public void setImage_list(Image[] image_list) {
		this.image_list = image_list;
	}

	public Skill[] getSkill_list() {
		return skill_list;
	}

	public void setSkill_list(Skill[] skill_list) {
		this.skill_list = skill_list;
	}
	public abstract String evolution(); 
	
	@Override //num : ����� ��ų �ѹ�, p : ���ݴ��ϴ� ���ϸ�
	public String use_skill(int num, Poketmonster p) { //��� ��ų�� �������� ����ϱ� �޼ҵ�
		System.out.println("--------- ��ų ��� --------");
		Skill temp = skill_list[num];
		int dam = temp.getPower() * this.getAtk();
		String str_base = this.getName()+"�� "+temp.getName()+" ����!";
		String str_normal = "ȿ���� �־���!";
		String str_good = "ȿ���� �����ߴ�!";
		String str_bad = "ȿ���� ���ڸ� �� ����.";
		if(temp.getType().equals("water"))
		{
			if(p.getType().equals("fire"))
			{
				dam*=2;
				str_base += str_good;
			}
			else
				str_base +=str_normal;
		}
		else if(temp.getType().equals("electric"))
		{
			if(p.getType().equals("water"))
			{
				dam*=2;
				str_base += str_good;
			}
			else if(p.getType().equals("grass"))
			{
				dam/=2;
				str_base += str_bad;
			}
			else
				str_base +=str_normal;
		}
		else if(temp.getType().equals("grass"))
		{
			if(p.getType().equals("water"))
			{
				dam*=2;
				str_base += str_good;
			}
			else if(p.getType().equals("fire"))
			{
				dam/=2;
				str_base += str_bad;
			}
			else
				str_base +=str_normal;
		}
		else if(temp.getType().equals("fire"))
		{
			if(p.getType().equals("grass"))
			{
				dam*=2;
				str_base += str_good;
			}
			else if(p.getType().equals("water"))
			{
				dam/=2;
				str_base += str_bad;
			}
			else
				str_base +=str_normal;
		}
		dam -= p.getDef();//���� �޴� ������ = dam - p�� def
		dam/=10;
		p.changeCurrent_HP(-dam);
		
		return str_base;
	}
	
	public void is_dead()
	{
		if(this.getCurrent_HP()==0)
		{
			this.setCondition("DEAD");
		}
	}
	
}

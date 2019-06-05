
import java.awt.Image;

import javax.swing.ImageIcon;

public class �̻��ؾ� extends Poketmonster {
	
	public �̻��ؾ�()
	{
		
		Image img1 = new ImageIcon(this.getClass().getResource("/�̻��ؾ�.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/�̻���Ǯ.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/�̻��ز�.png")).getImage();
		Image[] temp_img = new Image[3];
		temp_img[0]=img1;
		temp_img[1]=img2;
		temp_img[2]=img3;
		this.setImage_list(temp_img);
		
		Skill s1 = new Skill("�����ġ��",30,"normal");
		Skill s2 = new Skill("����ä��",40,"grass");
		Skill s3 = new Skill("�ٳ�������",40,"grass");
		Skill s4 = new Skill("���鰡��",0,"grass");
		
		Skill[] temp_skill = new Skill[4];
		temp_skill[0]=s1;
		temp_skill[1]=s2;
		temp_skill[2]=s3;
		temp_skill[3]=s4;
		this.setSkill_list(temp_skill);
		
		this.setName("�̻��ؾ�");
		this.setCurrent_HP(100);
		this.setMax_HP(100);
		this.setType("grass");
		this.setAtk(10);
		this.setDef(10);
		this.setCondition("normal");
		this.setE_LV(0);
		this.setM_LV(2);
		this.setSpeed(10);
		this.setKill_score(0);
		
	}
	
	public String evolution()
	{
			if(this.getE_LV()<this.getM_LV())
			{
				this.changeE_LV(1);
				this.setKill_score(0);
				this.changeAtk(1);
				this.changeMax_HP(1);
				this.changeCurrent_HP(1);
				this.changeDef(1);
				
				this.changeSpeed(1);
				if(this.getE_LV()==1)
				{
					this.setName("�̻���Ǯ");
					return "�̻��ؾ��� �̻���Ǯ���� ��ȭ�� �����Ͽ����ϴ�.";
				}
				else if(this.getE_LV()==2)
				{
					this.setName("�̻��ز�");
					return "�̻���Ǯ�� �̻��ز����� ��ȭ�� �����Ͽ����ϴ�.";
				}
				else
				{
					return "����";
				}
			}
			else
			{
				return "��ȭ �� �� �ִ� �ܰ谡 �����ϴ�.";
			}
		
	}

}


import java.awt.Image;

import javax.swing.ImageIcon;

public class ��ī�� extends Poketmonster {
	
	public ��ī��()
	{
		
		Image img1 = new ImageIcon(this.getClass().getResource("/��ī��.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/������.png")).getImage();
		Image[] temp_img = new Image[2];
		temp_img[0]=img1;
		temp_img[1]=img2;
		this.setImage_list(temp_img);
		
		Skill s1 = new Skill("�����ġ��",30,"normal");
		Skill s2 = new Skill("�鸸��Ʈ",50,"electric");
		Skill s3 = new Skill("������ȭ",40,"normal");
		Skill s4 = new Skill("�����ڼ���",0,"electric");
		Skill[] temp_skill = new Skill[4];
		temp_skill[0]=s1;
		temp_skill[1]=s2;
		temp_skill[2]=s3;
		temp_skill[3]=s4;
		this.setSkill_list(temp_skill);
		
		this.setName("��ī��");
		this.setCurrent_HP(100);
		this.setMax_HP(100);
		this.setType("electric");
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
		if(this.getKill_score()>0)
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
					this.setName("������");
					return "��ī�� ������� ��ȭ�� �����Ͽ����ϴ�.";
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
		else
		{
			return "���� ��ȭ�� �� �����ϴ�";
		}
	}

}

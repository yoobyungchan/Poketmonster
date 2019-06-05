
import java.awt.Image;

import javax.swing.ImageIcon;

public class 이상해씨 extends Poketmonster {
	
	public 이상해씨()
	{
		
		Image img1 = new ImageIcon(this.getClass().getResource("/이상해씨.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/이상해풀.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/이상해꽃.png")).getImage();
		Image[] temp_img = new Image[3];
		temp_img[0]=img1;
		temp_img[1]=img2;
		temp_img[2]=img3;
		this.setImage_list(temp_img);
		
		Skill s1 = new Skill("몸통박치기",30,"normal");
		Skill s2 = new Skill("넝쿨채찍",40,"grass");
		Skill s3 = new Skill("잎날가르기",40,"grass");
		Skill s4 = new Skill("수면가루",0,"grass");
		
		Skill[] temp_skill = new Skill[4];
		temp_skill[0]=s1;
		temp_skill[1]=s2;
		temp_skill[2]=s3;
		temp_skill[3]=s4;
		this.setSkill_list(temp_skill);
		
		this.setName("이상해씨");
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
					this.setName("이상해풀");
					return "이상해씨가 이상해풀으로 진화에 성공하였습니다.";
				}
				else if(this.getE_LV()==2)
				{
					this.setName("이상해꽃");
					return "이상해풀이 이상해꽃으로 진화에 성공하였습니다.";
				}
				else
				{
					return "오류";
				}
			}
			else
			{
				return "진화 할 수 있는 단계가 없습니다.";
			}
		
	}

}

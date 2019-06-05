
import java.awt.Image;

import javax.swing.ImageIcon;

public class 피카츄 extends Poketmonster {
	
	public 피카츄()
	{
		
		Image img1 = new ImageIcon(this.getClass().getResource("/피카츄.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/라이츄.png")).getImage();
		Image[] temp_img = new Image[2];
		temp_img[0]=img1;
		temp_img[1]=img2;
		this.setImage_list(temp_img);
		
		Skill s1 = new Skill("몸통박치기",30,"normal");
		Skill s2 = new Skill("백만볼트",50,"electric");
		Skill s3 = new Skill("전광석화",40,"normal");
		Skill s4 = new Skill("전기자석파",0,"electric");
		Skill[] temp_skill = new Skill[4];
		temp_skill[0]=s1;
		temp_skill[1]=s2;
		temp_skill[2]=s3;
		temp_skill[3]=s4;
		this.setSkill_list(temp_skill);
		
		this.setName("피카츄");
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
					this.setName("라이츄");
					return "피카츄가 라이츄로 진화에 성공하였습니다.";
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
		else
		{
			return "아직 진화할 수 없습니다";
		}
	}

}

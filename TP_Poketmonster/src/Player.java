

import java.util.*;

public class Player {
	Scanner input = new Scanner(System.in);
	
	private Poketmonster [] my_monster;
	private Item [] my_item;
	private int poketNum; //각 포켓몬과 대응되는 숫자(?)
	private Player [] player_list;
	private String name;

	
	public Player() {
		my_monster = new Poketmonster[3];
		my_item = new Item[2];
		poketNum = 0;
	}
	
	public Player(String name) {
		this();
		this.name = name;
	}

	
	public Poketmonster[] getMy_monster() {
		return my_monster;
	}

	public void setMy_monster(Poketmonster[] my_monster) {
		this.my_monster = my_monster;
	}

	public Item[] getMy_item() {
		return my_item;
	}

	public void setMy_item(Item[] my_item) {
		this.my_item = my_item;
	}
	public int getPoketNum() {
		return poketNum;
	}
	public void setPoketNum(int poketNum) {
		this.poketNum = poketNum;
	}
	public Player[] getPlayer_list() {
		return player_list;
	}
	public void setPlayer_list(Player[] player_list) {
		this.player_list = player_list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public void order_poketmon(Poketmonster p/*공격받는 포켓몬*/) {
		//my_monster[poketNum] : 공격할 포켓몬
		System.out.println("========== 공격하기 ==========");
		System.out.println("<사용할 스킬을 고르시오 >");
		System.out.println("포켓몬 : " + my_monster[poketNum].getName());
		for(int i=0;i<my_monster[poketNum].getSkill_list().length;i++)
		{
			System.out.printf("%d. %s\n",i+1,my_monster[poketNum].getSkill_list()[i].getName());
		}
		System.out.print("[선택] : ");
		int choice = input.nextInt();
		System.out.println(my_monster[poketNum].use_skill(choice-1, p));
	}

	
	public void use_item() {
		System.out.println("========== 아이템 사용하기 ==========");
		System.out.println("< 어떤 아이템을 사용하시겠습니까? >");
		System.out.println("1. 회복포션");
		System.out.println("2. 상태회복포션");
		System.out.print("[선택] : ");
		int pick = input.nextInt();
		switch (pick) {
		case 1: if(my_item[0].getCount()==0)
				{
					my_item[0].be_used();
					//System.out.println("회복포션이 다 떨어졌습니다.");
				}
				else
				{
					System.out.println("------ 회복포션을 사용할 포켓몬을 고르시오. ------");
					showMyPoketmon();
					int choice = input.nextInt();
					my_monster[choice-1].changeCurrent_HP(50);
					System.out.println("HP가 50 증가합니다.");
					System.out.println(my_monster[choice-1].getName() + "의 HP : " + my_monster[choice-1].getCurrent_HP());
					my_item[0].be_used();
				}
				break;
		case 2:	if(my_item[1].getCount()==0)
				{
					my_item[1].be_used();
					//System.out.println("상태회복포션이 다 떨어졌습니다.");
				}	
				else
				{
					System.out.println("----- 상태회복포션을 사용할 포켓몬을 고르시오. -----");
					showMyPoketmon();
					int choice = input.nextInt();
					my_monster[choice-1].setCondition("normal");
					System.out.println("상태가 normal로 회복됩니다.");
					System.out.println(my_monster[choice-1].getName() + "의 상태 : " + my_monster[choice-1].getCondition());
					my_item[1].be_used();
				}
				break;
			
		default:
			System.out.println("잘못된 번호를 입력하셨습니다.");
			break;
		}
	}

	
	public void switch_poketmon() {
		System.out.println();
		System.out.println("========== 포켓몬 교체하기 ==========");
		System.out.println("<교체할 포켓몬을 고르시오 >");
		for(int i=0;i<my_monster.length;i++)
		{
			if(my_monster[i].getCondition().equals("DEAD")) {
				System.out.println((i+1)+". "+my_monster[i].getName() + "(전투불능 상태)");
				continue;
			}
			else
				System.out.println((i+1)+". "+my_monster[i].getName());
		}
		System.out.println("몇 번 포켓몬으로 바꾸시겠습니까?");
		System.out.println("(전투불능 상태의 포켓몬으로는 교체할 수 없습니다.)");
		poketNum = input.nextInt()-1;
		System.out.println(my_monster[poketNum].getName() + "으로 교체하였습니다");
		System.out.println();
	}

	
	
	public void surrender() {
		System.out.println();
		System.out.println("========== 항복하기 ==========");
	}

	public void choose_poket() {
		Scanner input = new Scanner (System.in);
		System.out.println( "====== " + this.getName()+ "님의 포켓몬을 선택합니다 ======");
		System.out.println("<3마리의 포켓몬을 선택하세요>");
		int i = 0;
		Poketmonster [] temp = new Poketmonster [3];
		while (i < 3) {
			System.out.println();
			System.out.println("---- [포켓몬 종류] ----");
			System.out.println("[1] 꼬부기");
			System.out.println("[2] 이상해씨");
			System.out.println("[3] 파이리");
			System.out.println("[4] 피카츄");
			System.out.print((i+1) + "번째 포켓몬을 선택해 주세요 : ");
			int j = input.nextInt();
			if (j == 1) {
				Poketmonster m1 = new 꼬부기();
				temp[i] = m1;
				System.out.println("꼬부기를 " + (i+1) + "번째 포켓몬으로 추가합니다.");
				i++;
			} else if (j == 2) {
				Poketmonster m2 = new 이상해씨();
				temp[i] = m2;
				System.out.println("이상해씨를 " + (i+1) + "번째 포켓몬으로 추가합니다.");
				i++;
			} else if (j == 3) {
				Poketmonster m3 = new 파이리();
				temp[i] = m3;
				System.out.println("파이리를 " + (i+1) + "번째 포켓몬으로 추가합니다.");
				i++;
			} else if (j == 4) {
				Poketmonster m4 = new 피카츄();
				temp[i] = m4;
				System.out.println("피카츄를 " + (i+1) + "번째 포켓몬으로 추가합니다.");
				i++;
			} else {
				System.out.println("잘못된 숫자를 입력하셨습니다");

			}
		}
		this.setMy_monster(temp);
		System.out.println();
		System.out.println("======= " + this.getName() +"'s 포켓몬 ========");
		for(int k=0; k<this.getMy_monster().length; k++) {
			System.out.println((k+1) + ". " + this.getMy_monster()[k].getName());
		}
		System.out.println("===========================");
		System.out.println();
	}
	
	public void showMyPoketmon() {
		System.out.println("========== " + this.getName() +  "'s Poketmonster ==========");
		for(int i=0;i<my_monster.length;i++)
		{
			System.out.printf("%d: %s\n",i+1,my_monster[i].getName());
		}
	}
	
	
	public boolean allDead() {
		if(my_monster[0].getCondition().equals("DEAD") && my_monster[1].getCondition().equals("DEAD")
		   && my_monster[2].getCondition().equals("DEAD"))
			return true;
		else
			return false;
	}
}
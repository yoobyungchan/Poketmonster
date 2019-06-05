

import java.util.*;

public class Player {
	Scanner input = new Scanner(System.in);
	
	private Poketmonster [] my_monster;
	private Item [] my_item;
	private int poketNum; //�� ���ϸ�� �����Ǵ� ����(?)
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

	
	public void order_poketmon(Poketmonster p/*���ݹ޴� ���ϸ�*/) {
		//my_monster[poketNum] : ������ ���ϸ�
		System.out.println("========== �����ϱ� ==========");
		System.out.println("<����� ��ų�� ���ÿ� >");
		System.out.println("���ϸ� : " + my_monster[poketNum].getName());
		for(int i=0;i<my_monster[poketNum].getSkill_list().length;i++)
		{
			System.out.printf("%d. %s\n",i+1,my_monster[poketNum].getSkill_list()[i].getName());
		}
		System.out.print("[����] : ");
		int choice = input.nextInt();
		System.out.println(my_monster[poketNum].use_skill(choice-1, p));
	}

	
	public void use_item() {
		System.out.println("========== ������ ����ϱ� ==========");
		System.out.println("< � �������� ����Ͻðڽ��ϱ�? >");
		System.out.println("1. ȸ������");
		System.out.println("2. ����ȸ������");
		System.out.print("[����] : ");
		int pick = input.nextInt();
		switch (pick) {
		case 1: if(my_item[0].getCount()==0)
				{
					my_item[0].be_used();
					//System.out.println("ȸ�������� �� ���������ϴ�.");
				}
				else
				{
					System.out.println("------ ȸ�������� ����� ���ϸ��� ���ÿ�. ------");
					showMyPoketmon();
					int choice = input.nextInt();
					my_monster[choice-1].changeCurrent_HP(50);
					System.out.println("HP�� 50 �����մϴ�.");
					System.out.println(my_monster[choice-1].getName() + "�� HP : " + my_monster[choice-1].getCurrent_HP());
					my_item[0].be_used();
				}
				break;
		case 2:	if(my_item[1].getCount()==0)
				{
					my_item[1].be_used();
					//System.out.println("����ȸ�������� �� ���������ϴ�.");
				}	
				else
				{
					System.out.println("----- ����ȸ�������� ����� ���ϸ��� ���ÿ�. -----");
					showMyPoketmon();
					int choice = input.nextInt();
					my_monster[choice-1].setCondition("normal");
					System.out.println("���°� normal�� ȸ���˴ϴ�.");
					System.out.println(my_monster[choice-1].getName() + "�� ���� : " + my_monster[choice-1].getCondition());
					my_item[1].be_used();
				}
				break;
			
		default:
			System.out.println("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	
	public void switch_poketmon() {
		System.out.println();
		System.out.println("========== ���ϸ� ��ü�ϱ� ==========");
		System.out.println("<��ü�� ���ϸ��� ���ÿ� >");
		for(int i=0;i<my_monster.length;i++)
		{
			if(my_monster[i].getCondition().equals("DEAD")) {
				System.out.println((i+1)+". "+my_monster[i].getName() + "(�����Ҵ� ����)");
				continue;
			}
			else
				System.out.println((i+1)+". "+my_monster[i].getName());
		}
		System.out.println("�� �� ���ϸ����� �ٲٽðڽ��ϱ�?");
		System.out.println("(�����Ҵ� ������ ���ϸ����δ� ��ü�� �� �����ϴ�.)");
		poketNum = input.nextInt()-1;
		System.out.println(my_monster[poketNum].getName() + "���� ��ü�Ͽ����ϴ�");
		System.out.println();
	}

	
	
	public void surrender() {
		System.out.println();
		System.out.println("========== �׺��ϱ� ==========");
	}

	public void choose_poket() {
		Scanner input = new Scanner (System.in);
		System.out.println( "====== " + this.getName()+ "���� ���ϸ��� �����մϴ� ======");
		System.out.println("<3������ ���ϸ��� �����ϼ���>");
		int i = 0;
		Poketmonster [] temp = new Poketmonster [3];
		while (i < 3) {
			System.out.println();
			System.out.println("---- [���ϸ� ����] ----");
			System.out.println("[1] ���α�");
			System.out.println("[2] �̻��ؾ�");
			System.out.println("[3] ���̸�");
			System.out.println("[4] ��ī��");
			System.out.print((i+1) + "��° ���ϸ��� ������ �ּ��� : ");
			int j = input.nextInt();
			if (j == 1) {
				Poketmonster m1 = new ���α�();
				temp[i] = m1;
				System.out.println("���α⸦ " + (i+1) + "��° ���ϸ����� �߰��մϴ�.");
				i++;
			} else if (j == 2) {
				Poketmonster m2 = new �̻��ؾ�();
				temp[i] = m2;
				System.out.println("�̻��ؾ��� " + (i+1) + "��° ���ϸ����� �߰��մϴ�.");
				i++;
			} else if (j == 3) {
				Poketmonster m3 = new ���̸�();
				temp[i] = m3;
				System.out.println("���̸��� " + (i+1) + "��° ���ϸ����� �߰��մϴ�.");
				i++;
			} else if (j == 4) {
				Poketmonster m4 = new ��ī��();
				temp[i] = m4;
				System.out.println("��ī�� " + (i+1) + "��° ���ϸ����� �߰��մϴ�.");
				i++;
			} else {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�");

			}
		}
		this.setMy_monster(temp);
		System.out.println();
		System.out.println("======= " + this.getName() +"'s ���ϸ� ========");
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
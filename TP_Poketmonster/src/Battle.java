
import java.util.Scanner;

public class Battle {
	Scanner input = new Scanner(System.in);
	
	private int turn;
	private Player player1;
	private Player player2;
	private Player[] player_list;
	
	public Battle(){}
	public Battle(Player p1, Player p2){
		this.turn = 0;
		this.player1 = p1;
		this.player2 = p2;
		player_list = new Player[2];
		player_list[0] = p1;
		player_list[1] = p2;
	}
	
	// �� ������ ���� �ٲ� ���Կ�
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player[] getPlayer_list() {
		return player_list;
	}
	public void setPlayer_list(Player[] player_list) {
		this.player_list = player_list;
	}
	
	
//	public void menu() {
//		System.out.println("======= Battle Menu =======");
//		System.out.println("1. �����ϱ�");
//		System.out.println("2. ������ ����ϱ�");
//		System.out.println("3. ���ϸ� ��ü�ϱ�");
//		System.out.println("4. �׺��ϱ�");
//	}
	
	public void showBattlesit(){
		System.out.println();
		System.out.println("=============== Battle ===============");
		Poketmonster temp1 = player1.getMy_monster()[player1.getPoketNum()];
		Poketmonster temp2 = player2.getMy_monster()[player2.getPoketNum()];
		System.out.println("<P1:" + player1.getName() + ">");
		System.out.printf("[%s] HP:%d/%d\n",temp1.getName(),temp1.getCurrent_HP(),temp1.getMax_HP());
		System.out.println("\t\t   "+"<P2:" + player2.getName() + ">");
		System.out.printf("\t\t   [%s] HP:%d/%d\n",temp2.getName(),temp2.getCurrent_HP(),temp2.getMax_HP());
		System.out.println("======================================");
	}
	public int selectBattle() //1�� return�Ǹ� ���� ����
	{	
		System.out.println();
		System.out.println("=============== " + player_list[turn%2].getName()+"�� �� ===============");
		System.out.println("< Battle Menu >");
		System.out.println("1. �����ϱ�");
		System.out.println("2. ������ ����ϱ�");
		System.out.println("3. ���ϸ� ��ü�ϱ�");
		System.out.println("4. ��ȭ�ϱ�");
		System.out.println("5. �׺��ϱ�");
		System.out.print("[����] : ");
		int choice = input.nextInt();
		switch(choice)
		{//���� ����(2�� ���� �������� �̿�, turn�� ��� 1�� ������Ų��.
		case 1:player_list[turn%2].order_poketmon(player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()]);
			   player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()].is_dead();
			   
			   if(player_list[(turn+1)%2].allDead())
			   {
				   System.out.println(player_list[(turn+1)%2].getName()+"��/�� �й��Ͽ����ϴ�.");
				   System.out.println("������ �����մϴ�.");
				   return 1;
			   }
			   
			   if(player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()].getCondition().equals("DEAD"))
			   {	
				   System.out.println("������ ���� " + player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()].getName()
						   				+ "��(��) �����Ҵ� ���°� �Ǿ����ϴ�.");
				   System.out.println(player_list[(turn+1)%2].getName() + "�� ���ϸ��� ��ü�մϴ�.");
				   player_list[(turn+1)%2].switch_poketmon();
			   }
			   turn++;
				return 0;
		case 2:player_list[turn%2].use_item();
				turn++;
				return 0;
		case 3:player_list[turn%2].switch_poketmon();
				turn++;
				return 0;
		case 4: String temp = player_list[turn%2].getMy_monster()[player_list[turn%2].getPoketNum()].evolution();
				if(!temp.equals("����"))
				{
					turn++;
				}
				System.out.println(temp);
				return 0;
		case 5: player_list[turn%2].surrender();
				System.out.println(player_list[turn%2].getName()+"��/�� �׺��Ͽ����ϴ�.");
				System.out.println("������ �����մϴ�.");
				return 1;
		default:
				return 0;
		}
	
	}
		

	
}

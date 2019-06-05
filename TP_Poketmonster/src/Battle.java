
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
	
	// 깃 연습을 위해 바꿔 볼게요
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
//		System.out.println("1. 공격하기");
//		System.out.println("2. 아이템 사용하기");
//		System.out.println("3. 포켓몬 교체하기");
//		System.out.println("4. 항복하기");
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
	public int selectBattle() //1로 return되면 게임 종료
	{	
		System.out.println();
		System.out.println("=============== " + player_list[turn%2].getName()+"의 턴 ===============");
		System.out.println("< Battle Menu >");
		System.out.println("1. 공격하기");
		System.out.println("2. 아이템 사용하기");
		System.out.println("3. 포켓몬 교체하기");
		System.out.println("4. 진화하기");
		System.out.println("5. 항복하기");
		System.out.print("[선택] : ");
		int choice = input.nextInt();
		switch(choice)
		{//턴제 게임(2로 나눈 나머지를 이용, turn을 계속 1씩 증가시킨다.
		case 1:player_list[turn%2].order_poketmon(player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()]);
			   player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()].is_dead();
			   
			   if(player_list[(turn+1)%2].allDead())
			   {
				   System.out.println(player_list[(turn+1)%2].getName()+"이/가 패배하였습니다.");
				   System.out.println("게임을 종료합니다.");
				   return 1;
			   }
			   
			   if(player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()].getCondition().equals("DEAD"))
			   {	
				   System.out.println("공격을 받은 " + player_list[(turn+1)%2].getMy_monster()[player_list[(turn+1)%2].getPoketNum()].getName()
						   				+ "가(이) 전투불능 상태가 되었습니다.");
				   System.out.println(player_list[(turn+1)%2].getName() + "의 포켓몬을 교체합니다.");
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
				if(!temp.equals("실패"))
				{
					turn++;
				}
				System.out.println(temp);
				return 0;
		case 5: player_list[turn%2].surrender();
				System.out.println(player_list[turn%2].getName()+"이/가 항복하였습니다.");
				System.out.println("게임을 종료합니다.");
				return 1;
		default:
				return 0;
		}
	
	}
		

	
}

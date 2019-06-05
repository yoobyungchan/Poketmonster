

import java.awt.EventQueue;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("< Welcome to Poketmonster Game! >");
		

		Item[] temp_item = new Item[2];
		Item rp = new RecoveryPotion();
		Item crp = new ConditionRecoveryPotion();
		rp.setCount(2);
		crp.setCount(1);
		temp_item[0] = rp;
		temp_item[1] = crp;

		System.out.print("Player1의 이름을 입력하세요 : ");
		String name1 = input.nextLine();
		Player p1 = new Player(name1);
		p1.choose_poket();
		p1.setMy_item(temp_item);
		
		System.out.print("Player2의 이름을 입력하세요 : ");
		String name2 = input.nextLine();
		Player p2 = new Player(name2);
		p2.choose_poket();
		p2.setMy_item(temp_item);
		
		Battle b = new Battle(p1,p2);
		int d;//d가 1이면 (누군가의 패배를 의미) 게임이 종료된다. 일종의 트릭 숫자.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(b);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true)
		{
			b.showBattlesit();
			d = b.selectBattle();
			if(d==1)
				break;
		}
		
		
	}
	

}

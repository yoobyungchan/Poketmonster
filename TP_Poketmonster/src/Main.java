

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

		System.out.print("Player1�� �̸��� �Է��ϼ��� : ");
		String name1 = input.nextLine();
		Player p1 = new Player(name1);
		p1.choose_poket();
		p1.setMy_item(temp_item);
		
		System.out.print("Player2�� �̸��� �Է��ϼ��� : ");
		String name2 = input.nextLine();
		Player p2 = new Player(name2);
		p2.choose_poket();
		p2.setMy_item(temp_item);
		
		Battle b = new Battle(p1,p2);
		int d;//d�� 1�̸� (�������� �й踦 �ǹ�) ������ ����ȴ�. ������ Ʈ�� ����.
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

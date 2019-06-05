

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.SwingConstants;

public class View extends JFrame {
	private JPanel contentPane;
	private Battle battle;
	
	
	
	public View(Battle b){
		this.battle = b;
		
		Image img_back = new ImageIcon(this.getClass().getResource("/back.jpg")).getImage();// �� ������Ʈ �ȿ� img ���� �ȿ� �ִ� back.jpg ������ �����ͼ� image�� �ִ� �κ� (�ؿ� croc �������� �κе� ���ƿ�)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 466, 346);
		contentPane = new JPanel() {
			@Override
			public void paintComponent(Graphics g)
			{
				g.drawImage(img_back, 0, 0, null);		// ��濡 �̹��� �����ϴ� �κ�(���ȭ��)
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel enemy_cHP = new JLabel();
		enemy_cHP.setText(Integer.toString(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getCurrent_HP()));
		enemy_cHP.setBounds(160, 45, 25, 21);
		contentPane.add(enemy_cHP);		//��� ü�� ��ġ 
		
		JLabel enemy_mHP = new JLabel();
		enemy_mHP.setText(Integer.toString(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getMax_HP()));
		enemy_mHP.setBounds(190, 45, 25, 21);
		contentPane.add(enemy_mHP);		//��� �ִ�ü�� ��ġ
		
		JLabel our_cHP = new JLabel();
		our_cHP.setText(Integer.toString(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getCurrent_HP()));
		our_cHP.setBounds(340, 170, 27, 21);
		contentPane.add(our_cHP);		//�츮 ü�� ��ġ
		
		JLabel out_mHP = new JLabel();
		out_mHP.setText(Integer.toString(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getMax_HP()));
		out_mHP.setBounds(370, 170, 25, 21);
		contentPane.add(out_mHP);		//�츮 �ִ�ü�� ��ġ
		
		JProgressBar our_bar = new JProgressBar();
		our_bar.setValue(100);
		our_bar.setBounds(278, 158, 130, 10);
		contentPane.add(our_bar);	//�츮 ü�¹�
		
		JProgressBar enemy_bar = new JProgressBar();
		enemy_bar.setValue(100);
		enemy_bar.setBounds(94, 37, 130, 10);
		contentPane.add(enemy_bar);	//��� ü�¹�
		
	
		JLabel battletext = new JLabel();
		battletext.setText("battle situation explanation");
		battletext.setBounds(202, 240, 236, 44);
		contentPane.add(battletext); //��Ʋ�� ���� ������ ������ â
		
		JLabel enemy_poketmon = new JLabel("");
		
			enemy_poketmon.setIcon(new ImageIcon(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getImage_list()
					[b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getE_LV()]));
			enemy_poketmon.setBounds(285, 10, 130, 130);
			contentPane.add(enemy_poketmon);
			
		JLabel our_poketmon = new JLabel("");
		
		our_poketmon.setIcon(new ImageIcon(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getImage_list()
				[b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getE_LV()]));
		our_poketmon.setBounds(33, 80, 130, 130);
		contentPane.add(our_poketmon);
		
		JLabel enemy_name = new JLabel(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getName());
		enemy_name.setBounds(44, 13, 74, 15);
		contentPane.add(enemy_name); //�� �̸� �ִ� �κ�

		
		JLabel our_name = new JLabel(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getName());
		our_name.setBounds(250, 138, 74, 15);
		contentPane.add(our_name);//�츮 �̸� �ִ� �κ�
		
		
		JButton skill1 = new JButton(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getSkill_list()[0].getName());
		skill1.setHorizontalAlignment(SwingConstants.LEFT);
		skill1.setFont(new Font("����", Font.PLAIN, 9));
		skill1.setBounds(12, 221, 84, 36);
		contentPane.add(skill1);
		
		JButton skill2 = new JButton(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getSkill_list()[1].getName());
		skill2.setFont(new Font("����", Font.PLAIN, 9));
		skill2.setBounds(97, 221, 84, 36);
		contentPane.add(skill2); //��ų�� �׳� �̸� �־����
		
		JButton skill3 = new JButton(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getSkill_list()[2].getName());
		skill3.setFont(new Font("����", Font.PLAIN, 9));
		skill3.setBounds(12, 261, 84, 36);
		contentPane.add(skill3); //��ų �׳� ��������
		
		JButton skill4 = new JButton(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getSkill_list()[3].getName());
		skill4.setFont(new Font("����", Font.PLAIN, 9));
		skill4.setBounds(97, 261, 84, 36);
		contentPane.add(skill4);	//�̰͵� ��ų
	
		JButton ���ΰ�ħ = new JButton("���ΰ�ħ");
		���ΰ�ħ.setBounds(200,261,100,36);
		���ΰ�ħ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enemy_cHP.setText(Integer.toString(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getCurrent_HP()));
				enemy_mHP.setText(Integer.toString(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getMax_HP()));
				our_cHP.setText(Integer.toString(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getCurrent_HP()));
				out_mHP.setText(Integer.toString(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getMax_HP()));
				our_bar.setValue(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getCurrent_HP());
				enemy_bar.setValue(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getCurrent_HP());
				our_poketmon.setIcon(new ImageIcon(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getImage_list()
						[b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getE_LV()]));
				enemy_poketmon.setIcon(new ImageIcon(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getImage_list()
						[b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getE_LV()]));
				our_name.setText(b.getPlayer1().getMy_monster()[b.getPlayer1().getPoketNum()].getName());
				enemy_name.setText(b.getPlayer2().getMy_monster()[b.getPlayer2().getPoketNum()].getName());
			}
		});
		contentPane.add(���ΰ�ħ);
		
		JLabel label = new JLabel("/");
		label.setBounds(182, 48, 10, 15);
		contentPane.add(label);//ü�� ǥ���ϴ� ���� ������ �κ� 
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(362, 173, 10, 15);
		contentPane.add(label_1);//ü�� ǥ���ϴ� ���� ������ �κ�
		
		
	
	}


}


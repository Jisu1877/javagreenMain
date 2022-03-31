package Swing2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class T8 extends JFrame{
	JPanel pn1, pn2;
	JButton btn1F, btn2B, btn3N, btn4E, btnExit, img1, img2, img3, img4;
	
	public T8() {
		super("레이아웃 연습");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		CardLayout card = new CardLayout(); 	
		pn1 = new JPanel();
		pn2 = new JPanel();
		
		btn1F = new JButton("처음으로");
		btn2B = new JButton("이전");
		btn3N = new JButton("다음");
		btn4E = new JButton("마지막으로");
		btnExit = new JButton("종료");
		
		pn1.add(btn1F);
		pn1.add(btn2B);
		pn1.add(btn3N);
		pn1.add(btn4E);
		pn1.add(btnExit);
		
		img1 = new JButton();
		img1.setIcon(new ImageIcon("images/1.jpg"));
		img2 = new JButton();
		img2.setIcon(new ImageIcon("images/2.jpg"));
		img3 = new JButton();
		img3.setIcon(new ImageIcon("images/3.jpg"));
		img4 = new JButton();
		img4.setIcon(new ImageIcon("images/4.jpg"));
		
		pn2.setLayout(card);
		
		pn2.add(img1);
		pn2.add(img2);
		pn2.add(img3);
		pn2.add(img4);
		
		add(pn1, BorderLayout.NORTH);
		add(pn2, BorderLayout.CENTER);
		
		setVisible(true);
		
		
		//메소드영역
		
		//처음으로
		btn1F.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(pn2);
			}
		});
		
		//이전
		btn2B.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(pn2);
			}
		});
		
		//다음
		btn3N.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(pn2);
			}
		});
		
		//마지막
		btn4E.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.last(pn2);
			}
		});
		
		//종료
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료합니다.");
				System.exit(0);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T8();
	}
}

package Swing2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T5_CardLayout extends JFrame{
	JButton btn1, btn2, btn3, btn4;
	
	
	public T5_CardLayout() {
		super("카드 레이아웃");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
//		setLayout(new CardLayout());  //아래 2줄과 동일. 이름을 주지않을때..
		CardLayout card = new CardLayout(); 	//이름을 줄때..
		setLayout(card);
		btn1 = new JButton("봄");		//card 레이아웃을 지정하고나선, 제일 처음인 '봄'이 제일 위에 올라간다.
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");		//card 레이아웃을 지정하기 전엔 계속 덮어씌워져서 '겨울'이 보였을 것이다.. 
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		setVisible(true);
		
		// 메소드 영역
		// 봄 버튼 처리
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());	//다음 프레임을 보여달라..
			}
		});
		
		// 여름 버튼 처리
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());	
			}
		});
		// 가을 버튼 처리
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());	
			}
		});
		// 겨울 버튼 처리
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());	
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T5_CardLayout();
	}
}

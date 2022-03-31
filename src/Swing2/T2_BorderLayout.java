package Swing2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T2_BorderLayout extends JFrame {
	JButton btn1, btn2, btn3, btn4, btnExit;
	
	public T2_BorderLayout() {
		super("Border레이아웃");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		btn1 = new JButton("북쪽");
		btn2 = new JButton("남쪽");
		btn3 = new JButton("서쪽");
		btn4 = new JButton("동쪽");
		btnExit = new JButton("가운데(종료)");
		
		add(btn1, BorderLayout.NORTH);	//BorderLayout 은 열거형 클래스라서 클래스명.상수 로 불러온다.
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
		add(btn4, BorderLayout.EAST);
		add(btnExit, BorderLayout.CENTER);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T2_BorderLayout();
	}
}

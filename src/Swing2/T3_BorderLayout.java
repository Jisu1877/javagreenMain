package Swing2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class T3_BorderLayout extends JFrame {
	JPanel pn1;
	JButton btn1, btn2, btn3, btn4, btnOK, btnExit;
	
	public T3_BorderLayout() {
		super("Border레이아웃");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		pn1 = new JPanel();
		
		btn1 = new JButton("북쪽");
		btn2 = new JButton("남쪽");
		btn3 = new JButton("서쪽");
		btn4 = new JButton("동쪽");
		btnOK = new JButton("확인");
		btnExit = new JButton("종료");
		
		add(btn1, BorderLayout.NORTH);	//BorderLayout 은 열거형 클래스라서 클래스명.상수 로 불러온다.
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
		pn1.add(btnOK);
		pn1.add(btnExit);
		add(pn1, BorderLayout.CENTER);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 확인버튼
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "확인버튼을 누르셨습니다.");
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료버튼을 누르셨습니다.");
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T3_BorderLayout();
	}
}

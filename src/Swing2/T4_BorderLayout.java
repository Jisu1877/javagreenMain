package Swing2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class T4_BorderLayout extends JFrame {
	JPanel pn1;
	JButton btn1, btn2, btn3, btn4, btnOK, btnExit;
	
	public T4_BorderLayout() {
		super("Border레이아웃");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
//		setLayout(new BorderLayout());	// 생략가능한 이유는 BorderLayout이 기본레이아웃이라서 가능하다. 
		
		btn1 = new JButton("북쪽");
		btn2 = new JButton("남쪽");
		btn3 = new JButton("서쪽");
//		btn4 = new JButton("동쪽");
		btnOK = new JButton("확인");
		btnExit = new JButton("종료");

		pn1 = new JPanel();
		
		pn1.setLayout(null); 	//앱솔루트 레이아웃으로 하겠다. pn1의 맨위쪽과 맨왼쪽 모서리에서부터 시작위치를 두고 위치지정하겠다..
		
		btnOK.setBounds(50, 100, 100, 30);	// 왼쪽으로부터 50, 위로부터 100, 크기는 너비 100, 높이 30
		btnExit.setBounds(160, 100, 100, 30);
		
		pn1.add(btnOK);
		pn1.add(btnExit);
		
		add(btn1, BorderLayout.NORTH);	
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
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
		new T4_BorderLayout();
	}
}

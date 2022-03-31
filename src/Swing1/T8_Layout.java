package Swing1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T8_Layout extends JFrame {
	
	public T8_Layout() {
		super("Layout에 배치하기");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("입력");
		JButton btn2 = new JButton("출력");
		JButton btn3 = new JButton("종료");
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T8_Layout();
	}
}

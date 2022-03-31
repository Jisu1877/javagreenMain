package Swing1;

import javax.swing.JFrame;

public class T6_WindowAlign extends JFrame{
	
	public T6_WindowAlign() {
		super("스윙창 화면에 중앙정렬");
		
		setSize(600, 550);
		setLocationRelativeTo(null);	//윈도우화면 중앙에 프레임 출력하기
		setResizable(false);	//윈도우 프레임 고정(크기 조절을 못하게..)
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new T6_WindowAlign();
	}
}

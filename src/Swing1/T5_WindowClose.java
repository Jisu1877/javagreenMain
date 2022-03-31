package Swing1;

import javax.swing.JFrame;

public class T5_WindowClose extends JFrame {
	
	public T5_WindowClose() {
		super("스윙 - 화면 종료");
		
		setSize(300, 250);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//콘솔창(시스템)이 닫기버튼(x)을 누르면 닫히게하기.
	}
	
	public static void main(String[] args) {
		new T5_WindowClose();
	}
}

package Swing1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class T4_Adapter extends JFrame  {
	
	public T4_Adapter() {
		super("스윙 연습4(아답터사용)");
		setBounds(200, 200, 300, 280);
		
		setVisible(true);
		
		//윈도우 감시자(아답터 사용...)
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T4_Adapter();
	}
}

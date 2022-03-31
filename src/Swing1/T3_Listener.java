package Swing1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class T3_Listener extends JFrame implements WindowListener {
	
	public T3_Listener() {
		super("스윙연습3"); //부모 생성자중에 String 매개변수를 받는 생성자가 있는 것. setTitle의 역할을 한다. 
		setBounds(200, 250, 300, 350);
		
		setVisible(true);
		
		//윈도우 감시자(Listener)를 호출....(현재(this) 윈도우를 감시)
		addWindowListener(this);	//사용하려면 WindowListener 를 implements해야한다. 그리고 추상메소드를 모두 오버라이드해야한다.
		
	}
	
	public static void main(String[] args) {
		new T3_Listener();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {	//닫히는 순간 ing.
		System.exit(0);
	}	

	@Override
	public void windowClosed(WindowEvent e) {}	//닫힌 것.

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}	//윈도우 활성화.

	@Override
	public void windowDeactivated(WindowEvent e) {}
}

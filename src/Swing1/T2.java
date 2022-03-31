package Swing1;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T2 extends JFrame {		//JFrame을 상속받았기 때문에 내것처럼 사용 가능.
	
	public T2() {
//		this.setSize(400, 300); 	this.은 생략가능.
		setBounds(300, 400, 350, 300); 	//주모니터(윈도우)를 기준으로 좌표와 크기 지정(x,y,w,h).
		setTitle("스윙 연습2");
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
					//부모가 생성되야 메소드 사용가능하다.
		new T2();	//내가 생성되면서 부모가 먼저 생성된다. 
		
	}
}

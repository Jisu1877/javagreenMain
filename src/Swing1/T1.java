package Swing1;

import javax.swing.JFrame;

public class T1 {
	public static void main(String[] args) {
		
		//컨테이터 생성(깔기)
		JFrame frame = new JFrame();	//프레임은 컨테이너역할이다.
		
		//컨테이너 사이즈 주기(사이즈를 주기 전엔 보이지 않는다.)
		frame.setSize(400, 300); 		//프레임의 크기를 지정한다.
		
		frame.setTitle("스윙 연습1");		//프레임의 제목을 지정한다.
		
		frame.setVisible(true);			//프레임을 화면에 출력시켜준다.
	}
}

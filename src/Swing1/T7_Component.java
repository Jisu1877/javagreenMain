package Swing1;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class T7_Component extends JFrame {
	
	public T7_Component() {	
		/*
		super("컴포넌트 연습");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
		
		
		super("컴포넌트 연습");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//레이블 출력(JLable)
		JLabel lbl1 = new JLabel();
		lbl1.setText("회원가입폼");	//제목지정.
		this.add(lbl1); //이 레이블을 화면에 올리겠다. this.은 생략가능.
		
		JLabel lbl2 = new JLabel("안녕하세요.");
		add(lbl2);	//첫번째 lbl1을 덮어씌우면서 올라간다.
		
		//버튼(JButton)
		JButton btn1 = new JButton("확인");
		add(btn1);	//두번째 lbl2 위에 올라간다. 이것을 피하려면 패널을 사용한다.
		
		//체크박스(JCheckBox
		add(new JCheckBox("남자")); 	//제어를 할꺼면 변수명을 생성하면서 줘야하지만 보여만 줄거라면 생성과 동시에 add할수도 있다.
		
		//라디오버튼(JRadioButton)
		add(new JRadioButton("여자"));
		
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T7_Component();
	}
}

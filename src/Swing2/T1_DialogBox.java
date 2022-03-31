package Swing2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class T1_DialogBox extends JFrame {
	JPanel pn1, pn2;
	JButton btn1, btn2, btn3, btn4, btnExit, btn5;
	JLabel lblMsg;
	
	public T1_DialogBox() {
		//디자인 영역
		super("메세지박스 연습");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(2, 1));	//2행 1열
		
		pn1 = new JPanel();
		
		btn1 = new JButton("경고");
		btn2 = new JButton("메세지삭제");
		btn3 = new JButton("입력");
		btn4 = new JButton("예/아니오");
		btn5 = new JButton("예/아니오/취소");
		btnExit = new JButton("종료");
		
		pn1.add(btn1); //pn1패널에 btn1 올리기.
		pn1.add(btn2);
		pn1.add(btn3);
		pn1.add(btn4);
		pn1.add(btn5);
		pn1.add(btnExit);
		add(pn1);	//패널을 프레임에 올리기.
		
		/*-----------------------------------*/
		
		pn2 = new JPanel();
		lblMsg = new JLabel("메세지가 출력됩니다.");
		pn2.add(lblMsg);
		
		add(pn2);
		
		
		setVisible(true);
		
		/* ----------------------------------*/
		
		//메소드 영역
		
		//경고 메세지 출력 메소드
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("경고버튼을 누르셨습니다.");
				
				//DiallogBox를 이용한 메세지 출력
				JOptionPane.showMessageDialog(null, "경고합니다.");
			}	
		});
		
		
		// 메세지 레이블 내용 삭제하기 메소드

		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("");
			}
		});
		
		// 입력메소드
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("입력버튼을 누르셨습니다.");
//				JOptionPane.showInputDialog(null, "성명을 입력하세요.");
				String name = JOptionPane.showInputDialog(null, "성명을 입력하세요.", "성명입력창", JOptionPane.INFORMATION_MESSAGE);
				if(name != null) {
					lblMsg.setText("성명 : " + name);
				}
			}
		});
		
		// 예/아니오 메소드
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("'예/아니오'버튼을 누르셨습니다.");
				int ans = JOptionPane.showConfirmDialog(null, "계속 진행 하시겠습니까?", "진행창", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				// 0 : 예 , 1 : 아니오  항상 첫번째 버튼이 0이다.
				if(ans == 0) lblMsg.setText("작업을 계속 진행합니다.");
				else lblMsg.setText("작업을 종료합니다.");
			}
		});
		
		// 예/아니오/취소 메소드
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText("예/아니오/취소 버튼을 누르셨습니다.");
				int ans = JOptionPane.showConfirmDialog(null, "계속 진행하시겠습니까?", "진행창", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				// 0 : 예 , 1 : 아니오, 2 : 취소
				if(ans == 0) lblMsg.setText("작업을 계속 진행합니다.");
				else if(ans == 1) lblMsg.setText("작업을 종료합니다.");
				else lblMsg.setText("취소버튼을 누르셨습니다.");
			}
		});
		
		//종료메소드
		btnExit.addActionListener(new ActionListener() {	//익명인터페이스는 add를 빼고 new + 리스너명을 적는다.
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new T1_DialogBox();
	}
}

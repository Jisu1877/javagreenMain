package Windowbuilder.Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test1 {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 window = new Test1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("연습1");
		frame.getContentPane().setFont(new Font("굴림체", Font.PLAIN, 16));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("회 원 가 입");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 34));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(81, 35, 440, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("입 력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(35, 279, 108, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("조 회");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton_1.setBounds(321, 279, 108, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(464, 279, 108, 36);
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 103, 440, 154);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(197, 31, 116, 21);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("성 명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(48, 31, 116, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("나 이");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(48, 87, 116, 21);
		panel.add(lblNewLabel_2);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(197, 87, 116, 21);
		panel.add(txtAge);
		
		JButton btnNewButton_1_2 = new JButton("수 정");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setFont(new Font("굴림체", Font.BOLD, 18));
		btnNewButton_1_2.setBounds(178, 279, 108, 36);
		frame.getContentPane().add(btnNewButton_1_2);
		frame.setBounds(100, 100, 625, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* ===================================================*/
		
		
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}

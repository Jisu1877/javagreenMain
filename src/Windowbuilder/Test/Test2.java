package Windowbuilder.Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Test2 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 window = new Test2();
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
	public Test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("연습2");
		frame.setBounds(100, 100, 450, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("다녀온 산");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(45, 10, 79, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(23, 48, 121, 160);
		frame.getContentPane().add(panel1);
		
		JCheckBox mt1 = new JCheckBox("백두산");
		panel1.add(mt1);
		
		JCheckBox mt2 = new JCheckBox("한라산");
		panel1.add(mt2);
		
		JCheckBox mt3 = new JCheckBox("태백산");
		panel1.add(mt3);
		
		JCheckBox mt4 = new JCheckBox("소백산");
		panel1.add(mt4);
		
		JCheckBox mt5 = new JCheckBox("천태산");
		panel1.add(mt5);
		
		JLabel lblNewLabel_1 = new JLabel("교통수단");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(247, 10, 158, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton how1 = new JRadioButton("자가용");
		buttonGroup.add(how1);
		how1.setBounds(247, 67, 121, 23);
		frame.getContentPane().add(how1);
		
		JRadioButton how2 = new JRadioButton("버스");
		buttonGroup.add(how2);
		how2.setBounds(247, 126, 121, 23);
		frame.getContentPane().add(how2);
		
		JRadioButton how3 = new JRadioButton("기차");
		buttonGroup.add(how3);
		how3.setBounds(247, 185, 121, 23);
		frame.getContentPane().add(how3);
		
		JRadioButton how4 = new JRadioButton("도보");
		buttonGroup.add(how4);
		how4.setBounds(247, 244, 121, 23);
		frame.getContentPane().add(how4);
		
		JRadioButton how5 = new JRadioButton("자전거");
		buttonGroup.add(how5);
		how5.setBounds(247, 307, 121, 23);
		frame.getContentPane().add(how5);
	}
}

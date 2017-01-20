package com.ard.oos.r;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowMain {

	public JFrame frame;
	private JTextField txtYoyoYourComplete;
	private JTextField textField_2;
	private ButtonGroup bg=new ButtonGroup();
	private ButtonGroup bg1=new ButtonGroup();

	JPanel panel;
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	JPanel panel_4;
	JPanel panel_5;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public WindowMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		panel = new JPanel();
		frame.getContentPane().add(panel, "name_8858956923696");
		panel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(true);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnNewButton.setBounds(230, 110, 183, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Complete Time Table");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			panel.setVisible(false);
			panel_1.setVisible(true);
			panel_2.setVisible(false);
			panel_4.setVisible(false);
			panel_3.setVisible(false);
			panel_5.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(29, 111, 176, 43);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_8862230441779");
		panel_1.setLayout(null);
		
		JLabel lblEnterUrYear = new JLabel("Enter your year:");
		lblEnterUrYear.setBounds(103, 104, 88, 14);
		panel_1.add(lblEnterUrYear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_4.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnSubmit.setBounds(151, 200, 89, 23);
		panel_1.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		panel_1.add(btnBack);
		
		JRadioButton rdbtnstYear = new JRadioButton("1st year");
		rdbtnstYear.setBounds(219, 49, 109, 23);
		panel_1.add(rdbtnstYear);
		
		JRadioButton rdbtnndYear = new JRadioButton("2nd year");
		rdbtnndYear.setBounds(219, 75, 109, 23);
		panel_1.add(rdbtnndYear);
		
		JRadioButton rdbtnrdYear = new JRadioButton("3rd year");
		rdbtnrdYear.setBounds(219, 100, 109, 23);
		panel_1.add(rdbtnrdYear);
		
		JRadioButton rdbtnthYear = new JRadioButton("4th year");
		rdbtnthYear.setBounds(219, 126, 109, 23);
		panel_1.add(rdbtnthYear);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_8869746804890");
		panel_2.setLayout(null);
		
		JLabel lblEnterYourBranch = new JLabel("Enter your Branch:");
		lblEnterYourBranch.setBounds(80, 84, 110, 24);
		panel_2.add(lblEnterYourBranch);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				panel_3.setVisible(true);
				panel_5.setVisible(false);
			}
		});
		btnSubmit_1.setBounds(157, 197, 89, 23);
		panel_2.add(btnSubmit_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnBack_1.setBounds(10, 11, 89, 23);
		panel_2.add(btnBack_1);
		
		JRadioButton rdbtnCse = new JRadioButton("CSE");
		rdbtnCse.setBounds(209, 64, 109, 23);
		panel_2.add(rdbtnCse);
		
		JRadioButton rdbtnIt = new JRadioButton("IT");
		rdbtnIt.setBounds(209, 97, 109, 23);
		panel_2.add(rdbtnIt);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, "name_8872538024640");
		panel_3.setLayout(null);
		
		txtYoyoYourComplete = new JTextField();
		txtYoyoYourComplete.setText("yoyo your complete timetable here");
		txtYoyoYourComplete.setBounds(56, 151, 283, 20);
		panel_3.add(txtYoyoYourComplete);
		txtYoyoYourComplete.setColumns(10);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_4.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnBack_2.setBounds(10, 11, 89, 23);
		panel_3.add(btnBack_2);
		
		panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, "name_8874620241975");
		panel_4.setLayout(null);
		
		JLabel lblEnterUrIdrollno = new JLabel("Enter ur id/rollno:");
		lblEnterUrIdrollno.setBounds(43, 112, 131, 35);
		panel_4.add(lblEnterUrIdrollno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 119, 86, 20);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().equals("ADMIN"))
				{
					panel_5.setVisible(true);
					panel.setVisible(false);
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel_4.setVisible(false);
					panel_3.setVisible(false);
				}
			}
		});
		btnSubmit_2.setBounds(149, 198, 89, 23);
		panel_4.add(btnSubmit_2);
		
		bg.add(rdbtnthYear);
		bg.add(rdbtnrdYear);
		bg.add(rdbtnndYear);
		bg.add(rdbtnstYear);
		bg1.add(rdbtnIt);
		bg1.add(rdbtnCse);
		
		JButton btnBack_3 = new JButton("back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnBack_3.setBounds(10, 11, 89, 23);
		panel_4.add(btnBack_3);
		
		panel_5 = new JPanel();
		frame.getContentPane().add(panel_5, "name_63016655292923");
		panel_5.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("View time table");
		btnNewButton_2.setBounds(42, 119, 89, 23);
		panel_5.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EDIT DATABASE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(177, 119, 89, 23);
		panel_5.add(btnNewButton_3);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(309, 119, 89, 23);
		panel_5.add(btnGenerate);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				textField_2.setText(null);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(true);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
			}
		});
		btnLogout.setBounds(156, 206, 89, 23);
		panel_5.add(btnLogout);
	}
}

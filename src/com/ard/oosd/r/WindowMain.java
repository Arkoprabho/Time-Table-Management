package com.ard.oosd.r;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WindowMain {

	public JFrame frame;
	private JTextField txtYoyoYourComplete;
	private JTextField textField_2;
	private ButtonGroup yearButtonGroup=new ButtonGroup();
	private ButtonGroup branchButtonGroup=new ButtonGroup();

	// The first panel. This is what the user first sees.
	JPanel homePanel;
	// Visible after the user chooses to view the time table. Here he can choose the year.
	JPanel chooseYearPanel;
	// Visible after the user submits the year. Here he can choose the branch.
	JPanel chooseBranchPanel;
	// The user can now see the entire time table.
	JPanel completeTimeTablePanel;
	// The user is asked for his roll number. 
	JPanel rollNumberPanel;
	// The panel that is visible only to the admin.
	JPanel adminPanel;
	
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
		homePanel = new JPanel();
		frame.getContentPane().add(homePanel, "name_8858956923696");
		homePanel.setLayout(null);
		
		
		addLoginButton();
		
		addViewTimeTableButton();
		
		chooseYear();
		
		// Set the button parameters for the years.
		JRadioButton rdbtnstYear = setButtonParameters("1st year", 219, 49, 109, 23, chooseYearPanel);
		
		JRadioButton rdbtnndYear = setButtonParameters("2nd year", 219, 75, 109, 23, chooseYearPanel);
		
		JRadioButton rdbtnrdYear = setButtonParameters("3rd year", 219, 100, 109, 23, chooseYearPanel);
		
		JRadioButton rdbtnthYear = setButtonParameters("4th year", 219, 126, 109, 23, chooseYearPanel);
		
		chooseBranch();
		
		// Set the button parameters for the branch.
		JRadioButton rdbtnCse = setButtonParameters("CSE", 209, 64, 109, 23, chooseBranchPanel);
		
		JRadioButton rdbtnIt = setButtonParameters("IT", 209, 97, 109, 23, chooseBranchPanel);
		
		completeTimeTable();
		
		// Set all the radio buttons in their button group
		yearButtonGroup.add(rdbtnthYear);
		yearButtonGroup.add(rdbtnrdYear);
		yearButtonGroup.add(rdbtnndYear);
		yearButtonGroup.add(rdbtnstYear);
		branchButtonGroup.add(rdbtnIt);
		branchButtonGroup.add(rdbtnCse);
		
		inputRollNumber();
		
		admin();
	}

	/**
	 * Sets the admin panel with its details.
	 * Activates it's related panel.
	 */
	private void admin() {
		adminPanel = new JPanel();
		frame.getContentPane().add(adminPanel, "name_63016655292923");
		adminPanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("View time table");
		btnNewButton_2.setBounds(42, 119, 89, 23);
		adminPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EDIT DATABASE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(177, 119, 89, 23);
		adminPanel.add(btnNewButton_3);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(309, 119, 89, 23);
		adminPanel.add(btnGenerate);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				textField_2.setText(null);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(false);
				rollNumberPanel.setVisible(true);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		btnLogout.setBounds(156, 206, 89, 23);
		adminPanel.add(btnLogout);
	}

	/**
	 * Lets the user input the roll number to login.
	 * Activates it's related panel.
	 */
	private void inputRollNumber() {
		rollNumberPanel = new JPanel();
		frame.getContentPane().add(rollNumberPanel, "name_8874620241975");
		rollNumberPanel.setLayout(null);
		
		JLabel lblEnterUrIdrollno = new JLabel("Enter ur id/rollno:");
		lblEnterUrIdrollno.setBounds(43, 112, 131, 35);
		rollNumberPanel.add(lblEnterUrIdrollno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 119, 86, 20);
		rollNumberPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().equals("ADMIN"))
				{
					adminPanel.setVisible(true);
					homePanel.setVisible(false);
					chooseYearPanel.setVisible(false);
					chooseBranchPanel.setVisible(false);
					rollNumberPanel.setVisible(false);
					completeTimeTablePanel.setVisible(false);
				}
			}
		});
		btnSubmit_2.setBounds(149, 198, 89, 23);
		rollNumberPanel.add(btnSubmit_2);
		
		// TODO should validate the roll number and its associated section. It should also check if it is the admin and take to the respective panel.
		
		JButton btnBack_3 = new JButton("back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(false);
				rollNumberPanel.setVisible(false);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		btnBack_3.setBounds(10, 11, 89, 23);
		rollNumberPanel.add(btnBack_3);
	}

	/**
	 * Shows the complete time table.
	 * Activates it's related panel.
	 */
	private void completeTimeTable() {
		completeTimeTablePanel = new JPanel();
		frame.getContentPane().add(completeTimeTablePanel, "name_8872538024640");
		completeTimeTablePanel.setLayout(null);
		
		txtYoyoYourComplete = new JTextField();
		txtYoyoYourComplete.setText("yoyo your complete timetable here");
		txtYoyoYourComplete.setBounds(56, 151, 283, 20);
		completeTimeTablePanel.add(txtYoyoYourComplete);
		txtYoyoYourComplete.setColumns(10);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(true);
				rollNumberPanel.setVisible(false);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		btnBack_2.setBounds(10, 11, 89, 23);
		completeTimeTablePanel.add(btnBack_2);
	}

	/**
	 * Lets the user choose the branch.
	 * Activates it's related panel.
	 */
	private void chooseBranch() {
		chooseBranchPanel = new JPanel();
		frame.getContentPane().add(chooseBranchPanel, "name_8869746804890");
		chooseBranchPanel.setLayout(null);
		
		JLabel lblEnterYourBranch = new JLabel("Enter your Branch:");
		lblEnterYourBranch.setBounds(80, 84, 110, 24);
		chooseBranchPanel.add(lblEnterYourBranch);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(false);
				rollNumberPanel.setVisible(false);
				completeTimeTablePanel.setVisible(true);
				adminPanel.setVisible(false);
			}
		});
		btnSubmit_1.setBounds(157, 197, 89, 23);
		chooseBranchPanel.add(btnSubmit_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				chooseYearPanel.setVisible(true);
				chooseBranchPanel.setVisible(false);
				rollNumberPanel.setVisible(false);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		btnBack_1.setBounds(10, 11, 89, 23);
		chooseBranchPanel.add(btnBack_1);
	}

	/**
	 * Sets the parameters for the radio button.
	 * Also sets the panel it is associated with.
	 * @return
	 */
	private JRadioButton setButtonParameters(String name, int xPos, int yPos, int width, int height, JPanel panelToAdd) {
		JRadioButton rdbtnstYear = new JRadioButton(name);
		rdbtnstYear.setBounds(219, yPos, 109, 23);
		panelToAdd.add(rdbtnstYear);
		return rdbtnstYear;
	}

	/**
	 * Lets the user choose the year.
	 * Activates it's related panel.
	 */
	private void chooseYear() {
		chooseYearPanel = new JPanel();
		frame.getContentPane().add(chooseYearPanel, "name_8862230441779");
		chooseYearPanel.setLayout(null);
		
		JLabel lblEnterUrYear = new JLabel("Enter your year:");
		lblEnterUrYear.setBounds(70, 104, 120, 14);
		chooseYearPanel.add(lblEnterUrYear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(true);
				rollNumberPanel.setVisible(false);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		btnSubmit.setBounds(151, 200, 89, 23);
		chooseYearPanel.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(false);
				rollNumberPanel.setVisible(false);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		chooseYearPanel.add(btnBack);
	}

	/**
	 * Adds the View Time Table button to the homePanel.
	 */
	private void addViewTimeTableButton() {
		JButton viewTimeTableButton = new JButton("View Time Table");
		viewTimeTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			homePanel.setVisible(false);
			chooseYearPanel.setVisible(true);
			chooseBranchPanel.setVisible(false);
			rollNumberPanel.setVisible(false);
			completeTimeTablePanel.setVisible(false);
			adminPanel.setVisible(false);
			}
		});
		
		viewTimeTableButton.setBounds(29, 110, 200, 41);
		homePanel.add(viewTimeTableButton);
	}

	/**
	 * Adds the Login button to the homePanel.
	 */
	private void addLoginButton() {
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(false);
				chooseYearPanel.setVisible(false);
				chooseBranchPanel.setVisible(false);
				rollNumberPanel.setVisible(true);
				completeTimeTablePanel.setVisible(false);
				adminPanel.setVisible(false);
			}
		});
		
		loginButton.setBounds(230, 110, 183, 41);
		homePanel.add(loginButton);
	}
}

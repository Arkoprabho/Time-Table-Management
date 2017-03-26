package com.ard.oosd.r;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;

public class WindowMain {

	public JFrame frame;
	JLabel homeicon;
	JLabel lblHomeimage;
	//different panels used in the frame
	JPanel homepanel,selectionpanel,panel;
	JPanel adminpanel,adminloginpanel,studentpanel,rollid_panel,aboutpanel;
	JPanel completetimetablebranch,completetimetableyear;
	private JTextField rollfield;
	private JTextField passwordfield;
	/**
	 * Launch the application.
	 */
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//loading the main frame
					WindowMain window = new WindowMain();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAutoRequestFocus(false);
		frame.setIgnoreRepaint(true);
		//for full screen frame irrespective of screen resolution
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
		//frame.setBounds(0, 0, 1366, 768);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
						//create homepanel
						homepanel = new JPanel();
						homepanel.setBounds(104, 92, 1256, 647);
						frame.getContentPane().add(homepanel);
						homepanel.setBackground(Color.BLACK);
						homepanel.setLayout(new CardLayout(0, 0));
						
						//create admin panel
						adminpanel = new JPanel();
						adminpanel.setBackground(Color.BLACK);
						adminpanel.setBounds(104, 92, 1256, 647);
						frame.getContentPane().add(adminpanel);
						adminpanel.setLayout(null);
						
			
						//add generate button to admin panel
						JLabel lblGenerateTimeTable = new JLabel("Generate time table");
						lblGenerateTimeTable.setHorizontalAlignment(SwingConstants.CENTER);
						lblGenerateTimeTable.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblGenerateTimeTable.setForeground(Color.WHITE);
						lblGenerateTimeTable.setBounds(421, 361, 207, 72);
						adminpanel.add(lblGenerateTimeTable);
						
						//add viewcomplete time table button to admin panel
						JLabel lblViewCompleteTime_1 = new JLabel("View complete time table");
						lblViewCompleteTime_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								completetimetablebranch.setVisible(true);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								completetimetableyear.setVisible(false);
								rollfield.setVisible(true);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								adminpanel.setVisible(false);
							}
						});
						lblViewCompleteTime_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblViewCompleteTime_1.setForeground(Color.WHITE);
						lblViewCompleteTime_1.setBounds(421, 253, 236, 66);
						adminpanel.add(lblViewCompleteTime_1);
						
						//add view personal time table to admin panel
						JLabel lblViewPersonalTime = new JLabel("View Personal time table");
						lblViewPersonalTime.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								rollid_panel.setVisible(true);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(true);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								adminpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
								completetimetableyear.setVisible(false);
							}
						});
						lblViewPersonalTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblViewPersonalTime.setForeground(Color.WHITE);
						lblViewPersonalTime.setBounds(421, 146, 254, 53);
						adminpanel.add(lblViewPersonalTime);
						
						//set image as back on the admin panel
						JLabel lblback_2 = new JLabel(new ImageIcon("resources/images/Back.png"));
						lblback_2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								rollid_panel.setVisible(false);
								homepanel.setVisible(true);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								completetimetableyear.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								adminpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblback_2.setBounds(10, 11, 40, 40);
						adminpanel.add(lblback_2);
						
						JLabel logout = new JLabel("Logout");
						logout.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								adminloginpanel.setVisible(true);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								completetimetableyear.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(true);
								passwordfield.setText(null);
								adminpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						logout.setHorizontalAlignment(SwingConstants.CENTER);
						logout.setFont(new Font("Tahoma", Font.PLAIN, 17));
						logout.setForeground(Color.WHITE);
						logout.setBounds(466, 516, 111, 29);
						adminpanel.add(logout);
						
						//to add branch selection panel
						completetimetablebranch = new JPanel();
						completetimetablebranch.setBackground(Color.BLACK);
						completetimetablebranch.setBounds(104, 92, 1256, 647);
						frame.getContentPane().add(completetimetablebranch);
						completetimetablebranch.setLayout(null);
						
						JLabel lblChooseYourBranch = new JLabel("Choose your branch:");
						lblChooseYourBranch.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblChooseYourBranch.setForeground(Color.WHITE);
						lblChooseYourBranch.setBounds(510, 156, 152, 52);
						completetimetablebranch.add(lblChooseYourBranch);
						
						JLabel lblCSE = new JLabel("CSE");
						lblCSE.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								completetimetableyear.setVisible(true);
								adminpanel.setVisible(false);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblCSE.setHorizontalAlignment(SwingConstants.CENTER);
						lblCSE.setBackground(Color.BLACK);
						lblCSE.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblCSE.setForeground(Color.WHITE);
						lblCSE.setBounds(419, 285, 108, 27);
						completetimetablebranch.add(lblCSE);
						
						JLabel lblIt = new JLabel("IT");
						lblIt.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								completetimetableyear.setVisible(true);
								adminpanel.setVisible(false);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblIt.setHorizontalAlignment(SwingConstants.CENTER);
						lblIt.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblIt.setForeground(Color.WHITE);
						lblIt.setBounds(652, 285, 120, 27);
						completetimetablebranch.add(lblIt);
						
						JLabel lblBack = new JLabel(new ImageIcon("resources/images/Back.png"));
						lblBack.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								homepanel.setVisible(true);
								completetimetableyear.setVisible(false);
								adminpanel.setVisible(false);
								rollid_panel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblBack.setForeground(Color.WHITE);
						lblBack.setBounds(10, 11, 40, 40);
						completetimetablebranch.add(lblBack);
			
						//to add year selection panel
						completetimetableyear = new JPanel();
						completetimetableyear.setBackground(Color.BLACK);
						completetimetableyear.setBounds(104, 92, 1256, 647);
						frame.getContentPane().add(completetimetableyear);
						completetimetableyear.setLayout(null);
						
						JLabel lblChooseYourYear = new JLabel("Choose your year:");
						lblChooseYourYear.setFont(new Font("Tahoma", Font.PLAIN, 17));
						lblChooseYourYear.setForeground(Color.WHITE);
						lblChooseYourYear.setHorizontalAlignment(SwingConstants.CENTER);
						lblChooseYourYear.setBounds(474, 137, 176, 56);
						completetimetableyear.add(lblChooseYourYear);
						
						JLabel _1styear = new JLabel("1st year");
						_1styear.setHorizontalAlignment(SwingConstants.CENTER);
						_1styear.setFont(new Font("Tahoma", Font.PLAIN, 17));
						_1styear.setForeground(Color.WHITE);
						_1styear.setBounds(315, 275, 100, 34);
						completetimetableyear.add(_1styear);
						
						JLabel _2ndyear = new JLabel("2nd year");
						_2ndyear.setForeground(Color.WHITE);
						_2ndyear.setFont(new Font("Tahoma", Font.PLAIN, 17));
						_2ndyear.setHorizontalAlignment(SwingConstants.CENTER);
						_2ndyear.setBounds(453, 279, 100, 27);
						completetimetableyear.add(_2ndyear);
						
						JLabel _3rdyear = new JLabel("3rd year");
						_3rdyear.setFont(new Font("Tahoma", Font.PLAIN, 17));
						_3rdyear.setForeground(Color.WHITE);
						_3rdyear.setHorizontalAlignment(SwingConstants.CENTER);
						_3rdyear.setBounds(599, 275, 71, 34);
						completetimetableyear.add(_3rdyear);
						
						JLabel _4thyear = new JLabel("4th year");
						_4thyear.setFont(new Font("Tahoma", Font.PLAIN, 17));
						_4thyear.setForeground(Color.WHITE);
						_4thyear.setHorizontalAlignment(SwingConstants.CENTER);
						_4thyear.setBounds(718, 279, 89, 30);
						completetimetableyear.add(_4thyear);
						
						JLabel lblback_1 = new JLabel(new ImageIcon("resources/images/Back.png"));
						lblback_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								completetimetablebranch.setVisible(true);
								completetimetableyear.setVisible(false);
								adminpanel.setVisible(false);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
							}
						});
						lblback_1.setBounds(10, 11, 40, 40);
						completetimetableyear.add(lblback_1);
				
				//add about panel
				aboutpanel = new JPanel();
				aboutpanel.setBackground(Color.BLACK);
				aboutpanel.setBounds(104, 92, 1256, 647);
				frame.getContentPane().add(aboutpanel);
				aboutpanel.setLayout(new CardLayout(0, 0));
			
				//add student panel
				studentpanel = new JPanel();
				studentpanel.setBackground(Color.BLACK);
				studentpanel.setBounds(104, 92, 1256, 647);
				frame.getContentPane().add(studentpanel);
				studentpanel.setLayout(null);
				
				JLabel Login = new JLabel("LOGIN");
				Login.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						rollid_panel.setVisible(true);
						homepanel.setVisible(false);
						aboutpanel.setVisible(false);
						studentpanel.setVisible(false);
						rollfield.setVisible(true);
						passwordfield.setVisible(false);
						adminloginpanel.setVisible(false);
						adminpanel.setVisible(false);
						completetimetablebranch.setVisible(false);
						completetimetableyear.setVisible(false);
					}
				});
				Login.setFont(new Font("Tahoma", Font.PLAIN, 17));
				Login.setForeground(Color.WHITE);
				Login.setBounds(607, 212, 131, 34);
				studentpanel.add(Login);
				
				JLabel lblViewCompleteTime = new JLabel("View Complete time table");
				lblViewCompleteTime.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						completetimetablebranch.setVisible(true);
						rollid_panel.setVisible(false);
						homepanel.setVisible(false);
						aboutpanel.setVisible(false);
						studentpanel.setVisible(false);
						completetimetableyear.setVisible(false);
						rollfield.setVisible(true);
						passwordfield.setVisible(false);
						adminloginpanel.setVisible(false);
						adminpanel.setVisible(false);
					}
				});
				lblViewCompleteTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblViewCompleteTime.setForeground(Color.WHITE);
				lblViewCompleteTime.setBounds(540, 306, 222, 66);
				studentpanel.add(lblViewCompleteTime);
				
				//add panel for admin login
				adminloginpanel = new JPanel();
				adminloginpanel.setBackground(Color.BLACK);
				adminloginpanel.setBounds(104, 92, 1256, 647);
				frame.getContentPane().add(adminloginpanel);
				adminloginpanel.setLayout(null);
				
				JLabel lblEnterYourPassword = new JLabel("Enter your password");
				lblEnterYourPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblEnterYourPassword.setForeground(Color.WHITE);
				lblEnterYourPassword.setBounds(168, 232, 219, 52);
				adminloginpanel.add(lblEnterYourPassword);
				
				//textbox to enter password
				passwordfield = new JTextField();
				passwordfield.setBounds(500, 237, 171, 36);
				adminloginpanel.add(passwordfield);
				passwordfield.setColumns(10);
				passwordfield.setVisible(false);
				
				JLabel lblSubmit_1 = new JLabel("Submit");
				lblSubmit_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(passwordfield.getText().toString().equals("ADMIN"))
						{
							adminpanel.setVisible(true);
							rollid_panel.setVisible(false);
							homepanel.setVisible(false);
							aboutpanel.setVisible(false);
							studentpanel.setVisible(false);
							rollfield.setVisible(false);
							passwordfield.setVisible(false);
							adminloginpanel.setVisible(false);
							completetimetablebranch.setVisible(false);
							completetimetableyear.setVisible(false);
							
						}
					}
				});
				lblSubmit_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblSubmit_1.setForeground(Color.WHITE);
				lblSubmit_1.setBounds(552, 376, 102, 44);
				adminloginpanel.add(lblSubmit_1);
		
				//add rollid verification panel
				rollid_panel = new JPanel();
				rollid_panel.setBackground(Color.BLACK);
				rollid_panel.setBounds(104, 94, 1256, 645);
				frame.getContentPane().add(rollid_panel);
				rollid_panel.setLayout(null);
			
				JLabel lblSubmit = new JLabel("SUBMIT");
				lblSubmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblSubmit.setForeground(Color.WHITE);
				lblSubmit.setBounds(507, 328, 134, 55);
				rollid_panel.add(lblSubmit);
				
				JLabel lblEnterYourId = new JLabel("Enter your id or roll no:");
				lblEnterYourId.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblEnterYourId.setForeground(Color.WHITE);
				lblEnterYourId.setBounds(266, 248, 204, 20);
				rollid_panel.add(lblEnterYourId);
				
					
					rollfield = new JTextField();
					rollfield.setBounds(491, 248, 86, 20);
					rollid_panel.add(rollfield);
					rollfield.setColumns(10);
					
					JLabel lblback_3 = new JLabel(new ImageIcon("resources/images/Back.png"));
					lblback_3.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							rollid_panel.setVisible(false);
							homepanel.setVisible(true);
							aboutpanel.setVisible(false);
							studentpanel.setVisible(false);
							rollfield.setVisible(false);
							passwordfield.setVisible(false);
							adminloginpanel.setVisible(false);
							adminpanel.setVisible(false);
							completetimetablebranch.setVisible(false);
							completetimetableyear.setVisible(false);
						}
					});
					lblback_3.setBounds(10, 11, 40, 40);
					rollid_panel.add(lblback_3);
					rollfield.setVisible(false);
					
			
		
		//panel to select student teacher admin etc
		selectionpanel = new JPanel();
		selectionpanel.setBackground(Color.DARK_GRAY);
		selectionpanel.setBounds(0, 0, 106, 739);
		frame.getContentPane().add(selectionpanel);
		selectionpanel.setLayout(null);
		
		homeicon = new JLabel(new ImageIcon("resources/images/homeic_close.png"));
		homeicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JLabel lblHomeimage = new JLabel(new ImageIcon("resources/images/home.jpg"));
				lblHomeimage.setBounds(104, 94, 1256, 645);
				homepanel.add(lblHomeimage, "homepanel");
				homepanel.setVisible(true);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(false);
				rollid_panel.setVisible(false);
				rollfield.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				homeicon.setIcon(new ImageIcon("resources/images/homeic_Open.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				homeicon.setIcon(new ImageIcon("resources/images/homeic_close.png"));
			}
		});
		homeicon.setBounds(10, 11, 75, 78);
		selectionpanel.add(homeicon);
		
		JLabel lblAbout = new JLabel("ABOUT");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 JLabel lblHomeimage = new JLabel(new ImageIcon("resources/images/about.jpg"));
				lblHomeimage.setBounds(104, 94, 1256, 645);
				aboutpanel.add(lblHomeimage, "lblHomeimage");
				homepanel.setVisible(false);
				aboutpanel.setVisible(true);
				rollfield.setVisible(false);
				studentpanel.setVisible(false);
				rollid_panel.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
		});
		lblAbout.setBounds(21, 340, 46, 14);
		selectionpanel.add(lblAbout);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(true);
				rollid_panel.setVisible(false);
				rollfield.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
		});
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setBounds(21, 145, 46, 14);
		selectionpanel.add(lblStudent);
		
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(true);
				rollid_panel.setVisible(false);
				rollfield.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
		});
		lblTeacher.setForeground(Color.WHITE);
		lblTeacher.setBounds(21, 217, 46, 14);
		selectionpanel.add(lblTeacher);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(false);
				rollid_panel.setVisible(false);
				rollfield.setVisible(false);
				passwordfield.setText(null);
				passwordfield.setVisible(true);
				adminloginpanel.setVisible(true);
				adminpanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
		});
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setBounds(21, 275, 46, 14);
		selectionpanel.add(lblAdmin);
		
		//top panel
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(104, 0, 1256, 96);
		frame.getContentPane().add(panel);
		
	}
}

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
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

import com.ard.oosd.a.RollToClassMapping;
import com.sun.xml.internal.ws.assembler.dev.ServerTubelineAssemblyContext;

import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowMain {

	public JFrame frame;
	JLabel homeicon;
	JLabel lblHomeimage,backtoadminlabel,lblback_3;
	//different panels used in the frame
	JPanel homepanel,selectionpanel,appnamepanel;
	JPanel ProfessorPanel,generatePanel,adminpanel,adminloginpanel,studentpanel,rollid_panel,aboutpanel;
	JPanel completetimetablebranch,completetimetableyear;
	private JTextField rollfield;
	private JTextField passwordfield;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField Professorname;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		//for full screen frame irrespective of screen resolution
		//GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
		frame.setBounds(0, 0, 1366, 768);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
								
								ProfessorPanel = new JPanel();
								ProfessorPanel.setBackground(Color.BLACK);
								ProfessorPanel.setBounds(104, 127, 1262, 641);
								frame.getContentPane().add(ProfessorPanel);
								ProfessorPanel.setLayout(null);
								ProfessorPanel.setVisible(false);
								
								DefaultListModel<String> model=new DefaultListModel<>();
								JList<String> teacherlist = new JList<>(model);
								ProfessorPanel.add(teacherlist);
								JScrollPane listScrollPane = new JScrollPane(teacherlist,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
								
							//	listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
								
								teacherlist.setBounds(721, 145, 200, 258);
								ProfessorPanel.add(listScrollPane);
								ProfessorPanel.add(teacherlist);
								Professorname = new JTextField();
								Professorname.setBounds(509, 256, 86, 20);
								ProfessorPanel.add(Professorname);
								Professorname.setColumns(10);
								
								JLabel lblEnterTheProfessor = new JLabel("Enter the professor name to add:");
								lblEnterTheProfessor.setHorizontalAlignment(SwingConstants.CENTER);
								lblEnterTheProfessor.setForeground(Color.WHITE);
								lblEnterTheProfessor.setBounds(186, 256, 244, 20);
								ProfessorPanel.add(lblEnterTheProfessor);
								
								JButton btnAdd = new JButton("ADD");
								btnAdd.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										String s=Professorname.getText().toString();
										int k=0;
										int l=teacherlist.getModel().getSize();
											model.addElement(s);
											Professorname.setText(null);
									}
								});
								btnAdd.setBounds(418, 317, 89, 23);
								ProfessorPanel.add(btnAdd);
								
								JButton btnRemove = new JButton("Remove");
								btnRemove.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										int index=teacherlist.getSelectedIndex();
										model.remove(index);
										Professorname.setText(null);
									}
								});
								btnRemove.setBounds(574, 317, 89, 23);
								ProfessorPanel.add(btnRemove);
								
								JButton btnClear = new JButton("Clear");
								btnClear.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										model.clear();
										teacherlist.setModel(model);
									}
								});
								btnClear.setBounds(785, 414, 89, 23);
								ProfessorPanel.add(btnClear);
								
								
								DefaultListModel<String> model1=new DefaultListModel<>();
								
								//panel to select number of rooms
								generatePanel = new JPanel();
								generatePanel.setForeground(Color.WHITE);
								generatePanel.setBackground(Color.BLACK);
								generatePanel.setBounds(104, 126, 1262, 646);
								frame.getContentPane().add(generatePanel);
								generatePanel.setLayout(null);
								
								JLabel lblEnterNumberOf = new JLabel("Enter Number of Rooms");
								lblEnterNumberOf.setHorizontalAlignment(SwingConstants.CENTER);
								lblEnterNumberOf.setFont(new Font("Nunito Sans", Font.PLAIN, 14));
								lblEnterNumberOf.setForeground(Color.WHITE);
								lblEnterNumberOf.setBounds(145, 169, 170, 20);
								generatePanel.add(lblEnterNumberOf);
								
								textField = new JTextField();
								textField.setBounds(389, 169, 148, 20);
								generatePanel.add(textField);
								textField.setColumns(10);
								
								JLabel lblEnter = new JLabel("Enter Number of Sections");
								lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
								lblEnter.setForeground(Color.WHITE);
								lblEnter.setFont(new Font("Nunito Sans", Font.PLAIN, 14));
								lblEnter.setBounds(132, 246, 197, 42);
								generatePanel.add(lblEnter);
								
								textField_1 = new JTextField();
								textField_1.setBounds(389, 258, 148, 20);
								generatePanel.add(textField_1);
								textField_1.setColumns(10);
								
								JLabel lblSubmit_2 = new JLabel("Submit");
								lblSubmit_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
								lblSubmit_2.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										rollid_panel.setVisible(false);
										homepanel.setVisible(false);
										aboutpanel.setVisible(false);
										ProfessorPanel.setVisible(true);
										studentpanel.setVisible(false);
										rollfield.setVisible(false);
										passwordfield.setVisible(false);
										adminloginpanel.setVisible(false);
										adminpanel.setVisible(false);
										generatePanel.setVisible(false);
										completetimetablebranch.setVisible(false);
										completetimetableyear.setVisible(false);
									}
								});
								lblSubmit_2.setFont(new Font("Nunito Sans", Font.PLAIN, 14));
								lblSubmit_2.setForeground(Color.WHITE);
								lblSubmit_2.setBounds(318, 359, 46, 14);
								generatePanel.add(lblSubmit_2);
								generatePanel.setVisible(false);
								//create homepanel
								homepanel = new JPanel();
								homepanel.setBounds(104, 125, 1262, 647);
								frame.getContentPane().add(homepanel);
								homepanel.setBackground(Color.BLACK);
								homepanel.setLayout(new CardLayout(0, 0));
								homepanel.setVisible(true);
								
								JLabel lblHomeimage_1 = new JLabel(new ImageIcon("resources/images/homep.jpg"));
								lblHomeimage_1.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
								lblHomeimage_1.setBackground(new Color(0, 51, 153));
								lblHomeimage_1.setBounds(104, 94, 1256, 645);
								homepanel.add(lblHomeimage_1, "homepanel");
						
								//add rollid verification panel
								rollid_panel = new JPanel();
								rollid_panel.setBackground(Color.BLACK);
								rollid_panel.setBounds(104, 125, 1262, 645);
								frame.getContentPane().add(rollid_panel);
								rollid_panel.setLayout(null);
								rollid_panel.setVisible(false);
								
									rollfield = new JTextField();
									rollfield.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
									rollfield.setBounds(491, 248, 86, 20);
									rollid_panel.add(rollfield);
									rollfield.setColumns(10);
									
									//gives class year and branch
									JLabel lblSubmit = new JLabel("SUBMIT");
									lblSubmit.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent arg0) {
											String className=new RollToClassMapping().map(Integer.parseInt(rollfield.getText().toString()));
											System.out.println(className);
											backtoadminlabel.setVisible(false);
											lblback_3.setVisible(true);
											//professor_panel.setVisible(false);
										}
									});
									lblSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
									lblSubmit.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
									lblSubmit.setForeground(Color.WHITE);
									lblSubmit.setBounds(507, 328, 134, 55);
									rollid_panel.add(lblSubmit);
									
									JLabel lblEnterYourId = new JLabel("Enter your id or roll no:");
									lblEnterYourId.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
									lblEnterYourId.setForeground(Color.WHITE);
									lblEnterYourId.setBounds(266, 248, 204, 20);
									rollid_panel.add(lblEnterYourId);
									
										
			
										
										lblback_3 = new JLabel(new ImageIcon("resources/images/Back.png"));
										lblback_3.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
										lblback_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
										lblback_3.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												rollid_panel.setVisible(false);
												homepanel.setVisible(true);
												aboutpanel.setVisible(false);
												studentpanel.setVisible(false);
												rollfield.setVisible(false);
												//professor_panel.setVisible(false);
												passwordfield.setVisible(false);
												adminloginpanel.setVisible(false);
												adminpanel.setVisible(false);
												generatePanel.setVisible(false);
												completetimetablebranch.setVisible(false);
												completetimetableyear.setVisible(false);
											}
										});
										lblback_3.setBounds(10, 11, 40, 40);
										rollid_panel.add(lblback_3);
										
										backtoadminlabel = new JLabel(new ImageIcon("resources/images/Back.png"));
										backtoadminlabel.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseClicked(MouseEvent e) {
												adminpanel.setVisible(true);
												lblback_3.setVisible(true);
												rollid_panel.setVisible(false);
												homepanel.setVisible(false);
												aboutpanel.setVisible(false);
												studentpanel.setVisible(false);
												rollfield.setVisible(false);
												passwordfield.setVisible(false);
												//professor_panel.setVisible(false);
												adminloginpanel.setVisible(false);
												generatePanel.setVisible(false);
												completetimetablebranch.setVisible(false);
												completetimetableyear.setVisible(false);
												
											}
										});
										backtoadminlabel.setBounds(10, 11, 48, 40);
										backtoadminlabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
										rollid_panel.add(backtoadminlabel);
										backtoadminlabel.setVisible(false);
										rollfield.setVisible(false);
						
						//create admin panel
						adminpanel = new JPanel();
						adminpanel.setBackground(Color.BLACK);
						adminpanel.setBounds(104, 125, 1262, 647);
						frame.getContentPane().add(adminpanel);
						adminpanel.setLayout(null);
						adminpanel.setVisible(false);			
						
						//add generate button to admin panel
						JLabel lblGenerateTimeTable = new JLabel("Generate time table");
						lblGenerateTimeTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								completetimetablebranch.setVisible(false);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								completetimetableyear.setVisible(false);
								rollfield.setVisible(false);
								generatePanel.setVisible(true);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
						//		professor_panel.setVisible(false);
								adminpanel.setVisible(false);
							}
						});
						lblGenerateTimeTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblGenerateTimeTable.setHorizontalAlignment(SwingConstants.CENTER);
						lblGenerateTimeTable.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblGenerateTimeTable.setForeground(Color.WHITE);
						lblGenerateTimeTable.setBounds(421, 361, 207, 72);
						adminpanel.add(lblGenerateTimeTable);
						
						//add viewcomplete time table button to admin panel
						JLabel lblViewCompleteTime_1 = new JLabel("View complete time table");
						lblViewCompleteTime_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
							//	professor_panel.setVisible(false);
								generatePanel.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								adminpanel.setVisible(false);
							}
						});
						lblViewCompleteTime_1.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblViewCompleteTime_1.setForeground(Color.WHITE);
						lblViewCompleteTime_1.setBounds(421, 253, 236, 66);
						adminpanel.add(lblViewCompleteTime_1);
						
						//add view personal time table to admin panel
						JLabel lblViewPersonalTime = new JLabel("View Personal time table");
						lblViewPersonalTime.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblViewPersonalTime.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								rollid_panel.setVisible(true);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								//professor_panel.setVisible(false);
								generatePanel.setVisible(false);
								rollfield.setVisible(true);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								backtoadminlabel.setVisible(true);
								lblback_3.setVisible(false);
								adminpanel.setVisible(false);
								completetimetablebranch.setVisible(false);
								completetimetableyear.setVisible(false);
							}
						});
						lblViewPersonalTime.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblViewPersonalTime.setForeground(Color.WHITE);
						lblViewPersonalTime.setBounds(421, 146, 254, 53);
						adminpanel.add(lblViewPersonalTime);
						
						//set image as back on the admin panel
						JLabel lblback_2 = new JLabel(new ImageIcon("resources/images/Back.png"));
						lblback_2.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
						lblback_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblback_2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								rollid_panel.setVisible(false);
								homepanel.setVisible(true);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								completetimetableyear.setVisible(false);
							//	professor_panel.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								adminpanel.setVisible(false);
								generatePanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblback_2.setBounds(10, 11, 40, 40);
						adminpanel.add(lblback_2);
						
						JLabel logout = new JLabel("Logout");
						logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
						logout.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								adminloginpanel.setVisible(true);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								//professor_panel.setVisible(false);
								studentpanel.setVisible(false);
								completetimetableyear.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(true);
								passwordfield.setText(null);
								adminpanel.setVisible(false);
								generatePanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						logout.setHorizontalAlignment(SwingConstants.CENTER);
						logout.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						logout.setForeground(Color.WHITE);
						logout.setBounds(466, 516, 111, 29);
						adminpanel.add(logout);
						
						//to add branch selection panel
						completetimetablebranch = new JPanel();
						completetimetablebranch.setBackground(Color.BLACK);
						completetimetablebranch.setBounds(104, 125, 1262, 647);
						frame.getContentPane().add(completetimetablebranch);
						completetimetablebranch.setLayout(null);
						completetimetablebranch.setVisible(false);
						
						JLabel lblChooseYourBranch = new JLabel("Choose your branch:");
						lblChooseYourBranch.setHorizontalAlignment(SwingConstants.CENTER);
						lblChooseYourBranch.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblChooseYourBranch.setForeground(Color.WHITE);
						lblChooseYourBranch.setBounds(479, 156, 216, 52);
						completetimetablebranch.add(lblChooseYourBranch);
						
						JLabel lblCSE = new JLabel("CSE");
						lblCSE.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblCSE.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								completetimetableyear.setVisible(true);
								adminpanel.setVisible(false);
								rollid_panel.setVisible(false);
								//professor_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								generatePanel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblCSE.setHorizontalAlignment(SwingConstants.CENTER);
						lblCSE.setBackground(Color.BLACK);
						lblCSE.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblCSE.setForeground(Color.WHITE);
						lblCSE.setBounds(419, 285, 108, 27);
						completetimetablebranch.add(lblCSE);
						
						JLabel lblIt = new JLabel("IT");
						lblIt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
								generatePanel.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
								//professor_panel.setVisible(false);
								completetimetablebranch.setVisible(false);
							}
						});
						lblIt.setHorizontalAlignment(SwingConstants.CENTER);
						lblIt.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblIt.setForeground(Color.WHITE);
						lblIt.setBounds(652, 285, 120, 27);
						completetimetablebranch.add(lblIt);
						
						JLabel lblBack = new JLabel(new ImageIcon("resources/images/Back.png"));
						lblBack.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
						lblBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblBack.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								homepanel.setVisible(true);
								completetimetableyear.setVisible(false);
								adminpanel.setVisible(false);
								rollid_panel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								//professor_panel.setVisible(false);
								rollfield.setVisible(false);
								generatePanel.setVisible(false);
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
						completetimetableyear.setBounds(104, 125, 1262, 647);
						frame.getContentPane().add(completetimetableyear);
						completetimetableyear.setLayout(null);
						completetimetableyear.setVisible(false);
						
						JLabel lblChooseYourYear = new JLabel("Choose your year:");
						lblChooseYourYear.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						lblChooseYourYear.setForeground(Color.WHITE);
						lblChooseYourYear.setHorizontalAlignment(SwingConstants.CENTER);
						lblChooseYourYear.setBounds(474, 137, 176, 56);
						completetimetableyear.add(lblChooseYourYear);
						
						JLabel _1styear = new JLabel("1st year");
						_1styear.setCursor(new Cursor(Cursor.HAND_CURSOR));
						_1styear.setHorizontalAlignment(SwingConstants.CENTER);
						_1styear.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						_1styear.setForeground(Color.WHITE);
						_1styear.setBounds(315, 275, 100, 34);
						completetimetableyear.add(_1styear);
						
						JLabel _2ndyear = new JLabel("2nd year");
						_2ndyear.setCursor(new Cursor(Cursor.HAND_CURSOR));
						_2ndyear.setForeground(Color.WHITE);
						_2ndyear.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						_2ndyear.setHorizontalAlignment(SwingConstants.CENTER);
						_2ndyear.setBounds(453, 279, 100, 27);
						completetimetableyear.add(_2ndyear);
						
						JLabel _3rdyear = new JLabel("3rd year");
						_3rdyear.setCursor(new Cursor(Cursor.HAND_CURSOR));
						_3rdyear.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						_3rdyear.setForeground(Color.WHITE);
						_3rdyear.setHorizontalAlignment(SwingConstants.CENTER);
						_3rdyear.setBounds(599, 275, 71, 34);
						completetimetableyear.add(_3rdyear);
						
						JLabel _4thyear = new JLabel("4th year");
						_4thyear.setCursor(new Cursor(Cursor.HAND_CURSOR));
						_4thyear.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
						_4thyear.setForeground(Color.WHITE);
						_4thyear.setHorizontalAlignment(SwingConstants.CENTER);
						_4thyear.setBounds(718, 279, 89, 30);
						completetimetableyear.add(_4thyear);
						
						JLabel lblback_1 = new JLabel(new ImageIcon("resources/images/Back.png"));
						lblback_1.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
						lblback_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
						lblback_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								completetimetablebranch.setVisible(true);
								completetimetableyear.setVisible(false);
								adminpanel.setVisible(false);
								generatePanel.setVisible(false);
								rollid_panel.setVisible(false);
								homepanel.setVisible(false);
								aboutpanel.setVisible(false);
								studentpanel.setVisible(false);
								rollfield.setVisible(false);
								//professor_panel.setVisible(false);
								passwordfield.setVisible(false);
								adminloginpanel.setVisible(false);
							}
						});
						lblback_1.setBounds(10, 11, 40, 40);
						completetimetableyear.add(lblback_1);
				
				//add about panel
				aboutpanel = new JPanel();
				aboutpanel.setBackground(Color.BLACK);
				aboutpanel.setBounds(104, 125, 1262, 647);
				frame.getContentPane().add(aboutpanel);
				aboutpanel.setLayout(new CardLayout(0, 0));
				aboutpanel.setVisible(false);
			
				//add student panel
				studentpanel = new JPanel();
				studentpanel.setBackground(Color.BLACK);
				studentpanel.setBounds(104, 125, 1262, 647);
				frame.getContentPane().add(studentpanel);
				studentpanel.setLayout(null);
				studentpanel.setVisible(false);
				
				JLabel Login = new JLabel("LOGIN");
				Login.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
						//professor_panel.setVisible(false);
						generatePanel.setVisible(false);
						completetimetablebranch.setVisible(false);
						completetimetableyear.setVisible(false);
					}
				});
				Login.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
				Login.setForeground(Color.WHITE);
				Login.setBounds(607, 212, 131, 34);
				studentpanel.add(Login);
				
				JLabel lblViewCompleteTime = new JLabel("View Complete time table");
				lblViewCompleteTime.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
					//	professor_panel.setVisible(false);
						generatePanel.setVisible(false);
						adminloginpanel.setVisible(false);
						adminpanel.setVisible(false);
					}
				});
				lblViewCompleteTime.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
				lblViewCompleteTime.setForeground(Color.WHITE);
				lblViewCompleteTime.setBounds(540, 306, 222, 66);
				studentpanel.add(lblViewCompleteTime);
				
				//add panel for admin login
				adminloginpanel = new JPanel();
				adminloginpanel.setBackground(Color.BLACK);
				adminloginpanel.setBounds(104, 125, 1262, 647);
				frame.getContentPane().add(adminloginpanel);
				adminloginpanel.setLayout(null);
				adminloginpanel.setVisible(false);
				
				JLabel lblEnterYourPassword = new JLabel("Enter your password");
				lblEnterYourPassword.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
				lblEnterYourPassword.setForeground(Color.WHITE);
				lblEnterYourPassword.setBounds(168, 232, 219, 52);
				adminloginpanel.add(lblEnterYourPassword);
				
				//textbox to enter password
				passwordfield = new JTextField();
				passwordfield.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
				passwordfield.setBounds(500, 237, 171, 36);
				adminloginpanel.add(passwordfield);
				passwordfield.setColumns(10);
				passwordfield.setVisible(false);
				
				JLabel lblSubmit_1 = new JLabel("Submit");
				lblSubmit_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
							generatePanel.setVisible(false);
							passwordfield.setVisible(false);
						//	professor_panel.setVisible(false);
							adminloginpanel.setVisible(false);
							completetimetablebranch.setVisible(false);
							completetimetableyear.setVisible(false);
							
						}
					}
				});
				lblSubmit_1.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
				lblSubmit_1.setForeground(Color.WHITE);
				lblSubmit_1.setBounds(552, 376, 102, 44);
				adminloginpanel.add(lblSubmit_1);
					
			
		
		//panel to select student teacher admin etc
		selectionpanel = new JPanel();
		selectionpanel.setBackground(Color.DARK_GRAY);
		selectionpanel.setBounds(0, 30, 106, 739);
		frame.getContentPane().add(selectionpanel);
		selectionpanel.setLayout(null);
		selectionpanel.setVisible(true);
		
		homeicon = new JLabel(new ImageIcon("resources/images/home.png"));
		homeicon.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		homeicon.setToolTipText("HOME");
		homeicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				homepanel.setVisible(true);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(false);
				rollid_panel.setVisible(false);
				rollfield.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
		//		professor_panel.setVisible(false);
				generatePanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				homeicon.setIcon(new ImageIcon("resources/images/homehover.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				homeicon.setIcon(new ImageIcon("resources/images/home.png"));
			}
		});
		homeicon.setBounds(10, 11, 75, 78);
		selectionpanel.add(homeicon);
		
		JLabel lblAbout = new JLabel(new ImageIcon("resources/images/about.png"));
		lblAbout.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblAbout.setToolTipText("ABOUT");
		lblAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAbout.setForeground(Color.WHITE);
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 JLabel lblHomeimage = new JLabel(new ImageIcon("resources/images/aboutpage.jpg"));
				lblHomeimage.setBounds(104, 94, 1256, 645);
				aboutpanel.add(lblHomeimage, "lblHomeimage");
				homepanel.setVisible(false);
				aboutpanel.setVisible(true);
				rollfield.setVisible(false);
			//	professor_panel.setVisible(false);
				studentpanel.setVisible(false);
				generatePanel.setVisible(false);
				rollid_panel.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAbout.setIcon(new ImageIcon("resources/images/abouthover.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAbout.setIcon(new ImageIcon("resources/images/about.png"));
			}
		});
		lblAbout.setBounds(10, 450, 75, 78);
		selectionpanel.add(lblAbout);
		
		JLabel lblStudent = new JLabel(new ImageIcon("resources/images/student.png"));
		lblStudent.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblStudent.setToolTipText("STUDENT");
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(true);
				rollid_panel.setVisible(false);
				rollfield.setVisible(false);
				//professor_panel.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				generatePanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStudent.setIcon(new ImageIcon("resources/images/studenthover.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblStudent.setIcon(new ImageIcon("resources/images/student.png"));
			}
		});
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setBounds(10, 120, 75, 78);
		selectionpanel.add(lblStudent);
		
		JLabel lblTeacher = new JLabel(new ImageIcon("resources/images/teacher.png"));
		lblTeacher.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblTeacher.setToolTipText("TEACHER");
		lblTeacher.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				aboutpanel.setVisible(false);
				studentpanel.setVisible(true);
				rollid_panel.setVisible(false);
				//professor_panel.setVisible(false);
				rollfield.setVisible(false);
				passwordfield.setVisible(false);
				adminloginpanel.setVisible(false);
				adminpanel.setVisible(false);
				generatePanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTeacher.setIcon(new ImageIcon("resources/images/teacherhover.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTeacher.setIcon(new ImageIcon("resources/images/teacher.png"));
			}
		});
		lblTeacher.setForeground(Color.WHITE);
		lblTeacher.setBounds(10, 230, 75, 78);
		selectionpanel.add(lblTeacher);
		
		JLabel lblAdmin = new JLabel(new ImageIcon("resources/images/admin.png"));
		lblAdmin.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblAdmin.setToolTipText("ADMIN");
		lblAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				//professor_panel.setVisible(false);
				generatePanel.setVisible(false);
				completetimetablebranch.setVisible(false);
				completetimetableyear.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAdmin.setIcon(new ImageIcon("resources/images/adminhover.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAdmin.setIcon(new ImageIcon("resources/images/admin.png"));
			}
		});
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setBounds(10, 340, 75, 78);
		selectionpanel.add(lblAdmin);
		
		//top panel
		appnamepanel = new JPanel();
		appnamepanel.setBackground(new Color(255, 102, 0));
		appnamepanel.setBounds(104, 31, 1262, 97);
		frame.getContentPane().add(appnamepanel);
		appnamepanel.setLayout(null);
		appnamepanel.setVisible(true);
		
		//lable for app icon image in top panel
		JLabel lblNewLabel = new JLabel(new ImageIcon("resources/images/app_icon.png"));
		lblNewLabel.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 11, 122, 74);
		appnamepanel.add(lblNewLabel);

		//label for name of app in top panel
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("resources/images/appname.png"));
		lblNewLabel_1.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(147, 11, 1000, 74);
		appnamepanel.add(lblNewLabel_1);
		
		JPanel toolbar = new JPanel();
		toolbar.setBackground(new Color(51, 0, 102));
		toolbar.setBounds(0, 0, 1366, 32);
		frame.getContentPane().add(toolbar);
		toolbar.setLayout(null);
		
		JLabel lblClose = new JLabel(new ImageIcon("resources/images/Cancel Button.png"));
		lblClose.setFont(new Font("Nunito Sans", Font.PLAIN, 11));
		lblClose.setForeground(new Color(255, 255, 255));
		lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		lblClose.setBounds(1305, 0, 35, 32);
		toolbar.add(lblClose);
		
	}
}

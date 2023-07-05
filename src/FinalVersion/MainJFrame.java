package FinalVersion;

import java.awt.BorderLayout;
import java.io.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.CheckboxGroup;
import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import java.util.Base64;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 
 * Author: Elham Anqawi
 */
@SuppressWarnings("serial")

public class MainJFrame extends JFrame {
	WebDriver web;
//	WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10));
//	WebDriverWait wait;

	private JPanel contentPane;
	JPanel leftPanel;
	JPanel rightPanel;
	JPanel panel;
	JScrollPane scrollPane;
	JScrollPane scrollPane1;
	JScrollPane scrollPane2;
	static JTree tree;
	Box box;
	Box boxRight;
	Box boxh;
	JCheckBox[] checkBoxList;
	JCheckBox[] actionchecklist;
	ArrayList<String> test;
	ArrayList<String> senarios;
	LinkedList<TestCases> cases;
	ArrayList<dataSet> dd;
	JCheckBox[] sets;
	HashMap<String, ArrayList<JCheckBox>> selectedsets;
	HashMap<String, String> results = new HashMap<String, String>();
	HashMap<String, String> time = new HashMap<String, String>();

	String[] links = new String[10];
	private static JComboBox<String> comboBox;
	long start;
	long end;
	double timeNeeded;

//	boolean logedin=false;
//	String url;
//    boolean register=false;
//    boolean sw=false;
//    String set;

	private JTextField textField;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
					frame.setSize(1118, 727);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("deprecation")
	public MainJFrame() throws SQLException, ClassNotFoundException {
		setResizable(false);
		setTitle("Available Test Cases");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 727);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(49999, 49999));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(989, 636, 85, 37);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		JButton btnNewButton_1 = new JButton("Execute Selected Cases");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(10, 636, 238, 37);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					selectedSenarios();
					selectedsets();
					execute();
					getData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		leftPanel = new JPanel();

		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 139, 319, 403);
		contentPane.add(scrollPane);

		scrollPane.setColumnHeaderView(leftPanel);

		BoxLayout boxlayout2 = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
		leftPanel.setLayout(boxlayout2);

		panel = new JPanel();
		listOfSenarios();
		scrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(802, 139, 272, 403);
		contentPane.add(scrollPane1);

		scrollPane1.setColumnHeaderView(panel);

		BoxLayout boxlayout3 = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout3);

		rightPanel = new JPanel();

		scrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listOfcheckBoxes();

		scrollPane2.setBounds(404, 139, 311, 403);
		contentPane.add(scrollPane2);

		scrollPane2.setColumnHeaderView(rightPanel);

		BoxLayout boxlayout = new BoxLayout(rightPanel, BoxLayout.Y_AXIS);

		// to set the box layout
		rightPanel.setLayout(boxlayout);

		JLabel lblNewLabel = new JLabel("Add Link");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 20, 78, 26);
		contentPane.add(lblNewLabel);
		getLinks();
		comboBox = new JComboBox<String>(links);
		// comboBox = new JComboBox(links);
		comboBox.setBounds(98, 23, 288, 26);
		contentPane.add(comboBox);

		// textField = new JTextField();
		// textField.setBounds(98, 23, 288, 26);
		// contentPane.add(textField);
		// textField.setColumns(10);

		JButton btnNewButton_41 = new JButton("New test Cases");
		btnNewButton_41.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_41.setBounds(700, 20, 209, 37);
		contentPane.add(btnNewButton_41);
		btnNewButton_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// AddTestCaseJJ.main(null);

				// AddTestCaseJJ.main(null);
				setVisible(false);
				AddTestCaseJJ frame1 = new AddTestCaseJJ();
				frame1.setSize(1000, 700);
				frame1.setVisible(true);

			}
		});

		JButton btnNewButton_42 = new JButton("New Senario");
		btnNewButton_42.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_42.setBounds(900, 20, 209, 37);
		contentPane.add(btnNewButton_42);
		btnNewButton_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// AddTestCaseJJ.main(null);

				// AddTestCaseJJ.main(null);
				setVisible(false);
				AddNewScenario frame1 = null;
				try {
					frame1 = new AddNewScenario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame1.setSize(1000, 700);
				frame1.setVisible(true);

			}
		});

		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 215, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(277, 636, 109, 37);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Related Test Cases");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					selectedSenarios();
					sets();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(10, 570, 238, 37);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_1 = new JLabel("Test Cases");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(475, 116, 136, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Related Sets");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(868, 116, 127, 13);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Senarios");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(94, 116, 95, 13);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton_2 = new JButton("Show Results");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(277, 570, 109, 37);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				Object finalResult[] = { "result : " + results, "time : " + time };

				JOptionPane.showMessageDialog(null, finalResult);

			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				panel.removeAll();
				panel.repaint();

				if (cases != null) {
					cases.clear();
				}

				for (int i = 0; i < checkBoxList.length; i++) {
					if (checkBoxList[i].isSelected())
						checkBoxList[i].setSelected(false);

				}
				for (int i = 0; i < actionchecklist.length; i++) {
					if (actionchecklist[i].isSelected())
						actionchecklist[i].setSelected(false);
				}
//	                for(int i=0;i<cases.size();i++) {
//	                	if(selectedsets.get(dd.get(i).getCaseName()).isSelected())
//	                		selectedsets.get(dd.get(i).getCaseName()).setSelected(false);	
//	                	
//	                }

				selectedsets.clear();
				results.clear();
			}
		});

	}

	public void listOfcheckBoxes() throws SQLException, ClassNotFoundException {
		test = new ArrayList<String>();
		String username = "qa";
		String password = "qa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// String
		// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
		String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;

		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		con = DriverManager.getConnection(url);

		// execute query
		stmt = con.createStatement();
		String sql = "SELECT caseName FROM QA_Automation.DBO.TEST_CASES";
		result = stmt.executeQuery(sql);
		while (result.next()) {

			test.add(result.getString("caseName"));
		}
		// TODO Auto-generated catch block
		result.close();
		stmt.close();
		con.close();

		checkBoxList = new JCheckBox[test.size()];

		for (int i = 0; i < test.size(); i++) {

			checkBoxList[i] = new JCheckBox((test.get(i)));
			rightPanel.add(checkBoxList[i]);

		}

		// System.out.println(checkBoxList.length);

	}

	public void listOfSenarios() throws SQLException, ClassNotFoundException {
		senarios = new ArrayList<String>();
		String username = "qa";
		String password = "qa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// String
		// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
		String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;

		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		con = DriverManager.getConnection(url);
		// execute query
		stmt = con.createStatement();
		String sql = "SELECT DISTINCT senarioName FROM QA_Automation.DBO.SENARIOS";
		result = stmt.executeQuery(sql);
		while (result.next()) {

			senarios.add(result.getString("senarioName"));
		}
		// TODO Auto-generated catch block
		result.close();
		stmt.close();
		con.close();

		actionchecklist = new JCheckBox[senarios.size()];

		for (int i = 0; i < senarios.size(); i++) {

			actionchecklist[i] = new JCheckBox((senarios.get(i)));
			leftPanel.add(actionchecklist[i]);

		}

	}

	public void execute() throws SQLException, ClassNotFoundException {
		cases = new LinkedList<TestCases>();

		for (int i = 0; i < checkBoxList.length; i++) {
			if (checkBoxList[i].isSelected()) {
				String selectedCase = checkBoxList[i].getText();
				String username = "qa";
				String password = "qa";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// String
				// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
				String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

				Connection con = null;
				Statement stmt = null;
				ResultSet result = null;

				// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				con = DriverManager.getConnection(url);
				// execute query
				stmt = con.createStatement();
				String sql = "SELECT * FROM QA_Automation.DBO.TEST_CASES as dc where dc.caseName='" + selectedCase
						+ "'";
				result = stmt.executeQuery(sql);
				String testcase = null, id = null;
				ArrayList<Actions> ac = new ArrayList<Actions>();
				while (result.next()) {
					testcase = result.getString("caseName");
					id = result.getString("id");
					// test.add(result.getString("caseName"));
				}
				System.out.println();
				sql = "SELECT * FROM QA_Automation.DBO.Test_Cases as dc join QA_Automation.DBO.ACTIONS as ds on ds.caseid= dc.id where ds.caseid='"
						+ id + "'";
				result = stmt.executeQuery(sql);
				while (result.next()) {
					ac.add(new Actions(result.getString("caseid"), result.getString("actionId"),
							result.getString("link"), result.getString("actionElement"), result.getString("actionName"),
							result.getString("needWait"), result.getString("elementType"),
							result.getString("lisItemlink"), result.getString("secondAction"),
							result.getString("haveSecondAction"), result.getInt("waitingPeriode"),
							result.getString("waitingType")));

					// test.add(result.getString("caseName"));
				}
				cases.add(new TestCases(id, testcase, ac));
				System.out.println(cases.getFirst().action.size());

				// TODO Auto-generated catch blockS
				result.close();
				stmt.close();
				con.close();

//		checkBoxList[i].setSelected(false);
			}
		}

	}

	@SuppressWarnings("deprecation")

	public void getData() throws SQLException, InterruptedException, ClassNotFoundException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver web = new ChromeDriver(options);
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		// wait = new WebDriverWait(web, Duration.ofSeconds(5));
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		web.get(comboBox.getSelectedItem().toString());

		System.out.println(selectedsets);
//	   web.get("http://5.189.179.150/APEX/");
		// String c=null;
		// int i=0;
		String c = null;
		ArrayList<JCheckBox> l;
		for (int i = 0; i < cases.size(); i++) {

			System.out.println(" case " + cases.get(i).getCaseName());

			l = selectedsets.get(cases.get(i).getCaseName());
			System.out.println("l size" + l.size());
			for (int m = 0; m < l.size(); m++) {
				if (l.get(m).isSelected()) {
					c = l.get(m).getText();
					System.out.println("selected case " + l.get(m).getText());
					System.out.println("selected case2 " + l.get(m).getText() + i);
				}
			}
			for (int j = 0; j < cases.get(i).action.size(); j++) {
//			 String c = null;

				String username = "qa";
				String password = "qa";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// String
				// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
				String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

				Connection con = null;
				Statement stmt = null;
				ResultSet result = null;

				con = DriverManager.getConnection(url);

				// execute query
				stmt = con.createStatement();
				// String sql="SELECT inputname,setValue FROM automation.inputs as dc join
				// automation.dataset as ds on dc.input_id= ds.inputid where
				// dc.actionid='"+cases.get(i).action.get(j).getActionId()+"' and
				// ds.caseid='"+cases.get(i).getCaseId()+"'";
				String sql = "SELECT inputname,setValue FROM QA_Automation.DBO.INPUTS as dc join QA_Automation.DBO.DATASETS as ds on dc.input_id= ds.inputid join QA_Automation.DBO.TEST_CASES as tc on ds.caseid=tc.id where dc.actionid='"
						+ cases.get(i).action.get(j).getActionId() + "' and ds.caseid='" + cases.get(i).getCaseId()
						+ "' and ds.setName='" + c + "'";
				result = stmt.executeQuery(sql);
				String name = null, value = null;
				ArrayList<Actions> ac = new ArrayList<Actions>();
				while (result.next()) {

					name = result.getString("inputname");
					value = result.getString("setValue");
					System.out.println("input name " + name);
					System.out.println("value" + value);
					// test.add(result.getString("caseName"));
				}
				// Start counting (Time)
				// ...............................................................
				start = System.currentTimeMillis();
				System.out.println(cases.get(i).getCaseName());
				System.out.println(cases.get(i).action.get(j).getActionId());
				if (cases.get(i).action.get(j).getType().contains("single")) {
					if (cases.get(i).action.get(j).getAcationElement().contains("id")) {
						WebElement w;
						if (cases.get(i).action.get(j).getActionName().contains("send")) {
							if (cases.get(i).action.get(j).getNeedWait().equals("yes")
									&& cases.get(i).action.get(j).getHaveSeconedAction().equals("yes")) {
								if(cases.get(i).action.get(j).getWaitingtype()!=null||cases.get(i).action.get(j).getWaitingtype()!="//"){
									if(cases.get(i).action.get(j).getWaitingtype().equals("elementToBeClickable")) {
									System.out.println("inside yes");
									WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(5));
									w = wait.until(ExpectedConditions
											.elementToBeClickable(By.id(cases.get(i).action.get(j).getLink())));

									w.sendKeys(value);
									Thread.sleep(1000);
									w.sendKeys(Keys.ENTER);
									}else if(cases.get(i).action.get(j).getWaitingtype().equals("presenceOfElementLocated")) {
											System.out.println("inside yes");
											WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(5));
											w = wait.until(ExpectedConditions
													.presenceOfElementLocated(By.id(cases.get(i).action.get(j).getLink())));

											w.sendKeys(value);
											Thread.sleep(1000);
											w.sendKeys(Keys.ENTER);	
									}
								}

								

							} else if (cases.get(i).action.get(j).getNeedWait().equals("yes")
									&& cases.get(i).action.get(j).getHaveSeconedAction().equals("no")) {
								WebDriverWait wait2 = new WebDriverWait(web, Duration.ofSeconds(5));
								w = wait2.until(ExpectedConditions
										.elementToBeClickable(By.id(cases.get(i).action.get(j).getLink())));

								w.click();
								String s = decodeStr(value);
								w.sendKeys(s);
							} else if (cases.get(i).action.get(j).getNeedWait().equals("no")) {
								System.out.println("inside no");
								System.out.println(value);
								w = web.findElement(By.id(cases.get(i).action.get(j).getLink()));
								w.sendKeys(value);

								// Thread.sleep(3000);
							}
						} else if (cases.get(i).action.get(j).getActionName().contains("click")) {
							Thread.sleep(2000);
							w = web.findElement(By.id(cases.get(i).action.get(j).getLink()));
							w.click();
						} else if (cases.get(i).action.get(j).getActionName().contains("clear")) {

							w = web.findElement(By.id(cases.get(i).action.get(j).getLink()));
							w.sendKeys(Keys.CONTROL + "a");
							w.sendKeys(Keys.DELETE);
							if (cases.get(i).action.get(j).getHaveSeconedAction().equals("yes")) {
								// Thread.sleep(2000);
								w.sendKeys(value);
							} else {
								System.out.println("//////");
							}

						}

					} else if (cases.get(i).action.get(j).getAcationElement().contains("xpath")) {
						WebElement w1;
						if (cases.get(i).action.get(j).getActionName().contains("send")) {
							if (cases.get(i).action.get(j).getNeedWait().equals("yes")) {
								// wait = new WebDriverWait(web, Duration.ofSeconds(5));
								if(cases.get(i).action.get(j).getWaitingtype()!=null||cases.get(i).action.get(j).getWaitingtype()!="//") {
									if(cases.get(i).action.get(j).getWaitingtype().equals("elementToBeClickable")) {

										System.out.println("inside no1");
										// String xpath1=
										WebDriverWait wait2 = new WebDriverWait(web, Duration.ofSeconds(5));
										String s = decodeStr(value);
										w1 = wait2.until(ExpectedConditions
												.elementToBeClickable(By.xpath(cases.get(i).action.get(j).getLink())));
										// w1.click();
										w1.sendKeys(value);
									}else if(cases.get(i).action.get(j).getWaitingtype().equals("presenceOfElementLocated")) {
										System.out.println("inside no1");
										// String xpath1=
										WebDriverWait wait2 = new WebDriverWait(web, Duration.ofSeconds(5));
										String s = decodeStr(value);
										w1 = wait2.until(ExpectedConditions
												.presenceOfElementLocated(By.xpath(cases.get(i).action.get(j).getLink())));
										// w1.click();
										w1.sendKeys(value);
									}
								}

							}
							// jdfidb
							else if (cases.get(i).action.get(j).getNeedWait().equals("no")) {
								w1 = web.findElement(By.xpath(cases.get(i).action.get(j).getLink()));
								w1.sendKeys(value);
							}
							// idiavd
						} else if (cases.get(i).action.get(j).getActionName().contains("click")) {
							w1 = web.findElement(By.xpath(cases.get(i).action.get(j).getLink()));
							w1.click();
						}

					} else if (cases.get(i).action.get(j).getAcationElement().contains("bylinktext")) {
						if (cases.get(i).action.get(j).getNeedWait().equals("yes")) {
							System.out.println("waiting type///" + cases.get(i).action.get(j).getWaitingtype());
							if (cases.get(i).action.get(j).getWaitingtype()
									.equalsIgnoreCase("presenceOfElementLocated")) {
								System.out.println("inside list" + value);
								WebDriverWait wait = new WebDriverWait(web,
										Duration.ofSeconds(cases.get(i).action.get(j).getWaitingPeriode()));
								if (cases.get(i).action.get(j).getActionName().contains("click")) {
									System.out.println("inside list" + value);
									WebElement element2 = wait
											.until(ExpectedConditions.presenceOfElementLocated(By.linkText(value)));
									element2.click();
								}
							} else {
								System.out.println("///");
							}
						}
					} else if (cases.get(i).action.get(j).getAcationElement().contains("bycss")) {
						web.findElement(By.cssSelector(cases.get(i).action.get(j).getLink())).click();
					}
				} else if (cases.get(i).action.get(j).getType().contains("list")) {

					List<WebElement> list = web.findElements(By.xpath(cases.get(i).action.get(j).getLink()));
					WebDriverWait wait2 = new WebDriverWait(web, Duration.ofSeconds(5));
					for (WebElement b : list) {

//					 String c=b.getText();
						Thread.sleep(1000);
//					 if(c.equalsIgnoreCase("Registration Department")) {

						WebElement element2 = wait2.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath(cases.get(i).action.get(j).getListItemLink())));
						element2.click();
						break;
//					 }

					}

				} else {
					List<WebElement> allRows = web.findElements(By.xpath(cases.get(i).action.get(j).getLink()));
//			Thread.sleep(4000);
					WebElement firstRow = allRows.get(0);
					Thread.sleep(3000);
					firstRow.click();
					Thread.sleep(5000);
				}
			}
			// End timer
			// .........................................................................
			end = System.currentTimeMillis();
			timeNeeded = (end - start) / 1000.0;
			System.out.println("Test Case takes " + cases.get(i).getCaseId() + timeNeeded);
			start = 0;
			results(web, c, cases.get(i).getCaseId());

		}
	}

	public String decodeStr(String pass) {
		Base64.Encoder enc = Base64.getEncoder();
		byte[] encbytes = enc.encode(pass.getBytes());
		for (int i = 0; i < encbytes.length; i++) {
			System.out.printf("%c", (char) encbytes[i]);
			if (i != 0 && i % 4 == 0)
				System.out.print(' ');
		}
		System.out.println();
		Base64.Decoder dec = Base64.getDecoder();
		byte[] decbytes = dec.decode(encbytes);
		System.out.println(new String(decbytes));
		String s = new String(decbytes);
		return s;

	}

	public void selectedSenarios() throws SQLException, ClassNotFoundException {
		for (int i = 0; i < actionchecklist.length; i++) {
			if (actionchecklist[i].isSelected()) {
				String selectedCase = actionchecklist[i].getText();
				final String JDBC_Driver = "com.mysql.jdbc.Driver";
				final String DB_URL = "jdbc:mysql://localhost:3306/selenium";
				String username = "qa";
				String password = "qa";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// String
				// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
				String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

				Connection con = null;
				Statement stmt = null;
				ResultSet result = null;

				// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(url);

				// execute query
				stmt = con.createStatement();
				String sql = "SELECT caseName FROM QA_Automation.DBO.TEST_CASES as dc join QA_Automation.DBO.SENARIOS as ds on ds.caseid= dc.id where ds.senarioName='"
						+ selectedCase + "'";
				result = stmt.executeQuery(sql);
				String testcase = null;

				while (result.next()) {
					System.out.println("inside loop");
					testcase = result.getString("caseName");
					System.out.println(testcase);
					for (int j = 0; j < checkBoxList.length; j++) {
						if (checkBoxList[j].getText().equals(testcase)) {
							checkBoxList[j].setSelected(true);
							System.out.println(checkBoxList[j].getText());
						}
					}
					// test.add(result.getString("caseName"));
				}

				// TODO Auto-generated catch blockS
				result.close();
				stmt.close();
				con.close();

//			checkBoxList[i].setSelected(false);
			}
		}

	}

	public void getLinks() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		String username = "qa";
		String password = "qa";

		// String
		// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
		String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);

			// execute query
			// stmt=con.createStatement();

			stmt = con.createStatement();
			String sql = "SELECT * FROM QA_Automation.DBO.LINKS";
			result = stmt.executeQuery(sql);
			int i = 0;
			while (result.next()) {

				links[i] = result.getString("Link");

				i++;
			}
			result.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sets() throws SQLException, ClassNotFoundException {
//	panel.removeAll();
//	panel.repaint();

		dd = new ArrayList<dataSet>();
		for (int i = 0; i < checkBoxList.length; i++) {
			if (checkBoxList[i].isSelected()) {
				String selectedCase = checkBoxList[i].getText();

				System.out.println("selected Case " + selectedCase);
				String username = "qa";
				String password = "qa";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// String
				// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
				String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

				Connection con = null;
				Statement stmt = null;
				ResultSet result = null;

				// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(url);
				stmt = con.createStatement();
				String sql = "SELECT DISTINCT setName FROM QA_Automation.DBO.TEST_CASES as dc join QA_Automation.DBO.DATASETS as ds on ds.caseid= dc.id where dc.caseName='"
						+ selectedCase + "'";
				result = stmt.executeQuery(sql);
				String setnamee = null;

				ArrayList<String> st = new ArrayList<>();

				dataSet data = new dataSet();
				data.setCaseName(selectedCase);
				while (result.next()) {
					System.out.println("inside loop");
					st.add(result.getString("setName"));

					System.out.println(result.getString("setName"));

					// test.add(result.getString("caseName"));
				}
				data.setSetName(st);
				dd.add(data);
//	// TODO Auto-generated catch blockS
				result.close();
				stmt.close();
				con.close();

////		checkBoxList[i].setSelected(false);
			}

		}
		selectedsets = new HashMap<String, ArrayList<JCheckBox>>();
		ArrayList<JCheckBox> arr;
		for (int j = 0; j < dd.size(); j++) {
			arr = new ArrayList<JCheckBox>();
			// JLabel l= new JLabel(dd.get(j).getCaseName());
			System.out.println("]]]]]]" + dd.get(j).getCaseName());
			JLabel l = new JLabel(dd.get(j).getCaseName());
//		getForeground();
			l.setBackground(getForeground().ORANGE);
			panel.add(l);
			for (int t = 0; t < dd.get(j).getSetName().size(); t++) {
				// selectedsets.put(dd.get(j).getCaseName(), new
				// JCheckBox((dd.get(j).getSetName().get(t))));
				arr.add(new JCheckBox((dd.get(j).getSetName().get(t))));
				System.out.println("check]]]]]" + dd.get(j).getSetName().get(t));
				System.out.println("check\\\\" + selectedsets.get(dd.get(j).getCaseName()));
				panel.add(arr.get(t));

			}
			selectedsets.put(dd.get(j).getCaseName(), arr);
		}
		panel.revalidate();
		panel.repaint();
		System.out.println(selectedsets);
		JOptionPane.showMessageDialog(null, "Please Select One Set For Each Test Case ");
	}

	public void selectedsets() {
// selectedsets =new HashMap<String,String>();

//	 for(int i=0;i<dd.size();i++) {
//		 for(int j=0;j<dd.get(i).getSetName().size();j++) {
//			 if(selectedsets.get(dd.get(i).getCaseName()))
//		 }
//	 }

	}

	public void results(WebDriver web, String setname, String caseId) throws SQLException, ClassNotFoundException {
		String timeNeededst = timeNeeded + "  Seconds";

		String username = "qa";
		String password = "qa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// String
		// connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
		String url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";

		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url);
		stmt = con.createStatement();
		String sql = "SELECT * FROM QA_Automation.DBO.RESULTS as dc join QA_Automation.DBO.TEST_CASES as ds on dc.caseid= ds.id where caseid='"
				+ caseId + "' and setName='" + setname + "'";
		result = stmt.executeQuery(sql);
		String name = null;

		String res = null, selector = null, selectorValue = null;
		while (result.next()) {
			System.out.println("inside loop");
			name = result.getString("caseName");
			res = result.getString("expectedResult");
			selector = result.getString("selector");
			selectorValue = result.getString("selectorValue");

//			System.out.println(result.getString("setName")); 

			// test.add(result.getString("caseName"));
		}
//	// TODO Auto-generated catch blockS
		result.close();
		stmt.close();
		con.close();
		if (setname.equalsIgnoreCase("CorrectLog")) {
			if (selector.equals("byUrl")) {
				String url1 = web.getCurrentUrl();
				if (url1.equalsIgnoreCase(res)) {
					results.put(name, "Pass");
					time.put(name, timeNeededst);

				} else {
					results.put(name, "Fail");
					time.put(name, timeNeededst);

				}
			}
		} else {
			if (selector.equalsIgnoreCase("byUrl")) {
				String url1 = web.getCurrentUrl();
				if (url1.contains(res)) {
					results.put(name, "Pass");
					time.put(name, timeNeededst);
				} else {
					results.put(name, "Fail");
					time.put(name, timeNeededst);
				}
			} else if (selector.equalsIgnoreCase("byXpath")) {
				WebElement element2 = web.findElement(By.xpath(selectorValue));
				String v = element2.getText();
				if (v.contains(res)) {
					results.put(name, "Pass");
					// results.put(caseId, timeNeededst);
				} else {
					results.put(name, "Fail");
					// results.put(caseId, timeNeededst);
				}
			}

		}

	}
}

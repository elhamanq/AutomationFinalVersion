package FinalVersion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewTestCaseJ extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	JScrollPane scrollPane;
	JScrollPane scrollPane1;
	private JScrollPane scrollPane1_1;
	JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblNewLabel_4;
	DefaultTableModel model1;
//	final String JDBC_Driver="com.mysql.jdbc.Driver";
//	final String DB_URL="jdbc:mysql://localhost:3306/selenium";
//	
//	final String userName="root";
//	final String pass="1234567";
	Connection con=null;
	Statement stmt=null;
	ResultSet result=null;
	String username="qa";
	String	password="qa";
	
					//	String	connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
	String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";
	
	String Case;
	static int rowCount;
	boolean saved=false;
	DefaultTableModel model;
	static String[] CaseidList=new String[100];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTestCaseJ frame = new NewTestCaseJ();
					frame.setSize(1118, 700);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NewTestCaseJ() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000, 700);
//		setResizable(false);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(49999, 49999));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		  final JTable table = new JTable(); 
	        
	        // create a table model and set a Column Identifiers to this model 
	        Object[] columns = {"Id","Case Name"};
	         model = new DefaultTableModel();
	        model.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        table.setModel(model);
	       table.setBackground(Color.white);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,14);
	        table.setFont(font);
	        table.setRowHeight(30);
//	        getDataFromMysql();
//		 panel_1 = new JPanel();
//		
//		contentPane.add(panel_1);
//		panel_1.add(table);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(450, 90, 600, 400);
		 contentPane.add(scrollPane);
		 
		 if(CaseidList[0]!=null) {
			 getData();
		 }
		 
		 final JTable tablereadonly = new JTable();
	        model1 = (DefaultTableModel)tablereadonly.getModel();
	        model1.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        tablereadonly.setModel(model1);
	        tablereadonly.setBackground(Color.white);
	        tablereadonly.setForeground(Color.black);
	        tablereadonly.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	       
	        tablereadonly.setFont(font);
	        tablereadonly.setRowHeight(30);
	    
		 
		 JLabel lblNewLabel = new JLabel("Case ID");
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lblNewLabel.setBounds(31, 281, 83, 13);
		 contentPane.add(lblNewLabel);
		 
		 JLabel lblNewLabel_1 = new JLabel("Case Name");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lblNewLabel_1.setBounds(31, 342, 83, 13);
		 contentPane.add(lblNewLabel_1);
		 
		 textField = new JTextField();
		 textField.setBounds(151, 260, 182, 42);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 textField_1 = new JTextField();
		 textField_1.setBounds(151, 325, 182, 42);
		 contentPane.add(textField_1);
		 textField_1.setColumns(10);
		 
		 JButton btnNewButton = new JButton("Save");
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnNewButton.setBounds(31, 601, 96, 34);
		 contentPane.add(btnNewButton);
		 
		 JButton btnUpdate = new JButton("Update");
		 btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnUpdate.setBounds(151, 601, 96, 34);
		 contentPane.add(btnUpdate);
		 
		 JButton btnDelete = new JButton("Delete");
		 btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnDelete.setBounds(272, 601, 96, 34);
		 contentPane.add(btnDelete);
		 
		 JButton btnNewButton_1 = new JButton("Next Table");
		 btnNewButton_1.setForeground(new Color(255, 255, 255));
		 btnNewButton_1.setBackground(new Color(50, 205, 50));
		 btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnNewButton_1.setBounds(915, 601, 127, 34);
		 contentPane.add(btnNewButton_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("TEST CASE TABLE");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		 lblNewLabel_2.setBounds(457, 23, 158, 13);
		 contentPane.add(lblNewLabel_2);
		 
		  lblNewLabel_4 = new JLabel("");
		 lblNewLabel_4.setForeground(new Color(255, 69, 0));
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblNewLabel_4.setBounds(292, 210, 53, 22);
		 contentPane.add(lblNewLabel_4);
		 
		 JButton btnNewButton_2 = new JButton("Clear");
		 btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnNewButton_2.setForeground(new Color(255, 255, 255));
		 btnNewButton_2.setBackground(new Color(255, 215, 0));
		 btnNewButton_2.setBounds(450, 601, 96, 34);
		 contentPane.add(btnNewButton_2);
		 btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	clearBB();
	            }});
		 
		 JButton btnNewButton_3 = new JButton("Show All Cases");
		 btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		 btnNewButton_3.setBounds(904, 51, 138, 29);
		 contentPane.add(btnNewButton_3);
		 
		 JButton btnNewButton_4 = new JButton("Home");
		 btnNewButton_4.setBackground(new Color(176, 196, 222));
		 btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnNewButton_4.setBounds(792, 601, 96, 34);
		 contentPane.add(btnNewButton_4);
		 btnNewButton_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	MainJFrame frame;
					try {
						frame = new MainJFrame();
						setVisible(false); 
//						frame.setSize(1318, 727);
						// Hide current frame
		                frame.setVisible(true);
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            	//JOptionPane.showMessageDialog(null, new JScrollPane(tablereadonly));
//	            	JOptionPane.(800, 400);
	            	
	            }});
		 btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	try {
						getDataFromMysql();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	JOptionPane.showMessageDialog(null, new JScrollPane(tablereadonly));
//	            	JOptionPane.(800, 400);
	            	
	            }});
//		 getLastCase();
//		 
		 
		 final Object[] row = new Object[2];
		 btnNewButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		 try {
							Save();
//							getLastCase();
//							clearBB();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("eeeeeeee///"+e1.toString()); 
//							e.printStackTrace();
							
							
							saved=false;
							System.out.println("eeeeeeee///"+saved); 
							JOptionPane.showMessageDialog(null, e1.toString());
						}
//			 		 if(saved=true) {
			 		 if(saved==true) {
	                row[0] = textField.getText();
	                row[1] = textField_1.getText();
	               
	                
	                // add row to the model
	                model.addRow(row);
	                CaseidList[rowCount]=textField.getText();
	                rowCount++;
	                clearBB();
			 		 }
//			 		 }else {
//			 			JOptionPane.showMessageDialog(null, " Duplicate entry"+ textField.getText() +"for key 'testcase.id_UNIQUE' ");
//			 		 }
	            }

				
				
	        });
//		 scrollPane.add(table);
		  // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int yesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this case'"+textField.getText()+"'");
	            	
	            	if(yesOrNo==0) {
	            		int i = table.getSelectedRow();
		                if(i >= 0){
		                    // remove a row from jtable
		                    model.removeRow(i);
		                    try {
								Delete();
//								getLastCase();
								clearBB();
								
								if(rowCount>0) {
									
									rowCount--;
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }
		                else{
		                    System.out.println("Delete Error");
		                }
		            }else if(yesOrNo==1) {
		            	
		            }
	                // i = the index of the selected row
	                
	            }});
	        
	     // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textField.setText(model.getValueAt(i, 0).toString());
	            textField_1.setText(model.getValueAt(i, 1).toString());
	        }
	        });
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int yesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to Update this case'"+textField.getText()+"'");
	                // i = the index of the selected row
	            	if(yesOrNo==0) {
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textField.getText(), i, 0);
	                   model.setValueAt(textField_1.getText(), i, 1);
	                   try {
						Update();
						clearBB();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            	}
	            }
	        });
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	               if(rowCount>0) {
	            	   
					try {
						 NewActionJ frame = new NewActionJ();
						//setVisible(false); 
						frame.setSize(1318, 727);// Hide current frame
		                frame.setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	                
	            }else {
	            	JOptionPane.showMessageDialog(null, "You Cannot Move To The Next Page Until You Enter At Least One Test Case ");
	            }
	               }
	        });
		 		
	}
	public void Save() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			
			//execute query 
			//stmt=con.createStatement();
			 
			String sql="INSERT INTO QA_Automation.DBO.TEST_CASES (id, caseName) VALUES (?,?)";
			 PreparedStatement preparedStmt = con.prepareStatement(sql);
			  preparedStmt.setString (1, textField.getText());
			  preparedStmt.setString (2, textField_1.getText());
			  preparedStmt.execute();
			  
			 
			  
			// TODO Auto-generated catch block
//			result.close();
//			stmt.close();
			  saved=true;
			con.close();
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("eeeeeeee///"+e.toString()); 
//		e.printStackTrace();
		
		
		saved=false;
		System.out.println("eeeeeeee///"+saved); 
			
		
	}
		//INSERT INTO `automation`.`testcase` (`id`, `caseName`) VALUES ('S3', 'tt');
	}
	public void Update() throws SQLException {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			
			//execute query 
			//stmt=con.createStatement();
			
			String sql="update QA_Automation.DBO.TEST_CASES set caseName = ? where id = ?";
			 PreparedStatement preparedStmt = con.prepareStatement(sql);
			  preparedStmt.setString (1, textField_1.getText());
			  preparedStmt.setString (2, textField.getText());
			  preparedStmt.execute();
			
			// TODO Auto-generated catch block
//			result.close();
//			stmt.close();
			con.close();
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//INSERT INTO `automation`.`testcase` (`id`, `caseName`) VALUES ('S3', 'tt');
	}
	public void Delete() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);

			String sql="DELETE FROM QA_Automation.DBO.TEST_CASES WHERE id=?";
			 PreparedStatement preparedStmt = con.prepareStatement(sql);
			  preparedStmt.setString (1, textField.getText());
			  preparedStmt.execute();
			
			// TODO Auto-generated catch block
//			result.close();
//			stmt.close();
			con.close();
			for(int c=0;c<CaseidList.length;c++) {
				if(CaseidList[c]!=null&&CaseidList[c].equals(textField.getText())) {
					List<String> list = new ArrayList<String>(Arrays.asList(CaseidList));
					list.remove(textField.getText());
					CaseidList = list.toArray(new String[0]);
					
				}
			}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//INSERT INTO `automation`.`testcase` (`id`, `caseName`) VALUES ('S3', 'tt');
	}
//	public void getLastCase() throws SQLException {
//		
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			
//			con=DriverManager.getConnection(url);
//			//execute query 
//			//stmt=con.createStatement();
//			 
//			stmt=con.createStatement();
//			String sql="SELECT * FROM QA_Automation.DBO.TEST_CASES ORDER BY id DESC LIMIT 1";
//			result=stmt.executeQuery(sql);
//			while(result.next()) {
//		
//			Case=result.getString("id");
//			}
//			lblNewLabel_4.setText(Case);
//			// TODO Auto-generated catch block
//			result.close();
//			stmt.close();
//			con.close();
//	}catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}
	public void clearBB() {
		
		textField.setText("");
		textField_1.setText("");
		

	}
	public void getDataFromMysql() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			//execute query 
			//stmt=con.createStatement();
			 
			stmt=con.createStatement();
			String sql="SELECT * FROM QA_Automation.DBO.TEST_CASES";
			result=stmt.executeQuery(sql);
			while(result.next()){

	            Object o[] = {result.getString("id"),result.getString("caseName")};
	            model1.addRow(o);



	        }
			result.close();
			stmt.close();
			con.close();
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void getData() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			//execute query 
			//stmt=con.createStatement();
			 
			stmt=con.createStatement();
			for(int i=0;i<CaseidList.length;i++) {
			String sql="SELECT * FROM QA_Automation.DBO.TEST_CASES where QA_Automation.DBO.TEST_CASES.id='"+CaseidList[i]+"'";
			result=stmt.executeQuery(sql);
			while(result.next()){

	            Object o[] = {result.getString("id"),result.getString("caseName")};
	            model.addRow(o);
                


	        }
//			result.close();
//			stmt.close();
//			con.close();
			}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
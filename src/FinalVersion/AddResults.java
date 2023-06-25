package FinalVersion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import org.apache.commons.dbutils.DbUtils;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import com.mysql.cj.xdevapi.JsonArray;
import javax.swing.JComboBox;
/*
 * 
 * Author: Amal Kmail
 */
public class AddResults extends JFrame {
	
	
	private JFrame frame2;
	private JTextField txtresulttID;
	private JTextField txtSelector;
	private JTable table;
	private JTextField txtselectorValue;
	private JTextField txtexpectedResult;
	 private static JComboBox<?> c;
	 private static JComboBox<Object> c2;
	 static int rowCount;
		static String[] resultIdList=new String[100];


	 //   List<String> addedcases = new ArrayList<>();
	  //  static List<?> addedCases=null;
	  //  static List<?> setNames=null;
		static String array1[]=new String[10];
		String[]ss=AddTestCaseJJ.CaseidList;
		String[]ss1=AddTestCaseJ.setNameList;

	/**
	 * Launch the application.
	 * @param addedCases 
	 */
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddResults frame2 = new AddResults();
					//window.frame2.setVisible(true);
					frame2.setVisible(true);
					  frame2.setBounds(100, 100, 912, 400);
					   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param addedCases 
	 * @wbp.parser.entryPoint
	 */
	public AddResults() {
		initialize();
		//table_load();
		getdata();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param addedCases 
	 */
	private void initialize() {
		
		//frame2 = new JFrame();
	//	frame2.setBounds(100, 100, 912, 400);
	//	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Results ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		AddTestCaseJJ frame12 = new AddTestCaseJJ();
	//	addedCases=frame12.AddedTestCases();
		//setNames=AddTestCaseJ.setnames;
		JLabel lblNewLabel = new JLabel("Result ID");
		lblNewLabel.setBounds(66, 24, 118, 26);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Set Name");
		lblNewLabel_3.setBounds(602, 24, 118, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
		txtresulttID = new JTextField();
		txtresulttID.setBounds(150, 28, 96, 20);
		txtresulttID.setColumns(10);
		panel.add(txtresulttID);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(245, 237, 207));
		btnNewButton.setBounds(643, 82, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{			
				String resultId,caseId,setName,Selector,expectedResult,selectorValue;
				resultId = txtresulttID.getText();
				setName = (String) c2.getSelectedItem();
				Selector=txtSelector.getText();
				caseId = (String) c.getSelectedItem();
				Selector=txtSelector.getText();
				expectedResult=txtexpectedResult.getText();
				selectorValue=txtselectorValue.getText();

				
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
					//execute query 
						
						
						
						
					stmt=con.prepareStatement("INSERT INTO QA_Automation.DBO.RESULTS (resultId,caseId,setName,Selector,expectedResult,selectorValue)values(?,?,?,?,?,?)");
					//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
					stmt.setString(1,resultId);
					stmt.setString(2,caseId);
					stmt.setString(3,setName);
					stmt.setString(4,Selector);
					stmt.setString(5,expectedResult);
					stmt.setString(6,selectorValue);


					stmt.executeUpdate();
				//	table_load();
					// System.out.println(result);
					 final Object[] row = new Object[6];
					  row[0] = txtresulttID.getText();
		                row[1] = (String)c.getSelectedItem();
		                row[2] = (String)c2.getSelectedItem();
		                row[3] = txtSelector.getText();
		                row[4] = txtexpectedResult.getText();
		                row[5] = txtselectorValue.getText();
		                
		            	DefaultTableModel model=(DefaultTableModel)table.getModel();
		                model.addRow(row);
		                resultIdList[rowCount]=txtresulttID.getText();
		                rowCount++;
		                 
					 
					 
				
				 }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}}
		});
		panel.add(btnNewButton);
		
		JButton btnNewUpdate = new JButton("Update");
		btnNewUpdate.setBackground(new Color(181, 208, 244));
		btnNewUpdate.setBounds(27, 547, 89, 23);
		btnNewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultId,caseId,setName,Selector,expectedResult,selectorValue;
				resultId = txtresulttID.getText();
				setName = (String) c2.getSelectedItem();
				Selector=txtSelector.getText();
				caseId = (String) c.getSelectedItem();
			//	Selector=txtSelector.getText();
				expectedResult=txtexpectedResult.getText();
				selectorValue=txtselectorValue.getText();
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
						
						
						stmt=con.prepareStatement("UPDATE QA_Automation.DBO.RESULTS SET caseid =?,setName=?,selector=?,expectedResult=?,selectorValue=? WHERE resultid=? ");
						//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
						stmt.setString(1,caseId);
						stmt.setString(2,setName);
						stmt.setString(3,Selector);
						stmt.setString(4,expectedResult);
						stmt.setString(5,selectorValue);
						stmt.setString(6,resultId);

						

						stmt.executeUpdate();
						btnUpdateActionPerformed(e);

				
					// System.out.println(result);
					 
					 
					 
				
				 }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
			}}
		});
		panel.add(btnNewUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(181, 208, 244));
		btnDelete.setBounds(123, 547, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultIddel=txtresulttID.getText();
				try {
					String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
				stmt = con.prepareStatement("DELETE FROM QA_Automation.DBO.RESULTS WHERE resultid =?");
				stmt.setString(1, resultIddel);
				stmt.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
				            btnDeleteActionPerformed(e);				          
				          
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		panel.add(btnDelete);
		
		JLabel lblNewLabel_3_1 = new JLabel("Selector");
		lblNewLabel_3_1.setBounds(66, 45, 118, 26);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3_1);
		
		txtSelector = new JTextField();
		txtSelector.setBounds(150, 49, 96, 20);
		txtSelector.setColumns(10);
		panel.add(txtSelector);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 171, 784, 330);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ResultID", "CaseID", "SetName", "Selector","ExpectedResult","SelectorValue"
			}
		));
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane_1.setViewportView(table);
		
table.addMouseListener(new MouseListener() {
			
			private void jTableMouseClicked(ActionEvent e) {
			

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		        String tblresultId=tblModel.getValueAt(table.getSelectedRow(), 0).toString();//1
		        String tblcaseId=tblModel.getValueAt(table.getSelectedRow(), 1).toString();//2
		        String tblsetName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();//2
		        String tblselector=tblModel.getValueAt(table.getSelectedRow(), 3).toString();//2
		        String tblexpectedResult=tblModel.getValueAt(table.getSelectedRow(), 4).toString();//2
		        String tblselectorValue=tblModel.getValueAt(table.getSelectedRow(), 5).toString();//2

		     //   String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();
		        
		      //  txtcaseId.setText(tblcaseId);
		       // txtcaseName.setText(tblcaseName);
				if(table.getSelectedRowCount()==1) {
					txtresulttID.setText(tblresultId);
					c.setSelectedItem(tblcaseId);//.getValueAt(table.getSelectedRow(), 2).toString()
					txtSelector.setText(tblselector);

					c2.setSelectedItem(tblsetName);
				txtexpectedResult.setText(tblexpectedResult);
				txtselectorValue.setText(tblselectorValue);


				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setBackground(new Color(213, 240, 224));
		btnNewButton_1.setBounds(728, 547, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddScenarios frame1 = new AddScenarios();
				frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
		 		
			//	AddScenarios.main(null);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All");
		btnNewButton_2.setBackground(new Color(231, 213, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WholeTable_load();
			}
		});
		btnNewButton_2.setBounds(115, 149, 53, 23);
		panel.add(btnNewButton_2);
		
		txtselectorValue = new JTextField();
		txtselectorValue.setColumns(10);
		txtselectorValue.setBounds(434, 49, 96, 20);
		panel.add(txtselectorValue);
		
		txtexpectedResult = new JTextField();
		txtexpectedResult.setColumns(10);
		txtexpectedResult.setBounds(727, 46, 96, 20);
		panel.add(txtexpectedResult);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Expected Result");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(566, 45, 142, 26);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Selector Value");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(323, 45, 118, 26);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Case ID");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(340, 24, 118, 26);
		panel.add(lblNewLabel_3_3);
		
	//	String array[] = new String[addedCases.size()];
		//for(int i = 0; i < addedCases.size(); i++) 
			//array[i] = (String) addedCases.get(i);
		
		
		//array1 = new String[setNames.size()];
	//	for(int i = 0; i < setNames.size(); i++) 
	//		array1[i] = (String) setNames.get(i);
	//    String s2[] = addedCases.toString();
		c= new JComboBox<Object>(ss) ;
		c.setBounds(434, 27, 92, 22);
		panel.add(c);
		
		c2= new JComboBox<Object>(ss1) ;
		c2.setBounds(727, 24, 93, 22);
		panel.add(c2);
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()>0) {JOptionPane.showMessageDialog(null,"Please continue wit te added test case or delete it"); }
				else {
				setVisible(false);
				MainJFrame frame11;
				try {
					frame11 = new MainJFrame();
					frame11.setVisible(true);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}}
		});
		btnNewButton_3.setBounds(216, 547, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtresulttID.setText("");
				txtSelector.setText("");
				txtexpectedResult.setText("");
				txtselectorValue.setText("");

			}
		});
		btnNewButton_4.setBounds(728, 82, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
				
			}
		});
		btnNewButton_5.setBounds(33, 149, 89, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddTestCaseJ frame1 = new AddTestCaseJ();
				frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(637, 547, 89, 23);
		panel.add(btnNewButton_6);
		
		c.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try {
				
				getRelatedSets();
				System.out.println("array1 perform");
				int j;
				for( j=0;j<array1.length;j++) {
					System.out.println(j);
					System.out.println(array1[j]);
				}
				DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>( array1 );
				c2.setModel( model );
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}}
				
				);
	}
	
	public void getdata() {try 
	{
		String username="qa";
		String	password="qa";
		String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
       
		Connection con=null;
		Statement stmt=null;
		ResultSet result=null;
		
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
		
		//execute query 
		stmt=con.createStatement();
	//	System.out.println("array1");
		//System.out.println(array1);
		DefaultTableModel model=(DefaultTableModel)table.getModel();

		for(int j=0;model.getRowCount()>0;j++)
		{model.removeRow(0);}
		
for(int i=0;i<resultIdList.length;i++)			

{//System.out.println(CaseidList[i]);
		String sql="SELECT * FROM [QA_Automation].[dbo].[RESULTS] WHERE resultid ='"+resultIdList[i]+"'";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
		result=stmt.executeQuery(sql);

		while(result.next()) {
		
			
			
			//	model.removeRow(i);
            Object o[] = {result.getString("resultid"),result.getString("caseid"),result.getString("setName"),result.getString("selector"),result.getString("expectedResult"),result.getString("selectorValue")};
			model.addRow(o);
	//	table.setModel(DbUtils.resultSetToTableModel(result));
		// System.out.println(result.getType());
		 }
		
		 
} }
	catch (SQLException e1) 
	 {
		e1.printStackTrace();
  } }
	public void WholeTable_load()
    {
    	try 
    	{
    		String username="qa";
			String	password="qa";
			String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
	       
			Connection con=null;
			Statement stmt=null;
			ResultSet result=null;
			
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection(url);
			
			//execute query 
			stmt=con.createStatement();
			String sql="SELECT * FROM [QA_Automation].[dbo].[RESULTS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
			result=stmt.executeQuery(sql);
			 
			table.setModel(DbUtils.resultSetToTableModel(result));
			 System.out.println(result.getType());
			// JsonArray datasets = new JsonArray();
				//DefaultTableModel model=(DefaultTableModel)table.getModel();
			//	toString(result);
		    	//while(result.next()) {
		    	//	JSONObject jsonObject = (JSONObject) JSONParser.parse(result);
		    	//	jsonObject.get("caseid");
		    	//	jsonObject.get("inputid");
		    	//	jsonObject.get("setName");
		    	//	jsonObject.get("setValue");
		    	//	jsonObject.get("setId");
		    	//model.addRow(new Object[] {
		    		//	txtsetName.getText(),
		    			//txtsetValue.getText(),
		    			//txtcaseID.getText(),
		    			//txtinputID.getText()});}
	
			 
	} 
    	catch (SQLException e) 
    	 {
    		e.printStackTrace();
	  } 
    
    			
    			
    	
    }
	
	

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		
		if(table.getSelectedRowCount()==1)
		{tblModel.removeRow(table.getSelectedRow());}
		else {}
	}
	
	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		
		if(table.getSelectedRowCount()==1)
		{String resultid=txtresulttID.getText();
			String caseid=(String) c.getSelectedItem();
		String setName=(String) c2.getSelectedItem();
		String selector=txtSelector.getText();
		String selectorValue=txtselectorValue.getText();
		String expectedResult=txtexpectedResult.getText();


		
		tblModel.setValueAt(resultid, table.getSelectedRow(), 0);
		tblModel.setValueAt(caseid, table.getSelectedRow(), 1);
		tblModel.setValueAt(setName, table.getSelectedRow(), 2);
		tblModel.setValueAt(selector, table.getSelectedRow(), 3);
		tblModel.setValueAt(selectorValue, table.getSelectedRow(), 5);
		tblModel.setValueAt(expectedResult, table.getSelectedRow(), 4);

		
		JOptionPane.showInputDialog(this,"Updated Successfully");}
		
		else {
			
			if(table.getSelectedRowCount()==1) {		
				JOptionPane.showInputDialog(this,"Table is Empty ");
}
			else {JOptionPane.showInputDialog(this,"Please select single row for update ");}

			
		}
		

	
	}
	
	
  
	  public void table_load()
	    {
	    	try 
	    	{
	    		String username="qa";
				String	password="qa";
				String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
		       
				Connection con=null;
				Statement stmt=null;
				ResultSet result=null;
				
					//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con=DriverManager.getConnection(url);
				
				//execute query 
				stmt=con.createStatement();
				String sql="SELECT * FROM [QA_Automation].[dbo].[RESULTS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
				result=stmt.executeQuery(sql);
				 
			//	table.setModel(DbUtils.resultSetToTableModel(result));
				 System.out.println(result.getType());
					DefaultTableModel model=(DefaultTableModel)table.getModel();

				 // JsonArray datasets = new JsonArray();
					//DefaultTableModel model=(DefaultTableModel)table.getModel();
				//	toString(result);
			    	//while(result.next()) {
			    	//	JSONObject jsonObject = (JSONObject) JSONParser.parse(result);
			    	//	jsonObject.get("caseid");
			    	//	jsonObject.get("inputid");
			    	//	jsonObject.get("setName");
			    	//	jsonObject.get("setValue");
			    	//	jsonObject.get("setId");
			    	//model.addRow(new Object[] {
			    		//	txtsetName.getText(),
			    			//txtsetValue.getText(),
			    			//txtcaseID.getText(),
			    			//txtinputID.getText()});}
					model.addRow(new Object[] {
			    			//"",
			    			txtresulttID.getText(),
			    			c.getSelectedItem(),
			    			(String) c2.getSelectedItem(),
			    			txtSelector.getText(),
			    			txtselectorValue.getText(),


			    			txtexpectedResult.getText()
			    			});//}
				 
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    
	    			
	    			
	    	
	    }
	  
	  public static String toString(ResultSet rs) {

	        StringBuffer buf = new StringBuffer();
	        buf.append("[");
	        try {
	            ResultSetMetaData metaData = rs.getMetaData();
	            int nColumns = metaData.getColumnCount();
	            for (int i = 1; i <= nColumns; ++i) {
	                buf.append(metaData.getColumnName(i));
	                buf.append(" = ");
	                buf.append(rs.getString(i));
	                if (i < nColumns)
	                    buf.append(" , ");
	            }
	        } catch (SQLException e) {
	            buf.append(e.getMessage());
	            e.printStackTrace();
	        }
	        buf.append("]");

	        return buf.toString();
	    }
	  public void getRelatedSets() throws ClassNotFoundException, SQLException {
			try {
				
				String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
		       
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=null;
			String cid;
			Statement stmt=null;
			ResultSet result=null;
			con=DriverManager.getConnection(url);
			stmt=con.createStatement();
			System.out.println("c.getSelectedItem");
			System.out.println(c.getSelectedItem());
			cid=(String) c.getSelectedItem();
			String sql="SELECT DISTINCT setName FROM QA_Automation.DBO.TEST_CASES as dc join QA_Automation.DBO.DATASETS as ds on ds.caseid= dc.id where dc.id='"+cid+"'";
			result=stmt.executeQuery(sql);
			System.out.println(result);
			int i=0;
			while(result.next()){
				 System.out.print("result");
				 System.out.print(result);
		        array1[i]=result.getString("setName");
		        System.out.print("array1 inside function");
		        System.out.print(array1);

		         i++;
		    }
			int j;
			for( j=0;j<array1.length;j++) {
				System.out.println(j);
				System.out.println(array1[j]);
			}
			System.out.print(rootPaneCheckingEnabled);
			result.close();
			stmt.close();
			con.close();
		}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
			
		}
	  
	  public static class DbUtils {
		    public static TableModel resultSetToTableModel(ResultSet rs) {
		        try {
		            ResultSetMetaData metaData = rs.getMetaData();
		            int numberOfColumns = metaData.getColumnCount();
		            Vector columnNames = new Vector();

		            // Get the column names
		            for (int column = 0; column < numberOfColumns; column++) {
		                columnNames.addElement(metaData.getColumnLabel(column + 1));
		            }

		            // Get all rows.
		            Vector rows = new Vector();

		            while (rs.next()) {
		                Vector newRow = new Vector();

		                for (int i = 1; i <= numberOfColumns; i++) {
		                    newRow.addElement(rs.getObject(i));
		                }

		                rows.addElement(newRow);
		            }

		            return new DefaultTableModel(rows, columnNames);
		        } catch (Exception e) {
		            e.printStackTrace();

		            return null;
		        }
		    }
		}
}




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
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
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
public class AddScenarios extends JFrame{
	
	
	//private JFrame frame3;
	private JTextField txtsenID;
	private JTextField txtsenName;
	private JTable table;
	 private static JComboBox<?> c1;
	// static List<?> addedCases=null;
	 String[]ss=AddTestCaseJJ.CaseidList;
		static String[] senarioIdList=new String[100];
		static int rowCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScenarios frame3 = new AddScenarios();
				    frame3.setVisible(true);
				    frame3.setBounds(100, 100, 912, 400);
				    frame3.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public AddScenarios() {
		initialize();
		getdata();
	//	table_load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//frame3 = new JFrame();
		//frame3.setBounds(100, 100, 912, 400);
	//	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Senarios ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		//addedCases=AddTestCaseJJ.AddedCases;
		JLabel lblNewLabel = new JLabel("Scenario ID");
		lblNewLabel.setBounds(35, 24, 118, 26);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Case ID");
		lblNewLabel_3.setBounds(517, 24, 118, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
		txtsenID = new JTextField();
		txtsenID.setBounds(128, 28, 96, 20);
		txtsenID.setColumns(10);
		panel.add(txtsenID);
		
		txtsenName = new JTextField();
		txtsenName.setBounds(382, 28, 96, 20);
		txtsenName.setColumns(10);
		panel.add(txtsenName);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(245, 237, 207));
		btnNewButton.setBounds(663, 64, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{			
				String ScenarioId,ScenarioName,caseId;
				ScenarioId = txtsenID.getText();
				caseId = (String) c1.getSelectedItem();
				ScenarioName = txtsenName.getText();
				

				
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
					//execute query 
						
						
						
						
					stmt=con.prepareStatement("INSERT INTO QA_Automation.DBO.SENARIOS (senarioId,caseid,senarioName)values(?,?,?)");
					//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
					stmt.setString(1,ScenarioId);
					stmt.setString(3,ScenarioName);
					stmt.setString(2,caseId);
					


					stmt.executeUpdate();
					//table_load();
					// System.out.println(result);
					final Object[] row = new Object[3];
					  row[0] = txtsenID.getText();
		                row[2] = txtsenName.getText();
		                row[1] = (String)c1.getSelectedItem();
		            	DefaultTableModel model=(DefaultTableModel)table.getModel();
		                model.addRow(row);
		                senarioIdList[rowCount]=txtsenID.getText();
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
		btnNewUpdate.setBounds(68, 569, 89, 23);
		btnNewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ScenarioId,ScenarioName,caseId;
				ScenarioId = txtsenID.getText();
				caseId = (String) c1.getSelectedItem();
				ScenarioName = txtsenName.getText();
				
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
						
						
						stmt=con.prepareStatement("UPDATE QA_Automation.DBO.SENARIOS SET caseid=?,senarioName=? WHERE senarioId=? ");
						//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
						stmt.setString(3,ScenarioId);
						stmt.setString(1,caseId);
						stmt.setString(2,ScenarioName);
						
						

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
		btnDelete.setBounds(151, 569, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senIddel=txtsenID.getText();
				try {
					String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
				stmt = con.prepareStatement("DELETE FROM QA_Automation.DBO.SENARIOS WHERE senarioId =?");
				stmt.setString(1, senIddel);
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(70, 133, 771, 381);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setBackground(new Color(255, 240, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SenarioId", "CaseID", "SenarioName"
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
		        String tblsenId=tblModel.getValueAt(table.getSelectedRow(), 0).toString();//1
		        String tblsenName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();//2
		        String tblcaseid=tblModel.getValueAt(table.getSelectedRow(), 1).toString();//2

		     //   String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();
		        
		      //  txtcaseId.setText(tblcaseId);
		       // txtcaseName.setText(tblcaseName);
				if(table.getSelectedRowCount()==1) {
				txtsenID.setText(tblsenId);//.getValueAt(table.getSelectedRow(), 2).toString()
				txtsenName.setText(tblsenName);
				c1.setSelectedItem(tblcaseid);

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
	
		JButton btnNewButton_1 = new JButton("New Test Cases");
		btnNewButton_1.setBackground(new Color(213, 240, 224));
		btnNewButton_1.setBounds(730, 569, 111, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
		 		AddTestCaseJJ frame1 = new AddTestCaseJJ();
		 		frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
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
		btnNewButton_2.setBounds(140, 111, 54, 23);
		panel.add(btnNewButton_2);
	
	
		
		
		JLabel lblNewLabel_3_3 = new JLabel("Senario Name");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(278, 24, 118, 26);
		panel.add(lblNewLabel_3_3);
		
		JButton btnNewButton_3 = new JButton("Main Frame");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainJFrame frame11;
				try {
					frame11 = new MainJFrame();
					frame11.setVisible(true);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		
			}
		});
		btnNewButton_3.setBounds(613, 569, 118, 23);
		panel.add(btnNewButton_3);
		
	//	String array[] = new String[addedCases.size()];
		//for(int i = 0; i < addedCases.size(); i++) 
			//array[i] = (String) addedCases.get(i);
		
		c1= new JComboBox<Object>(ss) ;
		c1.setBounds(584, 27, 132, 22);
		panel.add(c1);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtsenID.setText("");
				txtsenName.setText("");
				
			}
		});
		btnNewButton_4.setBounds(750, 64, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
			}
		});
		btnNewButton_5.setBounds(70, 111, 89, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddResults frame1 = new AddResults();
				frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(533, 569, 89, 23);
		panel.add(btnNewButton_6);
	}
	public void getdata() {
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
		//	System.out.println("array1");
			//System.out.println(array1);
			DefaultTableModel model=(DefaultTableModel)table.getModel();

			for(int j=0;model.getRowCount()>0;j++)
			{model.removeRow(0);}
			
	for(int i=0;i<senarioIdList.length;i++)			

	{//System.out.println(CaseidList[i]);
			String sql="SELECT * FROM [QA_Automation].[dbo].[SENARIOS] WHERE senarioId ='"+senarioIdList[i]+"'";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
			result=stmt.executeQuery(sql);

			while(result.next()) {
			
				
				
				//	model.removeRow(i);
	            Object o[] = {result.getString("senarioId"),result.getString("caseid"),result.getString("senarioName")};
				model.addRow(o);
		//	table.setModel(DbUtils.resultSetToTableModel(result));
			// System.out.println(result.getType());
			 }
			
			 
	} }
		catch (SQLException e1) 
		 {
			e1.printStackTrace();
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
		{String senid=txtsenID.getText();
		String senName=txtsenName.getText();
		String caseId=(String) c1.getSelectedItem();
		
		tblModel.setValueAt(senid, table.getSelectedRow(), 0);
		tblModel.setValueAt(senName, table.getSelectedRow(), 2);
		tblModel.setValueAt(caseId, table.getSelectedRow(), 1);
		
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
				String sql="SELECT * FROM [QA_Automation].[dbo].[SENARIOS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
				result=stmt.executeQuery(sql);
				 
			//	table.setModel(DbUtils.resultSetToTableModel(result));
				 System.out.println(result.getType());
				 DefaultTableModel model=(DefaultTableModel)table.getModel();
				 model.addRow(new Object[] {
			    			//"",
			    			txtsenID.getText(),
			    			txtsenName.getText(),
			    			c1.getSelectedItem()
			    			});//}
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
				String sql="SELECT * FROM [QA_Automation].[dbo].[SENARIOS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
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




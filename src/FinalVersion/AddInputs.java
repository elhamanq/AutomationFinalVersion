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

import javax.swing.ComboBoxModel;
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

public class AddInputs extends JFrame {

	
//	private JFrame frame1;
	private JTextField txtinputId;
	private JTextField txtinputName;
	private JTable table;
    private static JComboBox<?> c;
    private static JComboBox<Object> c1;
    //List<String> inputs = new ArrayList<>();
	//static List<?> addedCases=null;
	//static List<?> addedActions=null;
	//static List<?> Inputs=null;
	static String array1[]=new String[100];
	String[]ss=AddTestCaseJJ.CaseidList;
	String[]ss1=NewActionJ.actionIdList;
	static String[] inputIdList=new String[100];
	static int rowCount;



	/**
	 * Launch the application.
	 * @param addedCases 
	 */
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInputs frame4 = new AddInputs();
					frame4.setVisible(true);
					frame4.setBounds(100, 100, 912, 400);
					frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//	AddTestCaseJJ frame12 = new AddTestCaseJJ();
				//	addedCases=frame12.AddedTestCases();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	System.out.println();
	}

	/**
	 * Create the application.
	 * @param addedCases 
	 * @param addedCases2 
	 * @wbp.parser.entryPoint
	 */
	public AddInputs() {
		initialize();
		getdata();
		//table_load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		
	//	new AddTestCaseJJ();
		//addedCases=AddTestCaseJJ.AddedCases;
		//new AddActionsJ();
	//	addedActions=AddActionsJ.Actions;
		
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inputs ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input ID");
		lblNewLabel.setBounds(41, 24, 118, 26);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Input Name");
		lblNewLabel_2.setBounds(347, 24, 118, 26);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Case ID");
		lblNewLabel_3.setBounds(572, 24, 118, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
		txtinputId = new JTextField();
		txtinputId.setBounds(133, 24, 96, 20);
		txtinputId.setColumns(10);
		panel.add(txtinputId);
		
		txtinputName = new JTextField();
		txtinputName.setBounds(439, 24, 96, 20);
		txtinputName.setColumns(10);
		panel.add(txtinputName);
		
		//String array[] = new String[addedCases.size()];
		//for(int i = 0; i < addedCases.size(); i++) 
		//	array[i] = (String) addedCases.get(i);

	//    String s2[] = addedCases.toString();
		
		System.out.println("ss1");
		System.out.println(ss1);

		c= new JComboBox<Object>(ss) ;
		
		c1= new JComboBox<Object>(ss1) ;
		c1.setBounds(124, 46, 105, 22);
		panel.add(c1);
		
		c.addActionListener(new ActionListener() { 
				
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		try {
			
			getRelatedActions();
			System.out.println("array1 perform");
			int j;
			for( j=0;j<array1.length;j++) {
				System.out.println(j);
				System.out.println(array1[j]);
			}
			ComboBoxModel<Object> model = new DefaultComboBoxModel<Object>( array1 );
			c1.setModel( model );
			
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		}}
			
			);
		c.setBounds(646, 27, 128, 22);
		panel.add(c);
		
		System.out.println("array1 BEFORE COMBO");
		System.out.println(array1);
	
		//c.getSelectedItem();
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(245, 237, 207));
		btnNewButton.setBounds(658, 77, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			
			{	//System.out.println("chosen")		;
				//System.out.println(c.getSelectedItem());
				String inputName,actionId,caseId,inputId;
				inputId = txtinputId.getText();
				caseId = (String) c.getSelectedItem();
				inputName = txtinputName.getText();
				actionId=(String) c1.getSelectedItem();
				
				 try {	String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
					//execute query 
						
						
						
						
					stmt=con.prepareStatement("INSERT INTO QA_Automation.DBO.INPUTS (inputname,actionid,caseid,input_id)values(?,?,?,?)");
					//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
					stmt.setString(1,inputName);
					stmt.setString(2,actionId);
					stmt.setString(3,caseId);
					stmt.setString(4,inputId);

					stmt.executeUpdate();
					//table_load();
					// System.out.println(result);
					 final Object[] row = new Object[4];
					  row[0] = (String)c.getSelectedItem();
		                row[1] = txtinputId.getText();
		                row[2] = txtinputName.getText();
		                row[3] = (String)c1.getSelectedItem();
		                
		            	DefaultTableModel model=(DefaultTableModel)table.getModel();
		                model.addRow(row);
		                inputIdList[rowCount]=txtinputId.getText();
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
		btnNewUpdate.setBounds(30, 596, 89, 23);
		btnNewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName,actionId,caseId,inputId;
				inputId = txtinputId.getText();
				caseId = (String) c.getSelectedItem();
				inputName = txtinputName.getText();
				actionId=(String) c1.getSelectedItem();
				 try {	String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
						
						
						stmt=con.prepareStatement("UPDATE QA_Automation.DBO.INPUTS SET actionid =?,caseid=?,inputname=? WHERE input_id=? ");
						//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
						stmt.setString(1,actionId);
						stmt.setString(2,caseId);
						stmt.setString(3,inputName);
						stmt.setString(4,inputId);
						

						stmt.executeUpdate();
						btnUpdateActionPerformed();
				
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
		btnDelete.setBounds(126, 596, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputIddel=txtinputId.getText();
				try {
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
				stmt = con.prepareStatement("DELETE FROM QA_Automation.DBO.INPUTS WHERE input_id =?");
				stmt.setString(1, inputIddel);
				stmt.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
				            btnDeleteActionPerformed();
				          
				          
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		panel.add(btnDelete);
		
		JLabel lblNewLabel_3_1 = new JLabel("Action ID");
		lblNewLabel_3_1.setBounds(41, 43, 118, 26);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 175, 806, 384);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CaseID", "inputID", "inputName", "ActionID"
			}
		));
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane_1.setViewportView(table);
		
table.addMouseListener(new MouseListener() {
			
			private void jTableMouseClicked() {
			

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		        String tblcaseId=tblModel.getValueAt(table.getSelectedRow(), 0).toString();//1
		        String tblinputId=tblModel.getValueAt(table.getSelectedRow(), 1).toString();//2
		        String tblinputName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();//2
		        String tblactionId=tblModel.getValueAt(table.getSelectedRow(), 3).toString();//2



		     //   String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();
		        
		      //  txtcaseId.setText(tblcaseId);
		       // txtcaseName.setText(tblcaseName);
				if(table.getSelectedRowCount()==1) {
					c.setSelectedItem(tblcaseId);//.getValueAt(table.getSelectedRow(), 2).toString()
				txtinputId.setText(tblinputId);
				txtinputName.setText(tblinputName);
				c1.setSelectedItem(tblactionId);

				
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
		btnNewButton_1.setBounds(747, 596, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	AddResults.main(null);
				//Inputs=AddedInputs();
				System.out.println("next inputs >>> test cases , inputs");
				//System.out.println(addedCases);
				//System.out.println(Inputs);
				setVisible(false);
				AddTestCaseJ frame11 = new AddTestCaseJ();
		 		//frame1.setSize(1118, 700);
				frame11.setSize(1000, 700);
		 		frame11.setVisible(true);
				

				
			//	System.out.println(AddedInputs);

				
				//AddTestCaseJ.main(null, addedCases , AddedInputs);

			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All");
		btnNewButton_2.setBackground(new Color(231, 213, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WholeTable_load();
			//	Inputs=AddedInputs();
				System.out.println("fff");
			//	System.out.println(Inputs);

				//System.out.println(Inputs.size());
			}
		});
		btnNewButton_2.setBounds(119, 152, 52, 23);
		panel.add(btnNewButton_2);
		
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
				 		
					}}});
		
		btnNewButton_3.setBounds(218, 596, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
				
			}
		});
		btnNewButton_4.setBounds(30, 152, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtinputName.setText("");
				txtinputId.setText("");
			}
		});
		btnNewButton_5.setBounds(747, 77, 89, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewActionJ frame1 = null;
				try {
					frame1 = new NewActionJ();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(658, 596, 89, 23);
		panel.add(btnNewButton_6);
	//	 array1 = new String[addedActions.size()];
	//	for(int i = 0; i < addedActions.size(); i++) 
			//array1[i] = (String) addedActions.get(i);
		
		
		//System.out.println("asas in");
		//System.out.println(addedCases);
	//	List<Integer> list = ...;
		
		
	}
	
	
	
	
	private void btnDeleteActionPerformed() {
		DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		
		if(table.getSelectedRowCount()==1)
		{tblModel.removeRow(table.getSelectedRow());}
		else {}
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
		
for(int i=0;i<inputIdList.length;i++)			

{//System.out.println(CaseidList[i]);
		String sql="SELECT * FROM [QA_Automation].[dbo].[INPUTS] WHERE input_id ='"+inputIdList[i]+"'";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
		result=stmt.executeQuery(sql);

		while(result.next()) {
		
			
			
			//	model.removeRow(i);
            Object o[] = {result.getString("caseid"),result.getString("input_id"),result.getString("inputname"),result.getString("actionid")};
			model.addRow(o);
	//	table.setModel(DbUtils.resultSetToTableModel(result));
		// System.out.println(result.getType());
		 }
		
		 
} }
	catch (SQLException e1) 
	 {
		e1.printStackTrace();
  } }
	private void btnUpdateActionPerformed() {
		DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		
		if(table.getSelectedRowCount()==1)
		{String inputId=txtinputId.getText();
		String inputName=txtinputName.getText();
		String caseid=(String) c.getSelectedItem();
		String actionId=(String) c1.getSelectedItem();
		
		tblModel.setValueAt(inputId, table.getSelectedRow(), 1);
		tblModel.setValueAt(inputName, table.getSelectedRow(), 2);
		tblModel.setValueAt(caseid, table.getSelectedRow(), 0);
		tblModel.setValueAt(actionId, table.getSelectedRow(), 3);
		
		JOptionPane.showInputDialog(this,"Updated Successfully");}
		
		else {
			
			if(table.getSelectedRowCount()==1) {		
				JOptionPane.showInputDialog(this,"Table is Empty ");
}
			else {JOptionPane.showInputDialog(this,"Please select single row for update ");}

			
		}
		

	
	}
	
/*	public List AddedInputs() {
		//	DefaultTableModel model=(DefaultTableModel)table.getModel();
			int AddedInputsNum=table.getModel().getRowCount();
			System.out.println("num of inputs in inputs");
			System.out.println(AddedInputsNum);

			
			for (int i = 0; i < AddedInputsNum; i++) 
			 
			   inputs.add((String) table.getModel().getValueAt(i, 1));//table.getModel().getValueAt(i, 0)
			System.out.println(inputs);

			return inputs;
		}
		*/
	
	public void WholeTable_load()
    {
    	try 
    	{
    		String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
	       
			Connection con=null;
			Statement stmt=null;
			ResultSet result=null;
			
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection(url);
			
			//execute query 
			stmt=con.createStatement();
			String sql="SELECT * FROM [QA_Automation].[dbo].[INPUTS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
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
  
	
	
	  public void table_load()
	    {
	    	try 
	    	{
	    		String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
		       
				Connection con=null;
				Statement stmt=null;
				ResultSet result=null;
				
					//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con=DriverManager.getConnection(url);
				
				//execute query 
				stmt=con.createStatement();
				String sql="SELECT * FROM [QA_Automation].[dbo].[INPUTS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
				result=stmt.executeQuery(sql);
				 
				DefaultTableModel model=(DefaultTableModel)table.getModel();
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
					model.addRow(new Object[] {
			    			//"",
							(String) c.getSelectedItem(),
			    			txtinputId.getText(),
			    			txtinputName.getText(),
			    			
			    			(String) c1.getSelectedItem()
			    			
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
	  public void getRelatedActions() throws ClassNotFoundException, SQLException {
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
			String sql="SELECT DISTINCT actionId FROM QA_Automation.DBO.TEST_CASES as dc join QA_Automation.DBO.ACTIONS as ds on ds.caseid= dc.id where dc.id='"+cid+"'";
			result=stmt.executeQuery(sql);
			System.out.println(result);
			int i=0;
			while(result.next()){
				 System.out.print("result");
				 System.out.print(result);
		        array1[i]=result.getString("actionId");
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
		            Vector<String> columnNames = new Vector<String>();

		            // Get the column names
		            for (int column = 0; column < numberOfColumns; column++) {
		                columnNames.addElement(metaData.getColumnLabel(column + 1));
		            }

		            // Get all rows.
		            Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

		            while (rs.next()) {
		                Vector<Object> newRow = new Vector<Object>();

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




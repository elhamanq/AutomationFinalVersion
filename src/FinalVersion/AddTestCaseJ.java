// Data Set.

package FinalVersion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
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
public class AddTestCaseJ extends JFrame {

	//JFrame frame;
	private JTextField txtsetID;
	private JTextField txtsetName;
	private JTextField txtsetValue;
	private JTable table;
	private static JComboBox<?> c;
	private static JComboBox<Object> c1;
//	static List<?> addedCases=null;
	//static List<?> addedInputs=null;
    List<String> sets = new ArrayList<>();
	static List<?> setnames=null;
	static String array1[]=new String[10];
	static String[] set=new String[100];
	String[]ss=AddTestCaseJJ.CaseidList;
	String[]ss1=AddInputs.inputIdList;
	static String[] setIdList=new String[100];
	static String[] setNameList=new String[100];
	static int rowCount;



	/**
	 * Launch the application.
	 * @param addedInputs 
	 * @param caseId 
	 */
	public static final void main(String[] args) {//
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTestCaseJ frame = new AddTestCaseJ();//
					frame.setBounds(100, 100, 912, 400);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param addedInputs 
	 */
	public AddTestCaseJ() {//String sentcaseId
		initialize();//sentcaseId
		//table_load();
		getdata();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {//String sentcaseId
		//frame = new JFrame();
	//	frame.setBounds(100, 100, 912, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//AddTestCaseJJ frame12 = new AddTestCaseJJ();
	//	addedCases=AddTestCaseJJ.AddedCases;
		//AddInputs frame123 = new AddInputs();
	//	addedInputs=AddInputs.Inputs;
		System.out.println("imprtant");

		//System.out.println(addedInputs);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Data Set", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Set Name");
		lblNewLabel.setBounds(306, 11, 118, 26);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Set ID");
		lblNewLabel_1.setBounds(29, 11, 118, 26);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Set Value");
		lblNewLabel_2.setBounds(607, 11, 118, 26);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Case ID");
		lblNewLabel_3.setBounds(29, 37, 118, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
		txtsetID = new JTextField();
		txtsetID.setBounds(121, 15, 96, 20);
		panel.add(txtsetID);
		txtsetID.setColumns(10);
		
		txtsetName = new JTextField();
		txtsetName.setBounds(398, 11, 96, 20);
		txtsetName.setColumns(10);
		panel.add(txtsetName);
		
		txtsetValue = new JTextField();
		txtsetValue.setBounds(699, 11, 96, 20);
		txtsetValue.setColumns(10);
		panel.add(txtsetValue);
		//txtcaseID.setText(addedCases);

		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(245, 237, 207));
		btnNewButton.setBounds(617, 76, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{			
				String setId,setName,setValue,caseId,inputId;
				setId = txtsetID.getText();
				setName = txtsetName.getText();
				setValue = txtsetValue.getText();
				caseId= (String) c.getSelectedItem();
				inputId=(String) c1.getSelectedItem();
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
					//execute query 
						
						
						
						
					stmt=con.prepareStatement("INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?,?)");
					//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
					stmt.setString(1,setId);
					stmt.setString(2,setName);
					stmt.setString(3,setValue);
					stmt.setString(4,caseId);
					stmt.setString(5,inputId);

					stmt.executeUpdate();

					 final Object[] row = new Object[5];
					  row[0] = (String)c.getSelectedItem();
		                row[1] = (String)c1.getSelectedItem();
		                row[2] = txtsetName.getText();
		                row[3] = txtsetValue.getText();
		                row[4] = txtsetID.getText();

		            	DefaultTableModel model=(DefaultTableModel)table.getModel();
		                model.addRow(row);
		                setIdList[rowCount]=txtsetID.getText();
		                setNameList[rowCount]=txtsetName.getText();

		                rowCount++;
		                
					// System.out.println(result);
					 
					 
					 
				
				 }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}}
		});
		panel.add(btnNewButton);
		
		JButton btnNewUpdate = new JButton("Update");
		btnNewUpdate.setBackground(new Color(181, 208, 244));
		btnNewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setId,setName,setValue,caseId,inputId;
				setId = txtsetID.getText();
				setName = txtsetName.getText();
				setValue = txtsetValue.getText();
				caseId= (String) c.getSelectedItem();
				inputId=(String) c1.getSelectedItem();
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
						
						
						stmt=con.prepareStatement("UPDATE QA_Automation.DBO.DATASETS SET setName =?,setValue=?,caseid=?,inputid=? WHERE setId=?");
						//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
						stmt.setString(1,setId);
						stmt.setString(2,setName);
						stmt.setString(3,setValue);
						stmt.setString(4,caseId);
						stmt.setString(5,inputId);

						stmt.executeUpdate();
						//table_load();
						btnUpdateActionPerformed(e);
					// System.out.println(result);
					 
					 
					 
				
				 }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
			}}
		});
		btnNewUpdate.setBounds(30, 556, 89, 23);
		panel.add(btnNewUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(181, 208, 244));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String setIddel=txtsetID.getText();
				try {
					String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
				stmt = con.prepareStatement("DELETE FROM QA_Automation.DBO.DATASETS WHERE setId =?");
				stmt.setString(1, setIddel);
				stmt.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
				            btnDeleteActionPerformed(e);
				          
				          
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(113, 556, 89, 23);
		panel.add(btnDelete);
		
		JLabel lblNewLabel_3_1 = new JLabel("Input ID");
		lblNewLabel_3_1.setBounds(306, 37, 118, 26);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 141, 766, 354);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "caseID", "inputID", "setName", "setValue", "setID" //txtcaseId.getText()
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
		        String tblsetId=tblModel.getValueAt(table.getSelectedRow(), 4).toString();//1
		        String tblsetName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();//2
		        String tblsetValue=tblModel.getValueAt(table.getSelectedRow(), 3).toString();//2
		        String tblinputId=tblModel.getValueAt(table.getSelectedRow(), 1).toString();//2
		        String tblcaseId=tblModel.getValueAt(table.getSelectedRow(), 0).toString();//2


		     //   String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();
		        
		      //  txtcaseId.setText(tblcaseId);
		       // txtcaseName.setText(tblcaseName);
				if(table.getSelectedRowCount()==1) {
				txtsetID.setText(tblsetId);//.getValueAt(table.getSelectedRow(), 2).toString()
				txtsetName.setText(tblsetName);
				txtsetValue.setText(tblsetValue);
				c1.setSelectedItem(tblinputId);
				c.setSelectedItem(tblcaseId);

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
		btnNewButton_1.setBackground(new Color(181, 208, 244));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			//	setnames=AddedSetNames();
				AddResults frame11 = new AddResults();
				frame11.setSize(1000, 700);
		 		frame11.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(706, 556, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All");
		btnNewButton_2.setBackground(new Color(231, 213, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WholeTable_load();
			}
		});
		btnNewButton_2.setBounds(117, 121, 50, 23);
		panel.add(btnNewButton_2);
		
		//String array[] = new String[addedCases.size()];
	//	for(int i = 0; i < addedCases.size(); i++) 
		//	array[i] = (String) addedCases.get(i);

	//    String s2[] = addedCases.toString();
		c= new JComboBox<Object>(ss) ;
		c.setBounds(131, 40, 86, 22);
		panel.add(c);
		c1= new JComboBox<Object>(ss1) ;
		c1.setBounds(394, 40, 100, 22);
		panel.add(c1);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
			}
		});
		btnNewButton_3.setBounds(29, 121, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setBounds(202, 556, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtsetName.setText("");
				txtsetID.setText("");
				txtsetValue.setText("");

			}
		});
		btnNewButton_5.setBounds(706, 76, 89, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddInputs frame1 = new AddInputs();
				frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(620, 556, 89, 23);
		panel.add(btnNewButton_6);
		c.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try {
				
				getRelatedInputs();
				System.out.println("array1 perform");
				int j;
				for( j=0;j<array1.length;j++) {
					System.out.println(j);
					System.out.println(array1[j]);
				}
				ComboBoxModel<Object> model = new DefaultComboBoxModel<Object>( array1 );
				c1.setModel(model);
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}}
				
				);
		/// array1 = new String[addedInputs.size()];
////		for(int i = 0; i < addedInputs.size(); i++) 
		//	array1[i] = (String) addedInputs.get(i);

	//    String s2[] = addedCases.toString();
		
		
		
		
	
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
		
for(int i=0;i<setIdList.length;i++)			

{//System.out.println(CaseidList[i]);
		String sql="SELECT * FROM [QA_Automation].[dbo].[DATASETS] WHERE setId ='"+setIdList[i]+"'";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
		result=stmt.executeQuery(sql);

		while(result.next()) {
		
			
			
			//	model.removeRow(i);
            Object o[] = {result.getString("caseid"),result.getString("inputid"),result.getString("setName"),result.getString("setValue"),result.getString("setId")};
			model.addRow(o);
	//	table.setModel(DbUtils.resultSetToTableModel(result));
		// System.out.println(result.getType());
		 }
		
		 
} }
	catch (SQLException e1) 
	 {
		e1.printStackTrace();
  } }
	public List AddedSetNames() {
		//	DefaultTableModel model=(DefaultTableModel)table.getModel();
			int setNum=table.getModel().getRowCount();
			System.out.println("num of inputs in inputs");
			System.out.println(setNum);

			
			for (int i = 0; i < setNum; i++) 
			 
			   sets.add((String) table.getModel().getValueAt(i, 2));//table.getModel().getValueAt(i, 0)
			System.out.println(sets);

			return sets;
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
		{String setId=txtsetID.getText();
		String setName=txtsetName.getText();
		String setValue=txtsetValue.getText();
		String inputId=(String) c1.getSelectedItem();

		String caseId=(String) c.getSelectedItem();

		
		tblModel.setValueAt(setId, table.getSelectedRow(), 4);
		tblModel.setValueAt(setName, table.getSelectedRow(), 2);
		tblModel.setValueAt(setValue, table.getSelectedRow(), 3);

		tblModel.setValueAt(inputId, table.getSelectedRow(), 1);
		tblModel.setValueAt(caseId, table.getSelectedRow(), 0);

		
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
				String sql="SELECT * FROM [QA_Automation].[dbo].[DATASETS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
				result=stmt.executeQuery(sql);
				 
				//table.setModel(DbUtils.resultSetToTableModel(result));
				//System.out.println(result.getType());
				// JsonArray datasets = new JsonArray();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
				//	toString(result);
			  //  	while(result.next()) {
			    	//	JSONObject jsonObject = (JSONObject) JSONParser.parse(result);
			    	//	jsonObject.get("caseid");
			    	//	jsonObject.get("inputid");
			    	//	jsonObject.get("setName");
			    	//	jsonObject.get("setValue");
			    	//	jsonObject.get("setId");
			    	model.addRow(new Object[] {
			    		
			    			(String) c.getSelectedItem(),
			    	(String) c1.getSelectedItem(),
			    		
			    			txtsetName.getText(),
			    			txtsetValue.getText(),
			    			txtsetID.getText()});}
		
				 
	//	} 
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
				String sql="SELECT * FROM [QA_Automation].[dbo].[DATASETS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
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
	  
	  
	  public void getRelatedInputs() throws ClassNotFoundException, SQLException {
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
			String sql="SELECT DISTINCT input_id FROM QA_Automation.DBO.TEST_CASES as dc join QA_Automation.DBO.INPUTS as ds on ds.caseid= dc.id where dc.id='"+cid+"'";
			result=stmt.executeQuery(sql);
			System.out.println(result);
			int i=0;
			while(result.next()){
				 System.out.print("result");
				 System.out.print(result);
		        array1[i]=result.getString("input_id");
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




class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}



class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(button, label + ": Ouch!");
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}

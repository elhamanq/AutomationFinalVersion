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

import javax.swing.AbstractButton;
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

public class AddActionsJ extends JFrame {

	
//	private JFrame frame1;
	private JTextField txtactionElement;
	private JTextField txtLink;
	private JTextField txtactionId;
	private static JTable table;
    private static JComboBox<?> c;
    private static JComboBox<?> c1;
    List<String> inputs = new ArrayList<>();
	static List<?> addedCases=null;
	static List<?> Actions=null;

	private JTextField txtactionName;
	private JTextField txtneedWait;
	private JTextField txtelementType;
	private JTextField txtItemLink;
	private JTextField txtSecondAction;
	private JTextField txtneedAction;
	private JTextField txtsecondAction;
    static List<String> actions = new ArrayList<>();
	 String[] actionElementList = { "byid", "byxpath" };
		static String[] actionIdList=new String[100];
		static int rowCount;
		String[]ss=AddTestCaseJJ.CaseidList;




	/**
	 * Launch the application.
	 * @param addedCases 
	 */
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddActionsJ frame4 = new AddActionsJ();
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
	public AddActionsJ() {
		initialize();
		getdata();
		//table_load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		
		//frame1 = new JFrame();
		//frame1.setBounds(100, 100, 912, 400);
		//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AddTestCaseJJ frame12 = new AddTestCaseJJ();
		//addedCases=AddTestCaseJJ.AddedCases;
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Actions ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Action Element");
		lblNewLabel.setBounds(41, 24, 140, 26);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Link");
		lblNewLabel_2.setBounds(331, 24, 118, 26);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Case ID");
		lblNewLabel_3.setBounds(572, 24, 118, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
		txtactionElement = new JTextField();
		txtactionElement.setBounds(158, 24, 96, 20);
		txtactionElement.setColumns(10);
		panel.add(txtactionElement);
		
		txtLink = new JTextField();
		txtLink.setBounds(410, 28, 96, 20);
		txtLink.setColumns(10);
		panel.add(txtLink);
		
		//String array[] = new String[addedCases.size()];
	//	for(int i = 0; i < addedCases.size(); i++) 
		//	array[i] = (String) addedCases.get(i);

	//    String s2[] = addedCases.toString();
		c= new JComboBox<Object>(ss) ;
		c.setBounds(659, 27, 94, 22);
		panel.add(c);
		
		//c.getSelectedItem();
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(245, 237, 207));
		btnNewButton.setBounds(779, 117, 89, 20);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			
			{	//System.out.println("chosen")		;
				//System.out.println(c.getSelectedItem());
				String caseId,actionId,Link,actionElement,actionName,needWait,elementType,listItemLink,secondAction,haveSecondAction;
				actionElement = (String) c1.getSelectedItem();
				caseId = (String) c.getSelectedItem();
				Link = txtLink.getText();
				actionId=txtactionId.getText();
				actionName=txtactionName.getText();
				needWait=txtneedWait.getText();
				elementType=txtelementType.getText();
				listItemLink=txtItemLink.getText();
				secondAction=txtSecondAction.getText();
				haveSecondAction=txtneedAction.getText();

				
				
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
					//execute query 
						
						
						
						
					stmt=con.prepareStatement("INSERT INTO QA_Automation.DBO.ACTIONS (caseid,actionId,link,actionElement,actionName,needWait,elementType,lisItemlink,secondAction,haveSecondAction)values(?,?,?,?,?,?,?,?,?,?)");
					//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
					stmt.setString(1,caseId);
					stmt.setString(2,actionId);
					stmt.setString(3,Link);
					stmt.setString(4,actionElement);
					stmt.setString(5,actionName);
					stmt.setString(6,needWait);
					stmt.setString(7,elementType);
					stmt.setString(8,listItemLink);
					stmt.setString(9,secondAction);
					stmt.setString(10,haveSecondAction);

					stmt.executeUpdate();
					//table_load();
					// System.out.println(result);
					 final Object[] row = new Object[10];
				    	row[0] = (String)c.getSelectedItem();
		                row[1] = txtactionId.getText();
		                row[2] = txtLink.getText();
		                row[3] = (String)c1.getSelectedItem();
		                row[4] = txtactionName.getText();
		                row[5] = txtneedWait.getText();
		                row[6] = txtelementType.getText();
		                row[7] = txtItemLink.getText();
		                row[8] = "";
		                row[9] = txtneedAction.getText();

		            	DefaultTableModel model=(DefaultTableModel)table.getModel();
		                model.addRow(row);
		                actionIdList[rowCount]=txtactionId.getText();
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
		btnNewUpdate.setBounds(27, 564, 89, 23);
		btnNewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caseId,actionId,Link,actionElement,actionName,needWait,elementType,listItemLink,secondAction,haveSecondAction;
				actionElement = (String) c1.getSelectedItem();
				caseId = (String) c.getSelectedItem();
				Link = txtLink.getText();
				actionId=txtactionId.getText();
				actionName=txtactionName.getText();
				needWait=txtneedWait.getText();
				elementType=txtelementType.getText();
				listItemLink=txtItemLink.getText();
				secondAction=txtSecondAction.getText();
				haveSecondAction=txtneedAction.getText();
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
						
						
						stmt=con.prepareStatement("UPDATE QA_Automation.DBO.ACTIONS SET caseid=?,link=?,actionElement=?,actionName=?,needWait=?,elementType=?,lisItemlink=?,secondAction=?,haveSecondAction=? WHERE actionId=? ");
						//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
						stmt.setString(1,caseId);
						stmt.setString(2,Link);
						stmt.setString(3,actionElement);
						stmt.setString(4,actionName);
						stmt.setString(5,needWait);
						stmt.setString(6,elementType);
						stmt.setString(7,listItemLink);
						stmt.setString(8,secondAction);
						stmt.setString(9,haveSecondAction);
						stmt.setString(10,actionId);
						

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
		btnDelete.setBounds(123, 564, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionIddel=txtactionId.getText();
				try {
					String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
				stmt = con.prepareStatement("DELETE FROM QA_Automation.DBO.ACTIONS WHERE actionId =?");
				stmt.setString(1, actionIddel);
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
		
		JLabel lblNewLabel_3_1 = new JLabel("Action ID");
		lblNewLabel_3_1.setBounds(41, 43, 140, 26);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3_1);
		
		txtactionId = new JTextField();
		txtactionId.setBounds(158, 43, 96, 20);
		txtactionId.setColumns(10);
		panel.add(txtactionId);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 140, 909, 383);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setBackground(new Color(255, 240, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CaseID", "ActionID", "Link", "ActionElement","ActionName","NeedWait","Elementtype","ListItemLink","SecondAction","HaveSecondAction"
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
		        String tblcaseId=tblModel.getValueAt(table.getSelectedRow(), 0).toString();//1
		        String tblactionId=tblModel.getValueAt(table.getSelectedRow(), 1).toString();//2
		        String tblLink=tblModel.getValueAt(table.getSelectedRow(), 2).toString();//2
		        String tblactionElement=tblModel.getValueAt(table.getSelectedRow(), 3).toString();//2
		        String tblactionName=tblModel.getValueAt(table.getSelectedRow(), 4).toString();//2
		        String tblneedWait=tblModel.getValueAt(table.getSelectedRow(), 5).toString();//2
		        String tblelementType=tblModel.getValueAt(table.getSelectedRow(), 6).toString();//2
		        String tblListItemLink=tblModel.getValueAt(table.getSelectedRow(), 7).toString();//2
		        String tblSecondAction=tblModel.getValueAt(table.getSelectedRow(), 8).toString();//2
		        String tblHaveSecondAction=tblModel.getValueAt(table.getSelectedRow(), 9).toString();//2



		     //   String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();
		        
		      //  txtcaseId.setText(tblcaseId);
		       // txtcaseName.setText(tblcaseName);
				if(table.getSelectedRowCount()==1) {
					c.setSelectedItem(tblcaseId);//.getValueAt(table.getSelectedRow(), 2).toString()
				txtactionId.setText(tblactionId);
				txtLink.setText(tblLink);
				c1.setSelectedItem(tblactionElement);
				txtactionName.setText(tblactionName);
				txtneedWait.setText(tblneedWait);
				txtelementType.setText(tblelementType);
				txtItemLink.setText(tblListItemLink);
				txtSecondAction.setText(tblSecondAction);
				txtneedAction.setText(tblHaveSecondAction);


				
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
		btnNewButton_1.setBounds(829, 564, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	AddResults.main(null);
			//	Actions=AddedActions();
				setVisible(false);
				AddInputs frame11 = new AddInputs();
		 		//frame1.setSize(1118, 700);
		
		 		//frame1.setSize(1118, 700);
				frame11.setSize(1000, 700);
		 		frame11.setVisible(true);
				List AddedInputs=AddedInputs();
			//	System.out.println("next inputs >>> test cases , inputs");
			//	System.out.println(addedCases);
				//System.out.println(AddedInputs);

				
				//AddTestCaseJ.main(null, addedCases , AddedInputs);

			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WholeTable_load();
			}
		});
		btnNewButton_2.setBounds(864, 117, 55, 20);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Action Name");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(318, 43, 118, 26);
		panel.add(lblNewLabel_3_1_1);
		
		txtactionName = new JTextField();
		txtactionName.setColumns(10);
		txtactionName.setBounds(410, 47, 96, 20);
		panel.add(txtactionName);
		
		txtneedWait = new JTextField();
		txtneedWait.setColumns(10);
		txtneedWait.setBounds(659, 47, 96, 20);
		panel.add(txtneedWait);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Need Wait");
		lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(567, 43, 118, 26);
		panel.add(lblNewLabel_3_1_1_1);
		
		txtelementType = new JTextField();
		txtelementType.setColumns(10);
		txtelementType.setBounds(158, 61, 96, 20);
		panel.add(txtelementType);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Element Type");
		lblNewLabel_3_1_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(41, 61, 118, 26);
		panel.add(lblNewLabel_3_1_1_2);
		
		txtItemLink = new JTextField();
		txtItemLink.setColumns(10);
		txtItemLink.setBounds(410, 65, 96, 20);
		panel.add(txtItemLink);
		
		JLabel lblNewLabel_3_1_1_3 = new JLabel("listItemLink");
		lblNewLabel_3_1_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1_3.setBounds(318, 61, 118, 26);
		panel.add(lblNewLabel_3_1_1_3);
		
		txtSecondAction = new JTextField();
		txtSecondAction.setColumns(10);
		txtSecondAction.setBounds(659, 65, 96, 20);
		panel.add(txtSecondAction);
		
		JLabel lblNewLabel_3_1_1_3_1 = new JLabel("Second Action");
		lblNewLabel_3_1_1_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1_3_1.setBounds(547, 61, 118, 26);
		panel.add(lblNewLabel_3_1_1_3_1);
		
		txtneedAction = new JTextField();
		txtneedAction.setColumns(10);
		txtneedAction.setBounds(189, 84, 65, 20);
		panel.add(txtneedAction);
		
		JLabel lblNewLabel_3_1_1_3_2 = new JLabel("Have Second Action");
		lblNewLabel_3_1_1_3_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1_1_3_2.setBounds(41, 80, 165, 26);
		panel.add(lblNewLabel_3_1_1_3_2);
		
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
		btnNewButton_3.setBounds(222, 564, 89, 23);
		panel.add(btnNewButton_3);
		
		c1= new JComboBox<Object>(actionElementList) ;
		c1.setBounds(264, 27, 30, 22);
		panel.add(c1);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLink.setText("");
				txtactionId.setText("");
				txtactionName.setText("");
				txtneedWait.setText("");
				txtelementType.setText("");
				txtItemLink.setText("");
				txtSecondAction.setText("");
			    txtneedAction.setText("");
			}
		});
		btnNewButton_4.setBounds(811, 83, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
				
		    
				
			}
		});
		btnNewButton_5.setBounds(688, 116, 89, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddTestCaseJJ frame1 = new AddTestCaseJJ();
				frame1.setSize(1000, 700);
		 		frame1.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(744, 564, 89, 23);
		panel.add(btnNewButton_6);
		System.out.println("asas action");
		System.out.println(addedCases);
	//	List<Integer> list = ...;
		
		
	}
	
	public static List AddedActions() {
		//	DefaultTableModel model=(DefaultTableModel)table.getModel();
			int ActionsNum=table.getModel().getRowCount();
			System.out.println("row count main");

			System.out.println(ActionsNum);

			for (int i = 0; i < ActionsNum; i++) 
			 
			   actions.add((String) table.getModel().getValueAt(i, 1));//table.getModel().getValueAt(i, 0)
			System.out.println("asas main");

			System.out.println(actions);
			return actions;
		}
	
	
	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
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
		
for(int i=0;i<actionIdList.length;i++)			

{//System.out.println(CaseidList[i]);
		String sql="SELECT * FROM [QA_Automation].[dbo].[ACTIONS] WHERE actionId ='"+actionIdList[i]+"'";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
		result=stmt.executeQuery(sql);

		while(result.next()) {
		
			
			
			//	model.removeRow(i);
			   Object o[] = {result.getString("caseid"),result.getString("actionId"),result.getString("link"),result.getString("actionElement"),result.getString("actionName"),result.getString("needWait"),result.getString("elementType"),result.getString("lisItemLink"),result.getString("secondAction"),result.getString("haveSecondAction"),result.getString("waitingPeriode")};
	            model.addRow(o);
	//	table.setModel(DbUtils.resultSetToTableModel(result));
		// System.out.println(result.getType());
		 }
		
		 
} }
	catch (SQLException e1) 
	 {
		e1.printStackTrace();
  } }
	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		
		if(table.getSelectedRowCount()==1)
		{String actionElement=(String) c1.getSelectedItem();
		String Link=txtLink.getText();
		String caseid=(String) c.getSelectedItem();
		String actionId=txtactionId.getText();
		String actionName=txtactionName.getText();
		String needWait=txtneedWait.getText();
		String secondAction=txtsecondAction.getText();
		String haveSecondAction=txtneedAction.getText();
		String Itemlinklist=txtItemLink.getText();
		String elementType=txtelementType.getText();
		
		
		tblModel.setValueAt(caseid, table.getSelectedRow(), 0);
		tblModel.setValueAt(actionId, table.getSelectedRow(), 1);
		tblModel.setValueAt(Link, table.getSelectedRow(), 2);
		tblModel.setValueAt(actionElement, table.getSelectedRow(), 3);
		tblModel.setValueAt(actionName, table.getSelectedRow(), 4);
		tblModel.setValueAt(needWait, table.getSelectedRow(), 5);
		tblModel.setValueAt(elementType, table.getSelectedRow(), 6);
		tblModel.setValueAt(Itemlinklist, table.getSelectedRow(), 7);
		tblModel.setValueAt(secondAction, table.getSelectedRow(), 8);
		tblModel.setValueAt(haveSecondAction, table.getSelectedRow(), 9);
		
		JOptionPane.showInputDialog(this,"Updated Successfully");}
		
		else {
			
			if(table.getSelectedRowCount()==1) {		
				JOptionPane.showInputDialog(this,"Table is Empty ");
}
			else {JOptionPane.showInputDialog(this,"Please select single row for update ");}

			
		}
		

	
	}
	
	public List AddedInputs() {
		//	DefaultTableModel model=(DefaultTableModel)table.getModel();
			int AddedInputsNum=table.getModel().getRowCount();
			
			
			for (int i = 0; i < AddedInputsNum; i++) 
			 
			   inputs.add((String) table.getModel().getValueAt(i, 1));//table.getModel().getValueAt(i, 0)
			
			return inputs;
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
			String sql="SELECT * FROM [QA_Automation].[dbo].[ACTIONS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
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
				String sql="SELECT * FROM [QA_Automation].[dbo].[ACTIONS] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
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
			    			txtactionId.getText(),
			    			txtLink.getText(),
			    			(String) c1.getSelectedItem(),
			    			txtactionName.getText(),
			    			txtneedWait.getText(),
			    			txtelementType.getText(),
			    			txtItemLink.getText(),
			    			txtSecondAction.getText(),
			    			txtneedAction.getText()
			    			
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




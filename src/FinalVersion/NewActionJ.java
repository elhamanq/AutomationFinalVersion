package FinalVersion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.util.Arrays;
public class NewActionJ extends JFrame {
	private JPanel contentPane;
	JPanel panel;
	JScrollPane scrollPane;
	JScrollPane scrollPane1;
	private JScrollPane scrollPane1_1;
	JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
//	final String JDBC_Driver="com.mysql.jdbc.Driver";
//	final String DB_URL="jdbc:mysql://localhost:3306/selenium";
//	
//	final String userName="root";
//	final String pass="1234567";
//	Connection con=null;
//	Statement stmt=null;
//	ResultSet result=null;
	Connection con=null;
	Statement stmt=null;
	ResultSet result=null;
	String username="qa";
	String	password="qa";
	
					//	String	connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
	String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";
	private JTextField ActionIdT;
	private JTextField LinkT;
	private JTextField ActionElemT;
	private JTextField ActionT;
	private JTextField NeedWaitT;
	private JTextField ElementTypT;
	private JTextField ListLinkT;
	private JTextField SecondAcT;
	private JTextField HaveSecondAcT;
	String Case=null;
	String ActionId=null;
	
	JComboBox<String> actionElement;
	JComboBox<String> actionC;
	JComboBox<String> needWaitC;
	JComboBox<String> elementTypeC;
	JComboBox<String> secondActC;
	JComboBox<String> havesecondActC;
	JComboBox WaitingTypeListC;
	 String[] waitingTypeList= {"elementToBeClickable","presenceOfElementLocated","//"};
	 String[] actionElementList = { "byid", "byxpath" };
	 String[] actionsList = { "sendkey", "click", "clear" };
	 String[] needWaitList = { "yes", "no"};
	 String[] elementTypeList = { "single", "list", "table"};
	 String[] secondActList = { "enter", "send","//"};
	 String[] HaveSecondActList = { "yes", "no"};
	 DefaultTableModel model;
	 DefaultTableModel model1;
		static String[] actionIdList=new String[100];

	 int rowCount=0;
		String[]ss=AddTestCaseJJ.CaseidList;
	String[]updated;
	JComboBox<String> caseidL;
 boolean saved=false;
 private JTextField waitingP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewActionJ frame = new NewActionJ();
					frame.setVisible(true);
					frame.setSize(1318, 727);
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
	@SuppressWarnings("unchecked")
	public NewActionJ() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1300, 700);
		 
		contentPane = new JPanel();
		contentPane.setIgnoreRepaint(true);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setEnabled(false);
		contentPane.setMaximumSize(new Dimension(49999, 49999));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		  final JTable table = new JTable(); 
	        
	        // create a table model and set a Column Identifiers to this model 
	        Object[] columns = {"CaseID","ActionID","Link","Action Elemnet","Action","Need Wait","Element Type","List","Have Seconed Action","Seconed Action","Waiting Periode","Waiting Type"};
	         model = (DefaultTableModel)table.getModel();
	        model.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        table.setModel(model);
	       table.setBackground(Color.white);
	        table.setForeground(Color.black);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        Font font = new Font("",1,12);
	        table.setFont(font);
	        table.setRowHeight(30);
	        table.getColumnModel().getColumn(8).setPreferredWidth(200);
	        table.getColumnModel().getColumn(3).setPreferredWidth(100);
	        table.getColumnModel().getColumn(9).setPreferredWidth(120);
	        
	        
	        final JTable tablereadonly = new JTable();
	        model1 = (DefaultTableModel)tablereadonly.getModel();
	        model1.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        tablereadonly.setModel(model1);
	        tablereadonly.setBackground(Color.white);
	        tablereadonly.setForeground(Color.black);
	        tablereadonly.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	       
	        tablereadonly.setFont(font);
	        tablereadonly.setRowHeight(30);
	        tablereadonly.getColumnModel().getColumn(8).setPreferredWidth(200);
	        tablereadonly.getColumnModel().getColumn(3).setPreferredWidth(100);
	        tablereadonly.getColumnModel().getColumn(9).setPreferredWidth(120);
	      //  table.getTableHeader().setResizingAllowed(true);
	       
	       
//		 panel_1 = new JPanel();
//		
//		contentPane.add(panel_1);
//		panel_1.add(table);
	        JTableHeader headerResumen = table.getTableHeader();
	        headerResumen.setResizingAllowed(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(487, 93, 800, 444);
		 contentPane.add(scrollPane);
//		 getDataFromMysql();
		 JLabel lblNewLabel = new JLabel("CaseID");
		 lblNewLabel.setBounds(10, 103, 45, 13);
		 contentPane.add(lblNewLabel);
		 
		 JLabel lblActionid = new JLabel("ActionID ");
		 lblActionid.setBounds(10, 142, 78, 13);
		 contentPane.add(lblActionid);
		 
		
		 
		 JLabel lblActionElement = new JLabel("Action Element");
		 lblActionElement.setBounds(10, 186, 113, 13);
		 contentPane.add(lblActionElement);
		 
		 JLabel lblAction = new JLabel("Action");
		 lblAction.setBounds(10, 262, 45, 13);
		 contentPane.add(lblAction);
		 
		 JLabel lblNeedWait = new JLabel("Need Wait");
		 lblNeedWait.setBounds(10, 304, 98, 13);
		 contentPane.add(lblNeedWait);
		 
		 JLabel lblElementType = new JLabel("Element type");
		 lblElementType.setBounds(10, 382, 98, 13);
		 contentPane.add(lblElementType);
		 
		 JLabel lblListlink = new JLabel("ListLink");
		 lblListlink.setBounds(10, 463, 78, 13);
		 contentPane.add(lblListlink);
		 
		 JLabel lblSeconedAction = new JLabel("Seconed Action");
		 lblSeconedAction.setBounds(10, 524, 98, 13);
		 contentPane.add(lblSeconedAction);
//		 getLastCase();
		 ActionIdT = new JTextField();
		 ActionIdT.setColumns(10);
		 ActionIdT.setBounds(151, 139, 308, 19);
		 contentPane.add(ActionIdT);
		 
		 LinkT = new JTextField();
		 LinkT.setColumns(10);
		 LinkT.setBounds(151, 220, 308, 19);
		 contentPane.add(LinkT);
		 
//		 ActionElemT = new JTextField();
//		 ActionElemT.setColumns(10);
//		 ActionElemT.setBounds(151, 237, 308, 19);
//		 contentPane.add(ActionElemT);
		 
//		 ActionT = new JTextField();
//		 ActionT.setColumns(10);
//		 ActionT.setBounds(151, 274, 308, 19);
//		 contentPane.add(ActionT);
		 
//		 NeedWaitT = new JTextField();
//		 NeedWaitT.setColumns(10);
//		 NeedWaitT.setBounds(151, 313, 308, 19);
//		 contentPane.add(NeedWaitT);
		 
//		 ElementTypT = new JTextField();
//		 ElementTypT.setColumns(10);
//		 ElementTypT.setBounds(151, 347, 308, 19);
//		 contentPane.add(ElementTypT);
		 
		 ListLinkT = new JTextField();
		 ListLinkT.setColumns(10);
		 ListLinkT.setBounds(151, 460, 308, 19);
		 contentPane.add(ListLinkT);
		 
//		 SecondAcT = new JTextField();
//		 SecondAcT.setColumns(10);
//		 SecondAcT.setBounds(151, 417, 308, 19);
//		 contentPane.add(SecondAcT);
		 
		 JLabel lblHaveSecondAction = new JLabel("Have Second Action");
		 lblHaveSecondAction.setBounds(10, 493, 124, 13);
		 contentPane.add(lblHaveSecondAction);
		 
//		 HaveSecondAcT = new JTextField();
//		 HaveSecondAcT.setColumns(10);
//		 HaveSecondAcT.setBounds(151, 452, 308, 19);
//		 contentPane.add(HaveSecondAcT);
		 table.addMouseListener(new MouseAdapter(){
		        
		        @Override
		        public void mouseClicked(MouseEvent e){
		            
		            // i = the index of the selected row
		            int i = table.getSelectedRow();
		            caseidL.setSelectedItem(model.getValueAt(i, 0).toString());
		            caseidL.setEditable(false);
                	ActionIdT.setText(model.getValueAt(i, 1).toString());
                	LinkT.setText(model.getValueAt(i, 2).toString());
                	actionElement.setSelectedItem(model.getValueAt(i, 3).toString());
                	actionC.setSelectedItem(model.getValueAt(i, 4).toString());
                	needWaitC.setSelectedItem(model.getValueAt(i, 5).toString());
                	elementTypeC.setSelectedItem(model.getValueAt(i, 6).toString());
                	ListLinkT.setText(model.getValueAt(i, 7).toString());
                	secondActC.setSelectedItem(model.getValueAt(i, 8).toString());
                	havesecondActC.setSelectedItem(model.getValueAt(i, 9).toString());
                	waitingP.setText(model.getValueAt(i, 10).toString()); 
                	WaitingTypeListC.setSelectedItem(model.getValueAt(i, 11).toString());
		        }
		        });
		 JButton save = new JButton("Save");
			save.setBackground(new Color(213, 240, 224));

		 save.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 save.setBounds(190, 584, 89, 25);
		 contentPane.add(save);
		 final Object[] row = new Object[12];
		 save.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            
	            	try {
						Save();
//						getLastActioId();
						
						rowCount++;
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						
						System.out.println("eeeeeeee///"+e.toString()); 
//						e.printStackTrace();
						
						
						saved=false;
						System.out.println("eeeeeeee///"+saved); 
						JOptionPane.showMessageDialog(null, e.toString());
					}
	           	 if(saved==true) {
		            	row[0] = caseidL.getSelectedItem().toString();
		                row[1] = ActionIdT.getText();
		                row[2] = LinkT.getText();
		                row[3] = actionElement.getSelectedItem().toString();
		                row[4] = actionC.getSelectedItem().toString();
		                row[5] = needWaitC.getSelectedItem().toString();
		                row[6] = elementTypeC.getSelectedItem().toString();
		                row[7] = ListLinkT.getText();
		                row[8] = havesecondActC.getSelectedItem().toString();
		                row[9] = secondActC.getSelectedItem().toString();
		                row[10]= waitingP.getText();
		                row[11]= WaitingTypeListC.getSelectedItem().toString();
		             
		                // add row to the model
		                model.addRow(row);
		                
		                
		               
		                actionIdList[rowCount]=ActionIdT.getText();
		        		System.out.println("actionIdList[rowCount]");
		        		System.out.println(actionIdList[rowCount]);


		                rowCount++;
		                
		            	 }
	           	clearBB();
	            }});
		 
		 JButton Update = new JButton("Update");
		 Update.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 Update.setBackground(new Color(181, 208, 244));
		//	btnNewUpdate.setBounds(95, 510, 89, 23);
		 Update.setBounds(278, 584, 83, 25);
		 contentPane.add(Update);
		 Update.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	int yesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to Update this case'"+ActionIdT.getText()+"'");
                // i = the index of the selected row
            	if(yesOrNo==0) {
	            	
	            	 int i = table.getSelectedRow();
		                
		                if(i >= 0) 
		                {
		                	

		                   model.setValueAt( caseidL.getSelectedItem().toString(), i, 0);
		                   model.setValueAt(ActionIdT.getText(), i, 1);
		                   model.setValueAt(LinkT.getText(), i, 2);
		                   model.setValueAt(actionElement.getSelectedItem().toString(), i, 3);
		                   model.setValueAt(actionC.getSelectedItem().toString(), i, 4);
		                   model.setValueAt(needWaitC.getSelectedItem().toString(), i, 5);
		                   model.setValueAt(elementTypeC.getSelectedItem().toString(), i, 6);
		                   model.setValueAt(ListLinkT.getText(), i, 7);
		                   model.setValueAt(secondActC.getSelectedItem().toString(), i, 8);
		                   model.setValueAt(havesecondActC.getSelectedItem().toString(), i, 9);
		                   model.setValueAt(waitingP.getText(),i,10);
		                   model.setValueAt(WaitingTypeListC.getSelectedItem().toString(),i,11);
		                   ActionIdT.setEditable(false);
		                   ActionIdT.setEnabled(false);
		                   try {
							Update();
							ActionIdT.setEditable(true);
			                   ActionIdT.setEnabled(true);
			                   clearBB();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                }
		                else{
		                    System.out.println("Update Error");
		                }}
		            }	
	            
	            	
		 });
		 JButton delete = new JButton("Delete");
			delete.setBackground(new Color(181, 208, 244));

		 delete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 delete.setBounds(359, 584, 100, 25);
		 contentPane.add(delete);
		 delete.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	int yesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure to delete this case'"+caseidL.getSelectedItem().toString()+"'");
	            	
	            	if(yesOrNo==0) {
	            	 int i = table.getSelectedRow();
		                if(i >= 0){
		                    // remove a row from jtable
		                    model.removeRow(i);
		                   ActionIdT.setEditable(false);
		                   ActionIdT.setEnabled(false);
		                   try {
							Delete();
							ActionIdT.setEditable(true);
			                   ActionIdT.setEnabled(true);
			                   clearBB();
//			                   getLastActioId();
			                   if(rowCount>0) {
			                	   rowCount--;
			                   }
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
		 
		 JButton next = new JButton("Next");
			next.setBackground(new Color(213, 240, 224));

		 next.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setVisible(false);
				AddInputs frame11 = new AddInputs();
		 		
				frame11.setSize(1000, 700);
		 		frame11.setVisible(true);
		 	}
		 });
		
		 next.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 next.setBounds(1135, 601, 78, 25);
		 contentPane.add(next);
		 
		 JLabel lblNewLabel_1 = new JLabel("ACTION TABLE");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		 lblNewLabel_1.setBounds(549, 31, 148, 13);
		 contentPane.add(lblNewLabel_1);
	
		 JLabel lblLink = new JLabel();
		 lblLink.setBounds(10, 223, 45, 13);
		 lblLink.setText("Link");
		 contentPane.add(lblLink);
		 
		 actionElement = new JComboBox(actionElementList);
		 actionElement.setBounds(151, 182, 308, 21);
		 contentPane.add(actionElement);
		
		 
		  actionC = new JComboBox(actionsList);
		 actionC.setBounds(151, 258, 308, 21);
		 contentPane.add(actionC);
		 
		  needWaitC = new JComboBox(needWaitList);
		 needWaitC.setBounds(151, 300, 308, 21);
		 contentPane.add(needWaitC);
		 needWaitC.addActionListener(new ActionListener() {
	            @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e1) {
	            	if(needWaitC.getSelectedItem()=="no") {
	            		waitingP.setEnabled(false);
	            		waitingP.setEditable(false);
	            		WaitingTypeListC.setSelectedItem("//");
	            		WaitingTypeListC.setEnabled(false);
	            	}
	            	else {
	            		waitingP.setEnabled(true);
	            		waitingP.setEditable(true);
	            		
	            		WaitingTypeListC.setEnabled(true);
	            	}
	            }});
		 
		 elementTypeC = new JComboBox(elementTypeList);
		 elementTypeC.setBounds(151, 378, 308, 21);
		 contentPane.add(elementTypeC);
		 ListLinkT.setEnabled(false);
 		ListLinkT.setEditable(false);
		 elementTypeC.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	if(elementTypeC.getSelectedItem().toString().equals("list")||elementTypeC.getSelectedItem().toString().equals("table")) {
	            		ListLinkT.setEditable(true);
	            		ListLinkT.setEnabled(true);
	            		
	            		
	            	} if(elementTypeC.getSelectedItem().toString().equals("single")){
	            		ListLinkT.setEnabled(false);
	            		ListLinkT.setEditable(false);

	            	}
	            	
	            	
	            }});
		 
		  secondActC = new JComboBox(secondActList);
		 secondActC.setBounds(151, 520, 308, 21);
		 contentPane.add(secondActC);
		 
		  havesecondActC = new JComboBox(HaveSecondActList);
		 havesecondActC.setBounds(151, 489, 308, 21);
		 contentPane.add(havesecondActC);
		 
		 JButton clear = new JButton("Clear");
		 clear.setForeground(new Color(0, 0, 0));
		 clear.setBackground(new Color(231, 213, 192));
		 clear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 clear.setBounds(95, 584, 100, 25);
		 contentPane.add(clear)
;
		 clear.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	clearBB();
	            }});
		 
		 JButton readonly = new JButton("Show All Table");
		 readonly.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 readonly.setBounds(1163, 49, 124, 33);
		 contentPane.add(readonly);
//		 int count = 0;
//		 for(int i=0;i<ss.length;i++) {
//			 if(!ss[i].equals("//")) {
//				updated= new String[ss.length - 1];
//		  
//		                updated[count++] = ss[i];
//		            }else {
//		            	updated=ss;
//		            }
//		        }
		 
		  caseidL = new JComboBox(ss)
;
		 caseidL.setBounds(151, 93, 308, 21);
		 contentPane.add(caseidL);
		 
		 JLabel lblNewLabel_3 = new JLabel("Waiting Period");
		 lblNewLabel_3.setBounds(10, 341, 98, 13);
		 contentPane.add(lblNewLabel_3);
		 
		 waitingP = new JTextField();
		 waitingP.setBounds(151, 338, 308, 19);
		 contentPane.add(waitingP);
		 waitingP.setColumns(10);
		 
		 JButton btnNewButton = new JButton("Back");
		 btnNewButton.setBackground(new Color(176, 196, 222));
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 btnNewButton.setBounds(1061, 601, 78, 25);
		 contentPane.add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	setVisible(false);
	            	AddTestCaseJJ frame;
					frame = new AddTestCaseJJ();
					frame.setSize(1118, 700);
					frame.setVisible(true);
					dispose();
				
	            	
	            }});
		 JLabel waitingType = new JLabel("Waiting Type ");
		 waitingType.setBounds(10, 429, 78, 13);
		 contentPane.add(waitingType);
		 
		  WaitingTypeListC = new JComboBox(waitingTypeList);
		 WaitingTypeListC.setBounds(151, 425, 308, 21);
		 contentPane.add(WaitingTypeListC);
//		 getLastActioId();
		 havesecondActC.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e1) {
	            	if(havesecondActC.getSelectedItem().toString().equals("no")) {
	            		secondActC.setSelectedItem(secondActList[2]);
	            		secondActC.setEditable(false);
	            		secondActC.setEnabled(false);
	            	}else {
	            		
	            		secondActC.setEnabled(true);
	            	}
	            	
	            	
	            }});
		 readonly.addActionListener(new ActionListener() {
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
		 
		 
	}
	public void Save() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			
			//execute query 
			//stmt=con.createStatement();
			 
			String sql="INSERT INTO QA_Automation.DBO.ACTIONS (caseid,actionId, link, actionElement, actionName, needWait, elementType, lisItemlink, secondAction, haveSecondAction,waitingPeriode,waitingType) VALUES (?,?, ?, ?,?, ?, ?, ?,?, ?,?,?)";
			 PreparedStatement preparedStmt = con.prepareStatement(sql);
			  preparedStmt.setString (1, caseidL.getSelectedItem().toString());
			  preparedStmt.setString (2, ActionIdT.getText());
			  preparedStmt.setString (3, LinkT.getText());
			  preparedStmt.setString (4, actionElement.getSelectedItem().toString());
			  preparedStmt.setString (5, actionC.getSelectedItem().toString());
			  preparedStmt.setString (6, needWaitC.getSelectedItem().toString());
			  preparedStmt.setString (7, elementTypeC.getSelectedItem().toString());
			  preparedStmt.setString (8, ListLinkT.getText());
			  preparedStmt.setString (9, secondActC.getSelectedItem().toString());
			  preparedStmt.setString (10, havesecondActC.getSelectedItem().toString());
			  preparedStmt.setString (11, waitingP.getText());
			  preparedStmt.setString (12, WaitingTypeListC.getSelectedItem().toString());
			  preparedStmt.execute();
			
			// TODO Auto-generated catch block
//			result.close();
//			stmt.close();
			con.close();
			saved=true;
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//INSERT INTO `automation`.`testcase` (`id`, `caseName`) VALUES ('S3', 'tt');
//		private JTextField caseid;
//		private JTextField ActionIdT;
//		private JTextField LinkT;
//		private JTextField ActionElemT;
//		private JTextField ActionT;
//		private JTextField NeedWaitT;
//		private JTextField ElementTypT;
//		private JTextField ListLinkT;
//		private JTextField SecondAcT;
//		private JTextField HaveSecondAcT;
	}
	public void Update() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			//execute query 
			//stmt=con.createStatement();
			 
			String sql="update QA_Automation.DBO.ACTIONS set link = ?,actionElement = ?,actionName = ?,needWait = ?,elementType = ?,ListItemLink = ?, secondAction= ?,haveSecondAction = ? ,waitingPeriode=?,waitingType=? where actionId = ?";
			 PreparedStatement preparedStmt = con.prepareStatement(sql);
			// preparedStmt.setString (2, ActionIdT.getText());
			  preparedStmt.setString (1, LinkT.getText());
			  preparedStmt.setString (2, actionElement.getSelectedItem().toString());
			  preparedStmt.setString (3, actionC.getSelectedItem().toString());
			  preparedStmt.setString (4, needWaitC.getSelectedItem().toString());
			  preparedStmt.setString (5, elementTypeC.getSelectedItem().toString());
			  preparedStmt.setString (6, ListLinkT.getText());
			  preparedStmt.setString (7, secondActC.getSelectedItem().toString());
			  preparedStmt.setString (8, havesecondActC.getSelectedItem().toString());
			  preparedStmt.setString (9, waitingP.getText());
			  preparedStmt.setString (10, WaitingTypeListC.getSelectedItem().toString());
			 preparedStmt.setString (11, ActionIdT.getText());
			 
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
			//execute query 
			//stmt=con.createStatement();
			 
			String sql="DELETE FROM QA_Automation.DBO.ACTIONS WHERE actionId=?";
			 PreparedStatement preparedStmt = con.prepareStatement(sql);
			  preparedStmt.setString (1, ActionIdT.getText());
			  
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
	
//public void getLastActioId() throws SQLException {
//		
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con=DriverManager.getConnection(url);
//			//execute query 
//			//stmt=con.createStatement();
//			 
//			stmt=con.createStatement();
//			String sql="SELECT * FROM QA_Automation.DBO.ACTIONS ORDER BY actionId DESC LIMIT 1";
//			result=stmt.executeQuery(sql);
//			while(result.next()) {
//		
//			ActionId=result.getString("actionId");
//			}
//			lblNewLabel_2_1.setText(ActionId);
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
	
	caseidL.setSelectedItem(actionElementList[0]);
	ActionIdT.setText("");
	LinkT.setText("");
	ListLinkT.setText("");
	waitingP.setText("");
	actionElement.setSelectedItem(actionElementList[0]);
	actionC.setSelectedItem(actionsList[0]);
	needWaitC.setSelectedItem(needWaitList[0]);
	elementTypeC.setSelectedItem(elementTypeList[0]);
	secondActC.setSelectedItem(secondActList[0]);
	havesecondActC.setSelectedItem(HaveSecondActList[0]);
	WaitingTypeListC.setSelectedIndex(0);

}



public void getDataFromMysql() throws SQLException {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection(url);
		
		//execute query 
		//stmt=con.createStatement();
		 
		stmt=con.createStatement();
		String sql="SELECT * FROM QA_Automation.DBO.ACTIONS";
		result=stmt.executeQuery(sql);
		while(result.next()){

            Object o[] = {result.getString("caseid"),result.getString("actionId"),result.getString("link"),result.getString("actionElement"),result.getString("actionName"),result.getString("needWait"),result.getString("elementType"),result.getString("lisItemLink"),result.getString("secondAction"),result.getString("haveSecondAction"),result.getString("waitingPeriode"),result.getString("waitingType")};
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
}
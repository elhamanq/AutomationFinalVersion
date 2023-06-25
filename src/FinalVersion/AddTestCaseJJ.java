// Test Cases
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
import java.awt.event.MouseMotionListener;
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


import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import javax.swing.border.EtchedBorder;
/*
 * 
 * Author: Amal Kmail
 */


public class AddTestCaseJJ extends JFrame{
	


//	private JFrame frame4;
	static String[] CaseidList=new String[100];
	private JTextField txtcaseId;
	private JTextField txtcaseName;
	private static JTable table;
	//static List AddedCases=null;
   // private List<Object> testcases;
    //static List<String> testcases = new ArrayList<>();
	static String array1[]=new String[10];
	static int rowCount;




	 
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTestCaseJJ frame4 = new AddTestCaseJJ();
					frame4.setVisible(true);
					frame4.setBounds(100, 100, 912, 400);
					frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				//JAVAFXJ.main(null);
			}
		});
	}


	 
	public AddTestCaseJJ() {
		initialize();
		getdata();
	//	table_load();
	}


	private void initialize() {
		
	//	frame4 = new JFrame();
	//	frame4.setBounds(100, 100, 912, 400);
	//	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Test Cases", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Case ID");
		lblNewLabel_3.setBounds(58, 55, 118, 26);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
		txtcaseId = new JTextField();
		txtcaseId.setBounds(126, 59, 96, 20);
		txtcaseId.setColumns(10);
		panel.add(txtcaseId);
        //jTableMouseClicked(e);

		
		/**/
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(245, 237, 207));
		btnNewButton.setBounds(726, 58, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{			
				String caseId,caseName;
				caseId = txtcaseId.getText();
				caseName=txtcaseName.getText();
				
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
					//execute query 
						
						
						
						
					stmt=con.prepareStatement("INSERT INTO QA_Automation.DBO.TEST_CASES (id,caseName)values(?,?)");
					//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
					
					stmt.setString(1,caseId);
					stmt.setString(2,caseName);

					stmt.executeUpdate();
					
					 final Object[] row = new Object[2];
					  row[0] = txtcaseId.getText();
		                row[1] = txtcaseName.getText();
		            	DefaultTableModel model=(DefaultTableModel)table.getModel();
		                model.addRow(row);
		                CaseidList[rowCount]=txtcaseId.getText();
		                rowCount++;
		                
		                // add row to the model
		           //     model.addRow(row);
					//table_load();
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
		btnNewUpdate.setBounds(95, 510, 89, 23);
		btnNewUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caseName,caseId;
				caseId = txtcaseId.getText();
				caseName=txtcaseName.getText();
				 try {	String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
						
						
						stmt=con.prepareStatement("UPDATE QA_Automation.DBO.TEST_CASES SET caseName=? WHERE id=? ");
						//String sql="INSERT INTO QA_Automation.DBO.DATASETS (setId,setName,setValue,caseid,inputid)values(?,?,?,?)";
						stmt.setString(2,caseName);
						stmt.setString(1,caseId);
						
						
						

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
		btnDelete.setBounds(194, 510, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caseIddel=txtcaseId.getText();
				try {
					String username="qa";
					String	password="qa";
					String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
			       
					Connection con=null;
					PreparedStatement stmt=null;
					ResultSet result=null;
					
						//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						con=DriverManager.getConnection(url);
					
				stmt = con.prepareStatement("DELETE FROM QA_Automation.DBO.Test_Cases WHERE id =?");
				stmt.setString(1, caseIddel);
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
		
		JLabel lblNewLabel_3_1 = new JLabel("Case Name");
		lblNewLabel_3_1.setBounds(293, 55, 118, 26);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_3_1);
		
		txtcaseName = new JTextField();
		txtcaseName.setBounds(406, 59, 96, 20);
		txtcaseName.setColumns(10);
		panel.add(txtcaseName);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(58, 176, 879, 323);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setBackground(new Color(255, 240, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "CaseID", "CaseName" //"Action",
			}
		));
		//  table.getColumn("Action").setCellRenderer(new ButtonRenderer());
	       // table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
	        
	        
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setRowHeight(30);
		scrollPane_1.setViewportView(table);
table.addMouseListener(new MouseListener() {
			
			private void jTableMouseClicked(ActionEvent e) {
			

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
		        String tblcaseId=tblModel.getValueAt(table.getSelectedRow(), 0).toString();//1
		        String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 1).toString();//2

		     //   String tblcaseName=tblModel.getValueAt(table.getSelectedRow(), 2).toString();
		        
		      //  txtcaseId.setText(tblcaseId);
		       // txtcaseName.setText(tblcaseName);
				if(table.getSelectedRowCount()==1) {
				txtcaseId.setText(tblcaseId);//.getValueAt(table.getSelectedRow(), 2).toString()
				txtcaseName.setText(tblcaseName);
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
		btnNewButton_1.setBounds(848, 510, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.out.println(txtcaseId.getText());
				setVisible(false);
			//	AddedCases=AddedTestCases();
				NewActionJ frame11=null;
				try {
					frame11 = new NewActionJ();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		//frame1.setSize(1118, 700);
				frame11.setSize(1000, 700);
		 		frame11.setVisible(true);
				//AddInputs.main(null,AddedCases);
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
		btnNewButton_2.setBounds(143, 154, 52, 23);
		panel.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Clear");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AddedCases=AddedTestCases();
getdata();
			//	array1 = new String[testcases.size()];
				//for(int k = 0; k < testcases.size(); k++) 
					//array1[k] = (String) testcases.get(k);
				
		    
			}
		});
		btnNewButton_3.setBounds(58, 154, 89, 23);
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
		btnNewButton_4.setBounds(278, 510, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcaseId.setText("");
				txtcaseName.setText("");
				
			}
		});
		
		
		btnNewButton_5.setBounds(814, 58, 89, 23);
		panel.add(btnNewButton_5);
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
		
for(int i=0;i<CaseidList.length;i++)			

{//System.out.println(CaseidList[i]);
		String sql="SELECT * FROM [QA_Automation].[dbo].[TEST_CASES] WHERE id ='"+CaseidList[i]+"'";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
		result=stmt.executeQuery(sql);

		while(result.next()) {
		
			
			
			//	model.removeRow(i);
            Object o[] = {result.getString("id"),result.getString("caseName")};
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
		{String caseid=txtcaseId.getText();
		String caseName=txtcaseName.getText();
		
		tblModel.setValueAt(caseid, table.getSelectedRow(), 0);
		tblModel.setValueAt(caseName, table.getSelectedRow(), 1);
		
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
			PreparedStatement stmt=null;
			ResultSet result=null;
			
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection(url);
			
			//execute query 
				stmt=con.prepareStatement("SELECT * FROM [QA_Automation].[dbo].[TEST_CASES] WHERE id=?");
			//String sql="SELECT * FROM [QA_Automation].[dbo].[TEST_CASES] WHERE caseid=?";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
				stmt.setString(1,txtcaseId.getText());
			result=stmt.executeQuery();
			 
		//	table.setModel(DbUtils.resultSetToTableModel(result));
			 System.out.println(result.getType());
			// JsonArray datasets = new JsonArray();
				DefaultTableModel model=(DefaultTableModel)table.getModel();
			//	toString(result);
		    	//while(result.next()) {
		    	//	JSONObject jsonObject = (JSONObject) JSONParser.parse(result);
		    	//	jsonObject.get("caseid");
		    	//	jsonObject.get("inputid");
		    	//	jsonObject.get("setName");
		    	//	jsonObject.get("setValue");
		    	//	jsonObject.get("setId");
		    	model.addRow(new Object[] {
		    			//"",
		    			txtcaseId.getText(),
		    			txtcaseName.getText()
		    			});//}
	
		System.out.println(model.getRowCount());	 ;
	} 
    	catch (SQLException e) 
    	 {
    		e.printStackTrace();
	  } 
    
    			
    			
    	
    }
  
/*	public static List AddedTestCases() {
	//	DefaultTableModel model=(DefaultTableModel)table.getModel();
		int AddedCasesNum=table.getModel().getRowCount();
		System.out.println("row count main");

		System.out.println(AddedCasesNum);

		for (int i = 0; i < AddedCasesNum; i++) 
		 
		   testcases.add((String) table.getModel().getValueAt(i, 0));//table.getModel().getValueAt(i, 0)
		System.out.println("asas main");

		System.out.println(testcases);
		return testcases;
	}
	*/
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
				String sql="SELECT * FROM [QA_Automation].[dbo].[TEST_CASES] ";//SELECT * FROM [QA_Automation].[dbo].[DATASETS] FOR JSON PATH,WITHOUT_ARRAY_WRAPPER
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
	AddTestCaseJJ classtest=new AddTestCaseJJ();
    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
    //    button.setText("rr");
       // button.setOpaque(true);
      //  button.addActionListener(new ActionListener() {
    //        @Override
          //  public void actionPerformed(ActionEvent e) {
         //       fireEditingStopped();
        //    }
     //   });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
     //       button.setForeground(table.getSelectionForeground());
      //      button.setBackground(table.getSelectionBackground());
        } else {
        //    button.setForeground(table.getForeground());
          //  button.setBackground(table.getBackground());
        }
     //   label = (value == null) ? "" : value.toString();
       // button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
           // JOptionPane.showMessageDialog(button, label + ": Ouch!");
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



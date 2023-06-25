package FinalVersion;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JButton;

import javax.swing.JTable;


public class TableActionCellRender extends DefaultTableCellRenderer {
	
	public Component getTableCellREnderComponent(JTable jtable,Object o,Boolean bln,Boolean bln1,int i ,int i1){
		// TODO Auto-generated method stub
		Component com=super.getTableCellRendererComponent( jtable, o, bln, bln1, i , i1);
		PanelAction action=new PanelAction();
		return com;}
	

}

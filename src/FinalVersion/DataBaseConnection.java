package FinalVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	private String sqlpro;
	
	public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		dataBase();

		//fillData();
		
		
	} 
	
	

	public static void dataBase() throws SQLException, ClassNotFoundException {
		String username="qa";
		String	password="qa";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						//	String	connUrl="jdbc:sqlserver://192.168.20.6\\MSSQLSERVER2017;database=QA_Automation;integratedSecurity=true;";
		String	url = "jdbc:sqlserver://192.168.20.6;instanceName=MSSQLSERVER2017;databaseName=QA_Automation;integratedSecurity=false;user=qa;password=qa;Trusted_Connection=No;";		
       
		Connection con=null;
		Statement stmt=null;
		ResultSet result=null;
		
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url);
			
			//execute query 
			stmt=con.createStatement();
			String sql="SELECT * FROM QA_Automation.DBO.TEST_CASES";
			result=stmt.executeQuery(sql);
			while(result.next()) {
				
			System.out.println(result.getString("caseName"));
			
			}
			// TODO Auto-generated catch block
			result.close();
			stmt.close();
			con.close();
		
		
		
	
		
	
}


	public DataBaseConnection() {
		super();
	}


	public DataBaseConnection(String sqlpro) {
		super();
		this.sqlpro = sqlpro;
	}


	public String getSqlpro() {
		return sqlpro;
	}


	public void setSqlpro(String sqlpro) {
		this.sqlpro = sqlpro;
	}
	
}
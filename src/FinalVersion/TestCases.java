package FinalVersion;
/*
 * 
 * Author: Elham Aqawi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestCases {
	private String caseId;
	private String caseName;
	ArrayList<Actions>  action;
	public TestCases(String caseId, String caseName,ArrayList<Actions> ac) {
		super();
		this.caseId = caseId;
		this.caseName = caseName;
		this.action=ac;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	
	
}

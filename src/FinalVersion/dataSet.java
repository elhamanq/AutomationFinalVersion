package FinalVersion;

import java.util.ArrayList;

/*
 * 
 * Author: Elham Anqawi
 */
public class dataSet {
	private String caseName;
	private ArrayList<String> setName;
	
	public dataSet() {
		super();
	}
	public dataSet(String caseName, ArrayList<String> setName) {
		super();
		this.caseName = caseName;
		this.setName = setName;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public ArrayList<String> getSetName() {
		return setName;
	}
	public void setSetName(ArrayList<String> setName) {
		this.setName = setName;
	}
	
	
}

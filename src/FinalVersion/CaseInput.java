package FinalVersion;
/*
 * 
 * Author: Elham Aqawi
 */
public class CaseInput {
	private String caseId;
	private String inputId;
	private String actionId;
	private String inputName;
	public CaseInput(String caseId, String inputId, String actionId, String inputName) {
		super();
		this.caseId = caseId;
		this.inputId = inputId;
		this.actionId = actionId;
		this.inputName = inputName;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getInputId() {
		return inputId;
	}
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	
	
	
	
	
	
	
}

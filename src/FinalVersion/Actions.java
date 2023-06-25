package FinalVersion;

/*
 * 
 * Author: Elham Anqawi
 */
public class Actions {

private String caseId;
private String actionId;
private String Link;
private String acationElement;
private String actionName;
private String needWait;
private String type;
private String listItemLink;
private String seconedAction;
private String haveSeconedAction;
private int waitingPeriode;
private String waitingtype;
public Actions(String caseId, String actionId, String link, String acationElement, String actionName,String needWait,String type,String listItemLink, String seconedAction,String haveSeconedAction,int waitingPeriode,String waitingtype) {
	super();
	this.caseId = caseId;
	this.actionId = actionId;
	Link = link;
	this.acationElement = acationElement;
	this.actionName = actionName;
	this.needWait=needWait;
	this.type=type;
	this.listItemLink=listItemLink;
	this.seconedAction=seconedAction;
	this.haveSeconedAction=haveSeconedAction;
	this.waitingPeriode=waitingPeriode;
	this.waitingtype=waitingtype;
}
public int getWaitingPeriode() {
	return waitingPeriode;
}
public void setWaitingPeriode(int waitingPeriode) {
	this.waitingPeriode = waitingPeriode;
}
public String getCaseId() {
	return caseId;
}
public void setCaseId(String caseId) {
	this.caseId = caseId;
}
public String getActionId() {
	return actionId;
}
public String getWaitingtype() {
	return waitingtype;
}
public void setWaitingtype(String waitingtype) {
	this.waitingtype = waitingtype;
}
public void setActionId(String actionId) {
	this.actionId = actionId;
}
public String getLink() {
	return Link;
}
public void setLink(String link) {
	Link = link;
}
public String getAcationElement() {
	return acationElement;
}
public void setAcationElement(String acationElement) {
	this.acationElement = acationElement;
}
public String getActionName() {
	return actionName;
}
public void setActionName(String actionName) {
	this.actionName = actionName;
}
public String getNeedWait() {
	return needWait;
}
public void setNeedWait(String needWait) {
	this.needWait = needWait;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getListItemLink() {
	return listItemLink;
}
public void setListItemLink(String listItemLink) {
	this.listItemLink = listItemLink;
}
public String getSeconedAction() {
	return seconedAction;
}
public void setSeconedAction(String seconedAction) {
	this.seconedAction = seconedAction;
}
public String getHaveSeconedAction() {
	return haveSeconedAction;
}
public void setHaveSeconedAction(String haveSeconedAction) {
	this.haveSeconedAction = haveSeconedAction;
}


	
	
	
	
	
}

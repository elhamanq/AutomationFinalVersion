package FinalVersion;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import graphql.Assert;
/*
 * 
 * Author: Elham Aqawi
 */
//public class pproj {
//static String set="http://5.189.179.150/APEX/";
//static WebDriver web=new ChromeDriver();
//static WebDriverWait wait = new WebDriverWait(web, Duration.ofSeconds(10));
//	@SuppressWarnings("deprecation")
	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


	//	loadAnonymous();
		
		//fillData();
		
		
	//} 
	//public  static void loadAnonymous() throws InterruptedException {
		 //System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 
		// WebDriver web=new ChromeDriver();
		
		// web.get(set);
	//	login();
	//	  Thread.sleep(1000);
		  /////////////////////////////////// to register patient by load anonymous 
	//	  List<WebElement> list2 = web.findElements(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_menuActions\"]/ul"));
		
		//	 System.out.println(list2.size());
		//	 for(WebElement b: list2) {
				
				
		//		 WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_menuActions_DXI2_T\"]")));
		//		 element3.click();
				 
		//		 Thread.sleep(3000);
		//			  web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_menuActions_DXI0_T\"]")).click();
		///			  System.out.println("s33");
		//			  Thread.sleep(3000);  
				
				 
		// }
			// encounter();
						 
	//}
	
	//public static void fillData() throws InterruptedException {
	//	login();
		
	//	  Thread.sleep(1000);
		//	 WebElement element4= web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_cmbDocumentCountry_I\"]"));

		//	 element4.sendKeys(Keys.CONTROL + "a");
		//	 element4.sendKeys(Keys.DELETE);
		//	 element4.sendKeys("Palestine");
		     //Thread.sleep(10000);
		//	  WebElement element14=web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_cmbDocumentType_I\"]"));
		//	     element14.sendKeys(Keys.CONTROL + "a");
			//	 element14.sendKeys(Keys.DELETE);
			//     element14.sendKeys("National ID");
			//     WebElement el17=web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_txtNationalID_I"));
			///     el17.sendKeys("1331154439");
		    //
			// WebElement element11=web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_cmbCountry_I"));
			// element11.sendKeys(Keys.CONTROL + "a");
		//	 element11.sendKeys(Keys.DELETE);
		//	 element11.sendKeys("Palestine");
			// Thread.sleep(5000);
			 
		//	 WebElement element10= web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_cmbGender_I"));
		//	 element10.sendKeys(Keys.CONTROL + "a");
		//	 element10.sendKeys(Keys.DELETE);
		//	 element10.sendKeys("Female");
			 
			 
			
		//	 WebElement element13= web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_txtCellularPhone1_I"));
			// element13.sendKeys("0598875979");
			
			// WebElement element5= web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_txtFirstName_I"));
			// element5.sendKeys("doaa");
			// WebElement element6= web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_txtSecoundName_I"));
		//	 element6.sendKeys("najeeb");
			// WebElement element7= web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_txtTherdName_I"));
		//	 element7.sendKeys("hamdan");
		//	 WebElement element8= web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_txtLastName_I"));
		//	 element8.sendKeys("anqawi");
			
		//	 WebElement element9=web.findElement(By.id("ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_PC_2_dateBirthDate_I"));
			// element9.sendKeys(Keys.CONTROL + "a");
			// element9.sendKeys(Keys.DELETE);
		//	 element9.sendKeys("11112000");

		//	  List<WebElement> list2 = web.findElements(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_menuActions\"]/ul"));
		//	 System.out.println("test");
			//	 System.out.println(list2.size());
			//	 for(WebElement b: list2) {
			//		 System.out.println("s");
				
			//			  web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ucRegistration1_ASPxCallbackPanel1_ASPxFormLayout1_menuActions_DXI0_T\"]")).click();
			//			  System.out.println("s33");
			//			  Thread.sleep(3000); 
					
			//	 }	
			//	 encounter();
	//}
	//public static void login() throws InterruptedException {
 //System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 
		 
		
	//	 web.get(set);
		 
	//	 System.out.println("title"+web.getTitle());
		// web.findElement(By.id("ctl00_MainContent_LoginRoundedPanel_ASPxFormLayout1_cmbFacility_I")).sendKeys("Luanda Medical Center");
		// System.out.println("title"+web.getTitle());
		// web.findElement(By.id("tbUserName_I")).sendKeys("admin");
	//	 System.out.println("title"+web.getTitle());
		
	//	 WebElement element = wait.until(
	//			 ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_MainContent_LoginRoundedPanel_ASPxFormLayout1_tbPassword_I\"]")));
	//	element.sendKeys("demo12345");

		//  
		// System.out.println("pass");

		// System.out.println("pass");
		// web.findElement(By.id("ctl00_MainContent_LoginRoundedPanel_ASPxFormLayout1_cmbLanguage_I")).sendKeys("English");
	     
		// web.findElement(By.xpath("//*[@id=\"ctl00_MainContent_LoginRoundedPanel_ASPxFormLayout1_btnLogin_CD\"]")).click();
	//	 web.findElement(By.id("ctl00_ctl00_A1")).click();
	//	 WebElement el= wait.until(
	//			 ExpectedConditions.elementToBeClickable(By.id("FilterInput")));
	//	 el.sendKeys("Registration department");
	//	 Thread.sleep(1000);
	//	 el.sendKeys(Keys.ENTER);
//		 el = wait.until(
//				 ExpectedConditions.elementToBeClickable(By.id("FilterInput")));
	//	
//		 el.click();
		 
		 
		// Thread.sleep(100);
		// List<WebElement> list = web.findElements(By.xpath("//*[@id=\"mnDepartments\"]"));
		 
		// System.out.println(list.size());
	
		// System.out.println(list.get(0).getText());
		
		
		// for(WebElement b: list) {
			
//			 String c=b.getText();
		//	 Thread.sleep(1000);
//			 if(c.equalsIgnoreCase("Registration Department")) {
				
			
		//		 WebElement element2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mnDepartments\"]/li[31]/a")));
		//	 element2.click();
		//	 break;
//			 }
			
		// }
//

		 
		 // to click on registration module 
		//  web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_ASPxPanel1_dvHomeScreen_ICell\"]/table/tbody/tr/td/div[42]/div/div/div[2]/a[2]")).click();
		  
		
	//}
	//public static void encounter() throws InterruptedException {
		 // pass to encounter page 
	//	 List<WebElement> list3 = web.findElements(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolderMenuItems_MenuBinder_MenuBinder_Callback_MenuBinder_mMain\"]/ul"));
	//	 for(WebElement b: list3) {
			// System.out.println("s");
			
		
				
		//	 WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_ctl00_ContentPlaceHolderMenuItems_MenuBinder_MenuBinder_Callback_MenuBinder_mMain_DXI1_T\"]")));
		//	 element3.click();
			 
			// Thread.sleep(3000);
				 
				 
				//  }
//		 if(web.getCurrentUrl().equalsIgnoreCase("http://213.6.189.191/Caritas_Test/modules/admission/Encounter.aspx?patient_id=P100196")) {
//			 System.out.println("pass to encounter page successfully");
//		 }
//		 else {
//			 System.out.println("try again");
//		 }
//		WebElement encType=web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_CallbackPanel_EncounterTypeComboBox_I\"]"));
//		encType.sendKeys(Keys.CONTROL + "a");
//		encType.sendKeys(Keys.DELETE);
//		encType.sendKeys("Inpatient");
		
	//	WebElement dep=web.findElement(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_CallbackPanel_cobDepartment_I\"]"));
	//	dep.sendKeys(Keys.CONTROL + "a");
	//	dep.sendKeys(Keys.DELETE);
	//	Thread.sleep(3000);
	//	dep.sendKeys("Surgical Clinic");

	//	 List<WebElement> list4 = web.findElements(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_CallbackPanel_menuActions\"]/ul"));
	//	 for(WebElement b: list4) {
			
			
		
	//		 WebElement save = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_ctl00_Content_MainContent_CallbackPanel_menuActions_DXI0_T\"]")));
	//		 save.click();
	//	 Thread.sleep(3000);
//
	//		 WebElement msg=web.findElement(By.xpath("//*[@id=\"lblSystemNotification\"]"));
	//		 String text=msg.getText();

	//		 if (msg.isEnabled() && text.contains("Save successfully"))
	//		 { 
	//		     System.out.println("Successfully completed");
	//		 }else{
	//		     System.out.println("Please enter all details");
	//		 }
		//	 Thread.sleep(3000);
				 
				
			//	  }
//
	//}/
		
	
//}


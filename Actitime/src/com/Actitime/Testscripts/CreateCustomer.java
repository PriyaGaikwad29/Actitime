package com.Actitime.Testscripts;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.Filelibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;
@Listeners(ListenerImplementation.class)
public class CreateCustomer extends Baseclass {
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasklnk().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewBtn().click();
		tp.getNewCust().click();
		Filelibrary f=new Filelibrary();
		String customername = f.readDataFromExcel("CUSTOMER", 4, 1);
		tp.getCustname().sendKeys(customername);
		String customerdesp = f.readDataFromExcel("CUSTOMER", 4, 2);
		Assert.fail();
		tp.getCustdesp().sendKeys(customerdesp);
		tp.getCreatebtn().click();
		
	}
	
	

	
}

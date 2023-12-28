package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class Baseclass {
	Filelibrary f=new Filelibrary();
	public static	WebDriver driver;
	@BeforeSuite
	public void connectDatabase() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("browser launched",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.readDataFromPropertyFile("un");
		String pw = f.readDataFromPropertyFile("pw");
	LoginPage lp=new LoginPage(driver);
	lp.getUntbx().sendKeys(un);
	lp.getPwtbx().sendKeys(pw);
	lp.getLgbtn().click();
		Reporter.log("loged in successfully",true);
		
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLgbtn().click();
		Reporter.log("loggedout successfully",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed successsfully",true);
	}
	
	@AfterSuite
	public void databaseDisconnect() {
		Reporter.log("database disconnected",true);
	}


}

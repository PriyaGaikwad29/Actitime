package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement AddnewBtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement NewCust;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement Custname;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createbtn;
	
	@FindBy(xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancelbtn;
	
	//initilization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddnewBtn() {
		return AddnewBtn;
	}

	public WebElement getNewCust() {
		return NewCust;
	}

	public WebElement getCustname() {
		return Custname;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	
	

}

package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClinicSelector {

	@FindBy (xpath="//span[contains(text(),'Houston Heart Rhythm')]")
	private WebElement clinicSelecter;
	
	
	public ClinicSelector(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	
	public void selectClinic() 
	{	
		clinicSelecter.click();
	}
	
	
}

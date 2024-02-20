package com.qa.testScripts;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import com.qa.generic.BaseLib;
import com.qa.generic.ExcelLib;
import com.qa.generic.GetPropertyValues;
import com.qa.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTechnician extends BaseLib {
	
	String sTestCaseID=null;
	String[] sData=null;

	@Test //(retryAnalyzer = RetryAnalyzer.class)
	public void VerifyTechnicianLogin() throws InterruptedException 
	{
		test = report.startTest("Current status Test execution starts");
		sTestCaseID="current_status";
		//sData=ExcelLib.toReadExcelData(sTestCaseID);
		LoginPage lp = new LoginPage(driver);
		lp.login(GetPropertyValues.getPropertyValue("username"), GetPropertyValues.getPropertyValue("password"));

		test.log(LogStatus.PASS, "Login Successfull");
		Thread.sleep(2000);

	}


}

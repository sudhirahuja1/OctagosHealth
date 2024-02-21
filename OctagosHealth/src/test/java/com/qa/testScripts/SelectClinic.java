package com.qa.testScripts;

import org.testng.annotations.Test;

import com.qa.generic.BaseLib;
import com.qa.generic.GetPropertyValues;
import com.qa.pages.ClinicSelector;
import com.qa.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class SelectClinic extends BaseLib{

	String sTestCaseID=null;
	//String[] sData=null;

	@Test //(retryAnalyzer = RetryAnalyzer.class)
	public void selectClinic() throws InterruptedException 
	{
		test = report.startTest("Current status Test execution starts");
		sTestCaseID="Select Clinic";
		
		LoginPage lp = new LoginPage(driver);
		lp.login(GetPropertyValues.getPropertyValue("username"), GetPropertyValues.getPropertyValue("password"));

		test.log(LogStatus.PASS, "Login Successfull");
		Thread.sleep(5000);
		
		//sData=ExcelLib.toReadExcelData(sTestCaseID);
		ClinicSelector cs = new ClinicSelector(driver);
		cs.selectClinic();

		test.log(LogStatus.PASS, "Clinic Selected");
		Thread.sleep(7000);
		
		test.log(LogStatus.PASS, "Clinic Selected Successfully");
		
		
		report.endTest(test);
		report.flush();

	}
}

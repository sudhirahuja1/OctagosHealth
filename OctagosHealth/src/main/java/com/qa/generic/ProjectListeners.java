package com.qa.generic;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
//import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
//import org.testng.ITestListener;
import org.testng.ITestResult;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

public class ProjectListeners implements ITestListener, WebDriverEventListener {
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkipCount=0;
	Logger nomismaLog;
	long startTime, stopTime;
	
	public ProjectListeners() {
		DateFormat dateFormat= new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
		Date date = new Date();
		System.setProperty("LongTimeDate", dateFormat.format(date));
		nomismaLog= Logger.getLogger(this.getClass());
		
		//or
		//actiLog= Logger.getLogger(MyProjectListeners.class);
	}
	
	//ITestListener
	
		//@Override
		public void onFinish(ITestContext arg0) {
			// TODO Auto-generated method stub
		stopTime=System.currentTimeMillis();
		nomismaLog.info("Test Suite execution finished: "+new Timestamp(new Date().getTime()));
		nomismaLog.info("Total time for test suite execution: "+(double)(stopTime-startTime)/1000+"seconds");
		}
		
		//ITestListener
		//@Override
		public void onStart(ITestContext arg0) {
			// TODO Auto-generated method stub
			startTime=System.currentTimeMillis();
			PropertyConfigurator.configure("log4j.properties");
			nomismaLog.info("Test Suite Execution started: "+new Timestamp(new Date().getTime()));
		}
		
		//ITestListener
		//@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
			nomismaLog.info("Test failed within success percentage");
		}
		
		//ITestListener
		//@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			iFailCount++;
			System.out.println("Test Failure:"+ iFailCount);
			nomismaLog.info("Test has been failed");
			Object object = result.getInstance();
			BaseLib obj= (BaseLib) object;
			//OR
			//BaseLib obj = (BaseLib) result.getInstance();
			DateFormat dateFormat= new SimpleDateFormat ("yy_MM_dd_hh_mm_ss");
			Date date= new Date();
			try{
				String fileName = result.getMethod().getMethodName().replace("Test", "");
				TakesScreenshot screenShots= (TakesScreenshot) obj.driver;
				File srcFile = screenShots.getScreenshotAs(OutputType.FILE);
				File destFile= new File(".\\screenshots\\"+fileName+dateFormat.format(date)+".png");
				FileUtils.copyFile(srcFile, destFile);
			}
			catch(IOException e) {
				//nomismaLog.error("Error: "+e);
				e.printStackTrace();
			}
		}
		
		//ITestListener
		//@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			iSkipCount++;
			System.out.println("Test Skipped: "+iSkipCount);
			nomismaLog.info("Test has been skipped: "+result.getName());
		}
		
		//ITestListener
		//@Override
		public void onTestStart(ITestResult arg0) {
			// TODO Auto-generated method stub
			nomismaLog.info("Test execution has been started: "+new Timestamp(new Date().getTime()));
		}
		
		//ITestListener
		//@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			iPassCount++;
			System.out.println("Test Pass: "+iPassCount);
			nomismaLog.info("TestScript Name: '"+result.getName()+"'  /Status--->Pass :)");
		}
		
		//WebDriverEventListener
		//@Override 
		//Sudhir
		//public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
			// TODO Auto-generated method stub
			
		//}
		//@Override
		public void afterClickOn(WebElement arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void afterNavigateBack(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void afterNavigateForward(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void afterNavigateRefresh(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void afterNavigateTo(String arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void afterScript(String arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}
		//@Override 
		//Sudhir
		//public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		//}
		
		//WebDriverEventListener
		//@Override
		public void beforeClickOn(WebElement ele, WebDriver driver) {
			// TODO Auto-generated method stub
			System.out.println("Trying to click: " + ele);
			//Highlight Elements before clicking
			for (int i = 0; i<1; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele, "color: black; border: 3px solid black");
			}
		}
		
		//WebDriverEventListener
		//@Override
		public void beforeFindBy(By by, WebElement ele, WebDriver driver) {
			// TODO Auto-generated method stub
			System.out.println("Trying to find: "+by);
			//System.out.println("Trying to find element: "+ele);

		}
		//@Override
		public void beforeNavigateBack(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void beforeNavigateForward(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}
		//@Override
		public void beforeNavigateRefresh(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}
		//WebDriverEventListener
		//@Override
		public void beforeNavigateTo(String url, WebDriver driver) {
			// TODO Auto-generated method stub
			System.out.println("Before Navigating To: "+url+ ", my url was: "+ driver.getCurrentUrl());
		}
		//@Override
		public void beforeScript(String arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}
		
		//WebDriverEventListener
		//@Override
		public void onException(Throwable t, WebDriver arg1) {
			// TODO Auto-generated method stub
			nomismaLog.fatal("Execution interrupted...");
			nomismaLog.fatal(t.getMessage());
		}

		//@Override
		public void afterAlertAccept(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void afterAlertDismiss(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void afterSwitchToWindow(String arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void beforeAlertAccept(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void beforeAlertDismiss(WebDriver arg0) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <X> void beforeGetScreenshotAs(OutputType<X> target) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeGetText(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterGetText(WebElement element, WebDriver driver, String text) {
			// TODO Auto-generated method stub
			
		}
		

	}


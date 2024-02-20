package com.qa.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static com.qa.generic.ProjectListeners.*;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseLib {
	public WebDriver driver; 
	ProjectListeners listeners;
	public ExtentReports report;
	public ExtentTest test;
	public WaitStatementLib wLib;
	public SoftAssert sAssert;
	
	
	@BeforeTest
	public void configBeforeTest(){
		report = new ExtentReports(".\\reports\\extentreport.html", true);
		report.addSystemInfo("Browser", "Chrome").addSystemInfo("Environment", "QA").addSystemInfo("URL", GetPropertyValues.getPropertyValue("testURL"));
	}
	
	
	@BeforeMethod
	@Parameters (value = "browser")
	
	public void preCondition (String browser) throws MalformedURLException, InterruptedException {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\exefiles\\geckodriver.exe");

			driver = new FirefoxDriver();
			Reporter.log("Firefox browser is Launched", true);
		}
			else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", ".\\exefiles\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
			else if (browser.equalsIgnoreCase("chrome")) {



				System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				Reporter.log("Chrome browser is Launched", true);
			}
		
					
			else if (browser.equalsIgnoreCase("Headlesschrome")) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  
			               + System.getProperty("file.separator")
			               + "BrowserDrivers"
			               + System.getProperty("file.separator")
			               + "chromedriver.exe");

				 String filePath = System.getProperty("user.dir");
			        
				String downloadFilepath = (filePath +"\\Downloads");
	
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				//Save Chrome Opions
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--test-type");
				
				options.addArguments("headless","disable-gpu","--test-type","--ignore-certificate-errors");
		        //options.addArguments("window-size=1200,1100");
		        options.addArguments("window-size=1920,1080");
		       // options.addArguments("window-size=maximize");

				System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
				driver = new ChromeDriver(options);
				Reporter.log("Chrome browser is Launched", true);
			}
		
			
		
		//listeners=new ProjectListeners();
		//driver=new EventFiringWebDriver(wDriver);
		//driver.register(listeners);

		driver.manage().window().maximize();
		if (browser.equalsIgnoreCase("chrome")) {
			driver.get(GetPropertyValues.getPropertyValue("testURL"));
			Reporter.log("Navigating to the OctagosHealth's URL", true);
		}
		
//		else {
//			driver.get(GetPropertyValues.getPropertyValue("testURL"));
//			Reporter.log("Navigating to the  URL", true);
//		}	
		wLib = new WaitStatementLib();
		wLib.implictWaitForSeconds(driver, 20);
	}
	
	@AfterMethod
	public void postCondition(ITestResult r) throws IOException{
		
		if (r.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, r.getThrowable());
			
		
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			FileUtils.copyFile(scrFile, new File(".\\screenshots\\" +r.getName()+timestamp+".jpg"));
			
		}
		
	driver.quit();
	Reporter.log("Browser Closed", true);
	test.log(LogStatus.PASS, "Browser Closed Successfully");
	
	}
	
//	@AfterSuite
//	public void configAfterSuite()
//	{
//		Reporter.log("Running after suite:", true);
//		DateFormat dateFormat = new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
//		
//		Date date = new Date();
//		String TimeStamp = dateFormat.format(date);
//		String XlPath = "./reports/excelreport/Report"+TimeStamp+".xlsx";
//		FileOutputStream Fos;
//		try
//		{
//			Fos =new FileOutputStream(XlPath);
//			Workbook wb=new HSSFWorkbook();
//			Sheet s = wb.createSheet();
//			
//			
//			ExcelLib.writeData(s, 0, "Total:", iPassCount+iFailCount);
//			ExcelLib.writeData(s, 1, "Passed:", iPassCount);
//			ExcelLib.writeData(s, 2, "Failed:", iFailCount);
//			ExcelLib.writeData(s, 3, "Skipped", iSkipCount);
//			
//			try
//			{
//				wb.write(Fos);
//				Fos.close();
//				wb.close();
//			}
//			catch(IOException e)
//			{
//				Reporter.log("Unable to write message to Excel", true);
//				e.printStackTrace();
//			}
//		}
//		catch(FileNotFoundException e)
//		{
//			Reporter.log("Excel file is not getting created", true);
//		}
//	}
}

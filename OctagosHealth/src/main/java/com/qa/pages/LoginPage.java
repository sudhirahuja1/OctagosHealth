package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;


public class LoginPage {

	
	    public static String SLOGAN1 = "Artificial Intelligence.";
	    public static String SLOGAN2 = "Healthcare Analytics.";
	    public static String SLOGAN3 = "Platform Integration.";

    
	    @FindBy(id="username")
	    private static WebElement txtusername;
	    
	    @FindBy(id="password")
	    private static WebElement txtpassword;
	    
	    @FindBy(xpath="//button[contains(text(),'Continue')]")
	    private static WebElement btnContinue;
		

	    public LoginPage(WebDriver driver)
	    {
	        PageFactory.initElements(driver, this);
	    }

	    public void login(String username, String password) throws InterruptedException{
			
	    	txtusername.clear();
	    	txtusername.sendKeys(username);
	    	//test.Log(Status.PASS, "Username Entred : "+ username);
	    	btnContinue.click();
	    	txtpassword.sendKeys(password);
	    	//test.Log(Status.PASS, "Username Entred : "+ username);
	    	btnContinue.click();
	    	
		}
	    
	    public String toString()
	    {
	        return "LoginPage";
	    }
	    public static void username(String username)
	    {
	        txtusername.clear();;
	        txtusername.sendKeys(username);
	        //test.Log(Status.Pass, "Username Entred : "+ username);
	    }

	    public static void clickContinue()
	    {
	        btnContinue.click();
	        //test.Log(Status.Pass, "Continue Button clicked");
	    }

	    public static void password(String password)
	    {
	        txtpassword.clear();
	        txtpassword.sendKeys(password);
	       // test.Log(Status.Pass, "Password Entered.");
	    }
//	    public void submit()
//	    {
//	        btnsubmitt.Click();
//	        test.Log(Status.Pass, "Clicked on SignIn button.");
//	    }
//	    public void LoginAsUser(String userName, String passWord)
//	    {
//	        username(userName);
//	        password(passWord);
//	        submit();
//	    }
//	    public String IsErrorMessageDisplayed()
//	    {
//	        String errorMeassage = ErrorMessage.Text;
//	        TestContext.Progress.WriteLine("Error message--" + errorMeassage);
//	        test.Log(Status.Pass, "Error message displayed : " + errorMeassage);
//	        return errorMeassage;
//	    }

//	    public String getUrl()
//	    {
//	        return "/Login";
//	    }
//	    public Boolean VerifySlogan()
//	    {
//	        Console.WriteLine("Slogans displayed are :-");
//	        Console.WriteLine("-------------------------");
//
//	        IList<IWebElement> slogan = getShortWait().Until(ExpectedConditions.VisibilityOfAllElementsLocatedBy(By.XPath("//div[contains(@class,'py-3 fw-bold')]//span[2]")));
//	        foreach(IWebElement element in slogan)
//	        {
//	            if(element.Text.Equals(SLOGAN1) | element.Text.Equals(SLOGAN2) | element.Text.Equals(SLOGAN3))
//	            {
//	                Console.WriteLine(element.Text);
//	                test.Log(Status.Pass, "Slogan displayed : "+ element.Text);
//	            }
//	        }
//	        Console.WriteLine("-------------------------");
//	        return true;
//	    }
//	    public Boolean VerifyPrivacyPolicy()    
//	    {
//	        getShortWait().Until(ExpectedConditions.ElementToBeClickable(By.XPath("//div[contains(text(),'Privacy Policy')]"))).Click();
//	        IWebElement Popup = getShortWait().Until(ExpectedConditions.ElementIsVisible(By.XPath("//div[@class='modal-content']")));
//
//	        if (Popup.Displayed)
//	        {
//	            Console.WriteLine("Privacy Policy popup displayed..!");
//	            IWebElement Title = getShortWait().Until(ExpectedConditions.ElementIsVisible(By.XPath("//div[@class='modal-content']//h5")));
//	            IWebElement SubTitle = getShortWait().Until(ExpectedConditions.ElementIsVisible(By.XPath("//div[@class='modal-content']//h6[@class='PrivacyPolicy']")));
//	            IWebElement EffectiveDate = getShortWait().Until(ExpectedConditions.ElementIsVisible(By.XPath("//div[@class='modal-content']//h6[@class='PrivacyPolicy']")));
//	            if(Title.Displayed && SubTitle.Displayed && EffectiveDate.Displayed)
//	            {
//	                Console.WriteLine("Title :- "+Title.Text);
//	                Console.WriteLine("SubTitle :- "+SubTitle.Text);
//	                Console.WriteLine("Effective Date :- " + EffectiveDate.Text);
//	                test.Log(Status.Pass, "Title :- " + Title.Text);
//	                test.Log(Status.Pass, "SubTitle :- " + SubTitle.Text);
//	                test.Log(Status.Pass, "Effective Date :- " + EffectiveDate.Text);
//	            }
//	            return true;
//	        }
//	        else
//	        {
//	            return false;
//	        }
//	    }
//	}
	
	
	
	
}

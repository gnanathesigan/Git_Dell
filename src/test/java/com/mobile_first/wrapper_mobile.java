package com.mobile_first;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wrapper_mobile {
    
    //WebDriver driver; 
    public static WebDriver driver;
    public static String currenttime = time();
    public static ExtentReports extentreports;
    public static ExtentSparkReporter sparkreporter;
    public static ExtentTest extenttest;
    public static Properties elements = null;
    public static Properties values=null;
    public static Logger Log = Logger.getLogger(wrapper_mobile.class.getName());
    
    public static final String Username = "ganesangopal3";
    public static final String Accesskey = "zhE2AYmymgvZBwjLdE3k";
    public static final String URL = "https://"+Username+":"+Accesskey+"@hub-cloud.browserstack.com/wd/hub";

    
 
    @BeforeSuite
    public void properties()
    {
	try {
            elements = new Properties();
            FileInputStream ele = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\elements.Properties");
	    elements.load(ele);
	    
	    values = new Properties();
            FileInputStream ele1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\values.Properties");
	    values.load(ele1);
		
	   
	}

	catch (Exception e) {
		e.printStackTrace();
	}
    }
    
    
    @BeforeTest  
    public void start() throws Exception
    {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("deviceName", "OnePlus 9");
	cap.setCapability("osVersion", "11.0");
	cap.setCapability("browserName", "chrome");
	cap.setCapability("deviceOrientation", "portrait");
	
//	cap.setCapability("deviceName", "iPhone 14 Pro Max");
//	cap.setCapability("osVersion", "16");
//	cap.setCapability("browserName", "safari");
//	cap.setCapability("deviceOrientation", "portrait");
	
	driver = new RemoteWebDriver(new URL(URL), cap);
       
    }
    
    public void loadingurl(String url) {
	try {
		driver.get(url);
		//driver.manage().window().maximize();
		
	}

	catch (Exception e) {
		e.printStackTrace();
	}

}
     
    public void goback() {
	try {
	    driver.navigate().back(); 
	}

	catch (Exception e) {
		e.printStackTrace();
	}

} 
    
    /************* Create the Current time *************/

	public static String time() {
		String currenttime = "";
		DateFormat df = new SimpleDateFormat("_yyyy_MM_dd_HH mm");
		Date date = new Date();
		currenttime = df.format(date);
		return currenttime;
	}

	
    public void screenshots(String filename)throws Exception{
	try {
	 TakesScreenshot shots= (TakesScreenshot)driver;
	 File SrcFile = shots.getScreenshotAs(OutputType.FILE);
	 String path=System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\Images - "+currenttime+ "\\" +filename + " -" + currenttime +".jpg";
	 File DestFile = new File(path);
	 FileUtils.copyFile(SrcFile, DestFile);
	 //extenttest.addScreenCaptureFromBase64String(path);
	 extenttest.addScreenCaptureFromPath(path);
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
    }
    
    
    
    
   
    public void initialiseExtentReports (String name)
    {
	File file=new File(name+".html");
	//System.out.println(name);
	extentreports = new ExtentReports();
	sparkreporter = new ExtentSparkReporter(file);
	extentreports.attachReporter(sparkreporter);
	
	extentreports.setSystemInfo("OS", System.getProperty("os.name"));
	extentreports.setSystemInfo("Java", System.getProperty("java.version"));
	//System.out.println("GNANATHESIGAN"+ name);
	extenttest = extentreports.createTest(name);
    }
    
    public void generateExtentReports(String name)
    {
	extentreports.flush();
	//System.out.println(name);
	try {
	    Desktop.getDesktop().browse(new File(name+".html").toURI());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
   
    
    @AfterMethod
    public void checkstatus(Method m, ITestResult result) throws Exception
    {
//	System.out.println(result.getStatus());
//	System.out.println(ITestResult.FAILURE);
//	System.out.println(ITestResult.SUCCESS);
	if(result.getStatus() == ITestResult.FAILURE)
	{
	    screenshots(m.getName());
	    extenttest.fail(m.getName() + " _ This method is getting failed");
	    
	}
	else if(result.getStatus() == ITestResult.SUCCESS) {
	    screenshots(m.getName());
	    extenttest.pass(m.getName()+ " _ This method is getting passed");
	  
	}
	
    }
//    public void reports(String name)
//    {
//	File file=new File(name+".html");
//	extentreports = new ExtentReports();
//	sparkreporter = new ExtentSparkReporter(file);
//	extentreports.attachReporter(sparkreporter);
//	//String Images=capture();
//	ExtentTest test1= extentreports.createTest(name);
//	//test1.addScreenCaptureFromBase64String(Images).log(Status.PASS, "This test is passed");
//	test1.log(Status.PASS,"This is Passed");
//	test1.log(Status.FAIL, "This is Failed");
//	test1.log(Status.INFO, "This is INFO");
//	test1.log(Status.SKIP, "This is Skipped");
//	extentreports.flush();
//	try {
//	    Desktop.getDesktop().browse(new File(name+".html").toURI());
//	} catch (IOException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	}
//    }
    
 // Waiting for a Seconds
 	public void waiting(int seconds) {
 		try {
 			Thread.sleep(seconds);
 		}

 		catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
 	
 	
 // Click the Elements
 	public void clickelement(String category, String locator) {
 		try {
 			switch (category.toLowerCase()) {
 			case "id":
 				driver.findElement(By.id(locator)).click();
 				break;
 			case "name":
 				driver.findElement(By.name(locator)).click();
 				break;
 			case "xpath":
 				driver.findElement(By.xpath(locator)).click();
 				break;
 			case "classname":
 				driver.findElement(By.className(locator)).click();
 				break;
 			default:
 				System.out.println("incorrect category");
 				break;
 			}

 		} catch (Exception e1) {
 			e1.printStackTrace(); 
 		}

 	}
 	
 	
      // Sendkeys for the Fields
       public void enterValue(String category, String locator, String text) {

 			try {
 				switch (category.toLowerCase()) {
 				case "id":
 					driver.findElement(By.id(locator)).clear();
 					driver.findElement(By.id(locator)).sendKeys(text);

 					break;
 				case "name":
 					driver.findElement(By.name(locator)).clear();
 					driver.findElement(By.name(locator)).sendKeys(text);
 					break;
 				case "xpath":
 					driver.findElement(By.xpath(locator)).clear();
 					driver.findElement(By.xpath(locator)).sendKeys(text);
 					break;
 				case "classname":
 					driver.findElement(By.className(locator)).clear();
 					driver.findElement(By.className(locator)).sendKeys(text);
 					break;
 				default: {
 					System.out.println("incorrect category");
 					driver.findElement(By.id(locator)).clear();
 					break;
 				}
 				}
 			} catch (Exception e) {
 				System.out.printf("There is a generic java exception");
 				e.printStackTrace();
 			}

 		}
 	
 	public void elementintercept(String locator)
 	{
 	   WebElement element = driver.findElement(By.xpath(locator));
 	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
 	   element.click();
 	}
 	
 	public void clickwithoutscroll(String locator)
 	{
 	   WebElement element = driver.findElement(By.xpath(locator));
 	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); 
 	}
 	
 	public void scrollintoview(String locator)
 	{
 	   WebElement element = driver.findElement(By.xpath(locator));
 	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
 	}
 	
 	public void scrollup()
 	{
 	   JavascriptExecutor js = (JavascriptExecutor) driver;
 	   js.executeScript("window.scrollBy(0,-713)");
 	}
 	
 	public boolean checkboxenable(String locator)
 	{
 	   WebElement element = driver.findElement(By.xpath(locator));
 	  boolean a= (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checked", element);
 	  //System.out.println(a);
 	  if(a==true)
 	  {
 	     Log.info("Already Checked");
 	  }
 	  else
 	  {
 	     element.click();
 	  }
 	  return a;
 	}
 	
 	public String gettext(String path)
 	{
 	    String text="";
 	    WebElement element=driver.findElement(By.xpath(path));
 	   text = element.getText(); 
 	    return text.toLowerCase().replace("unit price:", "").replace("单价:", "").trim();
 	}
 	
 	public int getsize(String locator) 
 	{
 	    List<WebElement> elements=driver.findElements(By.xpath(locator));
 	    int value=elements.size();
 	    return value;
 	   
 	}
 	
 	
 	public String getinnertext(String path)
 	{
 	    String text="";
 	    WebElement element=driver.findElement(By.xpath(path));
 	   text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element); 
 	    return text.toLowerCase().trim();
 	}
 	
 	
 	public void selectDropdownByValue(String category, String locator, String index) {

		Select drpdwngender;

		try {
			switch (category.toLowerCase()) {
			case "id":
				drpdwngender = new Select(driver.findElement(By.id(locator)));
				drpdwngender.selectByValue(index);
				//drpdwngender.selectByIndex(1);
				//drpdwngender.selectByVisibleText(index);
				break;
			case "name":
				drpdwngender = new Select(driver.findElement(By.name(locator)));
				drpdwngender.selectByValue(index);
				break;
			case "xpath":
				drpdwngender = new Select(driver.findElement(By.xpath(locator)));
				drpdwngender.selectByValue(index);
				break;
			case "classname":
				drpdwngender = new Select(driver.findElement(By.className(locator)));
				drpdwngender.selectByValue(index);
				break;
			default: {
				System.out.println("Mismatched Category");
			}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
 	
 	public void explicitywait(int sec, String category, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		try {
			switch (category.toLowerCase()) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				break;

			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
				wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.id(locator))));
				break;

			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				break;

			case "classname":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
				break;
			default: {
				System.out.println("Mismatched Category");
			}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
 	
 	public void explicitywaitfoelementclick(int sec, String category, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		try {
			switch (category.toLowerCase()) {
			case "id":
			    wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
				break;

			case "name":
				wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
				break;

			case "xpath":
			        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
				break;
				
			default: {
				System.out.println("Mismatched Category");
			}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
    
 	
    public List<WebElement> findelements(String category, String locator) {

	List<WebElement> locators = new ArrayList<WebElement>();

	try {
		switch (category.toLowerCase()) {
		case "id":
			locators = driver.findElements(By.id(locator));
			break;
		case "name":
			locators = driver.findElements(By.name(locator));
			break;
		case "xpath":
			locators = driver.findElements(By.xpath(locator));
			break;
		case "classname":
			locators = driver.findElements(By.className(locator));
			break;
		default: {
			System.out.println("incorrect category");
			locators = driver.findElements(By.id(locator));
			break;
		}
		}
	} catch (Exception e) {
		System.out.printf("There is a generic java exception");
		e.printStackTrace();
	}
	return locators;
}
    
  public List<String> brokenimagelink(List<String> allimagelink) throws Exception {
	List<String> linkss = new ArrayList<String>();
	
	for (int i = 0; i < allimagelink.size(); i++) {
		driver.get(allimagelink.get(i));
		//driver.manage().window().maximize();
		
		String title = driver.getTitle();
		//System.out.println(title.replace("|", ""));
		screenshots(title.replace("|", "").replace(":", ""));
		if (title.contains("404") || title.contains("Page Not Found") || title.contains("Oops")
				|| title.contains("problem") || title.contains("Server Not Found") || title.contains("Error")
				|| title.contains("www.") || title.contains("http:") || title.contains("Page introuvable")) {
			linkss.add(allimagelink.get(i));
			//screenshots(title);
			Log.info("Broken Links :\t" + allimagelink.get(i));
		}
		
	}

	return linkss;
}
    
  
  public void mousehover(String xpath)
  {
    //Instantiating Actions class
    Actions actions = new Actions(driver);
    WebElement mainMenu = driver.findElement(By.xpath(xpath));
    //Hovering on main menu
    actions.moveToElement(mainMenu).perform();
    //build()- used to compile all the actions into a single step 
   // actions.click().build().perform();
  }
  
   
    
    
    @AfterSuite
    public void end() throws Exception
    {
        driver.quit();
    }

}

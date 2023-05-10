package Cucumber_testng;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends wrapper_Cucumber {

    @Before
    public void setUp() throws Exception {
	
	
	elements = new Properties();
        FileInputStream ele = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\elements.Properties");
	elements.load(ele);
	
	values = new Properties();
        FileInputStream ele1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\values.Properties");
	values.load(ele1);
 
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("chromedriver --whitelisted-ips=''");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        
       // initialiseExtentReports("CUCUMBER START");
        
        
    }
    
    @After
    public void teardown() {
	
     // generateExtentReports("CUCUMBER START");
      driver.quit();
  }
  
}

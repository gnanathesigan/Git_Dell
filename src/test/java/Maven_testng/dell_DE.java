package Maven_testng;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import wrapper_Package.wrapper_Class;
import xls_package.xlsx_actions;

//@Listeners(Itestlistener.class)
public class dell_DE extends wrapper_Class {
    
    @Test(dataProvider = "germanurl")
    public void DElive(ITestContext context, String deurl)
    {
	loadingurl(deurl);
	Dimension dm = new Dimension(375,667);
	driver.manage().window().setSize(dm);
	driver.navigate().refresh();
	Log.info("DE Home Page");
    }


    @DataProvider
    public Object[][] germanurl() throws Exception
    {
        Object[][] arrayObject = xlsx_actions.getExcelData("DE");
    	return arrayObject;  
    }

}

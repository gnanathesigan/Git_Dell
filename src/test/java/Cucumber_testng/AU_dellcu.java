package Cucumber_testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import wrapper_Package.wrapper_Class;

public class AU_dellcu extends wrapper_Cucumber{
    
   // private static WebDriver driver;
    //public final static int TIMEOUT = 10;
    
    String actualpriceinplp ="";
    String actualproducttitleinplp ="";
    
    String actualwarrantyname="";
    String expectedwarrantynameincart="";
   
//    @Before
//    public void setUp() throws Exception {
//	elements = new Properties();
//        FileInputStream ele = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\elements.Properties");
//	elements.load(ele);
// 
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
//        driver.manage().window().maximize();
//        
//        
//    }
//    
    @Given("^Open Chrome and load the url of \"(.*?)\"$")
    public void testlive(String url) throws Exception
    {
	driver.get(url);
	System.out.println(elements.getProperty("Popup"));
	//Log.info("AU Home Page");
	    
	    int value = getsize(elements.getProperty("Popup"));
	    System.out.println(value);
	    if(value!=0)
	     {
		clickelement("xpath",elements.getProperty("Popup"));
	     }
	    else
	    {
		Log.info("Poup not presented on Home Page");
		System.out.println("Element is not there");
	    }
	    //checkstatus(m,result);
    }
    
    @When("^checking the all plp and checking broken pages.$")
    public void linkVerfications() throws Exception
    {
        List<String> mainlinks=new ArrayList<String>();
        
        List<String> allproductlinks=new ArrayList<String>();
    		
        List<WebElement> alllinks=findelements("xpath",elements.getProperty("Productmenus"));
        
        try
        {
        	    
        for(WebElement totallinks : alllinks)
    		{
           String linking=totallinks.getAttribute("href");
           mainlinks.add(linking);
    		}
    		
        }
      catch(Exception e)
        {
    	  e.printStackTrace();
        }
        
        Set<String> set = new LinkedHashSet<>(mainlinks);
        List<String> finallinks=new ArrayList<String>();
        finallinks.addAll(set);
        
        allproductlinks=brokenimagelink(finallinks);
    }


    @Then("^mousehover on the mainmenu section.$")
    public void mainmenushover() throws Exception
    { 
        clickelement("xpath",elements.getProperty("logo"));
        mousehover(elements.getProperty("mainmenu"));
    	  
    }

    @Given("^checking the PLP functionalities \"(.*?)\"$")
    public void PLP(String name) throws Exception
    { 
        clickelement("xpath",elements.getProperty("laptopmenu"));
        
        elementintercept(elements.getProperty("firstcategoryAU"));
        scrollintoview(elements.getProperty("sortingname"));
        screenshots("Inspiron Category");
        
        clickelement("xpath",elements.getProperty("sortingdesc"));
        scrollintoview(elements.getProperty("sortingname"));
        screenshots("Sorting Desc");
        
        selectDropdownByValue("xpath",elements.getProperty("sortingname"),name);
        scrollintoview(elements.getProperty("sortingname"));
        screenshots("Sorting ProductName");	  
        
        clickelement("xpath",elements.getProperty("listview"));
        scrollintoview(elements.getProperty("sortingname"));
        screenshots("List View Products");
        
        clickelement("xpath",elements.getProperty("gridview"));
        scrollintoview(elements.getProperty("sortingname"));
        screenshots("Grid View Products");
        
        elementintercept(elements.getProperty("compare"));
        scrollintoview(elements.getProperty("compare"));
        explicitywait(50,"xpath",elements.getProperty("notification"));
        screenshots("Compare Products");
        
        elementintercept(elements.getProperty("wishlist"));
        explicitywait(50,"xpath",elements.getProperty("closepopup"));
        screenshots("Wishlist");
        
        clickwithoutscroll(elements.getProperty("closepopup"));
        
        //Newly added Code
        mousehover(elements.getProperty("mainmenu"));
        clickelement("xpath",elements.getProperty("inspironmenu"));
       //clickelement("xpath",elements.getProperty("precisionmenu"));
        
        clickelement("xpath",elements.getProperty("sortingdesc"));
        scrollintoview(elements.getProperty("sortingname"));
        screenshots("Sorting Desc in Sub Category");
      //Newly added Code
        
        
        actualproducttitleinplp=gettext(elements.getProperty("producttitle"));
        actualpriceinplp=gettext(elements.getProperty("pricevalue"));
        
      //  System.out.println(actualproducttitleinplp);
      //  System.out.println(actualpriceinplp);
        
        elementintercept(elements.getProperty("addproduct"));
        waiting(5000);
        
       /// checkstatus(m,result);
    }

    @When("^verify the warranty page and product details.$")
    public void warrantypage() throws Exception
    { 
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
       if(url.contains("/index/index/pid"))
       {
	   explicitywait(50,"xpath",elements.getProperty("producttitlewarranty"));
	   
	   String expectedproducttitleinwarranty = gettext(elements.getProperty("producttitlewarranty"));
	   String expectedpriceinwarranty = gettext(elements.getProperty("productpricewarranty"));
	       
	        try
	        {
	        Assert.assertEquals(actualproducttitleinplp, expectedproducttitleinwarranty);
	        Assert.assertEquals(actualpriceinplp, expectedpriceinwarranty);
	        }
	        catch(Exception e)
	        {
	    	e.printStackTrace();
	        }
	        
	        scrollintoview(elements.getProperty("warrantyname"));
	        screenshots("Warranty Name");
	        
	        actualwarrantyname=gettext(elements.getProperty("warrantyname"));
	        
	        elementintercept(elements.getProperty("proceedbutton"));   
	        explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
       }
       else
       {
	   clickelement("xpath",elements.getProperty("minicart"));
	   explicitywait(50,"xpath",elements.getProperty("viewcart"));
	   clickelement("xpath",elements.getProperty("viewcart"));
	   explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
       }
       
        
       // checkstatus(m,result);
    }
    
    @Then("^checking the cart functionalities.$")
    public void cartpage() throws Exception
    { 
        String producttitlecart=getinnertext(elements.getProperty("producttitlecart"));
        String productpricecart=getinnertext(elements.getProperty("productpricecart"));
        String grandtotalcart=getinnertext(elements.getProperty("grandtotalcart"));
        
        System.out.println(producttitlecart);
        System.out.println(productpricecart);
        System.out.println(grandtotalcart);
        
        elementintercept(elements.getProperty("specificationcart"));
        scrollintoview(elements.getProperty("producttitlecart"));
        screenshots("Product Name in CartPage");
        expectedwarrantynameincart=getinnertext(elements.getProperty("warrantyincart"));
        //System.out.println(expectedwarrantynameincart);
        
        try
        {
        Assert.assertEquals(actualproducttitleinplp, producttitlecart);
        Assert.assertEquals(actualpriceinplp, productpricecart);
        Assert.assertEquals(actualpriceinplp, grandtotalcart);
      //  Assert.assertEquals(actualwarrantyname, expectedwarrantynameincart);
        }
        catch(Exception e)
        {
    	e.printStackTrace();
        }
        
        scrollintoview(elements.getProperty("warrantyincart"));
        elementintercept(elements.getProperty("movetowishlist"));
        explicitywait(50,"xpath",elements.getProperty("closepopup"));
        screenshots("move to wishlist");
        clickwithoutscroll(elements.getProperty("closepopup"));
        
        elementintercept(elements.getProperty("movealltowishlist"));
        explicitywait(50,"xpath",elements.getProperty("closepopup"));
        screenshots("move all to wishlist");
        clickwithoutscroll(elements.getProperty("closepopup"));
        
        elementintercept(elements.getProperty("continueshopping"));
        explicitywait(50,"xpath",elements.getProperty("searchbox"));
        
    }

    @Given("^checking the search page functionalities.$")
    public void searchpage() throws Exception
    { 
        clickelement("xpath",elements.getProperty("searchbox"));
        enterValue("xpath",elements.getProperty("searchbox"),"alienware");
        clickelement("xpath",elements.getProperty("searchbutton"));
        explicitywait(50,"xpath",elements.getProperty("secondcategoryAU"));
        screenshots("Search Page");
        elementintercept(elements.getProperty("secondcategoryAU"));
        screenshots("Alienware Category");
        clickelement("xpath",elements.getProperty("producttitle"));
        scrollintoview(elements.getProperty("addtocart"));
        explicitywaitfoelementclick(50,"xpath",elements.getProperty("addtocart"));
    }

    @When("^checking the PDP functionalities.$")
    public void PDP() throws Exception
    { 
        clickelement("xpath",elements.getProperty("addtocart"));
        waiting(5000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
        if(url.contains("/index/index/pid"))
        {
        explicitywait(50,"xpath",elements.getProperty("proceedbutton"));
        screenshots("Desktop Warranty");
        elementintercept(elements.getProperty("proceedbutton"));
        }
        
        else
        {
           clickelement("xpath",elements.getProperty("minicart"));
 	   explicitywait(50,"xpath",elements.getProperty("viewcart"));
 	   clickelement("xpath",elements.getProperty("viewcart"));
        }
        
        explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
        scrollintoview(elements.getProperty("multiproductcart"));
        screenshots("Multiple Product in Cart");
        
        clickelement("xpath",elements.getProperty("proceedtocheckout"));
        explicitywait(50,"xpath",elements.getProperty("makepayment"));
        waiting(10000);
    }

    @And("^checking the Checkout guest functionalities values are \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
    public void checkoutguest(String email, String fname, String lname, String address, String City, String zipcode, String company, String phone, String state) throws Exception
    { 
        clickelement("xpath",elements.getProperty("emailaddressfield"));
        enterValue("xpath",elements.getProperty("emailaddressfield"),email);
        clickelement("xpath",elements.getProperty("emailaddresslabel"));
        
        waiting(2000);
        clickelement("xpath",elements.getProperty("guestcheckbox"));
        
        enterValue("xpath",elements.getProperty("firstname"),fname);
        enterValue("xpath",elements.getProperty("lastname"),lname);
        enterValue("xpath",elements.getProperty("streetaddress"),address);
        enterValue("xpath",elements.getProperty("city"),City);
        enterValue("xpath",elements.getProperty("zipcode"),zipcode);
        enterValue("xpath",elements.getProperty("company"),company);
        enterValue("xpath",elements.getProperty("phonenumber"),phone);
        selectDropdownByValue("xpath",elements.getProperty("state"),state);
        
        scrollintoview(elements.getProperty("emailaddresslabel"));
        screenshots("Shipping Address");
        
        String producttitlecheckout=getinnertext(elements.getProperty("producttitlecheckout"));
        String warrantycheckout=getinnertext(elements.getProperty("warrantycheckout"));
        String pricecheckout=getinnertext(elements.getProperty("pricecheckout"));
        
        elementintercept(elements.getProperty("viewdetailcheckout"));
        
        try
        {
        Assert.assertEquals(actualproducttitleinplp, producttitlecheckout);
       // Assert.assertEquals(actualwarrantyname, warrantycheckout);
        Assert.assertEquals(actualpriceinplp, pricecheckout);
        }
        catch(Exception e)
        {
    	e.printStackTrace();
        }
        
        clickelement("xpath",elements.getProperty("deliverycheckbox"));
        clickelement("xpath",elements.getProperty("paymenttermcheckbox"));
        
        checkboxenable(elements.getProperty("billingsame"));
        screenshots("Complete Chekout");
        
       clickelement("xpath",elements.getProperty("makepayment"));
       explicitywait(50,"xpath",elements.getProperty("paymentprice"));
    }

    @Then("^checking the Checkout login functionalities values are \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
    public void checkoutlogin(String address, String City, String zipcode, String company, String phone, String state) throws Exception
    { 
        goback();
        waiting(10000);
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elements.getProperty("loaderimage"))));
        
        elementintercept(elements.getProperty("emailaddressfield"));
        enterValue("xpath",elements.getProperty("emailaddressfield"),values.getProperty("exisitingmail"));
        elementintercept(elements.getProperty("emailaddresslabel"));
        
        waiting(2000);
        screenshots("Exisiting Mail ID");
        clickelement("xpath",elements.getProperty("signinlink"));	
        explicitywait(50,"xpath",elements.getProperty("signinemail"));
        
        clickelement("xpath",elements.getProperty("signinemail"));
        enterValue("xpath",elements.getProperty("signinemail"),values.getProperty("exisitingmail"));
        clickelement("xpath",elements.getProperty("signinpassword"));
        enterValue("xpath",elements.getProperty("signinpassword"),values.getProperty("password"));
        waiting(15000);
        clickelement("xpath",elements.getProperty("signinbutton"));
        explicitywait(50,"xpath",elements.getProperty("manageoption"));
        
        mousehover(elements.getProperty("mainmenu"));
        clickelement("xpath",elements.getProperty("desktopall"));
        elementintercept(elements.getProperty("addproduct"));
        waiting(5000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
        if(url.contains("/index/index/pid"))
        {
        explicitywait(50,"xpath",elements.getProperty("proceedbutton"));
        screenshots("Desktop Warranty");
        elementintercept(elements.getProperty("proceedbutton"));
        explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
        clickelement("xpath",elements.getProperty("minicart"));
        explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
        clickelement("xpath",elements.getProperty("checkoutminicart"));
        explicitywait(50,"xpath",elements.getProperty("newaddcheckout"));
        }
        
        else
        {
            clickelement("xpath",elements.getProperty("minicart"));
            explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
            clickelement("xpath",elements.getProperty("checkoutminicart"));
            explicitywait(50,"xpath",elements.getProperty("newaddcheckout"));
        }
       
        waiting(15000);
        elementintercept(elements.getProperty("newaddcheckout"));
        waiting(2000);
        enterValue("xpath",elements.getProperty("streetaddress"),address);
        enterValue("xpath",elements.getProperty("city"),City);
        enterValue("xpath",elements.getProperty("zipcode"),zipcode);
        enterValue("xpath",elements.getProperty("company"),company);
        enterValue("xpath",elements.getProperty("phonenumber"),phone);
        selectDropdownByValue("xpath",elements.getProperty("state"),state);
        clickelement("xpath",elements.getProperty("newsavecheckout"));
        waiting(5000);
        
        elementintercept(elements.getProperty("deliverycheckbox"));
        elementintercept(elements.getProperty("paymenttermcheckbox"));
       
        checkboxenable(elements.getProperty("billingsame"));
        screenshots("Complete Chekout for logged users");
        
        clickelement("xpath",elements.getProperty("makepayment"));
        explicitywait(50,"xpath",elements.getProperty("paymentprice"));
        
        goback();
	waiting(10000);
	    
	goback();
	waiting(7000);
	    
	clickelement("xpath",elements.getProperty("minicart"));
	explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));  
	clickelement("xpath",elements.getProperty("firstproductminicart"));
	explicitywait(50,"xpath",elements.getProperty("acceptalert"));  
	clickelement("xpath",elements.getProperty("acceptalert"));
	waiting(7000);
	
	clickelement("xpath",elements.getProperty("minicart"));
	explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
	clickelement("xpath",elements.getProperty("firstproductminicart"));
	explicitywait(50,"xpath",elements.getProperty("acceptalert"));
	clickelement("xpath",elements.getProperty("acceptalert"));
	waiting(7000);
        
	clickelement("xpath",elements.getProperty("minicart"));
	explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
	clickelement("xpath",elements.getProperty("firstproductminicart"));
	explicitywait(50,"xpath",elements.getProperty("acceptalert")); 
	clickelement("xpath",elements.getProperty("acceptalert"));
	waiting(7000);
    }
//    @After
//    public void teardown() {
//  
//        driver.quit();
//    }
////    
}

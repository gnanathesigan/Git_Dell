package Maven_testng;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
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
public class dell_CN extends wrapper_Class {
    String actualpriceinplp ="";
    String actualproducttitleinplp ="";
    
    String actualwarrantyname="";
    String expectedwarrantynameincart="";
 
@Test(dataProvider = "chinaurl", priority=1)
public void CNlive(ITestContext context, String cnurl)
{
    loadingurl(cnurl);
    Log.info("CN Home Page");
}

@Test(priority=2)
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

@Test(priority=3)
public void mainmenushover() throws Exception
{ 
    clickelement("xpath",elements.getProperty("logo"));
    mousehover(elements.getProperty("mainmenu"));
	  
}

@Test(priority=4)
public void PLP() throws Exception
{ 
    clickelement("xpath",elements.getProperty("laptopmenu"));
    
    elementintercept(elements.getProperty("firstcategory"));
    scrollintoview(elements.getProperty("sortingname"));
    screenshots("Inspiron Category");
    
    clickelement("xpath",elements.getProperty("sortingdesc"));
    scrollintoview(elements.getProperty("sortingname"));
    screenshots("Sorting Desc");
    
    selectDropdownByValue("xpath",elements.getProperty("sortingname"),values.getProperty("ProductName"));
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
    
    actualproducttitleinplp=gettext(elements.getProperty("producttitle"));
    actualpriceinplp=gettext(elements.getProperty("pricevalue"));
    
   // System.out.println("PLP --> " + actualproducttitleinplp);
  //  System.out.println("PLP --> " + actualpriceinplp);
    
    elementintercept(elements.getProperty("addproduct"));
    explicitywait(50,"xpath",elements.getProperty("producttitlewarranty"));
    
}

@Test(priority=5)
public void warrantypage() throws Exception
{ 
    String expectedproducttitleinwarranty = gettext(elements.getProperty("producttitlewarranty"));
    String expectedpriceinwarranty = gettext(elements.getProperty("productpricewarranty"));
    
   // System.out.println("Warranty --> " + expectedproducttitleinwarranty);
   // System.out.println("Warranty --> " + expectedpriceinwarranty);
   
    try
    {
    Assert.assertEquals(actualproducttitleinplp, expectedproducttitleinwarranty);
    Assert.assertEquals(actualpriceinplp, expectedpriceinwarranty);
    }
    catch(Exception e)
    {
	e.printStackTrace();
    }
    
    scrollintoview(elements.getProperty("warrantynamechina"));
    screenshots("Warranty Name");
    
    actualwarrantyname=gettext(elements.getProperty("warrantynamechina"));
  //  System.out.println("Warranty --> " + actualwarrantyname);
    
    elementintercept(elements.getProperty("proceedbutton"));   
    explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
}

@Test(priority=6)
public void cartpage() throws Exception
{ 
//    String producttitlecart=getinnertext(elements.getProperty("producttitlecart"));
//    String productpricecart=getinnertext(elements.getProperty("productpricecart"));
//    String grandtotalcart=getinnertext(elements.getProperty("grandtotalcart"));
    
    String producttitlecart=gettext(elements.getProperty("producttitlecart"));
    String productpricecart=gettext(elements.getProperty("productpricecart"));
    String grandtotalcart=gettext(elements.getProperty("grandtotalcart"));
    
    System.out.println("CartPage --> " + producttitlecart);
    System.out.println("CartPage --> " + productpricecart);
    System.out.println("CartPage --> " + grandtotalcart);
    
    elementintercept(elements.getProperty("specificationcart"));
    scrollintoview(elements.getProperty("producttitlecart"));
    screenshots("Product Name in CartPage");
    expectedwarrantynameincart=getinnertext(elements.getProperty("warrantyincart"));
    System.out.println("CartPage --> " + expectedwarrantynameincart);
    
    try
    {
    Assert.assertEquals(actualproducttitleinplp, producttitlecart);
    Assert.assertEquals(actualpriceinplp, productpricecart);
    Assert.assertEquals(actualpriceinplp, grandtotalcart);
    Assert.assertEquals(actualwarrantyname, expectedwarrantynameincart);
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

@Test(priority=7)
public void searchpage() throws Exception
{ 
    clickelement("xpath",elements.getProperty("searchbox"));
    enterValue("xpath",elements.getProperty("searchbox"),"台式机");
    clickelement("xpath",elements.getProperty("searchbutton"));
    explicitywait(50,"xpath",elements.getProperty("firstcategory"));
    screenshots("Search Page");
    elementintercept(elements.getProperty("firstcategory"));
    screenshots("Inspiron Desktop Category");
    clickelement("xpath",elements.getProperty("producttitle"));
    scrollintoview(elements.getProperty("addtocart"));
    explicitywaitfoelementclick(50,"xpath",elements.getProperty("addtocart"));
}

@Test(priority=8)
public void PDP() throws Exception
{ 
    clickelement("xpath",elements.getProperty("addtocart"));
    explicitywait(50,"xpath",elements.getProperty("proceedbutton"));
    screenshots("Desktop Warranty");
    
    elementintercept(elements.getProperty("proceedbutton"));
    explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
    scrollintoview(elements.getProperty("multiproductcart"));
    screenshots("Multiple Product in Cart");
    
    clickelement("xpath",elements.getProperty("proceedtocheckout"));
    explicitywait(50,"xpath",elements.getProperty("makepayment"));
}

@Test(priority=9)
public void checkoutguest() throws Exception
{ 
    waiting(10000);
    clickelement("xpath",elements.getProperty("emailaddressfield"));
    //elementintercept(elements.getProperty("emailaddressfield"));
    enterValue("xpath",elements.getProperty("emailaddressfield"),values.getProperty("emailid"));
    clickelement("xpath",elements.getProperty("emailaddresslabel"));
    
    waiting(4000);
    clickelement("xpath",elements.getProperty("guestcheckbox"));
    
    enterValue("xpath",elements.getProperty("firstname"),values.getProperty("fname"));
    enterValue("xpath",elements.getProperty("lastname"),values.getProperty("lname"));
    enterValue("xpath",elements.getProperty("streetaddress"),values.getProperty("address"));
    enterValue("xpath",elements.getProperty("city"),values.getProperty("city"));
    enterValue("xpath",elements.getProperty("zipcode"),values.getProperty("chinazipcode"));
    enterValue("xpath",elements.getProperty("phonenumber"),values.getProperty("phonenumber"));
    selectDropdownByValue("xpath",elements.getProperty("state"),values.getProperty("chinastatecode"));
    
    scrollintoview(elements.getProperty("emailaddresslabel"));
    screenshots("Shipping Address");
    
    String producttitlecheckout=getinnertext(elements.getProperty("producttitlecheckout"));
    String warrantycheckout=getinnertext(elements.getProperty("warrantycheckout"));
    
    
    elementintercept(elements.getProperty("viewdetailcheckout"));
    
    try
    {
    Assert.assertEquals(actualproducttitleinplp, producttitlecheckout);
    Assert.assertEquals(actualwarrantyname, warrantycheckout);
    }
    catch(Exception e)
    {
	e.printStackTrace();
    }
    //elementintercept(elements.getProperty("chinaiovoice"));
    enterValue("xpath",elements.getProperty("chinaiovoice"),values.getProperty("invoice"));
    clickelement("xpath",elements.getProperty("deliverycheckbox"));
    clickelement("xpath",elements.getProperty("paymenttermcheckbox"));
    clickelement("xpath",elements.getProperty("agreecheckbox"));
    
    checkboxenable(elements.getProperty("billingsame"));
    
    screenshots("Complete Chekout");
    
   clickelement("xpath",elements.getProperty("makepayment"));
   explicitywait(50,"xpath",elements.getProperty("paymentprice"));
}

@Test(priority=10)
public void checkoutlogin() throws Exception
{ 
    goback();

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
    //waiting(30000);
    clickelement("xpath",elements.getProperty("signinbutton"));
    explicitywait(50,"xpath",elements.getProperty("manageoption"));
    
    clickelement("xpath",elements.getProperty("minicart"));
    explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
    clickelement("xpath",elements.getProperty("checkoutminicart"));
    explicitywait(50,"xpath",elements.getProperty("newaddcheckout"));
    
    elementintercept(elements.getProperty("newaddcheckout"));
    waiting(2000);
    enterValue("xpath",elements.getProperty("streetaddress"),values.getProperty("address"));
    enterValue("xpath",elements.getProperty("city"),values.getProperty("city"));
    enterValue("xpath",elements.getProperty("zipcode"),values.getProperty("chinazipcode"));
    enterValue("xpath",elements.getProperty("phonenumber"),values.getProperty("phonenumber"));
    selectDropdownByValue("xpath",elements.getProperty("state"),values.getProperty("chinastatecode"));
    clickelement("xpath",elements.getProperty("newsavecheckout"));
    waiting(5000);
    
   // elementintercept(elements.getProperty("chinaiovoice"));
    enterValue("xpath",elements.getProperty("chinaiovoice"),values.getProperty("invoice"));
    clickelement("xpath",elements.getProperty("deliverycheckbox"));
    clickelement("xpath",elements.getProperty("paymenttermcheckbox"));
    clickelement("xpath",elements.getProperty("agreecheckbox"));
   
    checkboxenable(elements.getProperty("billingsame"));
    screenshots("Complete Chekout for logged users");
    
    clickelement("xpath",elements.getProperty("makepayment"));
    explicitywait(50,"xpath",elements.getProperty("paymentprice"));
    
}

@DataProvider
public Object[][] chinaurl() throws Exception
{
    Object[][] arrayObject = xlsx_actions.getExcelData("CN");
	return arrayObject;  
}
}

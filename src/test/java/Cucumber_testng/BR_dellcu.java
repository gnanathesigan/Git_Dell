package Cucumber_testng;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BR_dellcu extends wrapper_Cucumber {
	
	 String actualpriceinplp ="";
	 String actualproducttitleinplp ="";
	    
	 String actualwarrantyname="";
	 String expectedwarrantynameincart="";
	 
	 
	
	@Given("^Open Chrome and load the brazil url of \"(.*?)\"$")
    public void testlive(String url) throws Exception
    {
	 loadingurl(url);
	   // Log.info("BR Home Page");
    }
	
	@When("^checking the all brazil plp and checking broken pages.$")
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


    @Then("^mousehover on the mainmenu section in brazil.$")
    public void mainmenushover() throws Exception
    { 
	clickelement("xpath",elements.getProperty("logo"));
	mousehover(elements.getProperty("mainmenu"));
    	  
    }
    @Given("^checking the brazil PLP functionalities \"(.*?)\"$")
    public void PLP(String name) throws Exception
    { 
	    clickelement("xpath",elements.getProperty("laptopmenu"));
	    
	    elementintercept(elements.getProperty("firstcategory"));
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
	        
	     clickelement("xpath",elements.getProperty("sortingdesc"));
	     scrollintoview(elements.getProperty("sortingname"));
	     screenshots("Sorting Desc in Sub Category");
	      //Newly added Code
	        
	    
	    actualproducttitleinplp=gettext(elements.getProperty("producttitle"));
	    actualpriceinplp=gettext(elements.getProperty("pricevalue"));
	    
	    System.out.println("PLP --> " + actualproducttitleinplp);
	    System.out.println("PLP --> " + actualpriceinplp);
	    
	    elementintercept(elements.getProperty("addproduct"));
	    waiting(5000);
	    
	    
    }

    @When("^verify the brazil warranty page and product details.$")
    public void warrantypage() throws Exception
    { 
	String url = driver.getCurrentUrl();
        System.out.println(url);
        
       if(url.contains("/index/index/pid"))
       {
	   explicitywait(50,"xpath",elements.getProperty("producttitlewarranty"));
	   
	   String expectedproducttitleinwarranty = gettext(elements.getProperty("producttitlewarranty"));
	    String expectedpriceinwarranty = gettext(elements.getProperty("productpricewarranty"));
	    
	    System.out.println("Warranty --> " + expectedproducttitleinwarranty);
	    System.out.println("Warranty --> " + expectedpriceinwarranty);
	   
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
       
       else
       {
	   clickelement("xpath",elements.getProperty("minicart"));
	   explicitywait(50,"xpath",elements.getProperty("viewcart"));
	   clickelement("xpath",elements.getProperty("viewcart"));
	   explicitywait(50,"xpath",elements.getProperty("grandtotalcart"));
       }
       
	    
    }
    
    @Then("^checking the brazil cart functionalities.$")
    public void cartpage() throws Exception
    { 
//	    String producttitlecart=getinnertext(elements.getProperty("producttitlecart"));
//	    String productpricecart=getinnertext(elements.getProperty("productpricecart"));
//	    String grandtotalcart=getinnertext(elements.getProperty("grandtotalcart"));
	    
	    String producttitlecart=gettext(elements.getProperty("producttitlecart"));
	    String productpricecart=gettext(elements.getProperty("productpricecart"));
	    String grandtotalcart=gettext(elements.getProperty("grandtotalcart"));
	    
	    System.out.println("CartPage --> " + producttitlecart);
	    System.out.println("CartPage --> " + productpricecart);
	    System.out.println("CartPage --> " + grandtotalcart);
	    
	    elementintercept(elements.getProperty("specificationcart"));
	    scrollintoview(elements.getProperty("producttitlecart"));
	    screenshots("Product Name in CartPage");
	    expectedwarrantynameincart=getinnertext(elements.getProperty("brwarrantyincart"));
	    System.out.println("CartPage --> " + expectedwarrantynameincart);
	    
	    try
	    {
	    Assert.assertEquals(actualproducttitleinplp, producttitlecart);
	    Assert.assertEquals(actualpriceinplp, productpricecart);
	    Assert.assertEquals(actualpriceinplp, grandtotalcart);
	   // Assert.assertEquals(actualwarrantyname, expectedwarrantynameincart);
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

    @Given("^checking the brazil search page functionalities.$")
    public void searchpage() throws Exception
    { 
	    clickelement("xpath",elements.getProperty("searchbox"));
	    enterValue("xpath",elements.getProperty("searchbox"),"inspiron");
	    clickelement("xpath",elements.getProperty("searchbutton"));
	    explicitywait(50,"xpath",elements.getProperty("firstcategory"));
	    screenshots("Search Page");
	    elementintercept(elements.getProperty("firstcategory"));
	    screenshots("Inspiron Desktop Category");
	    clickelement("xpath",elements.getProperty("producttitle"));
	    scrollintoview(elements.getProperty("addtocart"));
	    explicitywaitfoelementclick(50,"xpath",elements.getProperty("addtocart"));
    }

    @When("^checking the brazil PDP functionalities.$")
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
	    
    }

    @And("^checking the brazil Checkout guest functionalities values are \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
    public void checkoutguest(String email, String fname, String mname, String lname, String address, String number, String complement, String neightborhood, String City, String state, String zipcode, String phone, int installment) throws Exception
    { 
	    waiting(10000);
	    clickelement("xpath",elements.getProperty("emailaddressfield"));
	    //elementintercept(elements.getProperty("emailaddressfield"));
	    enterValue("xpath",elements.getProperty("emailaddressfield"),email);
	    clickelement("xpath",elements.getProperty("emailaddresslabel"));
	    
	    waiting(4000);
	    clickelement("xpath",elements.getProperty("guestcheckbox"));
	    
	    enterValue("xpath",elements.getProperty("firstname"),fname);
	    enterValue("xpath",elements.getProperty("middlename"),mname);
	    enterValue("xpath",elements.getProperty("lastname"),lname);
	    enterValue("xpath",elements.getProperty("streetaddress"),address);
	    enterValue("xpath",elements.getProperty("Numero"),number);
	    enterValue("xpath",elements.getProperty("Complemento"),complement);
	    enterValue("xpath",elements.getProperty("Bairro"),neightborhood);
	    enterValue("xpath",elements.getProperty("city"),City);
	    selectDropdownByValue("xpath",elements.getProperty("state"),state);
	    enterValue("xpath",elements.getProperty("zipcode"),zipcode);
	    enterValue("xpath",elements.getProperty("phonenumber"),phone);
	    
	    
	    scrollintoview(elements.getProperty("emailaddresslabel"));
	    screenshots("Shipping Address");
	    
	   // waiting(5000);
	   // elementintercept(elements.getProperty("viewdetailcheckout"));
	  //  waiting(5000);
	    
	    String producttitlecheckout=getinnertext(elements.getProperty("producttitlecheckout"));
	    System.out.println(producttitlecheckout);
	    String warrantycheckout=getinnertext(elements.getProperty("brwarrantycheckout"));
	    System.out.println(warrantycheckout);
	    
	    
	    try
	    {
	    Assert.assertEquals(actualproducttitleinplp, producttitlecheckout);
	    //Assert.assertEquals(actualwarrantyname, warrantycheckout);
	    }
	    catch(Exception e)
	    {
		e.printStackTrace();
	    }
	    //elementintercept(elements.getProperty("chinaiovoice"));
	    waiting(5000);
	    javascriptvaluepass();
	    waiting(3000);
	    selectDropdownByIndex("xpath",elements.getProperty("installment"),installment);
	    waiting(3000);
	    clickelement("xpath",elements.getProperty("deliverycheckbox"));
	    clickelement("xpath",elements.getProperty("brtermcheckbox"));
	    clickelement("xpath",elements.getProperty("emailcheckbox"));
	    clickelement("xpath",elements.getProperty("phonecheckbox"));
	    //checkboxenable(elements.getProperty("billingsame"));
	    
	    screenshots("Complete Chekout");
	    
	    clickelement("xpath",elements.getProperty("makepayment"));
	    explicitywait(50,"xpath",elements.getProperty("paymentprice"));
    }

    @Then("^checking the brazil Checkout login functionalities values are \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
    public void checkoutlogin(String address, String number, String complement, String neightborhood, String City, String state, String zipcode, String phone, int installment) throws Exception
    { 
	    //waiting(10000);
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
	    waiting(20000);
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
	    enterValue("xpath",elements.getProperty("Numero"),number);
	    enterValue("xpath",elements.getProperty("Complemento"),complement);
	    enterValue("xpath",elements.getProperty("Bairro"),neightborhood);
	    enterValue("xpath",elements.getProperty("city"),City);
	    selectDropdownByValue("xpath",elements.getProperty("state"),state);
	    enterValue("xpath",elements.getProperty("zipcode"),zipcode);
	    enterValue("xpath",elements.getProperty("phonenumber"),phone);
	    clickelement("xpath",elements.getProperty("newsavecheckout"));
	    waiting(5000);
	    
	    javascriptvaluepass();
	    waiting(3000);
	    selectDropdownByIndex("xpath",elements.getProperty("installment"),installment);
	    waiting(3000);
	    clickelement("xpath",elements.getProperty("deliverycheckbox"));
	    clickelement("xpath",elements.getProperty("brtermcheckbox"));
	    clickelement("xpath",elements.getProperty("emailcheckbox"));
	    clickelement("xpath",elements.getProperty("phonecheckbox"));
	   
	   // checkboxenable(elements.getProperty("billingsame"));
	    screenshots("Complete Chekout for logged users");
	    
	    clickelement("xpath",elements.getProperty("makepayment"));
	    explicitywait(50,"xpath",elements.getProperty("paymentprice"));
	   // waiting(10000);
	    goback();
	    waiting(10000);
	    
	    goback();
	    waiting(7000);
	    
	    clickelement("xpath",elements.getProperty("minicart"));
	    explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
	    clickelement("xpath",elements.getProperty("firstproductminicart"));
	    explicitywait(50,"xpath",elements.getProperty("acceptalert"));
	    clickelement("xpath",elements.getProperty("acceptalert"));
	    waiting(5000);
	    
	    clickelement("xpath",elements.getProperty("minicart"));
	    explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
	    clickelement("xpath",elements.getProperty("firstproductminicart"));
	    explicitywait(50,"xpath",elements.getProperty("acceptalert"));
	    clickelement("xpath",elements.getProperty("acceptalert"));
	    waiting(5000);
	    
	    clickelement("xpath",elements.getProperty("minicart"));
	    explicitywait(50,"xpath",elements.getProperty("checkoutminicart"));
	    clickelement("xpath",elements.getProperty("firstproductminicart"));
	    explicitywait(50,"xpath",elements.getProperty("acceptalert"));
	    clickelement("xpath",elements.getProperty("acceptalert"));
	    waiting(5000);
    }
}

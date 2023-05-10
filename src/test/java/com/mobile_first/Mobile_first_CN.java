package com.mobile_first;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.dell.listener.Itestlistener;

import io.github.bonigarcia.wdm.WebDriverManager;
import wrapper_Package.wrapper_Class;
import xls_package.xlsx_actions;

//@Listeners(Itestlistener.class)
public class Mobile_first_CN extends wrapper_mobile {
    
    

@Test(dataProvider = "chinaurl", priority=1)
public void Homepage(String cnurl) throws Exception
{ 
     loadingurl(cnurl);
     int value = getsize(elements.getProperty("allowcookie"));
     if(value!=0)
      {
	clickwithoutscroll(elements.getProperty("allowcookie"));
      }
     else
     {
 	Log.info("Poup not presented on Home Page");
     }    
     
//     Dimension currentDimension = driver. manage(). window(). getSize();
//     int height = currentDimension. getHeight();
//     int width = currentDimension. getWidth();
//     System. out. println("Current height: "+ height);
//     System. out. println("Current width: "+width);
     
     
     
     
     explicitywaitfoelementclick(50,"xpath",elements.getProperty("Homeslider1"));
     scrollintoview(elements.getProperty("Homeslider1"));
     clickwithoutscroll(elements.getProperty("Homeslider1"));
     waiting(15000);
     clickelement("xpath",elements.getProperty("logobutton"));
     
     explicitywaitfoelementclick(50,"xpath",elements.getProperty("Homeslider2"));
     scrollintoview(elements.getProperty("Homeslider2"));
     clickwithoutscroll(elements.getProperty("Homeslider2"));
     clickelement("xpath",elements.getProperty("logobutton"));
     
     explicitywaitfoelementclick(100,"xpath",elements.getProperty("Homeslider3"));
     scrollintoview(elements.getProperty("Homeslider3"));
     clickwithoutscroll(elements.getProperty("Homeslider3"));
     clickelement("xpath",elements.getProperty("logobutton"));
 
     explicitywaitfoelementclick(50,"xpath",elements.getProperty("homebanner"));
     scrollintoview(elements.getProperty("homebanner"));
     clickwithoutscroll(elements.getProperty("homebanner"));
     explicitywait(100,"xpath",elements.getProperty("banner1"));
    
    clickelement("xpath",elements.getProperty("banner1"));
    explicitywait(100,"xpath",elements.getProperty("banner1"));
    
    clickelement("xpath",elements.getProperty("banner1"));
    clickelement("xpath",elements.getProperty("nextbutton"));
    explicitywait(100,"xpath",elements.getProperty("banner1"));
    
    clickelement("xpath",elements.getProperty("banner1"));
    clickelement("xpath",elements.getProperty("nextbutton"));
    explicitywait(100,"xpath",elements.getProperty("finalbutton"));
    clickelement("xpath",elements.getProperty("finalbutton"));
    
    clickelement("xpath",elements.getProperty("logobutton"));
    
    explicitywaitfoelementclick(50,"xpath",elements.getProperty("homefaq"));
    scrollintoview(elements.getProperty("homefaq"));
    clickwithoutscroll(elements.getProperty("homefaq"));
    clickelement("xpath",elements.getProperty("logobutton"));
    
    explicitywaitfoelementclick(50,"xpath",elements.getProperty("homelearn"));
    scrollintoview(elements.getProperty("homelearn"));
    clickwithoutscroll(elements.getProperty("homelearn"));
    clickelement("xpath",elements.getProperty("logobutton"));
    
    explicitywaitfoelementclick(50,"xpath",elements.getProperty("homethumbnail"));
    scrollintoview(elements.getProperty("homethumbnail"));
    clickwithoutscroll(elements.getProperty("homethumbnail"));
    clickelement("xpath",elements.getProperty("logobutton"));
    
    explicitywaitfoelementclick(50,"xpath",elements.getProperty("homerecent"));
    scrollintoview(elements.getProperty("homerecent"));
    clickwithoutscroll(elements.getProperty("homerecent"));
    clickelement("xpath",elements.getProperty("logobutton"));
    
    explicitywaitfoelementclick(50,"xpath",elements.getProperty("seemore"));
    scrollintoview(elements.getProperty("seemore"));
    clickwithoutscroll(elements.getProperty("seemore"));
  
}


//@Test(priority=2)
//public void Footermenus() throws Exception
//{
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerbutton"));
//    clickwithoutscroll(elements.getProperty("footerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerlink1"));
//    clickwithoutscroll(elements.getProperty("footerlink1"));
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerbutton"));
//    clickwithoutscroll(elements.getProperty("footerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerlink2"));
//    clickwithoutscroll(elements.getProperty("footerlink2"));
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerbutton"));
//    clickwithoutscroll(elements.getProperty("footerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerlink3"));
//    clickwithoutscroll(elements.getProperty("footerlink3"));
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerbutton"));
//    clickwithoutscroll(elements.getProperty("footerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerlink4"));
//    clickwithoutscroll(elements.getProperty("footerlink4"));
//}
//
//@Test(priority=3)
//public void Headermenus() throws Exception
//{
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headershop"));
//    clickwithoutscroll(elements.getProperty("headershop"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlaptop"));
//    clickwithoutscroll(elements.getProperty("headerlaptop"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlapsub1"));
//    clickwithoutscroll(elements.getProperty("headerlapsub1"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlapsub2"));
//    clickwithoutscroll(elements.getProperty("headerlapsub2"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlapsub3"));
//    clickwithoutscroll(elements.getProperty("headerlapsub3"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlapsub4"));
//    clickwithoutscroll(elements.getProperty("headerlapsub4"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlapsub5"));
//    clickwithoutscroll(elements.getProperty("headerlapsub5"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlapsub6"));
//    clickwithoutscroll(elements.getProperty("headerlapsub6"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerdesktop"));
//    clickwithoutscroll(elements.getProperty("headerdesktop"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerdesksub1"));
//    clickwithoutscroll(elements.getProperty("headerdesksub1"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerdesksub2"));
//    clickwithoutscroll(elements.getProperty("headerdesksub2"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerdesksub3"));
//    clickwithoutscroll(elements.getProperty("headerdesksub3"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerdesksub4"));
//    clickwithoutscroll(elements.getProperty("headerdesksub4"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerdesksub5"));
//    scrollintoview(elements.getProperty("headerdesksub5"));
//    clickwithoutscroll(elements.getProperty("headerdesksub5"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headeralienware"));
//    scrollintoview(elements.getProperty("headeralienware"));
//    clickwithoutscroll(elements.getProperty("headeralienware"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headeraliensub1"));
//    scrollintoview(elements.getProperty("headeraliensub1"));
//    clickwithoutscroll(elements.getProperty("headeraliensub1"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headeraliensub2"));
//    scrollintoview(elements.getProperty("headeraliensub2"));
//    clickwithoutscroll(elements.getProperty("headeraliensub2"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headermonitor"));
//    scrollintoview(elements.getProperty("headermonitor"));
//    clickwithoutscroll(elements.getProperty("headermonitor"));
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headermonsub1"));
//    scrollintoview(elements.getProperty("headermonsub1"));
//    clickwithoutscroll(elements.getProperty("headermonsub1"));   
//    
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headersus1"));
//    scrollintoview(elements.getProperty("headersus1"));
//    clickwithoutscroll(elements.getProperty("headersus1"));
//
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerlearn"));
//    scrollintoview(elements.getProperty("headerlearn"));
//    clickwithoutscroll(elements.getProperty("headerlearn"));
//
//    clickelement("xpath",elements.getProperty("headerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("headerfaq"));
//    scrollintoview(elements.getProperty("headerfaq"));
//    clickwithoutscroll(elements.getProperty("headerfaq"));
//    
//}
//
//
//@Test(priority=4)
//public void PLPwithCart() throws Exception
//{
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerbutton"));
//    clickwithoutscroll(elements.getProperty("footerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerlink1"));
//    clickwithoutscroll(elements.getProperty("footerlink1"));
//
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    clickelement("xpath",elements.getProperty("sortimage"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickelement("xpath",elements.getProperty("sortimage"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickelement("xpath",elements.getProperty("sortingdrop"));
//    clickelement("xpath",elements.getProperty("sortingname1"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickelement("xpath",elements.getProperty("sortingdrop"));
//    clickelement("xpath",elements.getProperty("sortingprice"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickwithoutscroll(elements.getProperty("filtericon"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("inspironcheckbox"));
//    clickwithoutscroll(elements.getProperty("inspironcheckbox"));
//    scrollintoview(elements.getProperty("seeallfilter"));
//    clickwithoutscroll(elements.getProperty("seeallfilter"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//
//    scrollintoview(elements.getProperty("firstproductprice"));
//    clickelement("xpath",elements.getProperty("firstcomparecheckbox"));
//
//    scrollintoview(elements.getProperty("firstproductprice2"));
//    clickelement("xpath",elements.getProperty("secondcomparecheckbox"));
//
//    scrollintoview(elements.getProperty("firstproductprice"));
//    clickelement("xpath",elements.getProperty("firstaddbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("gotocart"));
//    waiting(5000);
//    clickwithoutscroll(elements.getProperty("continueshoppingpopup"));
//
//    scrollintoview(elements.getProperty("firstproductprice2"));
//    clickelement("xpath",elements.getProperty("secondbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("gotocart"));
//    waiting(5000);
//    clickwithoutscroll(elements.getProperty("gotocart"));
//
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("continueshopping1"));
//    clickelement("xpath",elements.getProperty("continueshopping1"));
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("maincompare"));
//    clickelement("xpath",elements.getProperty("maincompare"));
//    waiting(8000);
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("maincart"));
//    clickelement("xpath",elements.getProperty("maincart"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("continueshopping1"));
//    scrollintoview(elements.getProperty("delete1button"));
//    clickelement("xpath",elements.getProperty("delete2button"));
//    
//    waiting(15000);
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("cartmenu"));
//    scrollup();
//    clickelement("xpath",elements.getProperty("cartmenu"));
//    clickwithoutscroll(elements.getProperty("deleteallbutton"));
//    waiting(15000);
//}
//
//
//@Test(priority=5)
//public void PDPwithSearch() throws Exception
//{
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerbutton"));
//    clickwithoutscroll(elements.getProperty("footerbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("footerlink1"));
//    clickwithoutscroll(elements.getProperty("footerlink1"));
//  
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    clickelement("xpath",elements.getProperty("sortimage"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    
//    scrollintoview(elements.getProperty("firstproductimage"));
//    clickwithoutscroll(elements.getProperty("firstproductplp"));
//    
//    waiting(3000);
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("comparepdp"));
//    scrollintoview(elements.getProperty("colorheadpdp"));
//    clickelement("xpath",elements.getProperty("comparepdp"));
//    
//    clickelement("xpath",elements.getProperty("warrantyradio"));
//    
//    clickelement("xpath",elements.getProperty("addbuttonpdp"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("gotocart"));
//    waiting(5000);
//    clickwithoutscroll(elements.getProperty("gotocart"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("continueshopping1"));
//    
//    clickelement("xpath",elements.getProperty("searchboxmobile"));
//    waiting(3000);
//    enterValue("xpath",elements.getProperty("searchboxmobile"),"灵越");
//    clickelement("xpath",elements.getProperty("searchmic"));
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("searchallbutton"));
//    clickelement("xpath",elements.getProperty("searchallbutton"));
//    
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductimage"));
//    clickelement("xpath",elements.getProperty("sortimage"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickelement("xpath",elements.getProperty("sortimage"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickelement("xpath",elements.getProperty("sortingdrop"));
//    clickelement("xpath",elements.getProperty("sortingname1"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickelement("xpath",elements.getProperty("sortingdrop"));
//    clickelement("xpath",elements.getProperty("sortingprice"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//    scrollintoview(elements.getProperty("firstproductimage"));
//    scrollintoview(elements.getProperty("categorytitle"));
//
//    clickwithoutscroll(elements.getProperty("filtericon"));
//    //filtersearch
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("inspironcheckbox"));
//    clickwithoutscroll(elements.getProperty("inspironcheckbox"));
//    scrollintoview(elements.getProperty("seeallfilter"));
//    clickwithoutscroll(elements.getProperty("seeallfilter"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductplp"));
//  
//    scrollintoview(elements.getProperty("firstproductprice"));
//    clickelement("xpath",elements.getProperty("firstaddbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("gotocart"));
//    waiting(5000);
//    clickwithoutscroll(elements.getProperty("gotocart"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("continueshopping1"));
//    scrollintoview(elements.getProperty("delete1button"));  
//    
//    clickelement("xpath",elements.getProperty("checkoutbutton"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("guestbutton"));
//}
//
//@Test(priority=6)
//public void CheckoutandPaymentGuest() throws Exception
//{
//    
//    clickelement("xpath",elements.getProperty("guestbutton"));
//    waiting(8000);
//    
//    clickelement("xpath",elements.getProperty("productpopup"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductpopup"));
//    clickwithoutscroll(elements.getProperty("popupclose"));
//    
//    scrollintoview(elements.getProperty("paymentmethod"));
//    enterValue("xpath",elements.getProperty("guestfirstname"),values.getProperty("fname"));
//    enterValue("xpath",elements.getProperty("guestlastname"),values.getProperty("lname"));
//    enterValue("xpath",elements.getProperty("guestemail"),values.getProperty("emailid"));
//    enterValue("xpath",elements.getProperty("guestnumber"),values.getProperty("phonenumber"));
//    enterValue("xpath",elements.getProperty("guestaddress1"),values.getProperty("address"));
//    enterValue("xpath",elements.getProperty("guestaddress2"),values.getProperty("address1"));
//    enterValue("xpath",elements.getProperty("guestaddress3"),values.getProperty("address2"));
//    enterValue("xpath",elements.getProperty("guestcity"),values.getProperty("city"));
//    enterValue("xpath",elements.getProperty("guestpostcode"),values.getProperty("zipcode"));
//    clickelement("xpath",elements.getProperty("gueststate"));
//    clickelement("xpath",elements.getProperty("gueststateoption"));
//    
//    scrollintoview(elements.getProperty("guestusetype"));
//    clickelement("xpath",elements.getProperty("guestinvoice"));
//    enterValue("xpath",elements.getProperty("guestinvoice"),values.getProperty("invoice"));
//    clickelement("xpath",elements.getProperty("invoicecontainer"));
//    waiting(2000);
//    clickelement("xpath",elements.getProperty("guestcheckbox1"));
//    clickelement("xpath",elements.getProperty("guestcheckbox2"));
//    clickelement("xpath",elements.getProperty("guestcheckbox3"));
//    scrollintoview(elements.getProperty("guestcheckbox1"));
//    clickelement("xpath",elements.getProperty("paymentbutton"));
//  
//    explicitywait(50,"xpath",elements.getProperty("paymentprice"));
//    goback();
//    waiting(5000);
//    scrollup();
//    goback();
//    waiting(5000);
//}
//
//@Test(priority=7)
//public void CheckoutandPaymentlogged() throws Exception
//{
//    enterValue("xpath",elements.getProperty("loggedusername"),values.getProperty("exisitingmail"));
//    enterValue("xpath",elements.getProperty("loggedpassword"),values.getProperty("password"));
//    clickelement("xpath",elements.getProperty("returnusertitle"));
//    clickelement("xpath",elements.getProperty("logggedbutton"));
//    
//    waiting(10000);
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("productpopup"));
//    clickelement("xpath",elements.getProperty("productpopup"));
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("firstproductpopup"));
//    clickwithoutscroll(elements.getProperty("popupclose"));
//    
//    clickelement("xpath",elements.getProperty("shippingadd"));
//    waiting(3000);
//    enterValue("xpath",elements.getProperty("guestfirstname"),values.getProperty("fname"));
//    enterValue("xpath",elements.getProperty("guestlastname"),values.getProperty("lname"));
//    enterValue("xpath",elements.getProperty("guestnumber"),values.getProperty("phonenumber"));
//    enterValue("xpath",elements.getProperty("guestaddress1"),values.getProperty("address"));
//    enterValue("xpath",elements.getProperty("guestaddress2"),values.getProperty("address1"));
//    enterValue("xpath",elements.getProperty("guestaddress3"),values.getProperty("address2"));
//    enterValue("xpath",elements.getProperty("guestcity"),values.getProperty("city"));
//    enterValue("xpath",elements.getProperty("guestpostcode"),values.getProperty("zipcode"));
//    clickelement("xpath",elements.getProperty("gueststate"));
//    clickelement("xpath",elements.getProperty("gueststateoption"));
//    clickelement("xpath",elements.getProperty("shippingtitle"));
//    clickelement("xpath",elements.getProperty("shippingcheckbox"));
//    scrollintoview(elements.getProperty("guestaddress1"));
//    clickelement("xpath",elements.getProperty("shippingbutton"));
//    
//    waiting(10000);
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("productpopup"));
//    
//    scrollintoview(elements.getProperty("shippingadd"));
//    clickelement("xpath",elements.getProperty("billingadd"));
//    waiting(3000);
//    enterValue("xpath",elements.getProperty("guestfirstname"),values.getProperty("fname"));
//    enterValue("xpath",elements.getProperty("guestlastname"),values.getProperty("lname"));
//    enterValue("xpath",elements.getProperty("guestnumber"),values.getProperty("phonenumber"));
//    enterValue("xpath",elements.getProperty("guestaddress1"),values.getProperty("address"));
//    enterValue("xpath",elements.getProperty("guestaddress2"),values.getProperty("address1"));
//    enterValue("xpath",elements.getProperty("guestaddress3"),values.getProperty("address2"));
//    enterValue("xpath",elements.getProperty("guestcity"),values.getProperty("city"));
//    enterValue("xpath",elements.getProperty("guestpostcode"),values.getProperty("zipcode"));
//    clickelement("xpath",elements.getProperty("gueststate"));
//    clickelement("xpath",elements.getProperty("gueststateoption"));
//    clickelement("xpath",elements.getProperty("shippingtitle"));
//    clickelement("xpath",elements.getProperty("shippingcheckbox"));
//    scrollintoview(elements.getProperty("guestaddress1"));
//    clickelement("xpath",elements.getProperty("shippingbutton"));
//    
//    waiting(10000);
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("productpopup"));
//    
//    scrollintoview(elements.getProperty("guestusetype"));
//    clickelement("xpath",elements.getProperty("guestinvoice"));
//    enterValue("xpath",elements.getProperty("guestinvoice"),values.getProperty("invoice"));
//    clickelement("xpath",elements.getProperty("invoicecontainer"));
//    waiting(2000);
//    clickelement("xpath",elements.getProperty("guestcheckbox1"));
//    clickelement("xpath",elements.getProperty("guestcheckbox2"));
//    clickelement("xpath",elements.getProperty("guestcheckbox3"));
//    scrollintoview(elements.getProperty("guestcheckbox1"));
//    clickelement("xpath",elements.getProperty("paymentbutton"));
//  
//    explicitywait(50,"xpath",elements.getProperty("paymentprice"));
//    goback();
//    waiting(10000);
//    scrollup();
//    
//    clickelement("xpath",elements.getProperty("maincart"));
//    waiting(8000);
//    scrollup();
//    explicitywaitfoelementclick(50,"xpath",elements.getProperty("cartmenu"));
//}
//
//@Test(priority=8)
//public void Myaccountactivities() throws Exception
//{
//  scrollintoview(elements.getProperty("delete1button"));
//  clickelement("xpath",elements.getProperty("saveproduct2"));
//  waiting(5000);
//  
//  scrollup();
//  clickelement("xpath",elements.getProperty("cartmenu"));
//  clickwithoutscroll(elements.getProperty("deleteallbutton"));
//  waiting(7000);
//  
//  clickelement("xpath",elements.getProperty("myaccount"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccountheader"));
//  clickelement("xpath",elements.getProperty("myaccountheader"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("personalinfo"));
//  clickelement("xpath",elements.getProperty("personalinfo"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("popupclose"));
//  waiting(2000);
//  clickelement("xpath",elements.getProperty("personaledit"));
//  waiting(2000);
//  clickelement("xpath",elements.getProperty("personalsave"));
//  waiting(5000);
//  clickwithoutscroll(elements.getProperty("popupclose"));
//  waiting(5000);
//  
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccount"));
//  clickelement("xpath",elements.getProperty("myaccount"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccountheader"));
//  clickelement("xpath",elements.getProperty("myaccountheader"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("changepassword"));
//  clickelement("xpath",elements.getProperty("changepassword"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("popupclose"));
//  waiting(2000);
//  clickwithoutscroll(elements.getProperty("popupclose"));
//  waiting(5000);
//  
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccount"));
//  clickelement("xpath",elements.getProperty("myaccount"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccountheader"));
//  clickelement("xpath",elements.getProperty("myaccountheader"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("mycollection"));
//  clickelement("xpath",elements.getProperty("mycollection"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("popupclose"));
//  waiting(7000);
//  clickelement("xpath",elements.getProperty("collectionremove"));
//  waiting(10000);
//  clickwithoutscroll(elements.getProperty("popupclose"));
//  waiting(5000);
//  
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccount"));
//  clickelement("xpath",elements.getProperty("myaccount"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccountheader"));
//  clickelement("xpath",elements.getProperty("myaccountheader"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("addressbook"));
//  clickelement("xpath",elements.getProperty("addressbook"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("popupclose"));
//  waiting(2000);
//  clickwithoutscroll(elements.getProperty("popupclose"));
//  waiting(5000);
//  
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccount"));
//  clickelement("xpath",elements.getProperty("myaccount"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccountheader"));
//  clickelement("xpath",elements.getProperty("myaccountheader"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myorder"));
//  clickelement("xpath",elements.getProperty("myorder"));
//  waiting(10000);
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("popupclose"));
//  waiting(5000);
//  clickwithoutscroll(elements.getProperty("popupclose"));
//  waiting(5000);
//  
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccount"));
//  clickelement("xpath",elements.getProperty("myaccount"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("myaccountheader"));
//  clickelement("xpath",elements.getProperty("myaccountheader"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("logoutbutton"));
//  clickelement("xpath",elements.getProperty("logoutbutton"));
//  waiting(5000);
//  clickelement("xpath",elements.getProperty("myaccount"));
//  waiting(5000);
//
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("mainchat"));
//  clickwithoutscroll(elements.getProperty("mainchat"));
//  explicitywaitfoelementclick(50,"xpath",elements.getProperty("webchat"));
//  waiting(7000);
//  clickwithoutscroll(elements.getProperty("webchat"));
//  waiting(25000);
//}


@DataProvider
public Object[][] chinaurl() throws Exception
{
    Object[][] arrayObject = xlsx_actions.getExcelData("CN");
	return arrayObject;  
}

}

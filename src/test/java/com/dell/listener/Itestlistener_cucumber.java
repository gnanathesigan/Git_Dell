package com.dell.listener;

import java.net.Socket;
import java.net.SocketAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import Cucumber_testng.wrapper_Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import wrapper_Package.wrapper_Class;

public class Itestlistener_cucumber extends wrapper_Cucumber implements ITestListener {
  
    @Override
    public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println("onTestStart:" + result.getName());
	ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
	System.out.println("onTestSuccess");
	//screenshots(result.getName());
	
    }

    @Override
    public void onTestFailure(ITestResult result) {
	ITestListener.super.onTestFailure(result);
	//screenshots(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
	System.out.println("onTestSkipped");
	ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	System.out.println("onTestFailedButWithinSuccessPercentage");
	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
	System.out.println("onTestFailedWithTimeout");
	ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
	System.out.println(context.getName() +" :onStart");
	ITestListener.super.onStart(context);
	initialiseExtentReports(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
	System.out.println(context.getName() +" onFinish");
	ITestListener.super.onFinish(context);
	generateExtentReports(context.getName());
    }
    

}

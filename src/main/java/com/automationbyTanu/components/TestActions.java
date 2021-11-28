package com.automationbyTanu.components;

import com.automationbyTanu.browser.Drivermanager;
import com.automationbyTanu.properties.propertyloader;
import com.automationbyTanu.properties.propertyvalidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class TestActions {

 public  ThreadLocal<WebDriver> driver = new ThreadLocal<>();
 public Drivermanager driverManager;
 public BaseActions pageactions;

    @BeforeSuite
    public void setupconfigrations() throws Exception {
        propertyloader.intializeproperties();
        propertyvalidator.validateconfigrations();
        driverManager=new Drivermanager();
    }


    @BeforeMethod
    public void setupBrowser() throws InterruptedException {

    driverManager.loadriver();
    driver.set(driverManager.getDriver());
    pageactions=new BaseActions(driver.get());
    pageactions.launchurl(propertyloader.appurl);

    }

@AfterMethod
    public void teardownBrowser() throws Exception {
    driverManager.closebrowser();

    }
    @AfterSuite
    public void teardownobjects() throws Exception{
        propertyloader.configProperties=null;

    }


}


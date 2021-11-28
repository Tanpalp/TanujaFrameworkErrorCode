package com.automationbyTanu.browser;

import com.automationbyTanu.properties.propertyloader;
import org.openqa.selenium.WebDriver;

public class Drivermanager {

   public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void setDriver(WebDriver driver)

    {
        this.driver.set(driver);
     }

    public void loadriver()

    {
        Browser browser=null;
        String path="";
        if(propertyloader.runonbrowser.equalsIgnoreCase("Chrome")){
         browser=new chrome();
         path=propertyloader.chromedriverpath;

        }else if(propertyloader.runonbrowser.equalsIgnoreCase("Edge")){
            browser=new Edge();
            path=propertyloader.edgedriverpath;
        }

        browser.setHeadless(propertyloader.headless);
        browser.setRemote(propertyloader.remoteRun);
        browser.setMaximized(propertyloader.maximizemode);
        browser.setPageLoadTimeout(propertyloader.pageloadwait);
        browser.setprefernces();
      WebDriver driver=  browser.loadBrowser(path);
      setDriver(driver);
    }

    public void closebrowser()
    {

        driver.get().close();
    }


    public void closeallbrowsers() {

        driver.get().quit();
    }

}

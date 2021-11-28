package com.automationbyTanu.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Edge extends Browser {


    EdgeOptions edgeoptions;

    @Override

        public void setprefernces() {
      edgeoptions=new EdgeOptions();




        Map<String,Object> prefs=new HashMap<String,Object>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("useAutomationExtension",false);
        prefs.put("excludeSwitches", Collections.singleton("enable-automation"));
        edgeoptions.setCapability("prefs",prefs);



    }



    @Override
    public WebDriver loadBrowser(String path) {

        WebDriver driver=null;
        System.setProperty("WebDriver.edge.driver",path);
        if(isRemote()){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),edgeoptions);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            driver=new EdgeDriver(edgeoptions);
if(isMaximized()) {
    driver.manage().window().maximize();
}


            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if(isDeletecookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
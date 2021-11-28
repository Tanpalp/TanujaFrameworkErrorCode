package com.automationbyTanu.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class chrome extends Browser{


    ChromeOptions chromeoptions;
    @Override
    public void setprefernces() {
chromeoptions=new ChromeOptions();


if(isHeadless())
{
    chromeoptions.setHeadless(true);
}
if(isMaximized()){
    chromeoptions.addArguments("start-maximized");
}

Map<String,Object> prefs=new HashMap<String,Object>();
prefs.put("credentials_enable_service",false);
prefs.put("profile.password_manager_enabled",false);
prefs.put("useAutomationExtension",false);
prefs.put("excludeSwitches", Collections.singleton("enable-automation"));
chromeoptions.setExperimentalOption("prefs",prefs);



    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver=null;
        System.setProperty("Webdriver.chrome.driver",path);
        if(isRemote()){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:444/wb/hub"),chromeoptions);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            driver=new ChromeDriver(chromeoptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if(isDeletecookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}

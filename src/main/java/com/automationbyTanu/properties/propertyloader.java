package com.automationbyTanu.properties;

import com.automationbyTanu.configrationexceptions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class propertyloader {
   public static Properties configProperties;

    public static String runonbrowser;
    public static Boolean takescreenshot;
    public static String chromedriverpath;
    public static String iEdriverpath;
    public static String edgedriverpath;
    public static String firefoxdriverapth;
    public static Boolean maximizemode;
    public static Integer implicitwait;
    public static Integer explicitwait;
    public static Integer pageloadwait;
    public static boolean headless;
    public static boolean deletecookies;
    public static boolean remoteRun;
    public static String appurl;


    public static void intializeproperties()throws Exception
    {
        if(configProperties==null){
            configProperties=new Properties();
            FileInputStream fileInputStream=new FileInputStream(new File(System.getProperty("user.dir")+"/src//test//resources//config.properties"));
            configProperties.load(fileInputStream);
        }
        runonbrowser=configProperties.getProperty("RunonBrowser");
        takescreenshot= Boolean.valueOf(configProperties.getProperty("Takescreenshot"));
        chromedriverpath=configProperties.getProperty("Chromedriverpath");
        iEdriverpath=configProperties.getProperty("IEdriverpath");


        edgedriverpath=configProperties.getProperty("Edgedriverpath");
        firefoxdriverapth=configProperties.getProperty("Firefoxdriverpath");
        maximizemode=Boolean.valueOf(configProperties.getProperty("Maximizemode"));
        implicitwait=Integer.valueOf(configProperties.getProperty("Implicitwait"));
        explicitwait=Integer.valueOf(configProperties.getProperty("Explicitwait"));

        pageloadwait=Integer.valueOf(configProperties.getProperty("Pageloadwait"));
        headless=Boolean.valueOf(configProperties.getProperty("headless"));
      deletecookies=Boolean.valueOf(configProperties.getProperty("deletecookies"));
        remoteRun=Boolean.valueOf(configProperties.getProperty("remoteRun"));
        appurl=configProperties.getProperty("appurl");


    }


    public static void main (String[]args) throws Exception {
        propertyloader.intializeproperties();

        propertyvalidator.validateconfigrations();
    }

}

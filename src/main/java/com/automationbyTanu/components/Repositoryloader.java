package com.automationbyTanu.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Repositoryloader {
    static Properties properties;


    public void loadproperties() throws IOException {
        String path = System.getProperty("user.dir") + "//src//main//resources//OR.properties";
        FileInputStream Fis = new FileInputStream(new File(path));
        properties = new Properties();
        properties.load(Fis);
    }

        public String  getproperty(String name)

        {
return properties.getProperty(name);
        }

        public static void main(String[]args)throws IOException{
        Repositoryloader loader=new Repositoryloader();
        loader.loadproperties();
        System.out.println(loader.getproperty("Loginpage.tbx_Username"));
    }

}

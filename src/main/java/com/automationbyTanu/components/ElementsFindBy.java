package com.automationbyTanu.components;

import com.automationbyTanu.properties.propertyloader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ElementsFindBy {
    WebDriver driver;
    WebDriverWait wait;

    public ElementsFindBy(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(this.driver,propertyloader.explicitwait);
    }

    public By findby(String element) throws IOException, Exception {
        By by;
        Repositoryloader loader = new Repositoryloader();
        loader.loadproperties();
        String elementvalue = loader.getproperty(element);
        String findby = elementvalue.split(":")[0];
        String findByvalue = elementvalue.split(":")[1];
        if (findby.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByvalue);

        } else if (findby.equalsIgnoreCase("id")) {
            by = By.id(findByvalue);
        } else if (findby.equalsIgnoreCase("name")) {
            by = By.name(findByvalue);
        } else if (findby.equalsIgnoreCase("class")) {
            by = By.className(findByvalue);
        } else if (findby.equalsIgnoreCase("css")) {
            by = By.cssSelector(findByvalue);
        } else if (findby.equalsIgnoreCase("linktext")) {
            by = By.linkText(findByvalue);
        } else if (findby.equalsIgnoreCase("partiallinktext")) {
            by = By.partialLinkText(findByvalue);
        } else {
            throw new Exception("Invalid locator Type/value in[" + element + "].plz check value in OR file");
        }
        return by;
    }


    public WebElement findElementBy(String element) throws Exception {
        By by = findby(element);
       return waituntillelementvisible(by);



    }

    public List<WebElement> findElementsBy(String element) throws Exception {
        By by = findby(element);
        return waituntillAllelementsvisible(by);


    }

    public WebElement waituntillelementvisible(By by)throws Exception{
return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }


    public List<WebElement >waituntillAllelementsvisible(By by)throws Exception{
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }


    public boolean waituntillelementunvisible(By by)throws Exception {

    return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

}



    public WebElement waituntlillelementfound(By by)throws Exception{
       return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waituntillclickable(By by)throws Exception{
return wait.until(ExpectedConditions.elementToBeClickable(by));

    }
}
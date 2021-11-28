package com.automationbyTanu.components;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import  org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseActions {

    WebDriver driver;

   public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickit(String elementRef) {
        try {
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.click();
        } catch (Exception e) {

        }
    }




    public void typeinto(String elementRef,String text) {

        try {

            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.click();
            elementBy.clear();
            elementBy.sendKeys(text);
        } catch (Exception e) {

        }
    }
        public String getTextFromElement(String elementRef) {
            try {
                ElementsFindBy findobj = new ElementsFindBy(driver);

                WebElement elementBy = findobj.findElementBy(elementRef);
                return elementBy.getText();

            } catch (Exception e) {
                return null;
            }
        }




    public String getattributeforelement(String elementRef, String attributetype) {
        try {

            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            return elementBy.getAttribute(attributetype);
        } catch (Exception e) {
            return null;
        }

    }


    public void getvaluefromdropdown(String elementRef, String selectBy, String option) {
        try {

            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            Select dropdown = new Select(elementBy);
            if (selectBy.equalsIgnoreCase("visibletext")) {
                dropdown.selectByVisibleText(option);
            } else if (selectBy.equalsIgnoreCase("value")) {
                dropdown.selectByValue(option);
            } else if (selectBy.equalsIgnoreCase("index")) {
                int Index = Integer.parseInt(option);
                dropdown.selectByIndex(Index);
            }
        } catch (Exception e) {

        }

    }


    public void switchtosecondwindow() {
        try {
            driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
        } catch (Exception e) {

        }
    }


    public void switchtolastwindow() {
        try {
            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(windows.size() - 1));
        } catch (Exception e) {

        }
    }

    public void hitenter(String elementRef) {
        try {

            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.ENTER);
        } catch (Exception e) {

        }
    }


    public void hittab(String elementRef) {
        try {

            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.TAB);
        } catch (Exception e) {

        }
    }


    public void launchurl(String url) {
        try {

            driver.get(url);
        } catch (Exception e) {

        }
    }


    public void refreshpage(String url) {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            new Actions(driver).sendKeys(Keys.F5);
        }
    }


    public void switchtoAlertandAccept() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {

        }
    }


    public void switchtoAlertandDismiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {

        }
    }


    public void switchtoframe(String elementRef) {
        try {
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            driver.switchTo().frame(elementBy);
        } catch (Exception e) {

        }
    }


    public void switchtoorigianlpagefromiframe(String elementRef) {
        try {

            driver.switchTo().defaultContent();
        } catch (Exception e) {

        }
    }


    public void scrolltoElement(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);

        } catch (Exception e) {

        }

    }

    public void scrolltoTop(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        } catch (Exception e) {

        }

    }


    public void scrolltoBottom(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        } catch (Exception e) {

        }

    }


    public void hoveronto(String elementRef) {
        try {
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
new Actions(driver).moveToElement(elementBy).build().perform();
        } catch (Exception e) {

        }

    }


    public void draganddrop(String elementRef1,String elementRef2)
    {
        try {
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy1 = findobj.findElementBy(elementRef1);
            WebElement elementBy2 = findobj.findElementBy(elementRef2);

            new Actions(driver).dragAndDrop(elementBy1,elementBy2).build().perform();
        } catch (Exception e) {

        }


    }


    public void rightclichelement(String elementRef)
    {
        try {
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            new Actions(driver).contextClick(elementBy).build().perform();
        }catch(Exception e)
        {

        }

    }


    public void doubleclickonlement(String elementRef)
    {
        try {
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            new Actions(driver).doubleClick(elementBy).build().perform();
        }catch(Exception e)
        {

        }

    }


    public boolean isenabled(String elementRef)
    {
        try{
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            return elementBy.isEnabled();

        }catch(Exception e)
        {
return false;
        }

    }

    public boolean isdispalyed(String elementRef)
    {
        try{
            ElementsFindBy findobj = new ElementsFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            return elementBy.isDisplayed();

        }catch(Exception e)
        {
            return false;
        }

    }
}
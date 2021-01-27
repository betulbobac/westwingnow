package pages;

import constant.TestSettingConstants;
import interfaces.IPageObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageObject implements IPageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Action action;

    public PageObject(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, TestSettingConstants.WAIT_TIMEOUT_IN_SECONDS);
        this.action = action;
    }

    public void clickElementByXpath(String xpath) {
        try{
            By waitBy = waitByXpath(xpath);
            this.driver.findElement(waitBy).click();
        }
        catch(Exception e){
            Assert.fail(String.format("%s xpath element cannot be clicked , %s",xpath,e.getMessage()));
        }

    }

    public By waitByXpath(String xpath) {
       By waitBy = null;
       try {
           waitBy = By.xpath(xpath);
           this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(waitBy,0));
       }
           catch(Exception e){
               Assert.fail(String.format("%s xpath element cannot be found , %s",xpath,e.getMessage()));
           }
       return waitBy;
       }

    public void enterTextByXpath(String xpath,String text) {
        try{
            By waitBy = waitByXpath(xpath);
            WebElement webElement = this.driver.findElement(waitBy);
            webElement.clear();
            webElement.click();
            webElement.sendKeys(text);


        }
        catch(Exception e){
            Assert.fail(String.format("%s text cannot be entered into %s",text,xpath));
        }
    }

    public void hover(String xpath) {
        try{
            By waitBy = waitByXpath(xpath);
            Actions actions = new Actions(driver);
            WebElement categoryOption = this.driver.findElement(waitBy);
            actions.moveToElement(categoryOption).perform();
        }
        catch(Exception e){
            Assert.fail(String.format("%s element cannot be mouse hovered due to %s",xpath,e.getMessage()));
        }
    }

    public void clickLastElement(String xpath) {
        try{
            By waitBy = waitByXpath(xpath);
            WebElement existingElements = null;
            for(WebElement elements:driver.findElements(waitBy)){
                existingElements = elements;
            }
                existingElements.click();
        }catch (Exception e){
            Assert.fail(xpath + " element cannot be clicked due to " + e.getMessage());
        }
    }

    public void clickFirstElement(String xpath) {
        try{
            By waitBy = waitByXpath(xpath);
            WebElement existingElements = null;
            for(WebElement elements:driver.findElements(waitBy)){
                existingElements = elements;
                break;
            }
            existingElements.click();
        }catch (Exception e){
            Assert.fail(xpath + " element cannot be clicked due to " + e.getMessage());
        }
    }

    public String getTextOfElement(String xpath) {
        String text ="";
        try{
            By waitBy = waitByXpath(xpath);
            text =this.driver.findElement(waitBy).getText();
            return text;
        }
        catch(Exception e){
            Assert.fail(String.format("%s xpath element cannot be clicked , %s",xpath,e.getMessage()));
        }

        return text;

    }

    public Boolean isElementExist(String xpath) {
        try{
            this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if(this.driver.findElements(By.xpath(xpath)).size()>0){
                return true;
            }
        }
        catch(Exception e){
            Assert.fail(String.format("%s xpath element cannot be clicked , %s",xpath,e.getMessage()));
        }

        return false;
    }

    public String getTextOfElementFirstElement(String xpath) {
        try{
            By waitBy = waitByXpath(xpath);
            WebElement existingElements = null;
            for(WebElement elements:driver.findElements(waitBy)){
                existingElements = elements;
                break;
            }
           return existingElements.getAttribute("textContent");
        }catch (Exception e){
            Assert.fail(xpath + " element cannot be clicked due to " + e.getMessage());
        }
    return null;
    }

    public ArrayList getTextOfAllElements(String xpath) {
    	ArrayList asList = new ArrayList();
        try{
            By waitBy = waitByXpath(xpath);
            WebElement existingElements = null;
            for(WebElement elements:driver.findElements(waitBy)){
                existingElements = elements;
                //existingElements.getAttribute("textContent");
                asList.add(existingElements.getAttribute("textContent"));
            }
           return asList;
        }catch (Exception e){
            Assert.fail(xpath + " element cannot be clicked due to " + e.getMessage());
        }
    return null;
    }
    
    
    public String getValueOfElement(String xpath) {
        String value ="";
        try{
            By waitBy = waitByXpath(xpath);
            value =this.driver.findElement(waitBy).getAttribute("value");
            return value;
        }
        catch(Exception e){
            Assert.fail(String.format("%s xpath element cannot be clicked , %s",xpath,e.getMessage()));
        }
        return value;

    }

    public void pressEnter() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoWaitForIdle(true);
        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public boolean isElementLoaded(String xpath) {
        Boolean isImageLoaded = null;

        try{
            By waitBy = waitByXpath(xpath);
            WebElement existingElements = null;
            for(WebElement elements:driver.findElements(waitBy)){
                isImageLoaded=elements.isDisplayed();
                //isImageLoaded  = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", elements);

                System.out.println(String.format("Loding status is true for image %s",elements.getAttribute("data-id")));

                if (!isImageLoaded) {
                    System.out.println(String.format("Loding status is %s for image %s",isImageLoaded,elements));
                }

            }
        }catch (Exception e){
            Assert.fail(xpath + " element cannot be clicked due to " + e.getMessage());
        }


        return isImageLoaded;
    }

    public boolean isImageLoaded(){
        int invalidImageCount = 0;
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));


        for (WebElement imgElement : imagesList) {
            if (imgElement != null) {
                System.out.println(String.format("Element %s is being verified",imgElement));

               if( verifyimageActive(imgElement) != 0) {
            	   return false;
               }
            }
        }
        System.out.println(String.format("Total no. of invalid images are %d",invalidImageCount));
		return true;
    }
    public int verifyimageActive(WebElement imgElement) {
        int invalidImageCount=0;

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() != 200) {
                invalidImageCount++;
                System.out.println("!!!!!This image is not loaded : "+imgElement.getAttribute("alt"));
                return invalidImageCount;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return invalidImageCount;
    }

	public String getTitleOfBrowser() {
		// TODO Auto-generated method stub
		return this.driver.getTitle();
	}
	
	 public boolean isLinkLoaded(){
	        int invalidLinkCount = 0;
	        List<WebElement> linkList = driver.findElements(By.tagName("a"));


	        for (WebElement linkElement : linkList) {
	            if (linkElement != null) {
	                System.out.println(String.format("Element %s is being verified",linkElement));

	               if( verifyLinkActive(linkElement) != 0) {
	            	   return false;
	               }
	            }
	        }
	        System.out.println(String.format("Total no. of invalid links are %d",invalidLinkCount));
			return true;
	    }
	    public int verifyLinkActive(WebElement linkElement) {
	        int invalidImageCount=0;

	        try {
	            HttpClient client = HttpClientBuilder.create().build();
	            HttpGet request = new HttpGet(linkElement.getAttribute("href"));
	            HttpResponse response = client.execute(request);
	            // verifying response code he HttpStatus should be 200 if not,
	            // increment as invalid images count
	            if (response.getStatusLine().getStatusCode() != 200) {
	                invalidImageCount++;
	                System.out.println("!!!!!This link is not loaded : "+linkElement.getAttribute("href"));
	                return invalidImageCount;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return invalidImageCount;
	    }
}

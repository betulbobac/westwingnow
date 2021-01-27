package interfaces;

import org.openqa.selenium.By;

public interface IPageObject {
    void clickElementByXpath(String xpath);
    By waitByXpath(String xpath);
    void enterTextByXpath(String xpath,String text);
    void hover(String xpath);
    void clickLastElement(String xpath);
    void clickFirstElement(String xpath);
    String getTextOfElement(String xpath);
    Boolean isElementExist(String xpath);
    String getTextOfElementFirstElement(String xpath);
    String getValueOfElement(String xpath);
    void pressEnter();

    boolean isElementLoaded(String xpath);
}

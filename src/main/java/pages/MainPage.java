package pages;

import constant.MainPageConstants;
import constant.MainPageXpathConstants;
import interfaces.IMainPage;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class MainPage extends PageObject implements IMainPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

	@Override
	public void clickSearchArea() {
		super.clickElementByXpath(MainPageXpathConstants.SEARCH_AREA);
	}

	@Override
	public void searchProduct(String searchText) {
		super.waitByXpath(MainPageXpathConstants.SEARCH_AREA);
		super.enterTextByXpath(MainPageXpathConstants.SEARCH_AREA, searchText);		
	}

	@Override
	public void clickAcceptCookie() {
		super.clickElementByXpath(MainPageXpathConstants.ACCEPT_COOKIE);		
	}

	@Override
	public void selectProductNameFromList(String text) {
		super.clickFirstElement(String.format(MainPageXpathConstants.SEARCH_TEXT, text));
	}

	@Override
	public void clickMyAccount() {
		super.clickElementByXpath(MainPageXpathConstants.MY_ACCOUNT);		
	}

	@Override
	public void enterEmail(String emailAddress) {
        super.enterTextByXpath(MainPageXpathConstants.EMAIL_AREA, MainPageConstants.EMAIL_ADDRESS);		
	}

	@Override
	public void clickLogin() {
       super.clickElementByXpath(MainPageXpathConstants.LOGIN);		
	}

	@Override
	public void enterPassword(String password) {
		super.enterTextByXpath(MainPageXpathConstants.PASSWORD_AREA, MainPageConstants.PASSWORD);
		
	}

	@Override
	public void clickLoginButton() {
        super.clickElementByXpath(MainPageXpathConstants.LOGIN_BUTTON);		
	}

	@Override
	public void waitUntilLoginSuccess() {
		super.waitByXpath(MainPageXpathConstants.LOGIN_SUCCESS_TEXT);
		
	}

	@Override
	public void clickWishListFirstProduct() {
         super.clickFirstElement(MainPageXpathConstants.WISHLIST_ICON_FIRST_PRODUCT);		
	}

	@Override
	public String getCounterValue() {
		return super.getTextOfElement(MainPageXpathConstants.WISHLIST_COUNTER);
		
	}

	@Override
	public void clickWishList() {
		super.clickElementByXpath(MainPageXpathConstants.WISHLIST_ICON);
		
	}

	@Override
	public boolean isProductExistInWishList() {
		return super.isElementExist(MainPageXpathConstants.PRODUCT_WITHIN_WISHLIST);
		
	}

	@Override
	public void waitUntilFilterApplied() {
		super.waitByXpath(MainPageXpathConstants.TITLE_AFTER_FILTER);
		
	}

	@Override
	public void removeFromWishList() {
		super.clickElementByXpath(MainPageXpathConstants.REMOVE_WISHLIST);
		
	}

	@Override
	public String getWishListInformation() {
		return super.getTextOfElement(MainPageXpathConstants.WISHLIST_INFO_TEXT);

	}

	@Override
	public boolean isCounterExist() {
		return super.isElementExist(MainPageXpathConstants.WISHLIST_COUNTER);
	}

	

   
}

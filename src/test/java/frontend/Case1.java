package frontend;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.MainPageConstants;
import constant.MainPageXpathConstants;

import org.testng.annotations.BeforeClass;


public class Case1 extends BaseTest{

   @BeforeClass
   public void BeforeClass() {
    mainPage.clickAcceptCookie();
   	mainPage.clickMyAccount();
   	mainPage.clickLogin();
   	mainPage.enterEmail(MainPageConstants.EMAIL_ADDRESS);
   	mainPage.enterPassword(MainPageConstants.PASSWORD);
   	mainPage.clickLoginButton();
   	mainPage.waitUntilLoginSuccess();
   }
	
	
	@Test
    public void Demo_TC001(){
    	
    	
    	mainPage.searchProduct("Möbel");
    	mainPage.selectProductNameFromList("Möbel");
    	mainPage.waitUntilFilterApplied();
    	mainPage.clickWishListFirstProduct();
    	Assert.assertEquals(mainPage.getCounterValue(), "1");
    	mainPage.clickWishList();
    	Assert.assertTrue(mainPage.isProductExistInWishList());
    	mainPage.removeFromWishList();
    	Assert.assertFalse(mainPage.isCounterExist());
    	
    	
    	
    	
    	
    }
    	
   
}

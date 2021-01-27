package interfaces;

import java.util.ArrayList;
import constant.MainPageConstants;
public interface IMainPage {
    void clickSearchArea();
    void clickAcceptCookie();
    void searchProduct(String searchText);
    void selectProductNameFromList(String text);
    void clickMyAccount();
    void enterEmail(String emailAddress);
    void clickLogin();
    void enterPassword(String password);
    void clickLoginButton();
    void waitUntilLoginSuccess();
    void clickWishListFirstProduct();
    String getCounterValue();
    void clickWishList();
    boolean isProductExistInWishList();
    void waitUntilFilterApplied();
    void removeFromWishList();
    String getWishListInformation();
    boolean isCounterExist();

}

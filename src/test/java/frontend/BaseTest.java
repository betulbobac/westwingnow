package frontend;

import constant.TestSettingConstants;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pages.MainPage;
import util.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest  {
    protected static WebDriver driver;
    protected static MainPage mainPage;

    @BeforeSuite
    public static void setUpSuite(){
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        String url = TestSettingConstants.URL;
        driver = webDriverFactory.createWebDriver(TestSettingConstants.CHROME);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);

        
    }

    @AfterSuite
    public static void tearDownSuite(){
        driver.close();
    }
}

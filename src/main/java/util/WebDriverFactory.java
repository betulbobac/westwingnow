package util;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import static constant.TestSettingConstants.*;

public class WebDriverFactory {
    public WebDriver createWebDriver(int type){
        WebDriver driver = null;
        switch (type){
            case IE:
                System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
                driver = new InternetExplorerDriver();
                return driver;

            case CHROME:
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
                chromeOptions.addArguments("--window-size=1400,600");
                chromeOptions.addArguments("disable-infobars");
                //Map<String,Object> prefs = new HasMap<String,Object>();
                //prefs.put("safebrowsing.enabled",true);
                driver = new ChromeDriver(chromeOptions);
                return driver;

            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver = new FirefoxDriver(firefoxOptions);
                return driver;

        }
            return driver;

    }
}

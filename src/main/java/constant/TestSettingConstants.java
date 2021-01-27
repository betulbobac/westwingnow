package constant;

public class TestSettingConstants {
    public static final String URL = "https://www.westwingnow.de/";
    public static final String PROJECT_BASE_DIR = System.getProperty("user.dir");
    public static final int IE = 1;
    public static final int CHROME = 2;
    public static final int FIREFOX = 3;
    public static final String IE_DRIVER_PATH = PROJECT_BASE_DIR +"\\src\\main\\java\\webdriver\\iedriver.exe";
    public static final String CHROME_DRIVER_PATH = PROJECT_BASE_DIR +"\\src\\main\\java\\webdriver\\chromedriver.exe";
    public static final String FIREFOX_DRIVER_PATH = PROJECT_BASE_DIR +"\\src\\main\\java\\webdriver\\geckodriver.exe";
    public static final int WAIT_TIMEOUT_IN_SECONDS = 10;
}

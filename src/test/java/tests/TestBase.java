package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver; //static so I can use it across all test classes that will extend this class as long as running our test

    @BeforeSuite
    @Parameters({"browser"})
    //@Optional in case didn't find the requested brwoser
    public void startDriver(@Optional("chrome") String browserName){

        //Choose which browser will open by writing browser value in testng.xml
        if (browserName.equalsIgnoreCase("chrome")) {
            //if we put it in the resources: System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            //if we put it in the resources: System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        /* or choose the browser by using switch case:
        switch (browserType) {
            case "firefox":
        */
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        /*or explicit waiting:
        public Wait<WebDriver> wait;
        wait = new WebDriverWait(driver, 20);
         */
        driver.navigate().to("https://www.google.com/ncr");
    }


    @AfterSuite
    public void stopDriver(){
        driver.quit();
    }

}

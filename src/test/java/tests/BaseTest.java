package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setup(){


        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs",prefs);

//        options.addArguments("--headless=new");
//        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));



    }





    @AfterMethod
    public void teardown(){
        if (driver!=null){
            driver.quit();
        }

    }
}

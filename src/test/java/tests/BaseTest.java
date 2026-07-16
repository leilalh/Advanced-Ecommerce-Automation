package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
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
    public void recordFailure(org.testng.ITestResult result){

        if (org.testng.ITestResult.FAILURE == result.getStatus()){
            org.openqa.selenium.TakesScreenshot camera = (org.openqa.selenium.TakesScreenshot) driver;

            java.io.File screenshot = camera.getScreenshotAs(org.openqa.selenium.OutputType.FILE);

            try {
                String directoryPath = "screenshots/";
                String fileName = result.getName()+"_"+ System.currentTimeMillis()+".png";

                java.io.File directory = new java.io.File(directoryPath);

                if (!directory.exists()){
                    directory.mkdirs();
                }

                java.nio.file.Files.copy(
                        screenshot.toPath(), java.nio.file.Paths.get(directoryPath + fileName),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING);


                System.out.println("Screenshot captured for failed test : "+result.getName());
            } catch (java.io.IOException e){
                System.out.println("Could not save screenshots: "+ e.getMessage());
            }
        }

    }

    public void teardown(){
        if (driver!=null){
            driver.quit();
        }

    }
}

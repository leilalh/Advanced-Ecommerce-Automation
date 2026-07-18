package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupReport(){
        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/ExtentReport.html");
        extent = new ExtentReports();

        extent.attachReporter(spark);
        extent.setSystemInfo("QA Engineer", "Leila");
        extent.setSystemInfo("Environment", "Production");
    }






    @BeforeMethod
    public void setup(java.lang.reflect.Method method){

        test = extent.createTest(method.getName());


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
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                String directoryPath = "screenshots/";
                String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";

                File directory = new File(directoryPath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                Files.copy(
                        screenshot.toPath(), Paths.get(directoryPath + fileName),
                        StandardCopyOption.REPLACE_EXISTING);

                //   Extent Report
                test.fail("Test Failed ! View screenshot below:")
                        .addScreenCaptureFromPath("../" + directoryPath + fileName);

                System.out.println("Screenshot captured for failed test : " + result.getName());
            } catch (java.io.IOException e) {
                System.out.println("Could not save screenshots: " + e.getMessage());
            }
        }
        else if (ITestResult.SUCCESS == result.getStatus()) {
            test.pass("Test passed successfully! ");
        }


        if (driver != null) {
            driver.quit();
        }
    }
    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
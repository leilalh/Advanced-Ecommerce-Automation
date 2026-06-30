package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By loginemail = By.cssSelector("input[data-qa='login-email']");
    By loginpassword = By.cssSelector("input[data-qa='login-password']");
    By loginbutton = By.cssSelector("button[data-qa='login-button'");

    By signUpname = By.cssSelector("input[data-qa='signup-name']");
    By signUpemail = By.cssSelector("input[data-qa='signup-email']");
    By signUpbutton = By.cssSelector("button[data-qa='signup-button'");

    public SignupLoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void enterloginEmailPassword(String logemail, String logpassword){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginemail)).sendKeys(logemail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginpassword)).sendKeys(logpassword);
    }
    public void clickloginbutton(){
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(loginbutton));
    }

    public void entersignupNameEmail(String sname, String semail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpname)).sendKeys(sname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpemail)).sendKeys(semail);

    }

    public void clicksignupbutton(){
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(signUpbutton));
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginSignupLink = By.xpath("//a[contains(text(),' Signup / Login')]");
    private By prodcutsButton = By.xpath("//a[contains(text(), ' Products')]");

    public HomePage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickloginSign(){
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(loginSignupLink));

    }
    public void clickprodcutsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(prodcutsButton)).click();
    }
}

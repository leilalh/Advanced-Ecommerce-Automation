package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginSignupLink = By.xpath("//a[contains(text(),' Signup / Login')]");

    public HomePage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickloginSign(){
        wait.until(ExpectedConditions.elementToBeClickable(loginSignupLink)).click();
    }
}

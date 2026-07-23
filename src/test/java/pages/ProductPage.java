package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By viewproducts = By.xpath("//a[contains(text(), 'View Product')]");
    private By quantityBox = By.id("quantity");
    private By addtocart = By.cssSelector("button.cart");
    private By continurshopping = By.xpath("//button[contains(text(), 'Continue Shopping')]");
    private By suceesMessagePopup = By.xpath("//p[contains(text(), 'Your product has been added to cart.')]");

    public ProductPage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait= wait;

    }


    public void clickViewProduct(){

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(viewproducts));

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void enterquantity(String numberQuantity){
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityBox)).clear();
        driver.findElement(quantityBox).sendKeys(numberQuantity);

    }
    public void clickaddcart(){
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();
    }
    public void clickcontinueshopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continurshopping)).click();
    }
    public String getPopupSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(suceesMessagePopup)).getText();
    }






}

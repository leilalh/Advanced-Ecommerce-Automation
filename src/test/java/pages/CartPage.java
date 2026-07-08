package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By ProceedButton = By.xpath("//a[contains(text(), 'Proceed To Checkout')]");
    private By ProductInCart = By.xpath("//a[contains(text(), 'Blue Top')]");
    private By productQuantityInCart = By.xpath("//td[@class='cart_quantity']/button");
    private By deletProdcutButton = By.className("cart_quantity_delete");


    public CartPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickProceedButton(){
        wait.until(ExpectedConditions.elementToBeClickable(ProceedButton)).click();
    }
    public boolean isProductDisplayedInCart(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductInCart)).isDisplayed();
    }
    public String getProductQuantityInCart(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart)).getText();
    }
    public void clearCartIfNotEmpty(){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(deletProdcutButton)).click();

            System.out.println("Cart cleared successfully for new test run");
        } catch (Exception e) {
            System.out.println("Cart is already empty. Skipping deletion");
        }









    }




}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By placeOrder = By.xpath("//a[contains(text(), 'Place Order')]");
    private By nameOnCard = By.cssSelector("input[data-qa='name-on-card']");
    private By cardNumber = By.cssSelector("input[data-qa='card-number']");
    private By cvcNumber = By.cssSelector("input[data-qa='cvc']");
    private By expiryMonth = By.cssSelector("input[data-qa='expiry-month']");
    private By expiryYear = By.cssSelector("input[data-qa='expiry-year']");
    private By payButton = By.cssSelector("button[data-qa='pay-button']");
    private By orderConfirmationMessage = By.cssSelector("h2[data-qa='order-placed']");
    private By downladInvoice = By.cssSelector(".btn.btn-default.check_out");

    public CheckoutPage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait = wait;
    }

    public void clickPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }
    public void enterPymentInformation(String pyname, String pynumber, String pycvc, String pymonth,
                                       String pyyear){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard)).sendKeys(pyname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber)).sendKeys(pynumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvcNumber)).sendKeys(pycvc);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryMonth)).sendKeys(pymonth);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryYear)).sendKeys(pyyear);


    }
    public void clickPayButton(){

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(payButton));

       // wait.until(ExpectedConditions.elementToBeClickable(payButton)).click();
    }
    public String getOrderConfirmationMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).getText();
    }
    public void clickDownloadInvoice(){
        wait.until(ExpectedConditions.elementToBeClickable(downladInvoice)).click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName){
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        if (dirContents != null){
            for (File file : dirContents){
                if (file.getName().equals(fileName)){
                    return true;
                }
            }
        }
        return false;
    }



}

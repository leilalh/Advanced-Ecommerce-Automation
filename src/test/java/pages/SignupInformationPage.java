package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupInformationPage {

    private WebDriver driver;
    private WebDriverWait wait;


    //..................Account Information..........................

    private By genderButton = By.id("id_gender2");
    private By accountPassword = By.cssSelector("input[data-qa='password']"); //why not id

    private By dayOfbirth = By.cssSelector("select[data-qa='days']");
    private By monthOfBirth = By.cssSelector("select[data-qa='months']");
    private By yearOfbirth = By.cssSelector("select[data-qa='years']");

    //......................Address Information......................

    private By addressFirstname = By.cssSelector("input[data-qa='first_name']");
    private By addressLastname = By.cssSelector("input[data-qa='last_name']");
    private By address1 = By.cssSelector("input[data-qa='address']");
    private By countryBox = By.cssSelector("select[data-qa='country']");
    private By stateBox = By.cssSelector("input[data-qa='state']");
    private By CityBox = By.cssSelector("input[data-qa='city']");
    private By zipcodeBox = By.cssSelector("input[data-qa='zipcode']");
    private By mobileNumberBox = By.cssSelector("input[data-qa='mobile_number']");
    private By createaccountButton = By.cssSelector("button[data-qa='create-account']");



    public SignupInformationPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickgenderbutton(){

        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(genderButton));

//        wait.until(ExpectedConditions.elementToBeClickable(genderButton)).click();

    }

    public void enterAccountInformation(String apassword,
                                        String adayeofbirth,String amonthofbirth, String ayearofbirth){

        wait.until(ExpectedConditions.visibilityOfElementLocated(accountPassword)).sendKeys(apassword);
        new Select(driver.findElement(dayOfbirth)).selectByValue(adayeofbirth);
        new Select(driver.findElement(monthOfBirth)).selectByValue(amonthofbirth);
        new Select(driver.findElement(yearOfbirth)).selectByValue(ayearofbirth);


    }

    public void enterAddressInformation(String afirstname, String alastname, String accaddress,
                                        String acountry, String astate,String acity,String azipecode,
                                        String amobilenumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressFirstname)).sendKeys(afirstname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLastname)).sendKeys(alastname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address1)).sendKeys(accaddress);
        new Select(driver.findElement(countryBox)).selectByValue(acountry);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateBox)).sendKeys(astate);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CityBox)).sendKeys(acity);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeBox)).sendKeys(azipecode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberBox)).sendKeys(amobilenumber);



    }
    public void clickcreateaccount(){
        wait.until(ExpectedConditions.elementToBeClickable(createaccountButton)).click();

    }





}

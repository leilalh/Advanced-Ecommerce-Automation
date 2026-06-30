package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupInformationPage;
import pages.SignupLoginPage;

public class AutomationTest extends BaseTest{

    @Test
    public void testNewUserSignup(){

        HomePage homePage = new HomePage(driver,wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver,wait);
        SignupInformationPage signupInformationPage = new SignupInformationPage(driver, wait);

        homePage.clickloginSign();
        signupLoginPage.entersignupNameEmail("leila","leiaa860009@gmail.com");
        signupLoginPage.clicksignupbutton();

        signupInformationPage.clickgenderbutton();
        signupInformationPage.enterAccountInformation("1234", "4","12","1999");
        signupInformationPage.enterAddressInformation("Leila","lahmidi","Quartier 22 agadir","Canada","Souss massa","Agadir","80000","0630085161");
        signupInformationPage.clickcreateaccount();

        //...................Assert............................
        String currentUrl = driver.getCurrentUrl();
        org.testng.Assert.assertTrue(currentUrl.contains("account_created"));

        String successMessage = driver.findElement(By.cssSelector("h2[data-qa='account-created']")).getText();
        org.testng.Assert.assertEquals(successMessage, "ACCOUNT CREATED!");



    }

    @Test
    public void testExistingUser(){

        HomePage homePage = new HomePage(driver,wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver,wait);


        homePage.clickloginSign();
        signupLoginPage.enterloginEmailPassword("leiaa86500999@gmail.com", "1234");
        signupLoginPage.clickloginbutton();

    }
}

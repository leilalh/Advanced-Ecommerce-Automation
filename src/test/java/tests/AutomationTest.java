package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SignupInformationPage;
import pages.SignupLoginPage;

public class AutomationTest extends BaseTest{

    @Test(priority = 2)
    public void testNewUserSignup(){

        HomePage homePage = new HomePage(driver,wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver,wait);
        SignupInformationPage signupInformationPage = new SignupInformationPage(driver, wait);

        homePage.clickloginSign();
        signupLoginPage.entersignupNameEmail("leila","test554@gmail.com");
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

    @Test(priority = 1)
    public void testExistingUser(){

        HomePage homePage = new HomePage(driver,wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver,wait);


        homePage.clickloginSign();
        signupLoginPage.enterloginEmailPassword("test11@gmail.com", "1234");
        signupLoginPage.clickloginbutton();

    }

    @Test(priority = 3)
    public void testAddProductToCart(){
        HomePage homepage = new HomePage(driver, wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);

        //............Login...............
        homepage.clickloginSign();
        signupLoginPage.enterloginEmailPassword("leila.lahmidi11@gmail.com", "aJ3L3aJ53i@7nMj");
        signupLoginPage.clicksignupbutton();

        //............. ADD Products scenario.............
        homepage.clickprodcutsButton();
        productPage.clickViewProduct();
        productPage.enterquantity("3");
        productPage.clickaddcart();

        //..........Assert..........

        org.testng.Assert.assertEquals(productPage.getPopupSuccessMessage(), "Your product has been added to cart.");
        productPage.clickcontinueshopping();
    }
}

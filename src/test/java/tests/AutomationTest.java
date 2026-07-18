package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class AutomationTest extends BaseTest{

    @Test(priority = 2)
    public void testNewUserSignup(){

        HomePage homePage = new HomePage(driver,wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver,wait);
        SignupInformationPage signupInformationPage = new SignupInformationPage(driver, wait);

        homePage.clickloginSign();
        signupLoginPage.entersignupNameEmail("leila","test5954@gmail.com");
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
        signupLoginPage.enterloginEmailPassword("test119@gmail.com", "1234");
        signupLoginPage.clickloginbutton();



    }

    @Test(priority = 3, dataProvider = "loginTestData")
    public void testAddProductToCart(String email, String password, String fullname){

        HomePage homepage = new HomePage(driver, wait);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);



        //............Login...............
        homepage.clickloginSign();
        signupLoginPage.enterloginEmailPassword(email, password);
        signupLoginPage.clickloginbutton();

        //........Check if the cart if empty............
        homepage.clickCartButton();
        cartPage.clearCartIfNotEmpty();
        homepage.removeAds();


        //............. ADD Products scenario.............
        homepage.clickprodcutsButton();
        homepage.removeAds();
        productPage.clickViewProduct();
        productPage.enterquantity("2");
        productPage.clickaddcart();

        //..........Assert..........

        org.testng.Assert.assertEquals(productPage.getPopupSuccessMessage(), "Your product has been added to cart.");
        productPage.clickcontinueshopping();

        //.............Cart........
        homepage.clickCartButton();

        org.testng.Assert.assertTrue(cartPage.isProductDisplayedInCart());
        org.testng.Assert.assertEquals(cartPage.getProductQuantityInCart(), "2");
        cartPage.clickProceedButton();
        homepage.removeAds();

        //..........CheckOut..............
        checkoutPage.clickPlaceOrder();
        homepage.removeAds();
        checkoutPage.enterPymentInformation(fullname,"66688899", "888", "05", "2033");
        checkoutPage.clickPayButton();

        org.testng.Assert.assertEquals(checkoutPage.getOrderConfirmationMessage(), "ORDER PLACED!");
        checkoutPage.clickDownloadInvoice();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        String downloadPath = "C:\\Users\\BeeClick\\Downloads";
        String expectedFileName = "invoice.txt";

        org.testng.Assert.assertTrue(checkoutPage.isFileDownloaded(downloadPath, expectedFileName), "Error : Invoice file was not found");



    }

    @DataProvider(name = "loginTestData")
    public Object[][] getLoginData() {

        return new Object[][]{

                {"leilabueckers@gmail.com", "djbH5iHKjakiHN@", "Lela User One"},
                {
                        "leila.lahmidi11@gmail.com", "aJ3L3aJ53i@7nMj", "Leila User Two"
                }
        };
    }


}

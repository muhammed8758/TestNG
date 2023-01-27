package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_NegativeLoginTets {
    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();

    @Test
    public void testName() throws InterruptedException {

        Name:
//        US100208_Negative_Login
//        Description:
//        User should not be able login with incorrect credentials
//        Acceptance Criteria:
//        As customer, I should not be able to log in the application
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
//        Error: User with email fake@bluerentalcars.com not found

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        blueRentalHomePage.loginLink.click();

        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("fake_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_password"));
        blueRentalLoginPage.loginButton.click();
        Thread.sleep(3000);

        Assert.assertEquals(blueRentalLoginPage.error_message_1.getText(),"User with email fake@bluerentalcars.com not found");

        Driver.closeDriver();


    }
}

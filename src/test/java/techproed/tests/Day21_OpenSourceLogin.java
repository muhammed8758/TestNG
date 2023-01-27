package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

    @Test
    public void openSourceLogin() throws InterruptedException {
        //1.Adim Sayfaya Git
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        //2.Adim Page Objesi Olustur
        OpenSourcePage openSourcePage = new OpenSourcePage();

        //3.Adim Bu objeyi kullanarak o class daki objelere ulas
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();

        //4.Assertion
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();

        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());




    }
}

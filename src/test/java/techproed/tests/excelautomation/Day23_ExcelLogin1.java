package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin1 {
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String,String>> excelDatalari;


    public void login() {


        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        //     ----ILK GIRIS-------
        //      loginLink butonu sadece ilk girisde sayfada gorunur
        //      Ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NoSuchElementException alir
        //      Biz bu exception u try catch kulanarak yakalariz ve test cases calismaya devam eder
        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {
        }
        //------- Sonraki Girisler -----------
        try {
//            kullanıcı ID ye tıkla
            blueRentalHomePage.userID.click();
//            Logout linkine tıkla
            blueRentalHomePage.logOutLink.click();
//            OK e tıkla
            blueRentalHomePage.OK.click();
//            home page logine tıkla
            blueRentalHomePage.loginLink.click();
        } catch (Exception e) {
        }



    }

    @Test
    public void customerLogin() throws IOException {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        //   ./ onceki tum dosyalari icer. Relative path
        String sheet = "customer_info";
        // Datalari Excel Utils Methodlarini Kullanarak Buraya ALacagiz
        excelUtils = new ExcelUtils(path,sheet);
        // excel datalarini getDataList methodu ile cekelim
       excelDatalari = excelUtils.getDataList();
       // Loop Kullanarak Datalari Tek Tek Test Caselerde Kullanalim
        for(Map<String,String> data: excelDatalari){
            login();// Her Loop da Login Sayfasina Goturecek
            // Kullanici adini gir
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            //Kullanici Sifresini gir
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            // login Butonuna Tikla
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            //giris islemi basarili oldugunu gostermek icin assertion
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.waitFor(1);
            // her bir giridenn sonra ekran goruntusu alinacak
            ReusableMethods.getScreenshot("EkranGoruntusu");


        }

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
    /*
    sam.walker@bluerentalcars.com	c!fas_art
    kate.brown@bluerentalcars.com	tad1$Fas
    raj.khan@bluerentalcars.com	    v7Hg_va^
    pam.raymond@bluerentalcars.com	Nga^g6!

    ----------
    ILK GIRIS

    HOME PAGE DEYİZ
    home page logine tıkla
    LOGIN PAGE DEYİZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    -------------
    IKINCI GIRIS

    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    -------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    ---------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
    ---------------
    HOME PAGE DEYİZ
    kullanıcı ID ye tıkla
    Logout linkine tıkla
    OK e tıkla
    home page logine tıkla
    LOGIN PAGE DEYIZ
    kullanıcı adını gir(excelden al)
    kullanıcı şifresini gir(excelden al)
    login page login butonuna tıkla
     */

}

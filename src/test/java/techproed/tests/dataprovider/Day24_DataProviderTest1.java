package techproed.tests.dataprovider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import java.security.Key;
public class Day24_DataProviderTest1 {
    //    DATA PROVIDER
    /*
    Nedir?
    1 Veri Deposudur. Bir cok veriyi Test Caselere loop kullanmadan aktarmakicin Kullanilir
    2 Data Provider 2D object return eder
    3 Data Provider TestNG den gelen bir ozellikdir
    4 Data Provider ne icin kullanilir?
    ***Data Provider DDT(data driven testing) icin kullanilir. Birden fazla datayi test caselerde kullanmak icin kullanilir
    5 Data Provider nasil kullanilir?
    ***@DataProvider annotasyonu ile veri havuzu olusur. @Test methodlarina bu data havuzu baglanir
    @Test(dataProvider = "urunler")
    6 Data Provider da 2 tane parametre vardir:
    ***name : method isimini override etmek icin, yani farkli bir isim ile data provider i cagirmak icin kullanilir
    ***parallel : paralel test caseler olusturmak icin kullanilir
     */
    @DataProvider(name = "smoke_test_data")
    public Object[][] urunler(){
        Object urunListesi[][] = {
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"honda"},
                {"toyota"},
                {"volvo"}
        };
        return urunListesi;
    }
    //    TEST METOTU
    @Test(dataProvider = "urunler")
    public void aramaTesti(String data){
        System.out.println(data);
    }
    //    GOOELE ARAMASI
    @Test(dataProvider = "smoke_test_data")
    public void googleAramasi(String araclar){
//        google a git
        Driver.getDriver().get("https://www.google.com");
//        COOKIES CIKANLAR ICIN
        try {
            Driver.getDriver().findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        }catch (Exception e){

        }
//        araclari arama kutusuna gir ve Enter a bas
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar+ Keys.ENTER);
//        sayfa title inin aradigim kelimeyi icerdigini assert et
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
//        driver i kapat
        Driver.closeDriver();
    }
}

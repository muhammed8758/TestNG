package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMethods {
    @Test
    public void homeTest() {
        System.out.println("Home Test");
     //   Assert.assertTrue(false);//Fail
    }
    @Test(dependsOnMethods = "homeTest") // ornek login e giremezse digerleri calismasina gerek yok
    public void searchTest() {
        System.out.println("Seach Test");
    }
    @Test(dependsOnMethods = "homeTest")
    public void paymentTest() {
        System.out.println("Payment Test");

    }
    @Test
    public void exitTest() {
        System.out.println("Exit Test");

    }
    /*
    TestNG de tum @Test methodlari birbirinden bagimsiz olarak calisirilar
    Eger methodlari bagimli hale getirmek istersen dependsOnMethods parametresi kullanilir
    Burdaki ornekte searchTest methodu homeTest methoduna bagimlidir
    searchTetst den once homeTest calisir
    Eger homeTest basarili isie searchTest calisir
    Eger homeTest basarisiz ise, searchTest IGNORE edilir.
     */

}

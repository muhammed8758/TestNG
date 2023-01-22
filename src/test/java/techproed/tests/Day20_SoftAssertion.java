package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {
    @Test
    public void softAssertTest() {
        //1. SoftAssert object olustur
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Satir 11");
        softAssert.assertEquals(2,5);// fail
        System.out.println("Satir 13");
        softAssert.assertTrue("JAVA".contains("U"));
        System.out.println("Satir 15");
        softAssert.assertTrue(true);
        System.out.println("Satir 17");
        softAssert.assertAll();// PASS yada FAIL olarak assertionlari isaretler

    }
}

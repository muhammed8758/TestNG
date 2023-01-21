package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotations {
    /*
    @Test : Test case olusturmak icin  kullanilir
    @Before  ve @After : 5 Before ve 5 after annotation var
    suite> tests > grup > class > method
    @BeforeSuite : her bir test suit den once 1 sefer calisir
    @AfterSuite : her bir test suit den sonra 1 sefer calisir
    @BeforeTest : her bir testten once (TEST CASE ILE KARISTIRILMAMASI LAZIM) 1 sefer calisir
    @AfterTest : her bir testten sonra (TEST CASE ILE KARISTIRILMAMASI LAZIM) 1 sefer calisir
    @BeforeClass : her bir class dan once  1 sefer calisir
    @AfterClass : her bir class dan sonra  1 sefer calisir
    @BeforeMethod : her bir @Test annotationdan once tek sefer calisir. Junitteki karsiligi @Before
    @AfterMethod : her bir @Test annotationdan sonra tek sefer calisir. Junitteki karsiligi @After

    @Ignore : @Test case leri (skip) atlamak icin kullanilir
    @Test (enable : false)

    TestNG de testlerin okunma sirasi isim sirasina gore calisir.
    @Test(priorty = 1) : Test Case leri oncelemek icin kullanilir

     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Group");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }



    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }


    @Test(priority = 1)
    public void test7() {
        System.out.println("Test 1");
    }
    @Test @Ignore
    public void test2() {
        System.out.println("Test 2");
    }
    @Test (enabled = false)
    public void test3() {
        System.out.println("Test 3");
    }
    @Test(priority = 5)
    public void test4() {
        System.out.println("Test 4");
    }
    @Test
    public void test5() {
        System.out.println("Test 5");
    }
    @Test
    public void test6() {
        System.out.println("Test 6");
    }


}

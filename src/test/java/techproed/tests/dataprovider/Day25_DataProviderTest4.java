package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class Day25_DataProviderTest4 {
    // Bu ornekte data provider methodumuz util class dan gelecek
    @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username, String password, String sube) {
        System.out.println("Username name : " + username+ "Password : " + password);

    }
    //musteriHizmetleri Verileri
    @Test(dataProvider = "musteriHizmetleriVerileri",dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTset(String username, String password){
        System.out.println(username  + " : " + password);
    }

    //personel verileri
    @Test(dataProvider = "personelVerileri",dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTest(String username, String password){
        System.out.println(username  + " : " + password);
    }

    // customer data
    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String username, String password){
        System.out.println("Excel Datalarim");
        System.out.println(username +password);


    }





}

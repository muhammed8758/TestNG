package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    //Page Objelerini bu Class da buluruz

    //1. construction
    public OpenSourcePage(){
        //PageFactory seleniumdan gelen ve bu sayfa elementlerini intantiane(baslangic degeri vermek) icin kullanilir

        PageFactory.initElements(Driver.getDriver(), this);
    }
    // PAGE OBJELERINI OLUSTUR
    // Traditional  olarak  public WebElement username=Driver.getDriver().findElement(By.name("username"));

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

}

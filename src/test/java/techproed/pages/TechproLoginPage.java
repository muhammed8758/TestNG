package techproed.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproLoginPage {
public TechproLoginPage(){
    PageFactory.initElements(Driver.getDriver(), this);

}
    @FindBy(xpath = "//*[@id='exampleInputEmail1']")
    public WebElement userName;
    @FindBy(xpath = "//*[@id='exampleInputPassword1']")
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;
}

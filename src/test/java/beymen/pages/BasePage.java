package beymen.pages;

import beymen.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.crypto.dsig.spec.XPathType;

public class BasePage {
    public BasePage(){
     PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@maxlength=\"50\"]" )
    WebElement searchBox;

    @FindBy(xpath = "//a[@title=\"Hesabım\"]")
    WebElement hesabım;

    @FindBy(xpath = "//a[@title=\"Favorilerim\"]")
    WebElement favorilerim;

    @FindBy(xpath = "//a[@title=\"Sepetim\"]")
    WebElement sepetim;




}

package beymen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{



    @FindBy(xpath = "//img[@alt=\"Beymen\"]" )
    public WebElement beymenImg;

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement acceptCerez;

    @FindBy(xpath = "//button[@id=\"genderManButton\"]")
    public WebElement genderButton;

}

package beymen.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(xpath = "//img[@alt=\"Beymen\"]" )
    WebElement searchBox;


}
